package com.kraftechnologie.tests.day14_properties_Singleton;

public class Singleton {

    private Singleton() {
    }
    private  static  String str;
    public static String getInstance(){
       if(str==null){
           System.out.println("str is null, assinging a value to it");
           str="some value";
       } else {
           System.out.println("it has a value, just returning it");
       }
       return str;
    }
}
