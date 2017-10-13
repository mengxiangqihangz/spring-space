package com.proxyPattern.staticProxy;

/*** 
 * �����࣬�ṩ�û�ʵ����ķ��ʿ��� 
 * @author Administrator 
 * 
 */  
public class Proxy implements UserManager{  
    private UserManager userManager;  
    public Proxy(UserManagerImpl ul){  
        userManager=ul;  
    } 
    
    public void addUser(String userId, String userName) {  
        System.out.println("���ڽ�������û�ǰ��׼������,�û�idΪ��"+userId+"����");  
        try {  
            userManager.addUser(userId, userName);  
            System.out.println("�ɹ�����û�"+userId+"�����ڽ���ȷ�ϴ�����");  
        } catch (Exception e) {  
            System.out.println("���,userId="+userId+"ʧ�ܣ�");  
        }  
          
          
    }  
  
    public void delUser(String userId) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public String findUser(String userId) {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public void modifyUser(String userId, String userName) {  
        // TODO Auto-generated method stub  
    }  
}  
