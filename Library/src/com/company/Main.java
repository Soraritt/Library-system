
package com.company;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    private static LibrarianDB Ldb =  new LibrarianDB();
    private static BookDB Bdb = new BookDB();
    private static BookLoan bookln =  new BookLoan();
    private static Scanner input = new Scanner(System.in);
    private static String menu_number;
    private static String menu_key;
    private static String staff_id;
    private static Librarian librarianStaff ;
    private static Book     bookborrow ;
    private static Book     bookreturn ;
    static void Choose_Mainmenu() {

          System.out.println("Main Menu ===============");
          System.out.println("1. Staff");
          System.out.println("2. Employee");
          System.out.println("3. Exit Program");
          System.out.println("==========================");

          System.out.println("Plz enter Menu : ");
          menu_number = input.nextLine();

          if(menu_number.equals("1")){
              menu_key ="staff";
              System.out.println("Plz enter Staff id : ");
              staff_id = input.nextLine();
              librarianStaff = Ldb.checkStaff(staff_id) ;
              if (librarianStaff  != null){
                  Choose_menu(menu_key);
               }
              else{
                  Choose_Mainmenu();
              }

          }
          else if (menu_number.equals("2")){
              menu_key ="emp";
              Choose_menu(menu_key);
          }
          else if (menu_number.equals("3")){
              System.exit(0);
          }
    }
    static void Choose_menu(String key) {

         if (key.equals("staff")) {
             System.out.println("Menu Staff ==============================");
             System.out.println("Staff id :"+librarianStaff.getId()+"\tStaff name :"+librarianStaff.getName());
             System.out.println("=========================================");
             System.out.println("1.Add Staff       2.List Staffs");
             System.out.println("3.Add User        4.List Users");
             System.out.println("5.Add Books       6.List Books       7.Search Books");
             System.out.println("8.Detail Books    9.Loan Books       10.Return Books");
             System.out.println("11.Return Menu    12.Exit Program");
             System.out.println("=========================================");
         }
         else if (key.equals("emp")){
             System.out.println("Menu Employee =============");
             System.out.println("1. Employee");
             System.out.println("2. Return Menu");
             System.out.println("3. Exit Program");
             System.out.println("===========================");
         }

        System.out.println("Plz enter Menu : ");
        String index = input.nextLine();
        String bookid,scheckperiod ;
        int periodday;
        boolean bcheck = false;
        if (key.equals("staff")) {
            switch (index) {
                case "1":
                    System.out.println("1. Adding Staff==============");
                    System.out.println("Plz enter Staff ID : ");
                    String staff_id = input.nextLine();
                    System.out.println("Plz enter Staff Name: ");
                    String staff_Name = input.nextLine();
                    Ldb.addStaff(staff_id,staff_Name,7,15);
                    Choose_menu(menu_key);
                    break;
                case "2":
                    System.out.println("2.List Staff====================");
                    Ldb.liststaff();
                    System.out.println("================================");
                    Choose_menu(menu_key);
                    break;
                case "3":
                    Choose_menu(menu_key);
                    break;
                case "4":
                    Choose_menu(menu_key);
                    break;
                case "5":
                    System.out.println("5. Adding Book==============");
                    System.out.println("Plz enter Book ID : ");
                    String id = input.nextLine();
                    System.out.println("Plz enter Book title: ");
                    String title = input.nextLine();
                    System.out.println("Plz enter Book author: ");
                    String author = input.nextLine();
                    System.out.println("Plz enter Book detail: ");
                    String detail = input.nextLine();
                    System.out.println("Plz enter Book shelf: ");
                    String shelf = input.nextLine();
                    System.out.println("Plz enter Book category: ");
                    String category = input.nextLine();
                    Bdb.addbook(id,title,author,detail,shelf,category);
                    Choose_menu(menu_key);
                    break;
                case "6":
                    System.out.println("6. List Books==============");
                    Bdb.listbook();
                    System.out.println("===========================");
                    Choose_menu(menu_key);
                    break;
                case "7":
                    System.out.println("7.Search Books============");
                    Choose_Search(menu_key);
                case "8":
                    System.out.println("8. Book Detail===================");
                    System.out.println("Plz enter Book ID: ");
                    bookid = input.nextLine();
                    Bdb.detailbook(bookid);
                    System.out.println("================================");
                    Choose_menu(menu_key);
                    break;
                case "9":
                    System.out.println("9. Book Loans===================");
                    System.out.println("Set period Default(Y/N): "+librarianStaff.getSt_Period_date()+"-"+librarianStaff.getEn_Period_date()+ " days");
                    scheckperiod = input.nextLine();
                    if(scheckperiod.equals("Y")){
                        System.out.println("Plz enter period day: ");
                        periodday = Integer.parseInt(input.nextLine());
                    }else{
                        periodday = librarianStaff.getSt_Period_date();
                    }

                    bcheck = false;
                    System.out.println("============================");
                    System.out.println("enter C : Confirms ,S : Show listbook ,E Exit  ");
                    System.out.println("============================");

                    ArrayList<Book> listborrow  = new ArrayList<Book>();
                    while(bcheck == false) {
                        System.out.println("Plz enter Book ID : ");
                        bookid = input.nextLine();
                        if(bookid.equals("C")){

                            bookln.confirm_Bookborrow(Bdb,listborrow,librarianStaff,"xxxx","",periodday);
                            System.out.println("Borrow Book is Success");
                            bcheck = true;
                        }
                        else if(bookid.equals("S")){
                            Iterator<Book> iter1 = listborrow.iterator();
                            System.out.println("List Books Loan===========================");
                            System.out.println("id    title");
                            while (iter1.hasNext()) {
                                Book bk = iter1.next();
                                System.out.println(bk.getId() + "\t\t" + bk.getTitle());
                            }
                        }
                        else if(bookid.equals("E")){
                            bcheck = true;
                        }
                        else{
                            bookborrow = Bdb.checkbook(bookid,"B");
                            if (bookborrow != null) {
                                Book bk = listborrow.stream()
                                         .filter(x -> bookborrow.getId().equals(x.getId()))
                                         .findAny().orElse(null);
                                if (bk != null){
                                    System.out.println("Book id  is duplicate  ==========");
                                }else {
                                    listborrow.add(bookborrow);
                                    System.out.println("count book borrow :  " + listborrow.size() + "  ==========");
                                }
                            }
                        }
                    }
                    Choose_menu(menu_key);
                    break;
                case "10":
                    bcheck = false;
                    System.out.println("10.Book Returns=============");
                    System.out.println("============================");
                    System.out.println("enter C : Confirms ,S : Show listbook ,E Exit  ");
                    System.out.println("============================");
                    ArrayList<Book> listreturns  = new ArrayList<Book>();
                    while(bcheck == false) {
                        System.out.println("Plz enter Book ID : ");
                        bookid = input.nextLine();
                        if(bookid.equals("C")){

                            bookln.return_Bookborrow(Bdb,listreturns,librarianStaff,"","",0);
                           System.out.println("Return Book is Success");
                            bcheck = true;
                        }
                        else if(bookid.equals("S")){
                            Iterator<Book> iter1 = listreturns.iterator();
                            System.out.println("List Books Return===========================");
                            System.out.println("id    title");
                            while (iter1.hasNext()) {
                                Book bk = iter1.next();
                                System.out.println(bk.getId() + "\t\t" + bk.getTitle());
                            }
                        }
                        else if(bookid.equals("E")){
                            bcheck = true;
                        }
                        else{
                            bookreturn = Bdb.checkbook(bookid,"R");
                            if (bookreturn != null) {
                                Book bk = listreturns.stream()
                                         .filter(x -> bookreturn.getId().equals(x.getId()))
                                         .findAny().orElse(null);
                                if (bk != null){
                                    System.out.println("Book id is duplicate  ==========");
                                }else {
                                    listreturns.add(bookreturn);
                                    System.out.println("count book return :  " + listreturns.size() + "  ==========");
                                }
                            }
                        }
                    }

                    Choose_menu(menu_key);
                    break;
                case "11":
                    Choose_Mainmenu();
                    break;
                case "12":
                    System.exit(0);
                    break;
            }
        }
    }

    static void Choose_Search(String key) {

        System.out.println("Menu Search Field Books ==================");
        System.out.println("1.Book id       2.Book Title    3.Category");
        System.out.println("4.Status        5.User id");
        System.out.println("6.Loan Date     7.Return Date");
        System.out.println("8.Return Menu   9.Exit Program");
        System.out.println("===========================================");
        System.out.println("Plz enter Key Search Field : ");
        String index = input.nextLine();
        String value= "" ;
        if (key.equals("staff")) {
            switch (index) {
                case "1":
                    System.out.println("Search Field Book id============");
                    System.out.println("Plz enter Book id : ");
                    value = input.nextLine();
                    Bdb.SearchBook("1",value);
                    Choose_Search(menu_key);
                    break;
                case "2":
                    System.out.println("Search Field Book Title============");
                    System.out.println("Plz enter Book Title : ");
                    value = input.nextLine();
                    Bdb.SearchBook("2",value);
                    Choose_Search(menu_key);
                    break;
                case "3":
                    System.out.println("Search Field Book Category==========");
                    System.out.println("Plz enter Book Category : ");
                    value = input.nextLine();
                    Bdb.SearchBook("3",value);
                    Choose_Search(menu_key);
                    break;
                case "4":
                    System.out.println("Search Field Book Status==========");
                    System.out.println("Plz enter Book Status : ");
                    value = input.nextLine();
                    Bdb.SearchBook("4",value);
                    Choose_Search(menu_key);
                    break;
                case "5":
                    System.out.println("Search Field Book User id==========");
                    System.out.println("Plz enter Book User id : ");
                    value = input.nextLine();
                    Bdb.SearchBook("5",value);
                    Choose_Search(menu_key);
                    break;
                case "6":
                    System.out.println("Search Field Book Loan Date==========");
                    System.out.println("Plz enter Book Loan Date : ");
                    value = input.nextLine();
                    Bdb.SearchBook("6",value);
                    Choose_Search(menu_key);
                    break;
                case "7":
                    System.out.println("Search Field Book Return Date==========");
                    System.out.println("Plz enter Book Return Date : ");
                    value = input.nextLine();
                    Bdb.SearchBook("7",value);
                    Choose_Search(menu_key);
                    break;
                case "8":
                    menu_key ="staff";
                    Choose_menu(menu_key);
                    break;
                case "9":
                    System.exit(0);
                    break;
            }
        }

    }
    public static void main(String[] args) {
	// write your code here
       Choose_Mainmenu();
       // DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
      //  Date date = new Date();
      //  System.out.println(sdf.format(date));


      /*  switch(menu_number) {
            case "1":
                System.out.println("Menu Staff ===============");
                System.out.println("1. Staff");
                System.out.println("2. Employee");
                System.out.println("3. Return Menu");
                System.out.println("4. Exit Program");
                System.out.println("==========================");
                break;
            case "2":
                System.out.println("Menu Employee ===============");
                System.out.println("1. Staff");
                System.out.println("2. Return Menu");
                System.out.println("3. Exit Program");
                System.out.println("=============================");
                break;
            case "3":
                System.exit(0);
        }
*/

 /*
        Scanner input = new Scanner(System.in);
        System.out.println("Plz enter ID : ");
        String id_input = input.nextLine();
        System.out.println("Plz enter Name : ");
        String name_input = input.nextLine();



*/

    }
}
