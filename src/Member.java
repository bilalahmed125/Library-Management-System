public class Member extends Person {
    private String memberId;
    private int dueAmount;
    private int monthlyItemsBorrowed;
    private int borrowLimit = 5;


    Member(String memberId){
        this(memberId,"N/A");
        this.memberId = memberId;
    }
    Member(String memberId, String name){
        super(name);
        this.memberId = memberId;
    }
    Member(String memberId, String name, int age){
        super(name,age);
        this.memberId = memberId;
    }
    Member(String memberId, String name, int age, String email){
        super(name,age,email);
        this.memberId = memberId;
    }

    void borrowBook(Book b){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of 5 Items Reached! Cant Borrow more Items!");
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
        }

    }
    void borrowJournal(Journal j){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of 5 Items Reached! Cant Borrow more Items!");
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
        }

    }
    void borrowMagazine(Magazine m){
        if(this.monthlyItemsBorrowed >= borrowLimit){
            System.out.println("Monthly borrowing Limit of 5 Items Reached! Cant Borrow more Items!");
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
        }

    }
    void returnBook(Book b){

    }
    void renewMemberShip() {
        monthlyItemsBorrowed = 0;
        System.out.println("Member Name: " + getName());
        System.out.println("Member ID: "+ memberId);
        System.out.println("MemberShip Renewed!\nThe BorrowLimit has been Reseted!");
        System.out.println("Your BorrowLimit : " + monthlyItemsBorrowed);
    }
}
