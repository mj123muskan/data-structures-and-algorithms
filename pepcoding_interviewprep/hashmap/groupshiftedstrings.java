package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class groupshiftedstrings {//order test case not working
	  public static List<List<String>> groupStrings(String[] strings) {
	         HashMap<String,ArrayList<String>> map=new HashMap<>();
	         for(int i=0;i<strings.length;i++)
	         {
	             String s="";
	             for(int j=1;j<strings[i].length();j++)
	             {
	                 int x=strings[i].charAt(j)-strings[i].charAt(j-1);
	                 s=s+x+"-";
	             }
	             if(map.containsKey(s))
	             {
	                 ArrayList<String> p=map.get(s);
	                 p.add(strings[i]);
	                 map.put(s,p);
	             }else
	             {
	                  ArrayList<String> p=new ArrayList<>();
	                 p.add(strings[i]);
	                 map.put(s,p);
	             }
	         }
	        List<List<String>> res=new ArrayList<>();
	        for(String f:map.keySet())
	        {
	             ArrayList<String> p=map.get(f);
	             res.add(p);
	        }
	 return res;
	     }
	 
	     public static void main(String[] args) {
	 
	         Scanner sc = new Scanner(System.in);
	 
	         // Length of the array
	         int N = sc.nextInt();
	 
	         String[] arr = new String[N];
	 
	         for (int i = 0; i < N; i++) {
	             arr[i] = sc.next();
	         }
	 
	         List<List<String>> stringsGrouped = groupStrings(arr);
	 
	         for (List<String> lst : stringsGrouped) {
	             Collections.sort(lst);
	         }
	 
	         stringsGrouped.sort(new ListComparator());
	 
	         display(stringsGrouped);
	 
	     }
	 
	     // Comparator for sorting the result list.
	     static class ListComparator implements Comparator<List<String>> {
	 
	         @Override
	         public int compare(List<String> l1, List<String> l2) {
	 
	             if (l1.size() != l2.size()) {
	                 return l2.size() - l1.size();
	             }
	 
	             for (int i = 0; i < l1.size(); i++) {
	                 String l1str = l1.get(i);
	                 String l2str = l2.get(i);
	 
	                 return l1str.compareTo(l2str);
	 
	             }
	 
	             return 0;
	 
	         }
	     }
	 
	     // Function to display a List of Lists of strings.
	     public static void display(List<List<String>> list) {
	 
	         for (int i = 0; i < list.size(); i++) {
	 
	             List<String> currList = list.get(i);
	 
	             for (int j = 0; j < currList.size(); j++) {
	                 System.out.print(currList.get(j) + " ");
	             }
	 
	             System.out.println();
	         }
	 
	     }

}
