import java.io.*;

class Q11{
        public static void checkFile() throws FileNotFoundException{
                FileReader ob=new FileReader("abc.txt");
                throw new FileNotFoundException();
        }
        public static void main(String[] args) {

        try {
                checkFile();

        }
        catch(FileNotFoundException e) {
                System.out.println("Exception is Handled"+ e);
        }
 }

}
//Output : Exception is Handledjava.io.FileNotFoundException: abc.txt (The system cannot find the file specified)


//FileNotFoundException :
