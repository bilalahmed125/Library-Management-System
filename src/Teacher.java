public class Teacher extends AcademicMember{

    private static int totalTeachers;

    public Teacher(String name, String teacherID){
        this(name,teacherID,"N/A");
    }
    public Teacher(String name, String teacherID, String department){
        this(name,teacherID,department,0);
    }
    public Teacher(String name, String teacherID, String department,int age){
        this(name,teacherID,department,age,"N/A");
    }
    public Teacher(String name, String teacherID, String department,int age,String email){
        super(name,teacherID,department,age,email);
        setBorrowLimit(10);
        setAcademicID(teacherID);
        totalTeachers++;
    }

    public String getTeacherID() {
        return getAcademicID();
    }
    public static int getTotalTeachers() {
        return Teacher.totalTeachers;
    }
    public static void setTotalTeachers(int totalTeachers) {
        Teacher.totalTeachers = totalTeachers;
    }
    @Override
    public double getDiscount(double amount){
        System.out.println("\t10% Teacher's Discount!");
        amount = amount - (amount * 0.10);          //10% Teacher discunot
        return amount;
    }
}
