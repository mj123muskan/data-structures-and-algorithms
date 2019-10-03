package coordinategeometry;

import java.util.ArrayList;
import java.util.Scanner;



public class jarvis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
//		point[] points = new point[10];
//		points[0] = new point(-1, -1);
//		points[1] = new point(0, 8);
//		points[2] = new point(1, 3);
//		points[3] = new point(0, 1);
//		points[4] = new point(8, 0);
//		points[5] = new point(-1, 1);
//		points[6] = new point(-2, -1);
//		points[7] = new point(0, -8);
//		points[8] = new point(7, 0);
//		points[9] = new point(-8, 0);
		
		point[] p = new point[n];
		for(int i=0;i<n;i++)
		{
			int x=scn.nextInt();
			int y=scn.nextInt();
			p[i]=new point(x, y);
		}
		ArrayList<point> k=convexhull(p);
		System.out.println(k);

	}

	public static ArrayList<point> convexhull(point[] p) {
		ArrayList<point> hull = new ArrayList<>();
		int li = 0;
		for (int i = 1; i < p.length; i++) {
			if (p[i].x < p[li].x) {
				li = i;
			}
		}
		
		int prev=li;
		int curr=-1;
		while(curr!=li)
		{
			hull.add(p[prev]);
			curr=(prev+1)%p.length;
			
			for(int i=0;i<p.length;i++)
			{
				if(orientation.getorientation(p[prev], p[curr], p[i])<0)
					//if(getorientation(p[prev], p[curr], p[i])<0)
				{
					curr=i;
				}
			}
			prev=curr;
		}
		return hull;
		
		
		

	}
	
//	public static class point {
//		int x;
//		int y;
//
//		point(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//
//		public String toString() {
//			return "(" + x + ", " + y + ")";
//		}
//
//	}
//	public static int getorientation(point p1, point p2, point p3) {
//		int val = (p2.y - p1.y) * (p3.x - p1.x) - (p3.y - p1.y) * (p2.x - p1.x);
//		return val == 0 ? 0 : val > 0 ? 1 : -1;
//	}

}
