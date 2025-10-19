public class Teacher extends AcademicMember{
    private String teacherID;
    private String department;

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
        this.teacherID = teacherID;
        this.department = department;
        setBorrowLimit(10);
        setAcademicID(teacherID);
    }

    public String getTeacherID() {
        return teacherID;
    }
    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public double getDiscount(double amount){
        System.out.println("\t10% Teacher's Discount!");
        amount = amount - (amount * 0.10);          //10% Teacher discunot
        return amount;
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
