package arrays;
import java.util.*;
public class magicsquareingrid {
	 public static void main(String[] args) {
 	  	  Scanner scn = new Scanner(System.in);
 	  	  int r = scn.nextInt();
 	  	  int c = scn.nextInt();
 	  	  int[][] Input = new int[r][c];
 	  	  for (int i = 0; i < r; i++) {
 	  	  	  for (int j = 0; j < c; j++) {
 	  	  	  	  Input[i][j] = scn.nextInt();
 	  	  	  }
 	  	  }
 	  	  System.out.print(numMagicSquaresInside(Input));
 	  }
 
 	  // -----------------------------------------------------
 	  // This is a functional problem. Do not make changes to main
 	  // This function takes as input an array and integer k.
 	  // It should print required output.
 	  public static int numMagicSquaresInside(int[][] grid) {
 	  	  // Write your code here
 	  	  int count=0;
 	  	  int f=0;
 	  	  for (int i = 0; i < grid.length; i++) {
 	  	  	  for (int j = 0; j < grid[0].length; j++) {
 	  	  	  	  if((i+1)<grid.length && (j+1)<grid[0].length && grid[i+1][j+1]==5)
 	  	  	  	  {
 	  	  	  	     boolean x= checkrows(i,j,grid);
 	  	  	  	     boolean y= checkcols(i,j,grid);
 	  	  	  	     boolean z=checkdiagnols(i,j,grid);
 	  	  	  	     if(x && y && z)
 	  	  	  	     {
 	  	  	  	         count++;
 	  	  	  	     }
 	  	  	  	  }
 	  	  	  }
 	  	  }
 	  	  return count;
 	  }
 	  
 	  public static boolean checkrows(int i,int j,int [][]grid)
 	  {
 		  int x=i;
 		  int y=j;
 	      if((i+2)>=grid.length || (j+2)>=grid[0].length || (i+1)>=grid.length || (j+1)>=grid[0].length){
 	          return false;
 	      }
 	       for (i=x; i < (x+3); i++) {
 	           int sum=0;
 	  	  	  for (j=y; j < (y+3); j++) {
 	  	  	  	  sum+=grid[i][j];
 	  	  	  }
 	  	  	  if(sum!=15)
 	  	  	  {
 	  	  	      return false;
 	  	  	  }
 	  	  }
 	  	  return true;
 	  }
 	  
 	    public static boolean checkcols(int i,int j,int [][]grid)
 	  {
 	    	int x=i;
 	 		  int y=j;
 	      if((i+2)>=grid.length || (j+2)>=grid[0].length || (i+1)>=grid.length || (j+1)>=grid[0].length){
 	          return false;
 	      }
 	       for (i=y; i < (y+3); i++) {
 	           int sum=0;
 	  	  	  for (j=x; j < (x+3); j++) {
 	  	  	  	  sum+=grid[j][i];
 	  	  	  }
 	  	  	  if(sum!=15)
 	  	  	  {
 	  	  	      return false;
 	  	  	  }
 	  	  }
 	  	  return true;
 	  }
 	  
 	     public static boolean checkdiagnols(int i,int j,int [][]grid)
 	  {
 	    	 int x=i;
 	    	 int y=j;
 	      if((i+2)>=grid.length || (j+2)>=grid[0].length || (i+1)>=grid.length || (j+1)>=grid[0].length){
 	          return false;
 	      }
 	      int suml=0;
 	      int sumr=0;
 	       for (i=x; i < (x+3); i++) {
 	           
 	  	  	  for (j=y; j < (y+3); j++) {
 	  	  	      if(i==j)
 	  	  	      {
 	  	  	          suml+=grid[i][j];
 	  	  	      }
 	  	  	       if(i+j==2)
 	  	  	      {
 	  	  	          sumr+=grid[i][j];
 	  	  	      }
 	  	  	  	  
 	  	  	  }
 	  	  	  
 	  	  }
 	  	  if(suml!=15 || sumr!=15)
 	  	  	  {
 	  	  	      return false;
 	  	  	  }
 	  	  return true;
 	  }
}
