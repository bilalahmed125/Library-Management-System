import java.util.Scanner;

public class Journal extends Publication{
    private int year;
    private String field;
    private static int totalJournals;

    public Journal(String title){
        this(title,"N/A");
    }
    public Journal(String title,String author){
        this(title,author,"N/A");
    }
    public Journal(String title,String author,String ISBN){
        this(title,author,ISBN,true);
    }
    public Journal(String title,String author,String ISBN,boolean isAvailable){
        this(title,author,ISBN,isAvailable,0);
    }
    public Journal(String title,String author,String ISBN,boolean isAvailable,int year){
        this(title,author,ISBN,isAvailable,year,"N/A");
    }
    public Journal(String title,String author, String ISBN, boolean isAvailable,int year,String field){
        super(title,author,ISBN,isAvailable);
        this.year = year;
        this.field = field;
        totalJournals++;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public static int getTotalJournals() {
        return Journal.totalJournals;
    }
    public static void setTotalJournals(int totalJournals) {
        Journal.totalJournals = totalJournals;
    }

    @Override
    public void showDetails(){
        String publicationType = getClass().getSimpleName();
        System.out.println(publicationType + " title: "+ getTitle() );
        System.out.println(publicationType + " author: "+ getAuthor() );
        System.out.println(publicationType + " ISBN: "+ getISBN() );
        System.out.println(publicationType + " year: "+ getYear() );
        System.out.println(publicationType + " field: "+ getField() );
        System.out.println(publicationType + " isAvailable: "+ (getIsAvailable()? "Yes" : "No" ) );
    }

    @Override
    public void updateDetails(){
        Scanner sc = new Scanner(System.in);
        String publicationType = getClass().getSimpleName();

        System.out.print("Enter "+publicationType+" title: ");
        String title = sc.nextLine();
        setTitle(title);
        System.out.print("Enter "+publicationType+" author: ");
        String author = sc.nextLine();
        setAuthor(author);
        System.out.print("Enter "+publicationType+" ISBN: ");
        String ISBN = sc.nextLine();
        setISBN(ISBN);
        System.out.print("Enter "+publicationType+" year: ");
        int year = sc.nextInt();       sc.nextLine();
        setYear(year);
        System.out.print("Enter "+publicationType+" field: ");
        String field = sc.nextLine();
        setField(field);
        System.out.print("Enter "+publicationType+" isAvailable (yes/no): ");
        String available = sc.nextLine();
        boolean isAvailable = available.equalsIgnoreCase("Yes") || available.equalsIgnoreCase("true") ? true : false;
        setIsAvailable(isAvailable);
    }

}
