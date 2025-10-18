public class Student extends Member{
    private String studentID;
    private String department;


    public Student(String name,String studentID){
        this(name,studentID,"N/A");
    }
    public Student(String name, String studentID, String department){
        this(name,studentID,department,0);
    }
    public Student(String name, String studentID, String department,int age){
        this(name,studentID,department,age,"N/A");
    }
    public Student(String name, String studentID, String department,int age,String email){
        super(name,studentID,age,email);
        this.studentID = studentID;
        this.department = department;

    }

    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }



}
