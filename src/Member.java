import java.util.Scanner;

public class Member extends Person {
    private String memberId;
    private double dueAmount;
    private int monthlyItemsBorrowed;
    private int borrowLimit = 5;
    private Book[] books = new Book[5];
    private Journal [] journals = new Journal[5];
    private Magazine[] magazines = new Magazine[5];
    private int bookCounter;
    private int journalCounter;
    private int magazineCounter;


    public Member(String name,String memberId){
        this(name,memberId,0);
    }
    public Member(String name,String memberId, int age){
        this(name,memberId,age,"N/A");
    }
    public Member(String name,String memberId, int age, String email){
        super(name,age,email);
        this.memberId = memberId;
    }

    public void setMemberId(String memberId){
        this.memberId = memberId;
    }
    public String getMemberId(){
        return this.memberId;
    }
    public double getDueAmount(){
        return this.dueAmount;
    }
    public void setDueAmount(double dueAmount){
        this.dueAmount = dueAmount;
    }
    public int getMonthlyItemsBorrowed(){
        return this.monthlyItemsBorrowed;
    }
    public void setMonthlyItemsBorrowed(int monthlyItemsBorrowed){
        this.monthlyItemsBorrowed = monthlyItemsBorrowed;
    }
    public int getBorrowLimit(){
        return this.borrowLimit;
    }
    public void setBorrowLimit(int borrowLimit){
        this.borrowLimit = borrowLimit;
    }
    public void addDueAmount(double amount){
        this.dueAmount += amount;
    }

    public boolean borrowBook(Book b){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of "+ borrowLimit +" Items Reached! Cant Borrow more Items!");
            System.out.println("Please Renew your MemberShip! To reset the Borrowing Limit.");
            return false;
        }
        else if(!b.getIsAvailable()){
            System.out.println("Book Not Available! Can't Borrow this Book!");
            return false;
        }
        else if (dueAmount >0){
            System.out.println("Please Pay Due Amount Before Borrowing Book! Unable to Borrow!");
            System.out.println("Your Due Amount: "+ dueAmount);
            return false;
        }
        monthlyItemsBorrowed++;
        b.setIsAvailable(true);
        books[bookCounter] = b;
        bookCounter++;
        return true;
    }

    public boolean borrowJournal(Journal j){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of "+ borrowLimit +" Items Reached! Cant Borrow more Items!");
            System.out.println("Please Renew your MemberShip! To reset the Borrowing Limit.");
            return false;
        }
        else if(!j.getIsAvailable()){
            System.out.println("Journal Not Available! Can't Borrow this Journal!");
            return false;
        }
        else if (dueAmount >0){
            System.out.println("Please Pay Due Amount Before Borrowing Journal! Unable to Borrow!");
            System.out.println("Your Due Amount: "+ dueAmount);
            return false;
        }
        monthlyItemsBorrowed++;
        j.setIsAvailable(false);
        journals[journalCounter] = j;
        journalCounter++;
        return true;
    }

    public boolean borrowMagazine(Magazine m){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of "+ borrowLimit +" Items Reached! Cant Borrow more Items!");
            System.out.println("Please Renew your MemberShip! To reset the Borrowing Limit.");
            return false;
        }
        else if(!m.getIsAvailable()){
            System.out.println("Magazine Not Available! Can't Borrow this Magazine!");
            return false;
        }
        else if (dueAmount >0){
            System.out.println("Please Pay Due Amount Before Borrowing Magazine! Unable to Borrow!");
            System.out.println("Your Due Amount: "+ dueAmount);
            return false;
        }
        monthlyItemsBorrowed++;
        m.setIsAvailable(false);
        magazines[magazineCounter] = m;
        magazineCounter++;
        return true;
    }

    public boolean returnBook(Book b){
        boolean flag = false;
        if(bookCounter != 0){                                        //searchihng book, if in member's ocupation
            for (int i = 0; i < books.length; i++) {
                if (books[i]!= null && books[i].getISBN().equals(b.getISBN())){
                    flag = true;
                    books[i] = null;
                    bookCounter --;
                    break;
                }
            }
            if (flag){
                b.setIsAvailable(true);
                return true;
            } else{
                System.out.println("\n\tUnable To RETURN BOOK! You Didnt Borrow this Book!");
                return false;
            }
        }
        else{
            System.out.println("\n\tYou havent Borrowed any book till yet!");
            return false;
        }
    }
    public boolean returnJournal(Journal j){
        boolean flag = false;
        if(journalCounter != 0){                                        //searchihng jornal, if in member's ocupation
            for (int i = 0; i < journals.length; i++) {
                if (journals[i]!= null && journals[i].getISBN().equals(j.getISBN())){
                    flag = true;
                    journals[i] = null;
                    journalCounter--;
                    break;
                }
            }
            if (flag){
                j.setIsAvailable(true);
                return true;
            } else{
                System.out.println("\n\tUnable To RETURN JOURNAL! You Didnt Borrow this Journal!");
                return false;
            }
        }
        else{
            System.out.println("\n\tYou havent Borrowed any Journal till yet!");
            return false;
        }
    }
    public boolean returnMagazine(Magazine m){
        boolean flag = false;
        if(magazineCounter != 0){                                        //searchihng jornal, if in member's ocupation
            for (int i = 0; i < magazines.length; i++) {
                if (magazines[i]!= null && magazines[i].getISBN().equals(m.getISBN())){
                    flag = true;
                    magazines[i] = null;
                    magazineCounter--;
                    break;
                }
            }
            if (flag){
                m.setIsAvailable(true);
                return true;
            } else{
                System.out.println("\n\tUnable To RETURN Magazine! You Didnt Borrow this Magazine!");
                return false;
            }
        }
        else{
            System.out.println("\n\tYou havent Borrowed any Magazine till yet!");
            return false;
        }
    }
    public void renewMemberShip() {
        monthlyItemsBorrowed = 0;
        System.out.println("Member Name: " + getName());
        System.out.println("Member ID: "+ memberId);
        System.out.println("MemberxShip Renewed!\nThe BorrowLimit has been Reseted!");
        System.out.println("Your BorrowLimit : " + monthlyItemsBorrowed);
    }
    public void lostBook(){
        System.out.println("Book Lost Fine is 10$ !");
        addDueAmount(10);
        System.out.println("Your due amount is: "+dueAmount);
    }
    public void lostJournal(){
        System.out.println("Journal Lost Fine is 6$ !");
        addDueAmount(6);
        System.out.println("Your due amount is: "+dueAmount);
    }
    public void lostMagazine(){
        System.out.println("Magazine Lost Fine is 3$ !");
        addDueAmount(3);
        System.out.println("Your due amount is: "+dueAmount);
    }

    public void payDueAmount(int amount) {
        if (amount > 0 && dueAmount > 0) {
            System.out.println("Your due amount is: " + dueAmount);
            System.out.println("You Paid Amount: " + amount);
            dueAmount -= amount;
            System.out.println("Your Due Amount Now : " + dueAmount);
        }
        else if(dueAmount < 0){
            System.out.println("You dont have to Pay!\nYou Dont have Any DUE AMOUNT! :) ");
            System.out.println("\tAmount returned!");
        }
        else if(amount < 0){
            System.out.println("InValid Amount! Try again!");
        }
    }
    @Override
    public void showDetails(){
        String memberType = getClass().getSimpleName();
        System.out.println(memberType +" Name: "+ getName());
        System.out.println(memberType +" ID: "+ memberId);
        System.out.println(memberType +" Age: "+ getAge());
        System.out.println(memberType +" Email: "+ getEmail());
        System.out.println(memberType +" Due Amount: "+ dueAmount);
        System.out.println(memberType +" Borrowed Items this Month: "+ monthlyItemsBorrowed);
    }
    @Override
    public void updateDetails(){
        Scanner sc = new Scanner(System.in);
        String memberType = getClass().getSimpleName();

        System.out.print("Enter "+memberType+" Name: ");
        String name = sc.nextLine();
        setName(name);
        System.out.print("Enter "+memberType+" ID: ");
        this.memberId = sc.nextLine();
        System.out.print("Enter "+memberType+" Age: ");
        int age = sc.nextInt();
        setAge(age);   sc.nextLine();
        System.out.print("Enter "+memberType+" Email: ");
        String email = sc.nextLine();
        setEmail(email);
    }

}
