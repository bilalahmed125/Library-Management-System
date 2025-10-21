import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        Library lib = new Library("POF Library","Main Campus",12345678,"POF@library.com");

        Student[] students = new Student[5];        //will aggregrate
        students[0] = new Student("Ahmed Ali","STD-001","Computer Science",20,"ahmed@student.com");
        students[1] = new Student("hassan Khan","STD-002","Software Engineering",19,"hassan@student.com");

        Teacher[] teachers = new Teacher[5];
        teachers[0] = new Teacher("Dr Bilal","TCH-001","Computer Science",45,"Bilal@teacher.com");
        teachers[1] = new Teacher("Dr Ali","TCH-002","Mathematics",38,"Ali@teacher.com");

        Member[] members = new Member[5];
        members[0] = new Member("Ali Raza","MEM-001",30,"ali@gmail.com");
        members[1] = new Member("Bilal Ahmed","MEM-002",28,"bilal@gmail.com");
        members[2] = new Member("Akbar Ali","MEM-003",50,"akbar@gmail.com");

        int studentCounter = 2;
        int teacherCounter = 2;
        int memberCounter = 3;

        // Add members to library   
        lib.addStudent(students[0]);
        lib.addStudent(students[1]);
        lib.addTeacher(teachers[0]);
        lib.addTeacher(teachers[1]);
        lib.addMember(members[0]);
        lib.addMember(members[1]);

        System.out.println("\n\n\t\t=+=+=LIBRARY MANAGEMENT SYSTEM=+=+=");
        System.out.println("\t\tLibrary Initialized Successfully!");
        Librarian currentLibrarian= lib.getLibrarians(0);
        boolean foundBook;
        boolean foundJournal;
        boolean foundMagazine;
        String isbn;
        boolean flag;
        String magName;
        String title;
        
        while(true){
            System.out.println("\n\n\t\t=+=+=MAIN MENU=+=+=");
            System.out.println("1. Librarian Portal.");
            System.out.println("2. Student Portal.");
            System.out.println("3. Teacher Portal.");
            System.out.println("4. Member Portal.");
            System.out.println("5. View Library Statistics.");
            System.out.println("6. Exit.");
            System.out.print("=>Enter your Choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("\n\n\n\t\t-----Welcome to Librarian Portal-----");
                    System.out.print("Enter Librarian ID: ");
                    String Id = sc.nextLine();
                    boolean found = false;
                    for(int i = 0; i < Librarian.getTotalLibrarian(); i++){
                        String libID = lib.getLibrarians(i).getEmployeeId();
                        if(libID.equals(Id)){
                            System.out.println("\n\tLibrarian verified!");
                            found = true;
                            currentLibrarian = lib.getLibrarians(i);
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("\n\tINVALID LIBRARIAN ID!");
                        break;
                    }

                    flag = false;
                    while(true){
                        if(flag) break;

                        System.out.println("\n\t---Library Menu---");
                        System.out.println("1. Add Book.");
                        System.out.println("2. Add Journal.");
                        System.out.println("3. Add Magazine. ");
                        System.out.println("4. Remove Book.");
                        System.out.println("5. Remove Journal.");
                        System.out.println("6. Remove Magazine.");
                        System.out.println("7. Search Publication.");
                        System.out.println("8. Show All Books.");
                        System.out.println("9. Show All Journals.");
                        System.out.println("10. Show All Magazines.");
                        System.out.println("11. Add Librarian.");
                        System.out.println("12. Remove Librarian.");
                        System.out.println("13. Add Student.");
                        System.out.println("14. Add Teacher.");
                        System.out.println("15. Add Member");
                        System.out.println("16. Remove Student.");
                        System.out.println("17. Remove Teacher.");
                        System.out.println("18. Remove Member");
                        System.out.println("19. Show All Students");
                        System.out.println("20. Show All Teachers");
                        System.out.println("21. Show All Members.");
                        System.out.println("22. Show Library Details.");
                        System.out.println("23. Update Library Details.");
                        System.out.println("24. Return to Main Menu.");
                        System.out.print("Enter your choice: ");
                        int ch = sc.nextInt(); sc.nextLine();

                        switch(ch){
                            case 1:
                                System.out.println("\n\t---Add Book---");
                                lib.addBook();
                                break;

                            case 2:
                                System.out.println("\n\t---Add Journal---");
                                lib.addJournal();
                                break;

                            case 3:
                                System.out.println("\n\t---Add Magazine---");
                                lib.addMagazine();
                                break;

                            case 4:
                                System.out.println("\n\t---Remove Book---");
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                lib.removeBook(isbn);
                                break;

                            case 5:
                                System.out.println("\n\t---Remove Journal---");
                                System.out.print("Enter Journal ISBN: ");
                                isbn = sc.nextLine();
                                lib.removeJournal(isbn);
                                break;

                            case 6:
                                System.out.println("\n\t---Remove Magazine---");
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                lib.removeMagazine(magName);
                                break;

                            case 7:
                                System.out.println("\n\t---Search Publication---");
                                System.out.print("Enter Title to Search: ");
                                title = sc.nextLine();
                                lib.searchPublication(title);
                                break;

                            case 8:
                                System.out.println("\n\t---All Books---");
                                lib.showAllBooks();
                                break;

                            case 9:
                                System.out.println("\n\t---All Journals---");
                                lib.showAllJournals();
                                break;

                            case 10:
                                System.out.println("\n\t---All Magazines---");
                                lib.showAllMagazines();
                                break;

                            case 11:
                                System.out.println("\n\t---Add Librarian   )---");
                                lib.addLibrarian();
                                break;

                            case 12:
                                System.out.println("\n\t---Remove Librarian---");
                                System.out.print("Enter Librarian Employee ID: ");
                                String empId = sc.nextLine();
                                lib.removeLibrarian(empId);
                                break;

                            case 13:
                                System.out.println("\n\t---Add Student   ---");
                                if(studentCounter >= 5){
                                    System.out.println("Student Array Full! Cannot add more students.");
                                    break;
                                }
                                System.out.print("Enter Student Name: ");
                                String sName = sc.nextLine();
                                System.out.print("Enter Student ID: ");
                                String sId = sc.nextLine();
                                System.out.print("Enter Department: ");
                                String sDept = sc.nextLine();
                                System.out.print("Enter Age: ");
                                int sAge = sc.nextInt(); sc.nextLine();
                                System.out.print("Enter Email: ");
                                String sEmail = sc.nextLine();
                                students[studentCounter] = new Student(sName,sId,sDept,sAge,sEmail);
                                lib.addStudent(students[studentCounter]);
                                studentCounter++;
                                break;

                            case 14:
                                System.out.println("\n\t---Add Teacher   ---");
                                if(teacherCounter >= 5){
                                    System.out.println("Teacher Array Full! Cannot add more teachers.");
                                    break;
                                }
                                System.out.print("Enter Teacher Name: ");
                                String tName = sc.nextLine();
                                System.out.print("Enter Teacher ID: ");
                                String tId = sc.nextLine();
                                System.out.print("Enter Department: ");
                                String tDept = sc.nextLine();
                                System.out.print("Enter Age: ");
                                int tAge = sc.nextInt(); sc.nextLine();
                                System.out.print("Enter Email: ");
                                String tEmail = sc.nextLine();
                                teachers[teacherCounter] = new Teacher(tName,tId,tDept,tAge,tEmail);
                                lib.addTeacher(teachers[teacherCounter]);
                                teacherCounter++;
                                break;

                            case 15:
                                System.out.println("\n\t---Add Member   ---");
                                if(memberCounter >= 5){
                                    System.out.println("Member Array Full! Cannot add more members.");
                                    break;
                                }
                                System.out.print("Enter Member Name: ");
                                String mName = sc.nextLine();
                                System.out.print("Enter Member ID: ");
                                String mId = sc.nextLine();
                                System.out.print("Enter Age: ");
                                int mAge = sc.nextInt(); sc.nextLine();
                                System.out.print("Enter Email: ");
                                String mEmail = sc.nextLine();
                                members[memberCounter] = new Member(mName,mId,mAge,mEmail);
                                lib.addMember(members[memberCounter]);
                                memberCounter++;
                                break;

                            case 16:
                                System.out.println("\n\t---Remove Student---");
                                System.out.print("Enter Student ID: ");
                                String stdId = sc.nextLine();
                                lib.removeStudent(stdId);
                                break;

                            case 17:
                                System.out.println("\n\t---Remove Teacher---");
                                System.out.print("Enter Teacher ID: ");
                                String tchId = sc.nextLine();
                                lib.removeTeacher(tchId);
                                break;

                            case 18:
                                System.out.println("\n\t---Remove Member---");
                                System.out.print("Enter Member ID: ");
                                String memId = sc.nextLine();
                                lib.removeMember(memId);
                                break;

                            case 19:
                                System.out.println("\n\t---All Students---");
                                lib.showAllStudents();
                                break;

                            case 20:
                                System.out.println("\n\t---All Teachers---");
                                lib.showAllTeachers();
                                break;

                            case 21:
                                System.out.println("\n\t---All Members---");
                                lib.showAllMembers();
                                break;

                            case 22:
                                System.out.println("\n\t---Library Details---");
                                lib.showLibraryDetails();
                                System.out.println("Total Books: " + lib.getBookCounter());
                                System.out.println("Total Journals: " + lib.getJournalCounter());
                                System.out.println("Total Magazines: " + lib.getMagazineCounter());
                                System.out.println("Total Librarians: " + Librarian.getTotalLibrarian());
                                System.out.println("Total Members: " + Member.getTotalMembers());
                                System.out.println("Total Students: " + Student.getTotalStudents());
                                System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
                                break;

                            case 23:
                                System.out.println("\n\t---Update Library Details---");
                                lib.updateLibraryDetails();
                                break;

                            case 24:
                                System.out.println("Returning to Main Menu...\n");
                                flag = true;
                                continue;

                            default:
                                System.out.println("INVALID CHOICE! Please Try Again.\n");
                                continue;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n\n\n\t\t-----Welcome to Student Portal-----");
                    flag = false;

                    System.out.print("Enter Student ID: ");
                    String stdId = sc.nextLine();
                    Student currentStudent = null;
                    for(int i=0; i<studentCounter; i++){
                        if(students[i].getStudentID().equals(stdId)){
                            currentStudent = students[i];
                            break;
                        }
                    }

                    if(currentStudent == null){
                        System.out.println("Invalid Student ID!");
                        break;
                    }

                    System.out.println("Welcome, " + currentStudent.getName() + "!");

                    while(true){
                        if(flag) break;

                        System.out.println("\n\t---Student Menu---");
                        System.out.println("1. Borrow Book.");
                        System.out.println("2. Borrow Journal.");
                        System.out.println("3. Borrow Magazine.");
                        System.out.println("4. Return Book.");
                        System.out.println("5. Return Journal.");
                        System.out.println("6. Return Magazine.");
                        System.out.println("7. Report Lost Book (20% Discount).");
                        System.out.println("8. Report Lost Journal (20% Discount).");
                        System.out.println("9. Report Lost Magazine (20% Discount).");
                        System.out.println("10. Pay Due Amount.");
                        System.out.println("11. View My Details.");
                        System.out.println("12. Update My Details.");
                        System.out.println("13. Search Publication.");
                        System.out.println("14. Return to Main Menu.");
                        System.out.print("Enter your choice: ");
                        int ch = sc.nextInt(); sc.nextLine();

                        switch(ch){
                            case 1:
                                System.out.println("\n\t---Borrow Book---");
                                lib.showAllBooks();
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                foundBook = false;

                                for(int i = 0; i < lib.getBookCounter(); i++){
                                    if(isbn.equals(lib.getBook(i).getISBN())){
                                        System.out.println("\n\tBOOK Found!");
                                        currentLibrarian.issueBook(currentStudent,lib.getBook(i));
                                        foundBook = true;
                                        break;
                                    }
                                }
                                if(!foundBook) System.out.println("\n\tNo BOOKS available with such ISBN!");
                                break;

                            case 2:
                                System.out.println("\n\t---Borrow Journal---");
                                lib.showAllJournals();
                                System.out.print("Enter Journal ISBN: ");
                                isbn = sc.nextLine();
                                foundJournal = false;

                                for(int i = 0; i < lib.getJournalCounter(); i++){
                                    if(isbn.equals(lib.getJournal(i).getISBN())){
                                        System.out.println("\n\tJournal Found!");
                                        currentLibrarian.issueJournal(currentStudent,lib.getJournal(i));
                                        foundJournal = true;
                                        break;
                                    }
                                }
                                if(!foundJournal) System.out.println("\n\tNo Journals available with such ISBN!");
                                break;

                            case 3:
                                System.out.println("\n\t---Borrow Magazine---");
                                lib.showAllMagazines();
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                foundMagazine = false;

                                for(int i = 0; i < lib.getMagazineCounter(); i++)
                                {   
                                    if(magName.equalsIgnoreCase(lib.getMagazine(i).getMagazineName()))
                                    {
                                        System.out.println("\n\tMagazine Found!");
                                        currentLibrarian.issueMagazine(currentStudent, lib.getMagazine(i));
                                        foundMagazine = true;
                                        break;
                                    }
                                }
                                if(!foundMagazine)
                                    System.out.println("\n\tNo Magazines available with such name!");
                                break;


                            case 4:
                                System.out.println("\n\t---RETURN Book---");
                                lib.showAllBooks();
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                foundBook = false;

                                for(int i = 0; i < lib.getBookCounter(); i++){
                                    if(isbn.equals(lib.getBook(i).getISBN())){
                                        currentLibrarian.returnBook(currentStudent,lib.getBook(i));
                                        foundBook = true;
                                        break;
                                    }
                                }
                                if(!foundBook) System.out.println("\n\tLibrary Doesnot Contain Book with such ISBN!");
                                break;

                            case 5:
                                System.out.println("\n\t---RETURN Journal---");
                                lib.showAllJournals();
                                System.out.print("Enter Journal ISBN: ");
                                isbn = sc.nextLine();
                                foundJournal = false;

                                for(int i = 0; i < lib.getJournalCounter(); i++){
                                    if(isbn.equals(lib.getJournal(i).getISBN())){
                                        currentLibrarian.returnJournal(currentStudent,lib.getJournal(i));
                                        foundJournal = true;
                                        break;
                                    }
                                }
                                if(!foundJournal) System.out.println("\n\tLibrary Doesnot Contain Journal with such ISBN!");
                                break;

                            case 6:
                                System.out.println("\n\t---RETURN Magazine---");
                                lib.showAllMagazines();
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                foundMagazine = false;

                                for(int i = 0; i < lib.getMagazineCounter(); i++){
                                    if(magName.equalsIgnoreCase(lib.getMagazine(i).getMagazineName())){
                                        currentLibrarian.returnMagazine(currentStudent,lib.getMagazine(i));
                                        foundMagazine = true;
                                        break;
                                    }
                                }
                                if(!foundMagazine) System.out.println("\n\tNo MAGAZINES available with such Name in this Library!");
                                break;

                            case 7:
                                System.out.println("\n\t---Report Lost Book---");
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                currentStudent.lostBook(isbn);
                                break;

                            case 8:
                                System.out.println("\n\t---Report Lost Journal---");
                                System.out.print("Enter Journal Title: ");
                                title = sc.nextLine();
                                currentStudent.lostJournal(title);
                                break;

                            case 9:
                                System.out.println("\n\t---Report Lost Magazine---");
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                currentStudent.lostMagazine(magName);
                                break;

                            case 10:
                                System.out.println("\n\t---Pay Due Amount---");
                                System.out.print("Enter Amount: ");
                                double amount = sc.nextDouble(); sc.nextLine();
                                currentStudent.payDueAmount(amount);
                                break;

                            case 11:
                                System.out.println("\n\t---My Details---");
                                currentStudent.showDetails();
                                break;

                            case 12:
                                System.out.println("\n\t---Update My Details---");
                                currentStudent.updateDetails();
                                break;

                            case 13:
                                System.out.println("\n\t---Search Publication---");
                                System.out.print("Enter Title: ");
                                title = sc.nextLine();
                                lib.searchPublication(title);
                                break;

                            case 14:
                                System.out.println("Returning to Main Menu...\n");
                                flag = true;
                                continue;

                            default:
                                System.out.println("INVALID CHOICE! Please Try Again.\n");
                                continue;
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n\n\n\t\t-----Welcome to Teacher Portal-----");
                    flag = false;

                    System.out.print("Enter Teacher ID: ");
                    String tchId = sc.nextLine();
                    Teacher currentTeacher = null;
                    for(int i=0; i<teacherCounter; i++){
                        if(teachers[i].getTeacherID().equals(tchId)){
                            currentTeacher = teachers[i];
                            break;
                        }
                    }

                    if(currentTeacher == null){
                        System.out.println("Invalid Teacher ID!");
                        break;
                    }

                    System.out.println("Welcome, " + currentTeacher.getName() + "!");

                    while(true){
                        if(flag) break;

                        System.out.println("\n\t---Teacher Menu---");
                        System.out.println("1. Borrow Book.");
                        System.out.println("2. Borrow Journal.");
                        System.out.println("3. Borrow Magazine.");
                        System.out.println("4. Return Book.");
                        System.out.println("5. Return Journal.");
                        System.out.println("6. Return Magazine.");
                        System.out.println("7. Report Lost Book (10% Discount).");
                        System.out.println("8. Report Lost Journal (10% Discount).");
                        System.out.println("9. Report Lost Magazine (10% Discount).");
                        System.out.println("10. Pay Due Amount.");
                        System.out.println("11. View My Details.");
                        System.out.println("12. Update My Details.");
                        System.out.println("13. Search Publication.");
                        System.out.println("14. Return to Main Menu.");
                        System.out.print("Enter your choice: ");
                        int ch = sc.nextInt(); sc.nextLine();

                        switch(ch){
                            case 1:
                                System.out.println("\n\t---Borrow Book---");
                                lib.showAllBooks();
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                foundBook = false;

                                  for(int i = 0; i < lib.getBookCounter(); i++){
                                    if(isbn.equals(lib.getBook(i).getISBN())){
                                        System.out.println("\n\tBook Found!");
                                        currentLibrarian.issueBook(currentTeacher, lib.getBook(i));
                                        foundBook = true;
                                        break;
                                    }
                                }
                                if(!foundBook) System.out.println("\n\tNo BOOKS available with such ISBN!");
                                break;

                            case 2:
                                System.out.println("\n\t---Borrow Journal---");
                                lib.showAllJournals();
                                System.out.print("Enter Journal ISBN: ");
                                isbn = sc.nextLine();
                                foundJournal = false;

                                  for(int i = 0; i < lib.getJournalCounter(); i++){
                                    if(isbn.equals(lib.getJournal(i).getISBN())){
                                        System.out.println("\n\tJournal Found!");
                                        currentLibrarian.issueJournal(currentTeacher, lib.getJournal(i));
                                        foundJournal = true;
                                        break;
                                    }
                                }
                                if(!foundJournal) System.out.println("\n\tNo Journals available with such ISBN!");
                                break;

                            case 3:
                                System.out.println("\n\t---Borrow Magazine---");
                                lib.showAllMagazines();
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                foundMagazine = false;

                                  for(int i = 0; i < lib.getMagazineCounter(); i++){
                                    if(magName.equalsIgnoreCase(lib.getMagazine(i).getMagazineName())){
                                        System.out.println("\n\tMagazine Found!");
                                        currentLibrarian.issueMagazine(currentTeacher, lib.getMagazine(i));
                                        foundMagazine = true;
                                        break;
                                    }
                                }
                                if(!foundMagazine) System.out.println("\n\tNo Magazines available with such Name!");
                                break;

                            case 4:
                                System.out.println("\n\t---RETURN Book---");
                                lib.showAllBooks();
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                foundBook = false;

                                  for(int i = 0; i < lib.getBookCounter(); i++){
                                    if(isbn.equals(lib.getBook(i).getISBN())){
                                        currentLibrarian.returnBook(currentTeacher, lib.getBook(i));
                                        foundBook = true;
                                        break;
                                    }
                                }
                                if(!foundBook) System.out.println("\n\tLibrary Doesnot Contain Book with such ISBN!");
                                break;

                            case 5:
                                System.out.println("\n\t---RETURN Journal---");
                                lib.showAllJournals();
                                System.out.print("Enter Journal ISBN: ");
                                isbn = sc.nextLine();
                                foundJournal = false;

                                  for(int i = 0; i < lib.getJournalCounter(); i++){
                                    if(isbn.equals(lib.getJournal(i).getISBN())){
                                        currentLibrarian.returnJournal(currentTeacher, lib.getJournal(i));
                                        foundJournal = true;
                                        break;
                                    }
                                }
                                if(!foundJournal) System.out.println("\n\tLibrary Doesnot Contain Journal with such ISBN!");
                                break;

                            case 6:
                                System.out.println("\n\t---RETURN Magazine---");
                                lib.showAllMagazines();
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                foundMagazine = false;

                                  for(int i = 0; i < lib.getMagazineCounter(); i++){
                                    if(magName.equalsIgnoreCase(lib.getMagazine(i).getMagazineName())){
                                        currentLibrarian.returnMagazine(currentTeacher, lib.getMagazine(i));
                                        foundMagazine = true;
                                        break;
                                    }
                                }
                                if(!foundMagazine) System.out.println("\n\tNo MAGAZINES available with such Name in this Library!");
                                break;

                            case 7:
                                System.out.println("\n\t---Report Lost Book---");
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                currentTeacher.lostBook(isbn);
                                break;

                            case 8:
                                System.out.println("\n\t---Report Lost Journal---");
                                System.out.print("Enter Journal Title: ");
                                title = sc.nextLine();
                                currentTeacher.lostJournal(title);
                                break;

                            case 9:
                                System.out.println("\n\t---Report Lost Magazine---");
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                currentTeacher.lostMagazine(magName);
                                break;

                            case 10:
                                System.out.println("\n\t---Pay Due Amount---");
                                System.out.print("Enter Amount: ");
                                double amount = sc.nextDouble(); sc.nextLine();
                                currentTeacher.payDueAmount(amount);
                                break;

                            case 11:
                                System.out.println("\n\t---My Details---");
                                currentTeacher.showDetails();
                                break;

                            case 12:
                                System.out.println("\n\t---Update My Details---");
                                currentTeacher.updateDetails();
                                break;

                            case 13:
                                System.out.println("\n\t---Search Publication---");
                                System.out.print("Enter Title: ");
                                title = sc.nextLine();
                                lib.searchPublication(title);
                                break;

                            case 14:
                                System.out.println("Returning to Main Menu...\n");
                                flag = true;
                                continue;

                            default:
                                System.out.println("INVALID CHOICE! Please Try Again.\n");
                                continue;
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n\n\n\t\t-----Welcome to Member Portal-----");
                    flag = false;

                    System.out.print("Enter Member ID: ");
                    String memId = sc.nextLine();
                    Member currentMember = null;
                    for(int i=0; i<memberCounter; i++){
                        if(members[i].getMemberId().equals(memId)){
                            currentMember = members[i];
                            break;
                        }
                    }

                    if(currentMember == null){
                        System.out.println("Invalid Member ID!");
                        break;
                    }

                    System.out.println("Welcome, " + currentMember.getName() + "!");

                    while(true){
                        if(flag) break;

                        System.out.println("\n\t---Member Menu---");
                        System.out.println("1. Borrow Book.");
                        System.out.println("2. Borrow Journal.");
                        System.out.println("3. Borrow Magazine.");
                        System.out.println("4. Return Book.");
                        System.out.println("5. Return Journal.");
                        System.out.println("6. Return Magazine.");
                        System.out.println("7. Report Lost Book (No Discount).");
                        System.out.println("8. Report Lost Journal (No Discount).");
                        System.out.println("9. Report Lost Magazine (No Discount).");
                        System.out.println("10. Pay Due Amount.");
                        System.out.println("11. View My Details.");
                        System.out.println("12. Update My Details.");
                        System.out.println("13. Search Publication.");
                        System.out.println("14. Return to Main Menu.");
                        System.out.print("Enter your choice: ");
                        int ch = sc.nextInt(); sc.nextLine();

                        switch(ch  ){
                            case 1:
                            {
                                System.out.println("\n\t---Borrow Book---");
                                lib.showAllBooks();
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                foundBook = false;
                                  for(int i = 0; i < lib.getBookCounter(); i++  ){
                                    if(isbn.equals(lib.getBook(i).getISBN())  ){
                                        System.out.println("\n\tBook Found!");
                                        currentLibrarian.issueBook(currentMember, lib.getBook(i));
                                        foundBook = true;
                                        break;
                                    }
                                }
                                if(!foundBook) System.out.println("\n\tNo Books available with such ISBN!");
                                break;
                            }
                            case 2: {
                                System.out.println("\n\t---Borrow Journal---");
                                lib.showAllJournals();
                                System.out.print("Enter Journal ISBN: ");
                                isbn = sc.nextLine();
                                foundJournal = false;
                                  for(int i = 0; i < lib.getJournalCounter(); i++){
                                    if(isbn.equals(lib.getJournal(i).getISBN())  ){
                                        System.out.println("\n\tJournal Found!");
                                        currentLibrarian.issueJournal(currentMember, lib.getJournal(i));
                                        foundJournal = true;
                                        break;
                                    }
                                }
                                if(!foundJournal) System.out.println("\n\tNo Journals available with such ISBN!");
                                break;
                            }
                            case 3: {
                                System.out.println("\n\t---Borrow Magazine---");
                                lib.showAllMagazines();
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                foundMagazine = false;
                                  for(int i = 0; i < lib.getMagazineCounter(); i++){
                                    if(magName.equalsIgnoreCase(lib.getMagazine(i).getMagazineName())){
                                        System.out.println("\n\tMagazine Found!");
                                        currentLibrarian.issueMagazine(currentMember, lib.getMagazine(i));
                                        foundMagazine = true;
                                        break;
                                    }
                                }
                                if(!foundMagazine) System.out.println("\n\tNo Magazines available with such name!");
                                break;
                            }
                            case 4:
                            {
                                System.out.println("\n\t---RETURN Book---");
                                lib.showAllBooks();
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                foundBook = false;
                                  for(int i = 0; i < lib.getBookCounter(); i++  ){
                                    if(isbn.equals(lib.getBook(i).getISBN())  ){
                                        currentLibrarian.returnBook(currentMember, lib.getBook(i));
                                        foundBook = true;
                                        break;
                                    }
                                }
                                if(!foundBook) System.out.println("\n\tLibrary Doesnot Contain Book with such ISBN!");
                                break;
                            }
                            case 5: {
                                System.out.println("\n\t---RETURN Journal---");
                                lib.showAllJournals();
                                System.out.print("Enter Journal ISBN: ");
                                isbn = sc.nextLine();
                                foundJournal = false;
                                  for(int i = 0; i < lib.getJournalCounter(); i++  ){
                                    if(isbn.equals(lib.getJournal(i).getISBN())  ){
                                        currentLibrarian.returnJournal(currentMember, lib.getJournal(i));
                                        foundJournal = true;
                                        break;
                                    }
                                }
                                if(!foundJournal)
                                    System.out.println("\n\tLibrary Doesnot Contain Journal with such ISBN!");
                                break;
                            }
                            case 6: {
                                System.out.println("\n\t---RETURN Magazine---");
                                lib.showAllMagazines();
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                foundMagazine = false;
                                  for(int i = 0; i < lib.getMagazineCounter(); i++){
                                    if(magName.equalsIgnoreCase(lib.getMagazine(i).getMagazineName())){
                                        currentLibrarian.returnMagazine(currentMember, lib.getMagazine(i));
                                        foundMagazine = true;
                                        break;
                                    }
                                }
                                if(!foundMagazine)
                                    System.out.println("\n\tNo MAGAZINES available with such Name in this Library!");
                                break;
                            }
                            case 7:
                                System.out.println("\n\t---Report Lost Book---");
                                System.out.print("Enter Book ISBN: ");
                                isbn = sc.nextLine();
                                currentMember.lostBook(isbn);
                                break;

                            case 8:
                                System.out.println("\n\t---Report Lost Journal---");
                                System.out.print("Enter Journal Title: ");
                                title = sc.nextLine();
                                currentMember.lostJournal(title);
                                break;

                            case 9:
                                System.out.println("\n\t---Report Lost Magazine---");
                                System.out.print("Enter Magazine Name: ");
                                magName = sc.nextLine();
                                currentMember.lostMagazine(magName);
                                break;

                            case 10:
                                System.out.println("\n\t---Pay Due Amount---");
                                System.out.print("Enter Amount: ");
                                double amount = sc.nextDouble(); sc.nextLine();
                                currentMember.payDueAmount(amount);
                                break;

                            case 11:
                                System.out.println("\n\t---My Details---");
                                currentMember.showDetails();
                                break;

                            case 12:
                                System.out.println("\n\t---Update My Details---");
                                currentMember.updateDetails();
                                break;

                            case 13:
                                System.out.println("\n\t---Search Publication---");
                                System.out.print("Enter Title: ");
                                title = sc.nextLine();
                                lib.searchPublication(title);
                                break;

                            case 14:
                                System.out.println("Returning to Main Menu...\n");
                                flag = true;
                                continue;

                            default:
                                System.out.println("INVALID CHOICE! Please Try Again.\n");
                                continue;
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n\t---Library Statistics---");
                    lib.showLibraryDetails();
                    System.out.println("Total Books: " + lib.getBookCounter());
                    System.out.println("Total Journals: " + lib.getJournalCounter());
                    System.out.println("Total Magazines: " + lib.getMagazineCounter());
                    System.out.println("Total Librarians: " + Librarian.getTotalLibrarian());
                    System.out.println("Total Members: " + Member.getTotalMembers());
                    System.out.println("Total Students: " + Student.getTotalStudents());
                    System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
                    break;

                case 6:
                    System.out.println("\n\tExiting Program, GOOD BYE!");
                    return;

                default:
                    System.out.println("INVALID CHOICE! PLEASE TRY AGAIN.\n");
                    continue;
            }
        }
    }
}