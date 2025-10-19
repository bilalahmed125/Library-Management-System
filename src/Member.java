import java.util.Scanner;

public class Member extends Person {
    private String memberId;
    private double dueAmount;
    private int monthlyItemsBorrowed;
    private int borrowLimit = 5;


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

    public void borrowBook(Book b){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of "+ borrowLimit +" Items Reached! Cant Borrow more Items!");
            System.out.println("Please Renew your MemberShip! To reset the Borrowing Limit.");
        }
        else if(!b.getIsAvailable()){
            System.out.println("Book Not Available! Can't Borrow this Book!");
        }
        else if (dueAmount >0){
            System.out.println("Please Pay Due Amount Before Borrowing Book! Unable to Borrow!");
            System.out.println("Your Due Amount: "+ dueAmount);
        }
        else{
            System.out.println("\nBook :"+ b.getTitle() +" , author: "+ b.getAuthor() + " , BORROWED!");
            monthlyItemsBorrowed++;
            System.out.println("Number of Items You BORROWED: "+ monthlyItemsBorrowed );
            b.setIsAvailable(false);
        }

    }
    public void borrowJournal(Journal j){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of "+ borrowLimit +" Items Reached! Cant Borrow more Items!");
            System.out.println("Please Renew your MemberShip! To reset the Borrowing Limit.");
        }
        else if(!j.getIsAvailable()){
            System.out.println("Journal Not Available! Can't Borrow this Journal!");
        }
        else if (dueAmount >0){
            System.out.println("Please Pay Due Amount Before Borrowing Journal! Unable to Borrow!");
            System.out.println("Your Due Amount: "+ dueAmount);
        }
        else{
            System.out.println("\nJournal :"+ j.getTitle() +" , author: "+ j.getAuthor() + " , BORROWED!");
            monthlyItemsBorrowed++;
            System.out.println("Number of Items You BORROWED: "+ monthlyItemsBorrowed );
            j.setIsAvailable(false);
        }

    }
    public void borrowMagazine(Magazine m){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of "+ borrowLimit +" Items Reached! Cant Borrow more Items!");
            System.out.println("Please Renew your MemberShip! To reset the Borrowing Limit.");
        }
        else if(!m.getIsAvailable()){
            System.out.println("Magazine Not Available! Can't Borrow this Magazine!");
        }
        else if (dueAmount >0){
            System.out.println("Please Pay Due Amount Before Borrowing Magazine! Unable to Borrow!");
            System.out.println("Your Due Amount: "+ dueAmount);
        }
        else{
            System.out.println("\nMagazine :"+ m.getMagazineName() +" , Of Date: "+ m.getPublishDate() + " , BORROWED!");
            monthlyItemsBorrowed++;
            System.out.println("Number of Items You BORROWED: "+ monthlyItemsBorrowed );
            m.setIsAvailable(false);
        }

    }
    public void returnBook(Book b){
        System.out.println("BooK: "+ b.getTitle() +" , author: "+ b.getAuthor() + " , RETURNED!");
        System.out.println("Thank You for using our Service :)");
        b.setIsAvailable(true);

    }
    public void returnJournal(Journal j){
        System.out.println("Journal: "+ j.getTitle() +" , author: "+ j.getAuthor() + " , RETURNED!");
        System.out.println("Thank You for using our Service :)");
        j.setIsAvailable(true);
    }
    public void returnMagazine(Magazine m){
        System.out.println("Magazine: "+ m.getMagazineName() +" , of Date: "+ m.getPublishDate()+"-"+m.getPublishMonth()+"-"+m.getPublishYear() + " , RETURNED!");
        System.out.println("Thank You for using our Service :)");
        m.setIsAvailable(true);
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
        System.out.println("Enter "+memberType+" Name: ");
        String name = sc.nextLine();
        setName(name);
        System.out.println("Enter "+memberType+" ID: ");
        this.memberId = sc.nextLine();
        System.out.println("Enter "+memberType+" Age: ");
        int age = sc.nextInt();
        setAge(age);   sc.nextLine();
        System.out.println("Enter "+memberType+" Email: ");
        String email = sc.nextLine();
        setEmail(email);
    }

}
