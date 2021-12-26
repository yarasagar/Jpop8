package com.sagar.jacocodemo;

public class Messages {
    public String getMessage(String name){
        StringBuilder sb = null;
        if(name == null || name.trim().length() == 0){
            sb = new StringBuilder("empty");
        }else{
            sb = new StringBuilder(name);
        }
        return sb.toString();
    }
}
