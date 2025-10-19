public class Librarian extends Person{
    private String employeeId;
    private double salary;

    public Librarian(String name){
        this(name,"N/A");
    }
    public Librarian(String name,String employeeId){
        this(name,employeeId,0);
    }
    public Librarian(String name,String employeeId,int age){
        this(name,employeeId,age,"N/A");
    }
    public Librarian(String name,String employeeId,int age,String email){
        this(name,employeeId,age,email,0.0);
    }
    public Librarian(String name,String employeeId,int age,String email,double salary){
        super(name,age,email);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void issueBook(Member m,Book b){                                       //Any method that accpets member can also accpet Student and Teacher as they are child of Member.
        System.out.println("\n\tProccessing Issue BOOK!...");
        if(m.borrowBook(b)){
            String memberType = m.getClass().getSimpleName();
            System.out.println("\n\tBook :"+ b.getTitle() +" , author: "+ b.getAuthor() + " , BORROWED!");
            System.out.println("\tby, "+ memberType +" Name: "+ m.getName() + " , "+memberType+" ID: "+ m.getMemberId());
            System.out.println("Number of Items You BORROWED: "+ m.getMonthlyItemsBorrowed() + "/" + m.getBorrowLimit());
        }
        else{
            System.out.println("\tISSUE FAILED!");
        }
    }
    public void issueJournal(Member m,Journal j){                                  //Any method that accpets member can also accpet Student and Teacher as they are child of Member.
        System.out.println("\n\tProccessing Issue Journal!...");
        if(m.borrowJournal(j)){
            String memberType = m.getClass().getSimpleName();
            System.out.println("\n\tJournal : "+j.getTitle() +" , author: "+ j.getAuthor() + " , BORROWED!");
            System.out.println("\tby,"+memberType+ " Name: " + m.getName() + " , "+ memberType +" ID: "+ m.getMemberId());
            System.out.println("Number of Items you BORROWED: "+ m.getMonthlyItemsBorrowed() + "/" + m.getBorrowLimit());
        }
        else{
            System.out.println("\tISSUE FAILED!");
        }
    }
    public void issueMagazine(Member m,Magazine mag){                        //Any method that accpets member can also accpet Student and Teacher as they are child of Member.
        System.out.println("\n\tProccessing Issue Magazine!...");
        if(m.borrowMagazine(mag)){
            String memberType = m.getClass().getSimpleName();
            System.out.println("\n\tMagazine Name: "+mag.getMagazineName() + " , Publish Date: "+mag.getPublishDate()+"-"+mag.getPublishMonth()+"-"+mag.getPublishYear()+ "BORROWED1");
            System.out.println("\tby, "+ memberType +" Name: " + m.getName() + " , "+ memberType +" ID: "+ m.getMemberId());
            System.out.println("Number of Items You BORRWOED: "+m.getMonthlyItemsBorrowed() + "/" + m.getBorrowLimit());
        }
        else{
            System.out.println("\tISSUE FAILED!");
        }
    }
    public void returnBook(Member m,Book b){
        System.out.println("\n\tProccessing Return Book!...");
        if(m.returnBook(b)){
            String memberType = m.getClass().getSimpleName();
            System.out.println("BooK: " + b.getTitle() + " , author: " + b.getAuthor() + " , RETURNED!");
            System.out.println("\tby, "+ memberType +" Name: " + m.getName() + " , "+ memberType +" ID: "+ m.getMemberId());
            System.out.println("Thank You for using our Service :)");
        }
        else{
            System.out.println("\tRETURNED FAILED!");
        }
    }
    public void returnJournal(Member m,Journal j){
        System.out.println("\n\tProccessing Return Journal!...");
        if(m.returnJournal(j)){
            String memberType = m.getClass().getSimpleName();
            System.out.println("Journal: "+ j.getTitle() +" , author: "+ j.getAuthor() + " , RETURNED!");
            System.out.println("\tby, "+ memberType +" Name: " + m.getName() + " , "+ memberType +" ID: "+ m.getMemberId());
            System.out.println("Thank You for using our Service :)");
        }
        else{
            System.out.println("\tRETURNED FAILED!");
        }
    }
    public void returnMagazine(Member m,Magazine mag){
        System.out.println("\n\tProccessing Return Magazine!...");
        if(m.returnMagazine(mag)){
            String memberType = m.getClass().getSimpleName();
            System.out.println("Magazine: "+mag.getMagazineName() + " , Publish Date: "+mag.getPublishDate()+"-"+mag.getPublishMonth()+"-"+mag.getPublishYear()+ " , RETURNED!");
            System.out.println("\tby, "+ memberType +" Name: " + m.getName() + " , "+ memberType +" ID: "+ m.getMemberId());
            System.out.println("Thank You for using our Service :)");
        }
        else{
            System.out.println("\tRETURNED FAILED!");
        }
    }
    @Override
    public void showDetails(){

    }



}
