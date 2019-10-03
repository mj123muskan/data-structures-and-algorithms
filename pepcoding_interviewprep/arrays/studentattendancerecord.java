package arrays;

import java.util.*;
	 
	 public class studentattendancerecord {
	 
	     // This is a functional problem. You have to complete this function.
	     // It takes as input a String S. It should return true if the student could
	     // be rewarded, else should return false.
	     public static boolean checkRecord(String s) {
	         // write your code here. 
	         int ca=0;
	         int cl=0;
	         
	         for(int i=0;i<s.length();i++)
	         {
	             char c=s.charAt(i);
	             if(c=='A')
	             {
	                 ca++;
	             }else if(c=='L')
	             {
	                 int j=i;
	                 while(j<s.length() && s.charAt(j)=='L')
	                 {
	                     j++;
	                 }
	                 if((j-i)>2)
	                 {
	                     return false;
	                 }
	                 
	                 if((j-i)==2)
	                 {
	                     cl++;
	                 }
	                 if(j==s.length()-1)
	                 {
	                     break;
	                 }
	                 i=j-1;
	             }
	         }
	         
	         if(ca>1 || cl>1)
	         {
	             return false;
	         }
	         
	         return true;
	         
	     }
	 
	     public static void main(String[] args) {
	         Scanner sc = new Scanner(System.in);
	 
	         String S = sc.next();
	 
	         if (checkRecord(S)) {
	             System.out.println("Yes");
	         } else {
	             System.out.println("No");
	         }
	 
	     }
	 }

