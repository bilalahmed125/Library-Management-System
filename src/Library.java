import java.util.Scanner;

public class Library {
    private String libraryName;
    private String libraryAddress;
    private int libraryContact;
    private String libraryEmail;

    private static final int maxLibrarians=2;
    private static final int maxMembers = 5;
    private static final int maxStudents = 3;
    private static final int maxTeachers = 2;
    private static final int maxBooks = 6;
    private static final int maxJournals= 3;
    private static final int maxMagazines = 2;

    private Librarian[] librarians = new Librarian[maxLibrarians];      //will compose
    private Member[]  members = new Member[maxMembers];              //will aggregrate
    private Student[] students = new Student[maxStudents];            //will aggregrate
    private Teacher[]  teachers = new Teacher[maxTeachers];           //will aggregrate
    private Book[] books = new Book[maxBooks];                     //will compose
    private Journal[] journals = new Journal[maxJournals];            //will compose
    private Magazine[] magazines = new Magazine[maxMagazines];         //will compose
    private int bookCounter;
    private int journalCounter;
    private int magazineCounter;
    private int librarianCounter;
    private int memberCounter;
    private int studentCounter;
    private int teacherCounter;


    Library(String libraryName){
        this(libraryName,"N/A");
    }
    Library(String libraryName, String libraryAddress){
        this(libraryName,libraryAddress,0);
    }
    Library(String libraryName, String libraryAddress, int libraryContact){
        this(libraryName,libraryAddress,libraryContact,"N/A");
    }
    Library(String libraryName, String libraryAddress, int libraryContact, String libraryEmail){
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
        this.libraryContact = libraryContact;
        this.libraryEmail = libraryEmail;
        this.librarians[0] = new Librarian("Ali Khan","LIB-123",22,"alikhan123@gmail.com",50000);

        this.books[0] = new Book("Introduction to Programming","Bilal","BK-001",true,300,"English",1);
        this.books[1] = new Book("Basics of Science","Hassan","BK-002",true,250,"English",2);
        this.books[2] = new Book("Learning Java","Bilal","BK-003",true,400,"English",1);
        bookCounter = 3;

        this.magazines[0] = new Magazine("Monthly Knowledge",10,8,2025);
        magazineCounter++;

        this.journals[0] = new Journal("Student Research Journal","ALI","JR-001",true,2025,"General Studies");
        this.journals[1] = new Journal("Science Insights","Ahmed","JR-002",true,2024,"General Science");

        journalCounter = 2;
        librarianCounter++;
    }

    public String getLibraryName(){
        return libraryName;
    }
    public String getLibraryAddress(){
        return libraryAddress;
    }
    public Librarian getLibrarians(int i){
        return librarians[i];
    }
    public Book getBook(int i){
        return books[i];
    }
    public Journal getJournal(int i){
        return journals[i];
    }
    public Magazine getMagazine(int i){
        return magazines[i];
    }
    public String getLibraryEmail(){
        return libraryEmail;
    }
    public int getLibraryContact(){
        return libraryContact;
    }
    public int getBookCounter(){
        return bookCounter;
    }
    public int getJournalCounter(){
        return journalCounter;
    }
    public int getMagazineCounter(){
        return magazineCounter;
    }



void addBook() {
        if(bookCounter < maxBooks){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter book Title: ");
            String title = sc.nextLine();
            System.out.println("Enter Book Author: ");
            String author = sc.nextLine();
            System.out.println("Enter BOOK ISBN: ");
            String isbn = sc.nextLine();
            System.out.println("Enter Book pages(int): ");
            int pages = sc.nextInt(); sc.nextLine();
            System.out.println("Enter BOOK language: ");
            String language = sc.nextLine();
            System.out.println("Enter Book Edition(int): ");
            int edition = sc.nextInt(); sc.nextLine();
            System.out.println("Enter Book Availibility(yes/no): ");
            String availibility = sc.nextLine();
            boolean isAvailable = availibility.equalsIgnoreCase("yes")||availibility.equalsIgnoreCase("true")? true:false;

            books[bookCounter] = new Book(title,author,isbn,isAvailable,pages,language,edition);               //composition...

            System.out.println("\n\tBook: "+books[bookCounter].getTitle()+" , author: "+books[bookCounter].getAuthor());
            System.out.println("\n\tBook Added Successfully!");
            bookCounter++;
        }
        else{
            System.out.println("\n\tBOOK Filled Cannot Add more!");
        }
    }
    public void addJournal(){
        if(journalCounter < maxJournals){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Journal Title: ");
            String title = sc.nextLine();
            System.out.println("Enter Journal Author: ");
            String author = sc.nextLine();
            System.out.println("Enter Journal ISBN: ");
            String isbn = sc.nextLine();
            System.out.println("Enter Journal Field: ");
            String field = sc.nextLine();
            System.out.println("Enter Journal Year(int): ");
            int year = sc.nextInt(); sc.nextLine();
            System.out.println("Enter Journal Availibility(yes/no): ");
            String availibility = sc.nextLine();
            boolean isAvailable = availibility.equalsIgnoreCase("yes")||availibility.equalsIgnoreCase("true")? true:false;

            journals[journalCounter] = new Journal(title,author,isbn,isAvailable,year,field);          //composition

            System.out.println("\n\tJournal: "+journals[journalCounter].getTitle()+" , author: "+journals[journalCounter].getAuthor());
            System.out.println("\n\tJournal Added Successfully!");
            journalCounter++;
        }
        else{
            System.out.println("\n\tJournal FIlled Cannot Add more!");
        }
    }
    public void addMagazine(){
        if(magazineCounter < maxMagazines){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Magazine Name: ");
            String magazineName = sc.nextLine();
            System.out.println("Enter Publish Year(int): ");
            int publishYear = sc.nextInt(); sc.nextLine();
            System.out.println("Enter Publish Month(int): ");
            int publishMonth = sc.nextInt(); sc.nextLine();
            System.out.println("Enter Publish Day(int): ");
            int publishDay = sc.nextInt(); sc.nextLine();

            magazines[magazineCounter] = new Magazine(magazineName,publishDay,publishMonth,publishYear);         //cpmostion

            System.out.println("\n\tMagazine: "+magazines[magazineCounter].getMagazineName()+" , Publish Date : "+magazines[magazineCounter].getPublishDate()+"-"+magazines[magazineCounter].getPublishMonth()+"-"+magazines[magazineCounter].getPublishYear());
            System.out.println("\n\tMagazine Added Successfully!");
            magazineCounter++;
        }
        else{
            System.out.println("\n\tMagazines FIlled Cannot Add more!");
        }
    }
    public void removeBook(String isbn){
        if(bookCounter > 0){
            boolean flag = false;
            Book b = null;
            for(int i = 0; i < bookCounter; i++){
                if(books[i].getISBN().equals(isbn)){
                    b = books[i];
                    for(int j=i ; j<bookCounter-1 ; j++){
                        books[j]=books[j+1];
                    }
                    bookCounter--;
                    books[bookCounter]=null;
                    Book.setTotalBooks(Book.getTotalBooks()-1);
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("\n\tBook: "+b.getTitle()+" , author: "+b.getAuthor());
                System.out.println("\n\tBook Removed Successfully!");
            }
            else{
                System.out.println("\n\tUnable to Find Such BOOK! Failed to remove!");
            }
        }
        else{
            System.out.println("\n\tNo BOOKS to REMOVE!");
        }
    }
    public void removeJournal(String isbn){
        if(journalCounter > 0){
            boolean flag = false;
            Journal journal = null;
            for(int i = 0; i < journalCounter; i++){
                if(journals[i].getISBN().equals(isbn)){
                    journal = journals[i];
                    for(int j=i ; j<journalCounter-1 ; j++){
                        journals[j]=journals[j+1];
                    }
                    journalCounter--;
                    journals[journalCounter]=null;
                    flag = true;
                    Journal.setTotalJournals(Journal.getTotalJournals()-1);
                    break;
                }
            }
            if(flag){
                System.out.println("\n\tJournal: "+journal.getTitle()+" , author: "+journal.getAuthor());
                System.out.println("\n\tJournal Removed Successfully!");
            }
            else{
                System.out.println("\n\tUnable to Find Such JOURNAL! Failed to remove!");
            }
        }
        else{
            System.out.println("\n\tNo Journals to REMOVE!");
        }
    }
    public void removeMagazine(String MagazineName){
        if(magazineCounter > 0){
            boolean flag = false;
            Magazine m = null;
            for(int i = 0; i < magazineCounter; i++){
                if(magazines[i].getMagazineName().equalsIgnoreCase(MagazineName)){
                    m = magazines[i];
                    for(int j=i ; j<magazineCounter-1 ; j++){
                        magazines[j]=magazines[j+1];
                    }
                    magazineCounter--;
                    magazines[magazineCounter]=null;
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("\n\tMagazine: "+m.getMagazineName()+" , Publish Date: "+m.getPublishDate()+"-"+m.getPublishMonth()+"-"+m.getPublishYear());
                System.out.println("\n\tMagazine Removed Successfully!");
                Magazine.setTotalMagazine(Magazine.getTotalMagazine()-1);
            }
            else{
                System.out.println("\n\tUnable to Find Such MAGAZINE! Failed to remove!");
            }
        }
        else{
            System.out.println("\n\tNo MAGAZINES to REMOVE!");
        }
    }
    public void searchPublication(String title){
        boolean found = false;
        if(bookCounter>0){
            for(int i=0;i<bookCounter;i++){
                if(books[i].getTitle().equalsIgnoreCase(title)){
                    System.out.println("\n\tBook: "+title+" , author: "+books[i].getAuthor());
                    System.out.println("\t\tBook FOUND!");
                    found = true;
                }
            }
        }
        if(journalCounter>0){
            for(int i=0;i<journalCounter;i++){
                if(journals[i].getTitle().equalsIgnoreCase(title)){
                    System.out.println("\n\tJournal: "+title+" , author: "+journals[i].getAuthor());
                    System.out.println("\t\tJournal FOUND!");
                    found = true;
                }
            }
        }
        if(magazineCounter>0){
            for(int i=0;i<magazineCounter;i++){
                if(magazines[i].getMagazineName().equalsIgnoreCase(title)){
                    System.out.println("\n\tMagazine: "+magazines[i].getMagazineName()+" , author: "+magazines[i].getPublishDate()+"-"+magazines[i].getPublishMonth()+"-"+magazines[i].getPublishYear());
                    System.out.println("\t\tMagazine FOUND!");
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println("\n\tNo Publications Found!!");
        }
    }

    public void addLibrarian(){
        Scanner sc = new Scanner(System.in);

        if(librarianCounter < maxLibrarians){
            System.out.println("Enter Librarian's Name: ");
            String name = sc.nextLine();
            System.out.println("Enter Librarian EmployeeID : ");
            String employeeID = sc.nextLine();
            System.out.println("Enter Librarian Age : ");
            int age = sc.nextInt(); sc.nextLine();
            System.out.println("Enter Librarian email : ");
            String email = sc.nextLine();
            System.out.println("Enter Librarian Salary : ");
            double salary = sc.nextDouble();  sc.nextLine();

            librarians[librarianCounter]= new Librarian(name,employeeID,age,email,salary);          //composition...
            System.out.println("\tLibrarian Name: "+ librarians[librarianCounter].getName()+" , EmployeeID: "+librarians[librarianCounter].getEmployeeId()+" , ADDED!");
            System.out.println("\n\tLibrarian Added Successfully!");
            librarianCounter++;
        }
        else{
            System.out.println("\n\tLibrarians FILLED! Cant add more Librarians at the moment!");
        }
    }
    public void removeLibrarian(String employeeID){
        if(librarianCounter>0){
            boolean flag = false;
            Librarian lib = null;
            for(int i=0;i<librarianCounter;i++){
                if(librarians[i].getEmployeeId().equals(employeeID)){
                    lib = librarians[i];
                    for(int j=i;j<librarianCounter-1;j++){
                        librarians[j]=librarians[j+1];
                    }
                    librarianCounter--;
                    flag = true;
                    Librarian.setTotalLibrarian(Librarian.getTotalLibrarian()-1);
                    librarians[librarianCounter]=null;
                    break;
                }
            }
            if(flag){
                System.out.println("\tLibrarian Name: " + lib.getName() + " , EmployeeID: " + lib.getEmployeeId());
                System.out.println("\n\tLibrarian REMOVED Successfully!");
            }
            else{
                System.out.println("\n\tLibrarian Not FOUND!Cant REmove!");
            }
        }else{
            System.out.println("\n\tNo Librarians to remove!");
        }
    }
    public void addMember(Member m){
        Scanner sc = new Scanner(System.in);

        if(memberCounter < maxMembers){
//            System.out.println("Enter Member's Name: ");
//            String name = sc.nextLine();
//            System.out.println("Enter MemberID : ");
//            String employeeID = sc.nextLine();
//            System.out.println("Enter Member Age : ");
//            int age = sc.nextInt(); sc.nextLine();
//            System.out.println("Enter Member email : ");
//            String email = sc.nextLine();
            members[memberCounter]=m;
            //members[memberCounter]= new Member(name,employeeID,age,email);          //composition...

            System.out.println("\tMEmber Name: "+ members[memberCounter].getName()+" , MemberID: "+members[memberCounter].getMemberId()+" , ADDED!");
            System.out.println("\n\tMember Added Successfully!");
            memberCounter++;
        }
        else{
            System.out.println("\n\tMEMBERS FILLED! Cant add more MEMBERS at the moment!");
        }
    }
    public void removeMember(String memberID){
        if(memberCounter>0){
            boolean flag = false;
            Member m = null;
            for(int i=0;i<memberCounter;i++){
                if(members[i].getMemberId().equals(memberID)){
                    m = members[i];
                    for(int j=i;j<memberCounter-1;j++){
                        members[j]=members[j+1];
                    }
                    memberCounter--;
                    members[memberCounter]=null;
                    flag = true;
                    Member.setTotalMembers(Member.getTotalMembers()-1);
                    break;
                }
            }
            if(flag) {
                System.out.println("\tMember Name: " + m.getName() + ", MemberID: " + m.getMemberId());
                System.out.println("\n\tMember Removed Successfully!");
            }
            else{
                System.out.println("\n\tMembers NOT FOUND!Cant REMOVE!");
            }
        }
        else{
            System.out.println("\n\tNO Members to Remove!");
        }
    }
    public void addStudent(Student s){
        Scanner sc = new Scanner(System.in);

        if(studentCounter < maxStudents){
//            System.out.println("Enter Student's Name: ");
//            String name = sc.nextLine();
//            System.out.println("Enter StudnetID : ");
//            String employeeID = sc.nextLine();
//            System.out.println("Enter Student Department : ");
//            String department = sc.nextLine();
//            System.out.println("Enter Studnet Age : ");
//            int age = sc.nextInt(); sc.nextLine();
//            System.out.println("Enter Student email : ");
//            String email = sc.nextLine();
              students[studentCounter]=s;
//            students[studentCounter]= new Student(name,employeeID,department,age,email);          //composition...

            System.out.println("\tStudent Name: "+ students[studentCounter].getName()+" , StudentID: "+students[studentCounter].getStudentID()+" , ADDED!");
            System.out.println("\n\tStudnets Added Successfully!");
            studentCounter++;
        }
        else{
            System.out.println("\n\tStudnets FILLED! Cant add more Students at the moment!");
        }
    }
    public void removeStudent(String studentID){
        if(studentCounter>0){
            boolean flag = false;
            Student s = null;
            for(int i=0;i<studentCounter;i++){
                if(students[i].getStudentID().equals(studentID)){
                    s = students[i];
                    for(int j=i;j<studentCounter-1;j++){
                        students[j]=students[j+1];
                    }
                    studentCounter--;
                    students[studentCounter]=null;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.println("\tStudent Name: " + s.getName() + ", StudnetID: " + s.getStudentID());
                System.out.println("\n\tStudent Removed Successfully!");
                Student.setTotalStudents(Student.getTotalStudents()-1);
            }
            else{
                System.out.println("\n\tSTUDENT NOT FOUND!Cant REMOVE!");
            }
        }
        else{
            System.out.println("\n\tNO STUDENTS to Remove!");
        }
    }
    public void addTeacher(Teacher t){
        Scanner sc = new Scanner(System.in);

        if(teacherCounter < maxTeachers){
//            System.out.println("Enter Teacher's Name: ");
//            String name = sc.nextLine();
//            System.out.println("Enter TeacherID : ");
//            String employeeID = sc.nextLine();
//            System.out.println("Enter Teacher Department : ");
//            String department = sc.nextLine();
//            System.out.println("Enter Teacher Age : ");
//            int age = sc.nextInt(); sc.nextLine();
//            System.out.println("Enter Teacher email : ");
//            String email = sc.nextLine();
//
//            teachers[teacherCounter]= new Teacher(name,employeeID,department,age,email);          //composition...
              teachers[teacherCounter] = t;
            System.out.println("\tTeacher Name: "+ teachers[teacherCounter].getName()+" , TeacherID: "+teachers[teacherCounter].getTeacherID()+" , ADDED!");
            System.out.println("\n\tTeacher Added Successfully!");
            teacherCounter++;
        }
        else{
            System.out.println("\n\tTeachers FILLED! Cant add more Teachers at the moment!");
        }
    }
    public void removeTeacher(String teacherID){
        if(teacherCounter>0){
            boolean flag = false;
            Teacher t = null;
            for(int i=0;i<teacherCounter;i++){
                if(teachers[i].getTeacherID().equals(teacherID)){
                    t = teachers[i];
                    for(int j=i;j<teacherCounter-1;j++){
                        teachers[j]=teachers[j+1];
                    }
                    teacherCounter--;
                    teachers[teacherCounter]=null;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.println("\tTeacher Name: " + t.getName() + ", TeacherID: " + t.getTeacherID());
                System.out.println("\n\tTeacher Removed Successfully!");
                Teacher.setTotalTeachers(Teacher.getTotalTeachers()-1);
            }
            else{
                System.out.println("\n\tTEACHER NOT FOUND!Cant REMOVE!");
            }
        }
        else{
            System.out.println("\n\tNO TEACHERs to Remove!");
        }
    }
    public void showTotalNumberOfMembers(){
        System.out.println("TotalNumber Of members : "+memberCounter);
    }
    public void showTotalNumberOfStudents(){
        System.out.println("TotalNumber of students : "+studentCounter);
    }
    public void showTotalNumberOfTeachers(){
        System.out.println("TotalNumber of teachers : "+teacherCounter);
    }
    public void showAllBooks(){
        if(bookCounter==0){
            System.out.println("No BOOKS ADDED TILL YET!");
            return;
        }
        for(int i = 0; i < bookCounter; i++){
            System.out.println("===================================================");
            books[i].showDetails();
            System.out.println("===================================================");
        }
    }
    public void showAllJournals(){
        if(journalCounter==0){
            System.out.println("No JOURNALS ADDED TILL YET!");
            return;
        }
        for(int i = 0; i < journalCounter; i++){
            System.out.println("===================================================");
            journals[i].showDetails();
            System.out.println("===================================================");
        }
    }
    public void showAllMagazines(){
        if(magazineCounter==0){
            System.out.println("No Magazines ADDED TILL YET!");
            return;
        }
        for(int i = 0; i < magazineCounter; i++){
            System.out.println("================================================");
            magazines[i].showDetails();
            System.out.println("==================================================");
        }
    }
    public void showAllMembers(){
        if(memberCounter==0){
            System.out.println("No Members ADDED TILL YET!");
            return;
        }
        for(int i = 0; i < memberCounter; i++){
            System.out.println("================================================");
            members[i].showDetails();
            System.out.println("================================================");
        }
    }
    public void showAllTeachers(){
        if(teacherCounter==0){
            System.out.println("No Teachers ADDED TILL YET!");
            return;
        }
        for(int i = 0; i < teacherCounter; i++){
            System.out.println("==============================================");
            teachers[i].showDetails();
            System.out.println("===============================================");
        }
    }
    public void showAllStudents(){
        if(studentCounter==0){
            System.out.println("No STUDENTs ADDED TILL YET!");
            return;
        }
        for(int i = 0; i < studentCounter; i++){
            System.out.println("===============================================");
            students[i].showDetails();
            System.out.println("===============================================");
        }
    }
    public void showLibraryDetails(){
        System.out.println("Library Name: " + libraryName);
        System.out.println("Library Address: " + libraryAddress);
        System.out.println("Library Contact: " + libraryContact);
        System.out.println("Library Email: " + libraryEmail);
    }
    public void updateLibraryDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Library Name: ");
        libraryName = sc.nextLine();
        System.out.println("Enter Library Address: ");
        libraryAddress = sc.nextLine();
        System.out.println("Enter Library Contact: ");
        libraryContact = sc.nextInt(); sc.nextLine();
        System.out.println("Enter Library Email: ");
        libraryEmail = sc.nextLine();
    }




}
