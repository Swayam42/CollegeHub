package com.iter.SwayamJethi.imageClasses;

import java.util.*;
public class ImageApp extends Image{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Input ImageLibrarySize : ");
		int s=sc.nextInt();
		ImageLibrary ob=new ImageLibrary(s);
		for(int i=0;i<s;i++) {
			System.out.print("Input imageWidth : ");
			int w=sc.nextInt();
			System.out.print("Input imageHeight : ");
			int h=sc.nextInt();
		System.out.print("Input colorCode : ");
			int c=sc.nextInt();
			
			
			Image obj=new Image(w,h,c);
			ob.addImage(obj);
		}
		
		ob.display();
		
	}

}