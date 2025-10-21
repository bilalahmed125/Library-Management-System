import java.util.Scanner;

public class Librarian extends Person{
    private String employeeId;
    private double salary;
    private static int totalLibrarian;


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
        totalLibrarian++;
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
    public static int getTotalLibrarian() {
        return Librarian.totalLibrarian;
    }
    public static void setTotalLibrarian(int totalLibrarian) {
        Librarian.totalLibrarian = totalLibrarian;
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
    public void renewMemberShip(Member m) {
        String memberType = m.getClass().getSimpleName();
        System.out.println("\n\tProccessing Renew Member Ship!...");
        if (m.getBookCounter()==0 && m.getJournalCounter()==0 && m.getMagazineCounter()==0){
            m.setMonthlyItemsBorrowed(0);
            System.out.println(memberType + " Name: " + m.getName());
            System.out.println(memberType + " ID: " + m.getMemberId());
            System.out.println("\n\t" + memberType + "'s Member Ship Renewed!\nThe BorrowLimit has been Reseted!");
            System.out.println("Your BorrowLimit : " + m.getBorrowLimit());
        }
        else{
            System.out.println("\n\tPlease First Return the Borrowed Item(s), Before Renewal!");
            System.out.println("\n\tRENEWAL FAILED!");
        }
    }

    @Override
    public void showDetails(){
        String memberType = getClass().getSimpleName();
        System.out.println(memberType +" Name: "+ getName());
        System.out.println(memberType +" ID: "+ employeeId);
        System.out.println(memberType +" Age: "+ getAge());
        System.out.println(memberType +" Email: "+ getEmail());
        if(getSalary() != 0)
            System.out.println(memberType +" Salary: "+ getSalary());
        else
            System.out.println(memberType +" Salary: \"N/A\" ");
    }

    @Override
    public void updateDetails(){
        Scanner sc = new Scanner(System.in);
        String memberType = getClass().getSimpleName();

        System.out.print("Enter "+memberType+" Name: ");
        String name = sc.nextLine();
        setName(name);
        System.out.print("Enter "+memberType+" ID: ");
        this.employeeId = sc.nextLine();
        System.out.print("Enter "+memberType+" Age: ");
        int age = sc.nextInt();
        setAge(age);   sc.nextLine();
        System.out.print("Enter "+memberType+" Email: ");
        String email = sc.nextLine();
        setEmail(email);
        System.out.println("Enter"+ memberType +"Salary: ");
        this.salary = sc.nextDouble(); sc.nextLine();
    }
}
