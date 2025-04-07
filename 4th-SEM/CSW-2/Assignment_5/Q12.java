package Assignment_5;
/*List Files and Directories: Write a program in Java that asks the user for a directory 
path and then lists all files and subdirectories in that directory. If the directory does not 
exist, the program should inform the user. */
import java.io.*;
public class Q12 {
	public static void searchFile(File f[],String ext) {
		ext=".java";
		if(f!=null) {
			for(File i:f) {
				if(i.isFile()&& i.getName().endsWith(ext)) { //to search a particular type of file (Eg. .txt , .java , etc) 
					System.out.println(i.getName());
				}
			}
		}
	}
	

	public static void main(String[] args) {
		File f=new File("C:\\Users\\HP\\OneDrive\\Desktop\\ALL FILES ARE HERE");
		if(!f.exists()||!f.isDirectory()) {
			System.out.println("Doesn't Exist");
		}
		File arr[]=f.listFiles();
		
			
			if(arr!=null) {
				
				for(File i:arr){
					
					if(i.isFile()){
						System.out.println("The file name is"+i.getName());
					}
					else if(i.isDirectory()){
						System.out.println("The file name is"+i.getName());
					}
				}
			}	
			
		
		System.out.println("\nAll Java Files are as Follows : ");
		searchFile(arr,".java");
		
	}

}

/*
OUTPUT :
The file name is011208
The file name is12.jpeg
The file name is2241011097
The file name is2241013125
The file name is2241019453
The file name is2341003057
The file name is2341003057AD
The file name is2341003057EL
The file name is2341016288_sucheta
The file name is2341016337
The file name isabs_Q2.java
The file name isad2_2241016292
The file name isadd&remove.html
The file name isaditi
The file name isAditi_2241001028
The file name isad_10
The file name isAD_2241016292
The file name isAnshuman
The file name isappend.html
The file name isarya
The file name isAssignments-01.zip
The file name isassingment 2 AD.pdf
The file name isbgimg.jpg
The file name isbtstrp.html
The file name isClearBit.java
The file name isCSE2631 Assignment2.pdf
The file name isCSW1
The file name isCSW1_Assignment_bitwise (2).pdf
The file name isCSW1_Assignment_bitwise.pdf
The file name isCSW1_Assignment_Bootstrap (2).pdf
The file name isCSW1_Assignment_Bootstrap.pdf
The file name isCSW1_Assignment_jQuery.pdf
The file name isCSW1_Assignment_Wrapper.pdf
The file name iscsw_2241016292
The file name isdipti ranjan rout
The file name isDLD NOTES PART - 1 (2).pdf
The file name isDLD NOTES PART - 1.pdf
The file name isDONT DELETE
The file name isDONT DELETE.zip
The file name isDPM
The file name isDPM.zip
The file name iseclipse
The file name isencap_Q1.java
The file name isform.html
The file name isFull Stack Java Development with Spring MVC, Hibernate, jQuery, and Bootstrap.pdf
The file name ishtml
The file name ishtml 2.html
The file name ishtml.zip
The file name isImplementation.java
The file name isInheritQ1.java
The file name isITER-K
The file name isjavaScript3057
The file name isJquery_midsem
The file name islab13-6
The file name isNew folder
The file name isNew folder (2)
The file name isNew folder (3)
The file name isNew folder (4)
The file name isNew folder (5)
The file name isNew folder (6)
The file name isnewyear.html
The file name isOnlineTest.mdb
The file name isop
The file name ispackage Assignment_1_java;.txt
The file name isPolyQ1.java
The file name ispolyQ2.java
The file name isproxy
The file name isQ1 (2).java
The file name isQ1 (3).java
The file name isQ2 (2).java
The file name isQ2 (3).java
The file name isq2.java
The file name isQ3 (2).java
The file name isq3.java
The file name isQ5 (2).java
The file name isQ6.java
The file name isQ7 (2).java
The file name isSample.mdb
The file name isShiv208
The file name istemp
The file name isTG.htm
The file name istodo.html
The file name iswallpapersden.com_batman-cool-the-dark-knight_5824x3264.jpg
The file name isweb
The file name iswebdev
The file name isWrapper Classes.pdf

All Java Files are as Follows : 
abs_Q2.java
ClearBit.java
encap_Q1.java
Implementation.java
InheritQ1.java
PolyQ1.java
polyQ2.java
Q1 (2).java
Q1 (3).java
Q2 (2).java
Q2 (3).java
q2.java
Q3 (2).java
q3.java
Q5 (2).java
Q6.java
Q7 (2).java

*/
