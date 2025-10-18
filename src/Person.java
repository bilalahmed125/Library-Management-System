public abstract class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name) {
        this(name,0);
        this.name = name;
    }
    public Person(String name, int age){
        this(name,age,"N/A");
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }


    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(String age){
        this.age = age;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public void updateDetails(String name, String age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public abstract void showDetails();

}
