package com.proxyPattern.dynamicProxy;

public class Client {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        LogHandler logHandler = new LogHandler();  
        UserManager userManager = (UserManager)logHandler.newProxyInstance(new UserManagerImpl());  
        userManager.findUser("0001");  
    }  
}  
