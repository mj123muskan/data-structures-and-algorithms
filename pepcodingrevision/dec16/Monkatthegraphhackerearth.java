package dec16;

import java.util.Scanner;

public class Monkatthegraphhackerearth {

	public static void main(String[] args) {
	Scanner scn=new  Scanner(System.in);
	int n= scn.nextInt();
	int []b= new int[n];
	for(int i=0;i<n;i++)
	{
		b[i]=scn.nextInt();
	}
	
	int sum=0;
	for(int i=0;i<n;i++)
	{
		sum+=b[i];
	}
	if(sum==2*(n-1))
	{
		System.out.println("Yes");
	}
	else System.out.println("No");
	}

}
