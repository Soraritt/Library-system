package com.company;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class BookLoan {
    private String bookloan_id;
    private Date   bookloan_date  ;
    private String book_id ;
    private String loan_user_id  ;
    private String loan_flag     ;
    private String loan_staff_id    ;
    private String loan_period ;
    private Date loan_date     ;
    private Date return_date   ;
    private final DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);



    public BookLoan(){
        this.bookloan_id = "";
        this.bookloan_date  = new Date();

        this.loan_date   = null;
        this.return_date = null;
    }

    public void borrow_Trans(String book_id,int period){
      //
    }

    public void confirm_Bookborrow(BookDB listDB,ArrayList listBorrow,Librarian lstaff,String loan_id,String user_id ,int period_day) {

        Iterator<Book> iterborrow = listBorrow.iterator();

        while (iterborrow.hasNext()) {
            Book list = iterborrow.next();
            listDB.updateData(list.getId(),loan_id,lstaff.getId(),user_id,period_day,"B");
        }
    }
    public void return_Bookborrow(BookDB listDB,ArrayList listreturn,Librarian lstaff,String loan_id,String user_id ,int period_day) {

        Iterator<Book> iterreturn = listreturn.iterator();

        while (iterreturn.hasNext()) {
            Book list = iterreturn.next();
            listDB.updateData(list.getId(),loan_id,lstaff.getId(),user_id,period_day,"R");
        }
    }

    public String getBookloan_id() {
        return bookloan_id;
    }

    public void setBookloan_id(String bookloan_id) {
        this.bookloan_id = bookloan_id;
    }

    public Date getBookloan_date() {
        return bookloan_date;
    }

    public void setBookloan_date(Date bookloan_date) {
        this.bookloan_date = bookloan_date;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }


    public String getLoan_user_id() {
        return loan_user_id;
    }

    public void setLoan_user_id(String loan_user_id) {
        this.loan_user_id = loan_user_id;
    }

    public String getLoan_flag() {
        return loan_flag;
    }

    public void setLoan_flag(String loan_flag) {
        this.loan_flag = loan_flag;
    }

    public String getLoan_staff_id() {
        return loan_staff_id;
    }

    public void setLoan_staff_id(String loan_staff_id) {
        this.loan_staff_id = loan_staff_id;
    }

    public String getLoan_period() {
        return loan_period;
    }

    public void setLoan_period(String loan_period) {
        this.loan_period = loan_period;
    }

    public Date getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
