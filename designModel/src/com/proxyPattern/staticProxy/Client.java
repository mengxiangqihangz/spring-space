package com.proxyPattern.staticProxy;

public class Client {  
  
    public static void main(String []args){  
        UserManager userManager=new Proxy( new UserManagerImpl());  
        userManager.addUser("0001", "ÕÅÈı");
    }  
}  
