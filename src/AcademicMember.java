import java.util.Scanner;

public abstract class AcademicMember extends Member{
    private String academicID;
    private String department;

    public AcademicMember(String name, String academicID){
        this(name,academicID,"N/A");
    }
    public AcademicMember(String name, String academicID,String department){
        this(name,academicID,department,0);
    }
    public AcademicMember(String name, String academicID,String department, int age){
        this(name,academicID,department,age,"N/A");
    }
    public AcademicMember(String name, String academicID, String department, int age, String email){
        super(name,academicID,age,email);
        this.academicID = academicID;
        this.department = department;
        setMemberId(academicID);
    }

    public String getAcademicID() {
        return academicID;
    }
    public void setAcademicID(String academicID) {
        this.academicID = academicID;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract double getDiscount(double amount);

    @Override
    public void showDetails(){
        String memberType = getClass().getSimpleName();
        System.out.println(memberType +" Name: "+ getName());
        System.out.println(memberType +" ID: "+ academicID);
        System.out.println(memberType +" Department: "+ department);
        System.out.println(memberType +" Age: "+ getAge());
        System.out.println(memberType +" Email: "+ getEmail());
        System.out.println(memberType +" Due Amount: "+ getDueAmount());
        System.out.println(memberType +" Borrowed Items this Month: "+ getMonthlyItemsBorrowed());
    }
    @Override
    public void updateDetails(){
        Scanner sc = new Scanner(System.in);
        String memberType = getClass().getSimpleName();

        System.out.print("Enter "+memberType+" Name: ");
        String name = sc.nextLine();
        setName(name);
        System.out.print("Enter "+memberType+" ID: ");
        this.academicID = sc.nextLine();
        System.out.print("Enter "+memberType+"'s Department Name: ");
        this.department = sc.nextLine();
        System.out.print("Enter "+memberType+" Age: ");
        int age = sc.nextInt();
        setAge(age);   sc.nextLine();
        System.out.print("Enter "+memberType+" Email: ");
        String email = sc.nextLine();
        setEmail(email);
    }
}
