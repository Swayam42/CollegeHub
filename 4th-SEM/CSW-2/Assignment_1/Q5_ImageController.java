package Assignment_1;
import java.util.*;

class ImageLibrary extends Image{
	Image arrayOfImageObject[]; 
	int maxSize; //to store the size of array
	int imgCount; 
	
	public ImageLibrary(int maxSize){
		imgCount=0;
		this.maxSize=maxSize;
		arrayOfImageObject=new Image[maxSize];
	}
	
	
	public void addImage(Image ob) {
	arrayOfImageObject[imgCount]=new Image(ob.getImageWidth(),ob.getImageHeight(),ob.getColorCode());
	imgCount++;
	}
	
	//method to return an image from the array :
	public Image getImage(int i) {
		return arrayOfImageObject[i];
	}
	
	//method to search  an object
	public Image search(Image x) {
		for(int i=0;i<=imgCount;i++){
			if(arrayOfImageObject[i].equals(x)) {
				return arrayOfImageObject[i];
			}
		}
		return x;
	}
	
	@Override
	public boolean equals(Object o) {
		Image obj=(Image)o; //Object o type casted to Image type and stored in obj
		return imageWidth==obj.imageWidth && imageHeight==obj.imageHeight && colorCode==obj.colorCode;
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
		System.out.print("Input ImageLibrarySize : ");
		int s=sc.nextInt();
		ImageLibrary ob=new ImageLibrary(s);
//		for(int i=0;i<s;i++) {
//			System.out.print("Input imageWidth : ");
//			int w=sc.nextInt();
//			System.out.print("Input imageHeight : ");
//			int h=sc.nextInt();
//		System.out.print("Input colorCode : ");
//			int c=sc.nextInt();
//			
//			
//			Image obj=new Image(w,h,c);
//			ob.addImage(obj);
//		}
		
		Image img1=new Image(12,43,6);
		Image img2=new Image(12,63,60);
		ob.addImage(img1);
		ob.addImage(img2);
		System.out.println(ob.search(img1));
		
		
		
	
		
	}

}
