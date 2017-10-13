package com.zlyg.purchase.dao.basic;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.zlyg.purchase.common.ApplicationHelper;
import com.zlyg.purchase.model.Entity;

/**
 * @author justin
 * 
 * 提供常用的数据操作方法
 *
 * @param <T>
 */
public abstract class BaseDao<T extends Entity> {
	protected int maxResult = 1000;
	/**
	 * 实体类型
	 */
	protected Class<T> type;
	/**
	 * jdbc查询模板
	 */
	protected JdbcTemplate jdbcTemplate;

	/**
	 * 缓存表名
	 */
	private String tableName = null;

	/**
	 * 缓存主键名
	 */
	private String keyName = null;
	/**
	 * 缓存实体映射关系
	 */
	private final static Map<String, RowMapper<?>> rowMappers = new HashMap<String, RowMapper<?>>();

	/**
	 * 初始化泛型Dao
	 */
	@SuppressWarnings("unchecked")
	public BaseDao() {
		// 获取类型
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			this.type = (Class<T>) ((ParameterizedType) type)
					.getActualTypeArguments()[0];
			// 根据类型获取jdbcTemplate，选择数据库
			System.out.println("type="+this.type.getName());
			String[] cname = this.type.getName().split("\\.");
			
			for (int i = 0; i < cname.length; i++) {
				System.out.println(cname[i]);
			}
			
			String suffix = cname[cname.length - 2];
			
			System.out.println(suffix);
			
			this.jdbcTemplate = (JdbcTemplate) ApplicationHelper.getBean("jdbcTemplate_" + suffix);
		} else {
			System.out.println("no jdbcTemplate selected!");
		}
	}

	/**
	 * 获取泛型实体对应的表的表名
	 * 
	 * 
	 * @return 对应的数据库表名字
	 */
	protected String getTableName() {
		if (tableName != null) {
			return tableName;
		}
		tableName = getTableName(type);
		return tableName;
	}

	/**
	 * 获取泛型实体对应的表的表名,根据泛型类的名字中间大写字母转为下划线+小写字母
	 * 
	 * @return 对应的数据库表名字
	 */
	protected String getTableName(Class<?> type) {
		StringBuilder sb = new StringBuilder();
		char[] ch = type.getSimpleName().toCharArray();
		sb.append(String.valueOf(ch[0]).toLowerCase());
		for (int i = 1; i < ch.length; i++) {
			if (ch[i] >= 'A' && ch[i] <= 'Z') {
				sb.append("_" + String.valueOf(ch[i]).toLowerCase());
			} else {
				sb.append(ch[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 获取泛型实体对应的表的主键名
	 */
	protected String getKeyName() {
		if (keyName != null) {
			return keyName;
		}
		keyName = getKeyName(type);
		return keyName;
	}

	/**
	 * 根据实体类获取实体对应的表的主键名
	 */
	protected String getKeyName(Class<?> type) {
		try {
			Method method = type.getMethod("getKeyName");
			Object t = type.newInstance();
			return (String) method.invoke(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取主键值
	 * 
	 */
	protected Object getKeyValue(Object t) {
		String keyName = getKeyName(t.getClass());
		if (keyName != null) {
			try {
				Field field = t.getClass().getDeclaredField(keyName);
				field.setAccessible(true);
				return field.get(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 获取实体映射类
	 * 
	 * @param mappedClass
	 * @return
	 */
	protected <E> BeanPropertyRowMapper<E> getBeanPropertyRowMapper(
			Class<E> mappedClass) {
		@SuppressWarnings("unchecked")
		BeanPropertyRowMapper<E> ret = (BeanPropertyRowMapper<E>) rowMappers
				.get(mappedClass.getName());
		if (ret == null) {
			ret = BeanPropertyRowMapper.newInstance(mappedClass);
			rowMappers.put(mappedClass.getName(), ret);
		}
		return ret;
	}

	protected String formatObjVal(Object obj) {
		if (obj == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		if (obj instanceof Object[]) {
			Object[] objs = (Object[]) obj;
			for (int i = 0; i < objs.length; i++) {
				sb.append(objs[i] + ",");
			}
			if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			return sb.toString();
		}
		return obj.toString();
	}

	/**
	 * 获取一个实体 ,if size>1 throw Exception
	 * 
	 * @param sql
	 *            查询语句
	 * @param values
	 *            查询参数
	 * @return entity or null
	 */
	protected T getT(String sql, Object... values) {
		RowMapper<T> rowMapper = getBeanPropertyRowMapper(type);
		List<T> results = jdbcTemplate.query(sql, rowMapper, values);
		T ret = DataAccessUtils.singleResult(results);
		return ret;
	}

	/**
	 * 查询实体列表
	 * 
	 * @param sql
	 *            查询语句
	 * @param values
	 *            查询参数
	 * @return
	 */
	protected List<T> queryList(String sql, Object... values) {
		RowMapper<T> rowMapper = getBeanPropertyRowMapper(type);
		List<T> results = jdbcTemplate.query(sql, rowMapper, values);
		return results;
	}

	/**
	 * 查询实体列表
	 * 
	 * @param sql
	 *            查询语句
	 * @param values
	 *            查询参数
	 * @return
	 */
	protected <E> List<E> queryList(String sql, Class<E> type, Object... values) {
		List<E> results = jdbcTemplate.queryForList(sql, type, values);
		return results;
	}

	/**
	 * 更新一个相关实体
	 * 
	 * @param entity
	 *            要更新的实体
	 * @param tableName
	 *            对应的表
	 * @param keyName
	 *            对于的主键
	 * @param keyValue
	 *            对于的主键值
	 * @return 受影响的记录数
	 */
	protected int updateEntity(Entity entity, String tableName, String keyName,
			Object keyValue) {
		StringBuilder sb = new StringBuilder();
		List<Object> values = new ArrayList<Object>();
		PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(entity
				.getClass());
		for (PropertyDescriptor pd : pds) {
			if (pd.getWriteMethod() != null && pd.getReadMethod() != null) {
				try {
					String key = pd.getName();
					// 属性名称和字段名称不一致，userName转换为user_name
					key = attrNameToField(key);
					Object value = pd.getReadMethod().invoke(entity);
					if (value != null) {
						sb.append(" " + key + "=?,");
						values.add(value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (sb.length() == 0) {
			return 0;
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.insert(0, "update " + tableName + " set");
		sb.append(" where " + keyName + "=?");
		values.add(keyValue);
		
		int ret = jdbcTemplate.update(sb.toString(), values.toArray());
		return ret;
	}

	/**
	 * 更新一个相关实体
	 * 
	 * @param entity
	 * @return 受影响的记录数
	 */
	protected int updateEntity(Entity entity) {
		return updateEntity(entity, getTableName(entity.getClass()),
				getKeyName(entity.getClass()), getKeyValue(entity));
	}

	/**
	 * 获取单一的查询结果，返回记录数不能大于1
	 * 
	 * @param sql
	 *            查询语句
	 * @param requiredType
	 *            要返回的类型
	 * @param args
	 *            查询参数
	 * @return E or null
	 */
	protected <E> E getObject(String sql, Class<E> requiredType, Object... args) {
		RowMapper<E> rowMapper = new SingleColumnRowMapper<E>(requiredType);
		List<E> results = jdbcTemplate.query(sql, rowMapper, args);
		E ret = DataAccessUtils.singleResult(results);
		return ret;
	}

	/**
	 * 根据主键值和泛型类获取实体
	 * 
	 * @param id
	 *            主键值
	 * @param cla
	 *            对应实体的类
	 * @return
	 */
	protected <E> E get(Number id, Class<E> cla) {
		String sql = "select * from " + getTableName(cla) + " where "
				+ getKeyName(cla) + "=" + id;
		RowMapper<E> rowMapper = getBeanPropertyRowMapper(cla);
		List<E> results = jdbcTemplate.query(sql, rowMapper);
		E ret = DataAccessUtils.singleResult(results);
		return ret;
	}

	/**
	 * 获取实体有效值和对应的字段
	 * 
	 * @param t
	 * @return
	 */
	protected Map<String, Object> getFieldValues(Entity t) {
		PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(t
				.getClass());
		Map<String, Object> ret = new LinkedHashMap<String, Object>(pds.length);
		for (int i = 0, size = pds.length; i < size; i++) {
			Method read = pds[i].getReadMethod();
			Method write = pds[i].getWriteMethod();
			if (read != null && write != null) {
				Object obj = null;
				try {
					obj = read.invoke(t);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
				if (obj != null) {
//					ret.put(pds[i].getName(), obj);
					// 转换，把属性名称转换为字段名称
					// 把model中的属性转换为数据表字段2016-7-9修改，修改人justin
					String fieldName = this.attrNameToField(pds[i].getName());
					ret.put(fieldName, obj);
				}
			}
		}
		return ret;
	}

	protected int update(String sql, Object... vlaues) {
		return jdbcTemplate.update(sql, vlaues);
	}

	public void save(T t) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.setTableName(getTableName());
		Map<String, Object> kvs = getFieldValues(t);
		simpleJdbcInsert.setColumnNames(new ArrayList<String>(kvs.keySet()));
		simpleJdbcInsert.execute(kvs);
	}

	public void saves(T[] ts) {
		for (T t : ts) {
			save(t);
		}
	}

	public void saves(List<T> ts) {
		for (T t : ts) {
			save(t);
		}
	}

	public Number saveAndReturnKey(T t) {
		Number key = (Number) getKeyValue(t);
		if (key != null) {
			save(t);
			return key;
		} else {
			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(
					jdbcTemplate);
			simpleJdbcInsert.setTableName(getTableName());
			simpleJdbcInsert.setGeneratedKeyName(getKeyName());
			
			Map<String, Object> kvs = getFieldValues(t);
			simpleJdbcInsert
					.setColumnNames(new ArrayList<String>(kvs.keySet()));
			key = simpleJdbcInsert.executeAndReturnKey(kvs);
			return key;
		}
	}

	public void saveEntitys(Entity... entitys) {
		for (Entity entity : entitys) {
			saveEntity(entity);
		}
	}

	public void saveEntity(Entity entity) {
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.setTableName(getTableName(entity.getClass()));
		Map<String, Object> kvs = getFieldValues(entity);
		simpleJdbcInsert.setColumnNames(new ArrayList<String>(kvs.keySet()));
		simpleJdbcInsert.execute(kvs);
	}

	public void saveOrUpdateEntity(Entity entity) {
		Object key = getKeyValue(entity);
		if (key == null) {
			this.saveEntity(entity);
		} else {
			String tableName = getTableName(entity.getClass());
			String keyName = getKeyName(entity.getClass());
			String sql = String.format("select count(*) from %s where %s=?",
					tableName, keyName);
			if (this.getObject(sql, Integer.class, key) > 0) {// 更新
				this.updateEntity(entity);
			} else {
				this.saveEntity(entity);
			}
		}
	}

	public Number saveEntityAndReturnKey(Entity entity) {
		Number key = (Number) getKeyValue(entity);
		if (key != null) {
			saveEntity(entity);
			return key;
		} else {
			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(
					jdbcTemplate);
			simpleJdbcInsert.setTableName(getTableName(entity.getClass()));
			simpleJdbcInsert.setGeneratedKeyName(getKeyName(entity.getClass()));
			
			Map<String, Object> kvs = getFieldValues(entity);
			simpleJdbcInsert
					.setColumnNames(new ArrayList<String>(kvs.keySet()));
			key = simpleJdbcInsert.executeAndReturnKey(kvs);
			return key;
		}
	}

	public int delete(Number id) {
		String sql = "delete from " + getTableName() + " where " + getKeyName()
				+ "=" + id;
		int ret = jdbcTemplate.update(sql);
		if (ret > 1) {
			throw new IllegalArgumentException("错误的主键");
		}
		return ret;
	}

	public int deleteByProperty(String propertyName, String value) {
		String sql = "delete from " + getTableName() + " where " + propertyName
				+ "=?";
		int ret = jdbcTemplate.update(sql, value);
		return ret;
	}

	public int update(T t) {
		return updateEntity(t, getTableName(), getKeyName(), getKeyValue(t));
	}

	public T get(Number id) {
		return getTByProperty(getKeyName(), id);
	}

	public T getTByProperty(String propertyName, Object value) {
		String sql = "select * from " + getTableName() + " where "
				+ propertyName + "=?";
		return getT(sql, value);
	}

	public List<T> queryByProperty(String propertyName, Object value) {
		String sql = "select * from " + getTableName() + " where "
				+ propertyName + "=?";
		return queryList(sql, value);

	}

	public List<T> queryByProperties(Map<String, Object> properties) {
		StringBuffer sql = new StringBuffer("select * from " + getTableName()
				+ " where 1=1 ");
		// + propertyName + "=?";

		Object[] params = new Object[properties.size()];
		int index = 0;
		for (String p : properties.keySet()) {
			sql.append(" AND " + p + "=?  ");
			params[index] = properties.get(p);
			index++;
		}
		return queryList(sql.toString(), params);

	}

	public int count() {
		String sql = "select count(*) from " + getTableName();
		Integer ret = jdbcTemplate.queryForObject(sql, Integer.class);
		return ret;
	}

	public int count(Class<?> entityClass) {
		String sql = "select count(*) from " + getTableName(entityClass);
		Integer ret = jdbcTemplate.queryForObject(sql, Integer.class);
		return ret;
	}

	public List<T> queryAll() {
		String sql = "select * from " + getTableName() + " limit " + maxResult;
		RowMapper<T> rowMapper = getBeanPropertyRowMapper(type);
		List<T> results = jdbcTemplate.query(sql, rowMapper);
		return results;
	}
	
	
	/**
	 * 2016-7-9号添加，把属性名称转换为数据库字段名称
	 * @param attribute
	 * @return
	 */
	public String attrNameToField (String attribute) {
		StringBuffer sf = new StringBuffer ();
		for (int i = 0; i < attribute.length(); i++) {
			char ch = attribute.charAt(i);
			if(ch >= 97 && ch <=122) {
				sf.append(ch);
			}else{
				sf.append("_").append(Character.toLowerCase(ch));
			}
		}
		return sf.toString();
	}

}