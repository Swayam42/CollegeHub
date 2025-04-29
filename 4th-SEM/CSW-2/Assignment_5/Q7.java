package Assignment_5;
/*Word Replacement in Sentences: Request a sentence and two words from the user: one
to search for and one to replace it with. Find the first occurrence of the search word in
the sentence. Replace the word using substring operations and concatenation. Display
the original and the modified sentences. */

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the sentence
        System.out.print("Input Sentence: ");
        String sentence = sc.nextLine();

        // Input the word to search for
        System.out.print("Input word to search: ");
        String search = sc.next();

        // Input the word to replace with
        System.out.print("Input word to replace with: ");
        String replace = sc.next();

        // Find the first occurrence of the search word
        int firstOccurrence = sentence.indexOf(search);

        if (firstOccurrence == -1) {
            // If the search word is not found
            System.out.println("The word '" + search + "' was not found in the sentence.");
        } else {
            // Replace the word using substring operations
            String modifiedSentence = sentence.substring(0, firstOccurrence) 
                                     + replace 
                                     + sentence.substring(firstOccurrence + search.length());

            // Display the original and modified sentences
            System.out.println("Original Sentence: " + sentence);
            System.out.println("Modified Sentence: " + modifiedSentence);
        }

        sc.close();
    }
}