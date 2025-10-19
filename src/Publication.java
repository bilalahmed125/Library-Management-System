public abstract class Publication {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Publication(){
        //empty helpeing method ForMagazine
    }
    public Publication(String title){
        this(title,"N/A");
    }
    public Publication(String title, String author){
        this(title,author,"N/A");
    }
    public Publication(String title, String author, String ISBN){
        this(title,author,ISBN,true);
    }
    public Publication(String title, String author, String ISBN, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }
    public void setIsAvailable(boolean available){
        isAvailable = available;
    }

    //public abstract void checkAvailability();
    public abstract void showDetails();
    public abstract void updateDetails();


}
