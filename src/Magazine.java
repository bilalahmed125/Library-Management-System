import java.util.Scanner;

public class Magazine extends Publication{
    private String magazineName;
    private int publishDate;
    private int publishMonth;
    private int publishYear;
    private static int totalMagazine;

    public Magazine(String magazineName){
        this(magazineName,0,0,0000);
    }
    public Magazine(String magazineName, int publishDate, int publishMonth, int publishYear) {
        this.magazineName = magazineName;
        this.publishDate = publishDate;
        this.publishMonth = publishMonth;
        this.publishYear = publishYear;
        totalMagazine++;
        setTitle(magazineName+" News");
        setIsAvailable(true);
        setISBN(publishYear+"-"+publishMonth+"-"+publishDate);
        setAuthor(magazineName);
    }

    public String getMagazineName(){
        return this.magazineName;
    }
    public int getPublishDate(){
        return this.publishDate;
    }
    public int getPublishMonth(){
        return publishMonth;
    }
    public int getPublishYear(){
        return publishYear;
    }
    public void setMagazineName(String magazineName){
        this.magazineName = magazineName;
    }
    public void setPublishDate(int publishDate){
        this.publishDate = publishDate;
    }
    public void setPublishMonth(int publishMonth){
        this.publishMonth = publishMonth;
    }
    public void setPublishYear(int publishYear){
        this.publishYear = publishYear;
    }
    public static int getTotalMagazine(){
        return Magazine.totalMagazine;
    }
    public static void setTotalMagazine(int totalMagazine){
        Magazine.totalMagazine = totalMagazine;
    }

    @Override
    public void showDetails(){
        String publicationType = getClass().getSimpleName();
        System.out.println(publicationType + " Name: "+ magazineName );
        System.out.println(publicationType + " Publish Date: "+ publishDate + "-" + publishMonth + "-" + publishYear);
        System.out.println(publicationType + " ISBN: "+ getISBN() );
        System.out.println(publicationType + " Available: " + (getIsAvailable() ? "Yes" : "No") );
    }

    @Override
    public void updateDetails(){
        Scanner sc = new Scanner(System.in);
        String publicationType = getClass().getSimpleName();

        System.out.print("Enter "+ publicationType + " Name: ");
        this.magazineName = sc.nextLine();
        System.out.print("Enter "+ publicationType + " Publish Date: ");
        this.publishDate = sc.nextInt(); sc.nextLine();
        System.out.print("Enter "+ publicationType + " Publish Month: ");
        this.publishMonth = sc.nextInt(); sc.nextLine();
        System.out.print("Enter "+ publicationType + " Publish Year: ");
        this.publishYear = sc.nextInt(); sc.nextLine();
        System.out.println("Enter "+publicationType + " ISBN: ");
        String isbn = sc.nextLine();
        setISBN(isbn);
        System.out.println("Enter "+publicationType + " Available (yes/no): ");
        String available = sc.nextLine();
        boolean isAvailable = available.equalsIgnoreCase("yes") || available.equalsIgnoreCase("true") ? true : false;
        setIsAvailable(isAvailable);
    }

}
