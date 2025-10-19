import java.util.Scanner;

public class Book extends Publication{
    private int pages;
    private String language;
    private int edition;

    public Book(String title){
        this(title,"N/A");
    }
    public Book(String title, String author){
        this(title,author,"N/A");
    }
    public Book(String title,String author, String ISBN){
        this(title,author,ISBN,true);
    }
    public Book(String title, String author, String ISBN,boolean isAvailable){
        this(title,author,ISBN,isAvailable,0);
    }
    public Book(String title, String author, String ISBN, boolean isAvailable,int pages){
        this(title,author,ISBN,isAvailable,pages,"N/A");
    }
    public Book(String title, String author , String ISBN, boolean isAvailable, int pages, String language){
        this(title,author,ISBN,isAvailable,pages,language,0);
    }
    public Book(String title, String author, String ISBN, boolean isAvailable, int pages,String language, int edition){
        super(title,author,ISBN,isAvailable);
        this.pages = pages;
        this.language = language;
        this.edition = edition;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getLanguage() {
        return this.language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getEdition() {
        return edition;
    }
    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public void showDetails(){
        String publicationType = getClass().getSimpleName();
        System.out.println(publicationType + " title: "+ getTitle() );
        System.out.println(publicationType + " author: "+ getAuthor() );
        System.out.println(publicationType + " ISBN: "+ getISBN() );
        System.out.println(publicationType + " pages: "+ pages );
        System.out.println(publicationType + " language: "+ language );
        System.out.println(publicationType + " edition: "+ edition);
        System.out.println(publicationType + " Availible: " + (getIsAvailable() ? "Yes" : "No") );
    }

    @Override
    public void updateDetails(){
        Scanner sc = new Scanner(System.in);

        String publicationType = getClass().getSimpleName();
        System.out.println("Enter " +publicationType + " title: ");
        String title = sc.nextLine();
        setTitle(title);
        System.out.println("Enter " +publicationType + " author: ");
        String author = sc.nextLine();
        setAuthor(author);
        System.out.println("Enter " +publicationType + " ISBN: ");
        String ISBN = sc.nextLine();
        setISBN(ISBN);
        System.out.println("Enter " +publicationType + " pages: ");
        int pages = sc.nextInt();   sc.nextLine();
        System.out.println("Enter " +publicationType + " language: ");
        String language = sc.nextLine();
        System.out.println("Enter " +publicationType + " edition: ");
        int edition = sc.nextInt();
        System.out.println("Enter "+publicationType+" isAvailable (yes/no): ");
        String available = sc.nextLine();
        boolean isAvailable = available.equalsIgnoreCase("Yes") || available.equalsIgnoreCase("true") ? true : false;
        setIsAvailable(isAvailable);
    }



}
