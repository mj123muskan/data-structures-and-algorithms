package arrays;

public class shortestsortedunsortedarray {

	 public static int findUnsortedSubarray(int[] a) {
 	 	 // write your code here.
 	 	 int count=1;
 	 	 
 	 	 int []minsofar=new int[a.length];
 	 	  int []maxsofar=new int[a.length];
 	 	  
 	 	  minsofar[a.length-1]=a[a.length-1];
 	 	  for(int i=a.length-2;i>=0;i--)
 	 	  {
 	 	      minsofar[i]=Math.min(minsofar[i+1],a[i]);
 	 	  }
 	 	  maxsofar[0]=a[0];
 	 	  for(int i=1;i<a.length;i++)
 	 	  {
 	 	      maxsofar[i]=Math.max(a[i],maxsofar[i-1]);
 	 	  }
 	 	  
 	 	  
 	 	  
 	 	  int fi=-1;
 	 	  int f=0;
 	 	  int li=-1;
 	 	  for(int i=0;i<a.length;i++)
 	 	  {
 	 	      if(minsofar[i]!=maxsofar[i])
 	 	      { f=1;
 	 	          if(fi==-1)
 	 	          {
 	 	              fi=li=i;
 	 	          }else
 	 	          {
 	 	              li=i;
 	 	          }
 	 	      }
 	 	  }
 	 	  if(f==0)
 	 	  {
 	 	      return 0;
 	 	  }else{
 	 	  return li-fi+1;
 	 	  }
 
 	 }
 
 	 public static void main(String[] args) {
 	 	 Scanner sc = new Scanner(System.in);
 
 	 	 // Input for length of array.
 	 	 int length = sc.nextInt();
 
 	 	 int[] arr = new int[length];
 
 	 	 // Input for elements of array.
 	 	 for (int i = 0; i < arr.length; i++) {
 	 	 	 arr[i] = sc.nextInt();
 	 	 }
 
 	 	 System.out.println(findUnsortedSubarray(arr));
 
 	 }
 
 	 // function to display an array.
 	 public static void display(int[] arr) {
 
 	 	 for (int i = 0; i < arr.length; i++) {
 	 	 	 System.out.print(arr[i] + " ");
 	 	 }
 
 	 	 System.out.println();
 	 }
 
 }
