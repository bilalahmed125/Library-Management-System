public class Library {
    private String libraryName;
    private String libraryAddress;
    private int libraryContact;
    private String libraryEmail;

    private int librarianCounter;
    private int publicationCounter;
    private int memberCounter;
    private int studentCounter;
    private int teacherCounter;

    //total books ,members, publications????


    private Librarian[] libarians = new Librarian[3];
    private Publication[] publications = new Publication[100];
    private Member[]  members = new Member[50];
    private Student[] students = new Student[30];
    private Teacher[]  teachers = new Teacher[15];


    Library(String libraryName){
        this(libraryName,"N/A");
        this.libraryName = libraryName;
    }
    Library(String libraryName, String libraryAddress){
        this(libraryName,libraryAddress,0);
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
    }
    Library(String libraryName, String libraryAddress, int libraryContact){
        this(libraryName,libraryAddress,libraryContact,"N/A");
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
        this.libraryContact = libraryContact;
    }
    Library(String libraryName, String libraryAddress, int libraryContact, String libraryEmail){
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
        this.libraryContact = libraryContact;
        this.libraryEmail = libraryEmail;
    }




}
