package com.iter.SwayamJethi.imageClasses;

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
	

	
	
}