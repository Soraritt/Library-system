package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class BookDB {
    private ArrayList<Book> books =  new ArrayList<Book>();
    private DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);

    public BookDB(){
        books.add(new Book("B-001","Harry Potter 1","JK Rowling"
                          ,"Harry Potter and the Philosophers Stone "
                          ,"L1/01","Fantasy"));
        books.add(new Book("B-002","Harry Potter 2","JK Rowling"
                          ,"Harry Potter and the Chamber of Secrets "
                          ,"L1/01","Fantasy"));
        books.add(new Book("B-003","Harry Potter 3","JK Rowling"
                          ,"Harry Potter and the Prisoner of Azkaban "
                          ,"L1/01","Fantasy"));
        books.add(new Book("B-004","Harry Potter 4","JK Rowling"
                          ,"Harry Potter and the Goblet of Fire "
                          ,"L1/01","Fantasy"));
        books.add(new Book("B-005","A Game of Thrones","George R. R. Martin"
                          ,"Series A Song of Ice No. 1"
                          ,"L1/02","epic fantasy"));
        books.add(new Book("B-006","A Clash of Kings","George R. R. Martin"
                          ,"Series A Song of Ice No. 2"
                          ,"L1/02","epic fantasy"));
        books.add(new Book("B-007","The Fallen Angels","Daniel Silva"
                          ,"The Fallen Angel (Gabriel Allon #12 ) "
                          ,"L2/01","Detective"));
        books.add(new Book("B-008","The Black Widow","Daniel Silva"
                          ,"The Black Widow (Gabriel Allon #16)"
                          ,"L2/02","Detective"));
    }

    public void addbook(String id ,String title,String author,String detail ,String shelf,String category){

        String[] ar1 ={id,title,author,detail,shelf,category};
        boolean checkfield = true;
        for(int i = 0 ; i < ar1.length ; i++ ){
            if (ar1[i].equals("")){
               System.out.println("Error Adding Book");
               checkfield = false;
               break;
            }
        }

        if(checkfield == true){
           books.add(new Book(id,title,author,detail,shelf,category));
        }
    }

    public void listbook(){
        Iterator<Book> iter1 = books.iterator();
        System.out.println("id    title   shelf   category  status      loan_id     user_id     staff_id    loan_date   return_date");
        while (iter1.hasNext()) {
            Book bk = iter1.next();
            System.out.println(bk.getId()+"\t\t"+bk.getTitle()+"\t\t"+bk.getShelf()
                    +"\t\t"+bk.getCategory()+"\t\t"+bk.getStatus()
                    +"\t\t"+bk.getLoan_id() +"\t\t"+bk.getUser_id() +"\t\t"+bk.getStaff_id()
                    +"\t\t"+(bk.getLoan_date()==null ? null : sdf.format(bk.getLoan_date()))
                    +"\t\t"+(bk.getReturn_date()==null ? null : sdf.format(bk.getReturn_date())) );
        }
    }

    public void detailbook(String id){

        Book bk = books.stream()
                 .filter(x -> id.equals(x.getId()))
                 .findAny().orElse(null);


        if (bk == null){
            System.out.println("find not found");
        }
        else{

            System.out.println("Book Id : "+bk.getId()+"\t\t Title : "+bk.getTitle()+"\t\t Author : "+bk.getAuthor());
            System.out.println("Detail : "+bk.getDetail());
            System.out.println("Shelf : "+bk.getShelf()+"\t\t Category : "+bk.getCategory()+"\t\t Status : "+bk.getStatus());
            System.out.println("Loan id : "+bk.getLoan_id()+"\t\t Staff id : "+bk.getStaff_id()+"\t\t User id : "+bk.getUser_id());
            System.out.println("Loan Date : "+(bk.getLoan_date()==null ? null : sdf.format(bk.getLoan_date()))
                              +"\nReturn Date : "+(bk.getReturn_date()==null ? null : sdf.format(bk.getReturn_date())));

        }
    }
    public void SearchBook(String keyfield,String keyvalue){
        List<Book> lbks ;
        switch (keyfield) {
            case "1":
                lbks = books.stream()
                            .filter(x -> keyvalue.equals(x.getId()))
                            .collect(Collectors.toList());
                break;
            case "2":
                lbks = books.stream()
                        .filter(x -> keyvalue.equals(x.getTitle()))
                        .collect(Collectors.toList());
                break;
            case "3":
                lbks = books.stream()
                        .filter(x -> keyvalue.equals(x.getCategory()))
                        .collect(Collectors.toList());
                break;
            case "4":
                lbks = books.stream()
                        .filter(x -> keyvalue.equals(x.getStatus()))
                        .collect(Collectors.toList());
                break;
            case "5":
                lbks = books.stream()
                        .filter(x -> keyvalue.equals(x.getUser_id()))
                        .collect(Collectors.toList());
                break;
            case "6":
                lbks = books.stream()
                        .filter(x -> keyvalue.equals(x.getLoan_date()))
                        .collect(Collectors.toList());
                break;
            case "7":
                lbks = books.stream()
                        .filter(x -> keyvalue.equals(x.getReturn_date()))
                        .collect(Collectors.toList());
                break;
             default:
                 lbks = null;
                 break;
        }
        if (lbks.size() == 0 ){
            System.out.println("find not found");
        }
        else {
            Iterator<Book> iter1 = lbks.iterator();
            System.out.println("id    title   shelf   category  status loan_date return_date");
            while (iter1.hasNext()) {
                Book bk = iter1.next();
                System.out.println(bk.getId() + "\t\t" + bk.getTitle() + "\t\t" + bk.getShelf() + " \t\t" + bk.getCategory()
                        + "\t\t" + bk.getStatus()
                        + "\t\t" +(bk.getLoan_date()==null ? null : sdf.format(bk.getLoan_date()))
                        + "\t\t" +(bk.getReturn_date()==null ? null : sdf.format(bk.getReturn_date())));
            }
            System.out.println("=====================================");
        }
    }

    public Book checkbook(String bookid,String sCheck){
           Book bk = books.stream()
                    .filter(x -> bookid.equals(x.getId()))
                    .findAny().orElse(null);
           // bk.setStatus("Y");

            if (bk == null){
                System.out.println("Book id : "+bookid+" not found");
            }
            else if ((bk.getStatus().equals("Y")) && (sCheck.equals("B"))){
                bk = null;
                System.out.println("Not Borrow Book id : "+bookid+" Status = Y");
            }
            else if ((bk.getStatus().equals("N")) && (sCheck.equals("R"))) {
                bk = null;
                System.out.println("Not Return Book id : "+bookid+" Status = N");
            }
            else{

            }
            return  bk;
    }

    public void updateData(String bookid,String loan_id,String staff_id,String user_id,int period_day,String sLoan){
        Book bk = books.stream()
                .filter(x -> bookid.equals(x.getId()))
                .findAny().orElse(null);


        if (sLoan.equals("B")) {
            Date currentDate = new Date();
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, period_day);

            bk.setStatus("Y");
            bk.setLoan_id(loan_id);
            bk.setStaff_id(staff_id);
            bk.setUser_id(user_id);
            bk.setLoan_date(currentDate);
            bk.setReturn_date(c.getTime());
        }
        else if (sLoan.equals("R")){
            bk.setStatus("N");
            bk.setLoan_id("");
            bk.setStaff_id("");
            bk.setUser_id("");
            bk.setLoan_date(null);
            bk.setReturn_date(null);
        }

    }
}
