import java.lang.ref.Cleaner;

class Student {
    private String name;
    private int rollNo;
    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.cleanable = cleaner.register(this, new CleanupTask(name));
    }

    public void display() {
        System.out.println("Student Name: " + name + ", Roll No: " + rollNo);
    }

    private static class CleanupTask implements Runnable {
        private final String name;

        CleanupTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Cleaning resources for: " + name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Bob", 102);

        s1.display();
        s2.display();

        s1 = null;
        s2 = null;

        System.gc();
    }
}
/*
output :
Student Name: Alice, Roll No: 101
Student Name: Bob, Roll No: 102
Cleaning resources for: Alice
Cleaning resources for: Bob
*/
