/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scrabblebuddy;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author John Stone
 */
public class ScrabbleBuddy {

    /**
     * @param args the command line arguments
     */
    static String[] temp;
    static ArrayList<String> searched;
    public static void main(String[] args) throws Exception {
       
 	   int n;

		try
		{
                   Scanner input = new Scanner(new File("words.txt"));
		   n = input.nextInt();
		   temp = new String[n];
		   for(int i=0;i<n;i++)
		      temp[i] = input.nextLine();
		   input.close();
		}
		finally{}
          Scanner in = new Scanner(System.in);
          System.out.print("Please enter a word: ");
         searched = new ArrayList<String>();
          String word = in.next();
          for(String s : Permu(word))
          {
                 //binarySearch(s);
          }
          

    }
    

   
    public static void binarySearch(String word)
    {
        boolean S = beenSearched(word);
        boolean done = false;
       if(S)
       {
            done = true;
        }
        int lo = -1;
        int high = temp.length;
        int midVal;
        while(!done)
        {
            midVal = (lo + high)/2;
            if(temp[midVal].compareTo(word)<0)
            {
                lo = midVal;
            }
            if(temp[midVal].compareTo(word)>0)
            {
                high = midVal;
            }
            else if(temp[midVal].compareTo(word) == 0)
            {
                System.out.println(word);
                done = true;
            }
            else if((lo+1)>=high)
            {
                  done = true;
	    }
        }
    }
    
   public static  ArrayList<String> Permu(String word)
   {
      ArrayList<String> result = new ArrayList<String>();
      ArrayList<String> tracker = new ArrayList<String>();
      
      if(word.length() == 0)
      {
         result.add(word);
          return result;
      }
      else 
      {
         for(int i=0;i<word.length();i++)
         {
            String shorter = word.substring(0,i) + word.substring(i+1);
               ArrayList<String> shorterPerm = Permu(shorter);

               for(String s : shorterPerm)
               {    
                   if(s.length()>=1)
                   {
                    binarySearch(word.charAt(i) + s);
                   }
                   result.add(word.charAt(i) + s);
               }
         }
      }
         return result;
   }

   public static boolean beenSearched(String word)
   {
//       ArrayList<String> b = searched;
       for(String s : searched)
      {
           if(word.equals(s))
               return true;
      }
       searched.add(word);
 //      searched = b;
       return false;
   }
    
}
