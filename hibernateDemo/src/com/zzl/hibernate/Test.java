package com.zzl.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zzl.model.User;
/**
 * http://www.cnblogs.com/hibernate3-example/archive/2012/05/17/2506935.html
 * User.hbm.xml注释：
 *generator有7个属性 ====http://blog.csdn.net/zzh87615/article/details/6091655
	identity：mysql数据库--递增
	sequence：
	hilo：
	native：
	下面是Generator子元素的一些内置生成器的快捷名字
	increment：递增  用于long、short或int类型生成唯一标示
	identity：
	sequence：序列
	hilo：高地位
	uuid.hex：用一个128-bit的UUID算法生成字符串类型的标识符。在一个网络中唯一（使用了IP地址）。UUID被编码为一个32位16进制数字的字符串。
	uuid.string：使用同样的UUID算法。UUID被编码为一个16个字符长的任意ASCII字符组成的字符串。
	由于id使用的是uuid这是个字符串类型。所有model和mysql都要用字符串类型。
 * 
 */
/*文件关联。hibernate.cfg.xml通过 <mapping resource="User.hbm.xml"/>将User.hbm.xml加入进来。
	User.hbm.xml通过<class name="com.zzl.model.User">将User加入进来
	即读取解析映射文件时，就已经将表中的信息封装到User的对象中了
*/
public class Test {
	public static void main(String[] args) {
		//读取并解析配置文件。相当于获得hibernate.cfg.xml上下文==对象
		Configuration cfg = new Configuration().configure();
		//读取并解析hibernate.cfg.xml文件映射信息。然后创建sessionFactory（会话工厂）
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = null;
		try{
//			会话工厂中打开一条会话
			session = factory.openSession();
			//开启一个事务（增删改操作必须，查询操作可选
			session.beginTransaction();
			
			User user = new User();
			user.setUsername("admin");
			user.setPassword("123");
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time1=format.format(new Date());
			user.setCreateTime(time1);
			user.setExpireTime(time1);
			
			//数据库操作---保存数据
			session.save(user);
			//提交事务
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//回滚事务
			session.getTransaction().rollback();
		}finally{
			if(session != null){
				if(session.isOpen()){
					//关闭session
					session.close();
				}
			}
		}
	}
}

