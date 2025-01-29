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
	
	void display() {
		for(int i=0;i<imgCount;i++) {
			System.out.println(arrayOfImageObject[i].toString());
		}
	}
	
	 
	
	
}