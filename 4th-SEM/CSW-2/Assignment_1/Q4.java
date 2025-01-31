package Assignment_1;

class Image{
	 int imageWidth;
	 int imageHeight;
	 int colorCode;
	
	//Parameterized Constructor
	public Image(int imageWidth,int imageHeight,int colorCode){
		this.imageWidth=imageWidth;
		this.imageHeight=imageHeight;
		this.colorCode=colorCode;
	}
	
	//Default Constructor
	public Image() {
		imageWidth=23;
		imageHeight=12;
		colorCode=23;
	}
	
	//toString method :
	@Override
	public String toString() {
		return imageWidth + " "+imageHeight +" "+colorCode;
	}
	
	//Getter and Setter Methods :
	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public int getColorCode() {
		return colorCode;
	}

	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}
	
	public String toString1() {
		return "\nHeight : "+imageHeight+ ", Width :"+imageWidth + ", ColorCode : "+colorCode;
	}

	
	
}
public class Q4 {

	public static void main(String[] args) {
		Image img1 =new Image();
		Image img2 =new Image(12,43,64);
		System.out.println("Image 1 : "+img1.toString1());
		System.out.println("Image  2 : "+img2.toString1());

	}

}













