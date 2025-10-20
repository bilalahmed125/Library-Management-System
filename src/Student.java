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
    public double getDiscount(double amount) {
        amount = amount - (amount * 0.20);               //20% Student discunot
        return amount;
    }

    //  @Override
//    public void lostBook(String isbn){
//        super.lostBook(isbn);
//
//        double originalFine = 10;
//        double discountedFine = getDiscount(originalFine);
//
//        addDueAmount(-originalFine);
//        addDueAmount(discountedFine);
//
//        System.out.println("\n\tSTUDENT DISCOUNT APPLIED! Original Fine was: "+originalFine +"$ ,"+" Discounted Fine is: "+discountedFine+"$");
//        System.out.println("\n\tYour due amount is: "+getDueAmount());
//    }
//    @Override
//    public void lostJournal(String title){
//        super.lostJournal(title);
//
//        double originalFine = 6;
//        double discountedFine = getDiscount(originalFine);
//
//        addDueAmount(-originalFine);
//        addDueAmount(discountedFine);
//
//        System.out.println("\n\tSTUDENT DISCOUNT APPLIED! Original Fine was: "+originalFine +"$ ,"+" Discounted Fine is: "+discountedFine+"$");
//        System.out.println("\n\tYour due amount is: "+getDueAmount());
//    }
//    @Override
//    public void lostMagazine(String name){
//        super.lostMagazine(name);
//
//        double originalFine = 3;
//        double discountedFine = getDiscount(originalFine);
//
//        addDueAmount(-originalFine);
//        addDueAmount(discountedFine);
//
//        System.out.println("\n\tSTUDENT DISCOUNT APPLIED! Original Fine was: "+originalFine +"$ ,"+" Discounted Fine is: "+discountedFine+"$");
//        System.out.println("\n\tYour due amount is: "+getDueAmount());
//    }

//    @Override
//    public void showDetails;      no need as didnt add or extended the method , so we can use them as is from the parent's calss ;
//        super.showDetails();
//    }
//    @Override
//    public void updateDetails(){
//        super.updateDetails();
//    }


}
