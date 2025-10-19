import java.util.Scanner;

public class Student extends AcademicMember{
//    private String studentID;
//  private String department;          both already in academicMember...
    private static int totalStudents;


    public Student(String name, String studentID){
        this(name,studentID,"N/A");
    }
    public Student(String name, String studentID, String department){
        this(name,studentID,department,0);
    }
    public Student(String name, String studentID, String department,int age){
        this(name,studentID,department,age,"N/A");
    }
    public Student(String name, String studentID, String department,int age,String email){
        super(name,studentID,department,age,email);
        setBorrowLimit(7);
        setAcademicID(studentID);
        totalStudents++;
    }

    public String getStudentID() {
        return getAcademicID();
    }
    public void setStudentID(String studentID) {
        setAcademicID(studentID);
    }
    public static int getTotalStudents() {
        return Student.totalStudents;
    }
    public static void setTotalStudents(int totalStudents) {
        Student.totalStudents = totalStudents;
    }

    @Override
    public double getDiscount(double amount){
        System.out.println("\t20% Student Discount!");
        amount = amount - (amount * 0.20);               //20% Student discunot
        return amount;
    }
    @Override
    public void lostBook(){
        double price;
        price = getDiscount(10);
        System.out.println("Book Lost Fine is "+ price +"$, (STUDENT DISCOUNT APPLIED!)");
        addDueAmount(price);
        System.out.println("Your due amount is: "+price);

    }
    @Override
    public void lostJournal(){
        double price;
        price = getDiscount(6);
        System.out.println("Journal Lost Fine is "+ price +"$, (STUDENT DISCOUNT APPLIED!)");
        addDueAmount(price);
        System.out.println("Your due amount is: "+price);
    }
    @Override
    public void lostMagazine(){
        double price;
        price = getDiscount(3);
        System.out.println("Magazine Lost Fine is "+ price +"$, (STUDENT DISCOUNT APPLIED!)");
        addDueAmount(price);
        System.out.println("Your due amount is: "+price);
    }

    @Override
    public void showDetails(){
        super.showDetails();
    }

    @Override
    public void updateDetails(){
        super.updateDetails();
    }


}
