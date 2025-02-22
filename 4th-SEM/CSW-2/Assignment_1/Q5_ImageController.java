/*
 Create an ImageLibrary, which contains a set of image objects (from Q4) and 
operations such as searching an image, inserting an image, and getting an image. 
Create an ImageController class to manage the program execution and call the 
methods to create and manipulate images.
 */
import java.util.Scanner;
class ImageLibrary{
    private Image arrayOfImageObject[];
    private int maxSize;
    private int imgCount;

     ImageLibrary(int maxSize){
        this.imgCount=0;
        this.maxSize=maxSize;
        arrayOfImageObject=new Image[maxSize];
    }
    //method to insert an image :
    public void addImage(Image ob) {
        arrayOfImageObject[imgCount]=new Image(ob.getImageWidth(),ob.getImageHeight(),ob.getColorCode());
        imgCount++;
        }
        
        //method to return an image from the array :
        public Image getImage(int i) {
           if(i<imgCount && i>=0){
            return arrayOfImageObject[i];
           }else{
            System.out.println("Invalid index");
            return null;
           }
        }
        
        //method to search  an object
        public Image search(Image x) {
            for(int i=0;i<imgCount;i++){
                if(arrayOfImageObject[i].equals(x)) {
                    return arrayOfImageObject[i];
                }
            }
            return null;
        }
        
        void display() {
            for(int i=0;i<imgCount;i++) {
                System.out.println(arrayOfImageObject[i].toString());
            }
        }
}

public class Q5_ImageController {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
	    int s=sc.nextInt();
	    ImageLibrary lib1= new ImageLibrary(s);
	    
	 for(int i=0;i<s;i++) {
		System.out.println("Enter object");
		lib1.addImage(new Image(sc.nextInt(),sc.nextInt(),sc.next()));
		System.out.println("continue ? yes= +1 / no= -1");
	    if(sc.nextInt()==-1)
	    	 break;
	 }
	 System.out.println("Enter to search Img");
	 System.out.println(lib1.search(new Image(sc.nextInt(),sc.nextInt(),sc.next())).toString());
    }
}
