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
        librarianCounter++;
    }

    public String getLibraryName(){
        return libraryName;
    }
    public String getLibraryAddress(){
        return libraryAddress;
    }
    public int getLibraryContact(){
        return libraryContact;
    }
    public String getLibraryEmail(){
        return libraryEmail;
    }


    public void addBook(Book b) {
        if (bookCounter < maxBooks){
            books[bookCounter] = b;
            System.out.println("\n\tBook: "+b.getTitle()+" , author: "+b.getAuthor());
            System.out.println("\n\tBook Added Successfully!");
            bookCounter++;
        }
    }
    public void addJournal(Journal j){
        if (journalCounter < maxJournals){
            journals[journalCounter] = j;
            System.out.println("\n\tJournal: "+j.getTitle()+" , author: "+j.getAuthor());
            System.out.println("\n\tJournal Added Successfully!");
            journalCounter++;
        }
    }
    public void addMagazine(Magazine m){
        if(magazineCounter < maxMagazines){
            magazines[magazineCounter] = m;
            System.out.println("\n\tMagazine: "+m.getTitle()+" , author: "+m.getAuthor());
            System.out.println("\n\tMagazine Added Successfully!");
            magazineCounter++;
        }
    }
    public void removeBook(Book b){
        if(bookCounter > 0){
            boolean flag = false;
            for(int i = 0; i < bookCounter; i++){
                if(books[i] == b){
                    for(int j=i ; j<bookCounter-1 ; j++){
                        books[j]=books[j+1];
                    }
                    bookCounter--;
                    books[bookCounter]=null;
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
    public void removeJournal(Journal journal){
        if(journalCounter > 0){
            boolean flag = false;
            for(int i = 0; i < journalCounter; i++){
                if(journals[i] == journal){
                    for(int j=i ; j<journalCounter-1 ; j++){
                        journals[j]=journals[j+1];
                    }
                    journalCounter--;
                    journals[journalCounter]=null;
                    flag = true;
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
    public void removeMagazine(Magazine m){
        if(magazineCounter > 0){
            boolean flag = false;
            for(int i = 0; i < magazineCounter; i++){
                if(magazines[i] == m){
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

    public void addLibrarian(Librarian lib){
        if(librarianCounter < maxLibrarians){
            librarians[librarianCounter] = lib;
            librarianCounter++;
            System.out.println("\tLibrarian Name: "+ lib.getName()+" , EmployeeID: "+lib.getEmployeeId()+" , ADDED!");
            System.out.println("\n\tLibrarian Added Successfully!");
        }
        else{
            System.out.println("\n\tLibrarians FILLED! Cant add more Librarians at the moment!");
        }
    }
    public void removeLibrarian(Librarian lib){
        if(librarianCounter>0){
            boolean flag = false;

            for(int i=0;i<librarianCounter;i++){
                if(librarians[i]==lib){
                    for(int j=i;j<librarianCounter-1;j++){
                        librarians[j]=librarians[j+1];
                    }
                    librarianCounter--;
                    flag = true;
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
        if(memberCounter < maxMembers ){
            members[memberCounter] = m;
            memberCounter++;
            System.out.println("\tMember Name: "+ m.getName()+", MemberID: "+m.getMemberId()+", ADDED!");
            System.out.println("\n\tMember Added Successfully!");
        }else{
            System.out.println("\n\tMembers Filled!Cant Add anymore Members Rightnow!");
        }
    }
    public void removeMember(Member m){
        if(memberCounter>0){
            boolean flag = false;
            for(int i=0;i<memberCounter;i++){
                if(members[i]==m){
                    for(int j=i;j<memberCounter-1;j++){
                        members[j]=members[j+1];
                    }
                    memberCounter--;
                    members[memberCounter]=null;
                    flag = true;
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
        if(studentCounter < maxStudents){
            students[studentCounter] = s;
            studentCounter++;
            System.out.println("\tStudent Name: "+ s.getName()+", StudnetID: "+s.getStudentID()+", ADDED!");
            System.out.println("\n\tStudent Added Successfully!");
        }
        else{
            System.out.println("\n\tStudents Filled!Cant Add anymore Students Right!");
        }
    }
    public void removeStudent(Student s){
        if(studentCounter>0){
            boolean flag = false;
            for(int i=0;i<studentCounter;i++){
                if(students[i]==s){
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
        if(teacherCounter < maxTeachers){
            teachers[teacherCounter] = t;
            teacherCounter++;
            System.out.println("\tTeacher Name: "+ t.getName()+", TeacherID: "+t.getTeacherID());
            System.out.println("\n\tTeacher Added Successfully!");
        }
        else{
            System.out.println("\n\tTeachers Filled!Cant Add anymore Teachers Right!");
        }
    }
    public void removeTeacher(Teacher t){
        if(teacherCounter>0){
            boolean flag = false;
            for(int i=0;i<teacherCounter;i++){
                if(teachers[i]==t){
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
            }
            else{
                System.out.println("\n\tTEACHER NOT FOUND!Cant REMOVE!");
            }
        }
        else{
            System.out.println("\n\tNO TEACHERs to Remove!");
        }
    }
    public void showTotalMembers(){
        System.out.println("TotalNumber Of members : "+memberCounter);
    }
    public void showTotalStudents(){
        System.out.println("TotalNumber of students : "+studentCounter);
    }
    public void showTotalTeachers(){
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
