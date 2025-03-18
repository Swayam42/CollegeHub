import java.io.*;

class Q11 {
    public static void checkFile() {
        try {
            FileReader ob = new FileReader("abc.txt");
            BufferedReader br = new BufferedReader(ob);
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            br.close(); // Close the reader
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    public static void main(String[] args) {
        checkFile();
    }
}
/*Output : 
Case 1: If "abc.txt" exists and contains text

Hello, World!
This is a test file.

Case 2: If "abc.txt" does not exist

File not found: java.io.FileNotFoundException: abc.txt (No such file or directory)

Case 3: If an IOException occurs (e.g., file cannot be read)

Error reading file: java.io.IOException: [Some specific error message]

*/
