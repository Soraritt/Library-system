package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class UserDB {
    private ArrayList<User> users =  new ArrayList<User>();

    public UserDB(){

        users.add(new User("user01","soraritt","chawapee"));
        users.add(new User("user02","rest","barlad"));
        users.add(new User("user03","luke","nest"));

    }

    public void adduser(String id, String fname ,String lname   ){
        users.add(new User(id,fname,lname));
    }

    public void listuser(){
        Iterator<User> iter1 = users.iterator();

        System.out.println("ID  FName  LName ");
        while (iter1.hasNext()) {
            User us = iter1.next();
            System.out.println(us.getId()+"\t\t"+us.getFname()+"\t\t"+us.getLname());
        }

    }
}
