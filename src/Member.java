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
    private static int totalMembers;

    public Member(String name,String memberId){
        this(name,memberId,0);
    }
    public Member(String name,String memberId, int age){
        this(name,memberId,age,"N/A");
    }
    public Member(String name,String memberId, int age, String email){
        this(name,memberId,age,email,true);
    }
    public Member(String name,String memberId, int age, String email, boolean increment){
        super(name,age,email);
        this.memberId = memberId;
        if(increment){
            totalMembers++;
        }
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
    public int getBookCounter(){
        return this.bookCounter;
    }
    public int getJournalCounter(){
        return this.journalCounter;
    }
    public int getMagazineCounter(){
        return this.magazineCounter;
    }
    public static int getTotalMembers(){
        return Member.totalMembers;
    }
    public static void setTotalMembers(int totalMembers){
        Member.totalMembers = totalMembers;
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
        b.setIsAvailable(false);
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
            for (int i = 0; i < bookCounter; i++) {
                if (books[i]!= null && books[i].getTitle().equals(b.getTitle())){
                    for(int j=i;j<bookCounter-1;j++){
                        books[j]=books[j+1];
                    }
                    flag = true;
                    books[bookCounter-1] = null;
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
            for (int i = 0; i < journalCounter; i++) {
                if (journals[i]!= null && journals[i].getTitle().equals(j.getTitle())){
                    for(int k=i ;k<journalCounter-1;k++){
                        journals[k]=journals[k+1];
                    }
                    flag = true;
                    journals[journalCounter-1] = null;
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
            for (int i = 0; i < magazineCounter; i++) {
                if (magazines[i]!= null && magazines[i].getMagazineName().equals(m.getMagazineName())){
                    for(int j = i ;j<magazineCounter-1;j++){
                        magazines[j]=magazines[j+1];
                    }
                    flag = true;
                    magazines[magazineCounter-1] = null;
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
    public void lostBook(String isbn ){
        boolean flag = false;
        double fine = 10.0;
        if(bookCounter != 0){
            for (int i = 0; i < bookCounter; i++){                              //searchihng Book, if in member's occupation
                if (books[i]!= null && books[i].getISBN().equals(isbn)){
                    for(int j = i ;j<bookCounter-1;j++){
                        books[j]=books[j+1];
                    }
                    flag = true;
                    books[bookCounter-1] = null;
                    bookCounter--;
                    break;
                }
            }
            if(flag){
                System.out.println("\n\tYou Lost Book!");
                System.out.println("\n\tBook Lost Fine is "+fine+"$ !");
                addDueAmount(10);
                System.out.println("Your due amount is: " + dueAmount);
                return;
            }else{
                System.out.println("\n\tCouldnt Find Book with this ISBN! Retry Later!");}
        }
        else{
            System.out.println("\n\tYou havent Borrowed any Book!");
        }
    }
    public void lostJournal(String title){
        boolean flag = false;
        double fine = 6.0 ;
        if(journalCounter != 0){                                        //searhcing journal, if in member's occpuation
            for (int i = 0; i < journalCounter; i++){
                if(journals[i] != null && journals[i].getTitle().equalsIgnoreCase(title)){
                    for(int j = i ; j < journalCounter-1; j++){
                        journals[j] = journals[j+1];
                    }
                    flag = true;
                    journals[journalCounter-1] = null;
                    journalCounter--;
                    break;
                }
            }
            if(flag){
                System.out.println("\n\tYou Lost Journal!");
                System.out.println("\n\tJournal Lost Fine is "+fine+"$ !");
                addDueAmount(6);
                System.out.println("Your due amount is: " + dueAmount);
                return;
            }else{
                System.out.println("\n\tCouldnt Find JOURNAL with this Title! Retry Later!");
            }
        }
        else{
            System.out.println("\n\tYou havent Borrowed any Journal!");
        }
    }

    public void lostMagazine(String name){
        boolean flag = false;
        double fine = 3;
        if(magazineCounter != 0){                                        //searching magazine, if in member's occupation
            for (int i = 0; i < magazineCounter; i++){
                if(magazines[i] != null && magazines[i].getMagazineName().equalsIgnoreCase(name)){
                    for(int j = i ; j < magazineCounter-1; j++){
                        magazines[j] = magazines[j+1];
                    }
                    flag = true;
                    magazines[magazineCounter-1] = null;
                    magazineCounter--;
                    break;
                }
            }
            if(flag){
                System.out.println("\n\tYou Lost Magazine!");
                System.out.println("\n\tMagazine Lost Fine is "+fine+"$ !");
                addDueAmount(3);
                System.out.println("Your due amount is: " + dueAmount);
                return;
            }else{
                System.out.println("\n\tCouldnt Find MAGAZINE with this Name! Retry Later!");
            }
        }
        else{
            System.out.println("\n\tYou havent Borrowed any Magazine!");
        }
    }


    public void payDueAmount(double amount){
        if (amount > 0 && dueAmount > 0){
            System.out.println("Your due amount is: " + dueAmount);
            System.out.println("You Paid Amount: " + amount);
            dueAmount -= amount;
            System.out.println("Your Due Amount Now : " + dueAmount);
        }
        else if(dueAmount <= 0){
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
