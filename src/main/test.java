package main;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String,Integer> m=new HashMap<>();
        String nm="111";
        if(!m.containsKey(nm)){
            System.out.println("111");
        }
        else{
            System.out.println("222");
        }
    }
}
