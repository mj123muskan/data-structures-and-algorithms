package test;

import java.util.Scanner;
import java.util.Stack;

public class test1 {


	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		// System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int x=0;
		int y=0;
		int p=10;
		int d=0;
		while(n!=0)
		{
			if(d==0)
			{
				x+=p;
				p+=10;
			}else if(d==1)
			{
			y+=p;
			p+=10;
			}else if(d==2)
			{
				x-=p;
				p+=10;
			}else if(d==3)
			{
				y-=p;
				p+=10;
			}
			d=(d+1)%4;
			n--;
		}
		System.out.print(x+" "+y);

	}

}
