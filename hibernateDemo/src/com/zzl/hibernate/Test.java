package com.zzl.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zzl.model.User;
/**
 * http://www.cnblogs.com/hibernate3-example/archive/2012/05/17/2506935.html
 * User.hbm.xmlע�ͣ�
 *generator��7������ ====http://blog.csdn.net/zzh87615/article/details/6091655
	identity��mysql���ݿ�--����
	sequence��
	hilo��
	native��
	������Generator��Ԫ�ص�һЩ�����������Ŀ������
	increment������  ����long��short��int��������Ψһ��ʾ
	identity��
	sequence������
	hilo���ߵ�λ
	uuid.hex����һ��128-bit��UUID�㷨�����ַ������͵ı�ʶ������һ��������Ψһ��ʹ����IP��ַ����UUID������Ϊһ��32λ16�������ֵ��ַ�����
	uuid.string��ʹ��ͬ����UUID�㷨��UUID������Ϊһ��16���ַ���������ASCII�ַ���ɵ��ַ�����
	����idʹ�õ���uuid���Ǹ��ַ������͡�����model��mysql��Ҫ���ַ������͡�
 * 
 */
/*�ļ�������hibernate.cfg.xmlͨ�� <mapping resource="User.hbm.xml"/>��User.hbm.xml���������
	User.hbm.xmlͨ��<class name="com.zzl.model.User">��User�������
	����ȡ����ӳ���ļ�ʱ�����Ѿ������е���Ϣ��װ��User�Ķ�������
*/
public class Test {
	public static void main(String[] args) {
		//��ȡ�����������ļ����൱�ڻ��hibernate.cfg.xml������==����
		Configuration cfg = new Configuration().configure();
		//��ȡ������hibernate.cfg.xml�ļ�ӳ����Ϣ��Ȼ�󴴽�sessionFactory���Ự������
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = null;
		try{
//			�Ự�����д�һ���Ự
			session = factory.openSession();
			//����һ��������ɾ�Ĳ������룬��ѯ������ѡ
			session.beginTransaction();
			
			User user = new User();
			user.setUsername("admin");
			user.setPassword("123");
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time1=format.format(new Date());
			user.setCreateTime(time1);
			user.setExpireTime(time1);
			
			//���ݿ����---��������
			session.save(user);
			//�ύ����
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
			session.getTransaction().rollback();
		}finally{
			if(session != null){
				if(session.isOpen()){
					//�ر�session
					session.close();
				}
			}
		}
	}
}

