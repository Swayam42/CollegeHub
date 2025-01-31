/*Develop a Java program for a library system using encapsulation, abstraction, and 
inheritance. Create an abstract LibraryResource class with private attributes (title, 
author), a constructor, getters, setters, and an abstract displayDetails() method. Extend 
it into Book, Magazine, and DVD classes, each adding a specific attribute 
(pageCount, issueDate, duration), along with constructors, getters, setters, and 
overridden displayDetails() methods. In the LibrarySystem class, instantiate various 
resources and call displayDetails() to display their information. */

abstract class LibraryResource{
    private String title;
    private String author;

    public LibraryResource(String title,String author){
        this.title=title;
        this.author=author;
    }

    String getTitle(){
        return title;
    }
    String getAuthor(){
        return author;
    }

    void setTitle(String title){
        this.title=title;
    }
    void setAuthor(String author){
        this.author=author;
    }

    abstract void displayDetails();
}


class Book extends LibraryResource {
    int pageCount;

    Book(String title,String author,int pageCount){
        super(title,author);
        this.pageCount=pageCount;
    }

    int getPageCount(){
        return pageCount;
    }

    void setPageCount(int pageCount){
        this.pageCount=pageCount;
    }


    @Override
    void displayDetails(){
        System.out.println("\nDetails of Book : ");
        System.out.println("\nTitle : "+getTitle());
        System.out.println("Author : "+getAuthor());
        System.out.println("PageCount : "+pageCount +" pages");
    }
}



class DVD extends LibraryResource {
    float duration;

    DVD(String title,String author,float duration){
        super(title,author);
        this.duration=duration;
    }
    
    float getDuration(){
        return duration;
    }

    void setduration(int duration){
        this.duration=duration;
    }


    @Override
    void displayDetails(){
        System.out.println("\nDetails of DVD : ");
        System.out.println("\nTitle : "+getTitle());
        System.out.println("Author : "+getAuthor());
        System.out.println("duration : "+duration+" mins");
    }
}



class Magazine extends LibraryResource {
    String issueDate;
    Magazine(String title,String author,String issueDate){
        super(title,author);
        this.issueDate=issueDate;
    }
    String getIssueDate(){
        return issueDate;
    }

    void setIssueDate(String issueDate){
        this.issueDate=issueDate;
    }

    void displayDetails(){
        System.out.println("\nDetails of Magazine : ");
        System.out.println("\nTitle : "+getTitle());
        System.out.println("Author : "+getAuthor());
        System.out.println("IssueDate : "+issueDate);
    }
}



public class Q7_LibrarySystem {
    public static void main(String[] args) {
        Book b1=new Book("Chhabila Madhu Barnabodha","Madhusudan Rao",56);
        Magazine m1=new Magazine("Business Yesterday", "Abhijeet Sahoo", "31-Feb-2029");
        DVD d1=new DVD("Bollywood Erotic Collection Set", "Mahatma Gandhi", 45.8f);
        b1.displayDetails();
        m1.displayDetails();
        d1.displayDetails();
    }
}

/*
OUTPUT :

Details of Book : 

Title : Chhabila Madhu Barnabodha
Author : Madhusudan Rao
PageCount : 56 pages

Details of Magazine : 

Title : Business Yesterday
Author : Abhijeet Sahoo
IssueDate : 31-Feb-2029

Details of DVD : 

Title : Bollywood Erotic Collection Set
Author : Mahatma Gandhi
duration : 45.8 mins
 */

