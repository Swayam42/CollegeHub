package com.iter.SwayamJethi.imageClasses;
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
