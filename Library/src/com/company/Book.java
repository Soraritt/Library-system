package com.company;
import java.util.Date;
public class Book {
    private String id;
    private String title  ;
    private String author ;
    private String detail ;
    private String shelf  ;
    private String category  ;
    private String status    ;
    private String loan_id   ;
    private String staff_id  ;
    private String user_id   ;
    private Date   loan_date  ;
    private Date   return_date;


   public  Book(String id ,String title,String author,String detail ,String shelf,String category){
       this.id = id;
       this.title  = title;
       this.author = author;
       this.detail = detail;
       this.shelf  = shelf;
       this.category  = category;
       this.status    = "N";
       this.loan_id   = "";
       this.staff_id  = "";
       this.user_id   = "";
       this.loan_date   = null;
       this.return_date = null;

   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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
