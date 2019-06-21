package com.company;
import java.util.ArrayList;
import java.util.Iterator;

public class LibrarianDB {

    private  ArrayList<Librarian> Librarians =  new ArrayList<Librarian>();

    public LibrarianDB(){

        Librarians.add(new Librarian("A001","Test001",7,15));
        Librarians.add(new Librarian("A002","Test002",7,15));
        Librarians.add(new Librarian("A003","Test003",7,15));

    }

    public void addStaff(String id, String name , int st_period , int en_period  ){
        Librarians.add(new Librarian(id,name,st_period,en_period));
    }

    public void liststaff(){
        Iterator<Librarian> iter1 = Librarians.iterator();

        System.out.println("ID  Name  Start_Period  End_Period");
        while (iter1.hasNext()) {
            Librarian Li = iter1.next();
            System.out.println(Li.getId()+"\t\t"+Li.getName()+"\t\t"+Li.getSt_Period_date()+"\t\t"+Li.getEn_Period_date());
        }

    }
    public Librarian checkStaff(String staff_id){

        Librarian lb = Librarians.stream()
                .filter(x -> staff_id.equals(x.getId()))
                .findAny().orElse(null);

        if (lb == null){
            System.out.println("Staff id : "+staff_id+" not found");

        }
        else{
          //
        }
        return  lb;
    }



}
