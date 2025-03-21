package Strings_Files;
/*WAP to return the maximum occuring character in the string*/
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		HashMap<Character, Integer> chars = new HashMap<>();
		String s="HelloWorld";
	
		for(int i=0;i<s.length();i++)
		{
			
				if(chars.containsKey(s.charAt(i)))
				{
					chars.put(s.charAt(i),chars.get(s.charAt(i))+1);
				}
				else			
					chars.put(s.charAt(i),1);
		}
		 
		Set s1=chars.entrySet();
		Iterator itr = s1.iterator();
		
		
		 int max = (Collections.max(chars.values()));
		 
	       
	        for (Entry<Character, Integer> entry : chars.entrySet()) {
	        		if (entry.getValue() == max) {
	                System.out.println(entry.getKey());
	            }
	}
}
}
