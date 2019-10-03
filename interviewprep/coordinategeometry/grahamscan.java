package coordinategeometry;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class grahamscan {//NOT WORKING
	 static point start = null;

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
//		point[] p = new point[10];
//		p[0]=new point(0,15);
//		p[1]=new point(10,0);
//		p[2]=new point(3,-1);
//		p[3]=new point(8,-8);
//		p[4]=new point(-1,-1);
//		p[5]=new point(3,0);
//		p[6]=new point(-8,-10);
//		p[7]=new point(4,2);
//		p[8]=new point(0,8);
//		p[9]=new point(-9,0);
		
		point[] p = new point[n];
		for(int i=0;i<n;i++)
		{
			int x=scn.nextInt();
			int y=scn.nextInt();
			p[i]=new point(x, y);
		}
//		p[0]=new point(0,15);
//		p[1]=new point(10,0);
//		p[2]=new point(3,-1);
//		p[3]=new point(8,-8);
//		p[4]=new point(-1,-1);
//		p[5]=new point(3,0);
//		p[6]=new point(-8,-10);
//		p[7]=new point(4,2);
//		p[8]=new point(0,8);
//		p[9]=new point(-9,0);
		System.out.println(convexhull(p));
	}

	public static Stack<point> convexhull(point[] p) {
		Stack<point> hull = new Stack<>();
		int bmi = 0;
		for (int i = 1; i < p.length; i++) {
			if (p[i].y < p[bmi].y) {
				bmi = i;
			} else if (p[i].y == p[bmi].y) {
				if (p[i].x < p[bmi].x) {
					bmi = i;
				}
			}
		}
		start = p[bmi];

		Arrays.sort(p, (p1,p2)->{
			int o = getorientation(start, p1, p2);
			//int o = orientation.getorientation(start, p1, p2);
			if (o == 0) {
				int starttop1 = getdistance(start, p1);
				int starttop2 = getdistance(start, p2);
				return starttop1 - starttop2;

			} else {
				return o;
			}
		});

		hull.push(p[0]);
		hull.push(p[1]);

		for (int i = 2; i < p.length; i++) {
			point poped = hull.pop();
			point  p2 = p[i];

			//while (orientation.getorientation(hull.peek(), poped, p2) > 0)
				while (getorientation(hull.peek(), poped, p2) > 0){
				poped = hull.pop();
			}
			hull.push(poped);
			hull.push(p2);
		}
		return hull;
	}

			private  static int getdistance(point start, point p1) {

			return (p1.x - start.x) * (p1.x - start.x) + (p1.y - start.y) * (p1.y - start.y);
		}
			
			public static class point {
			int x;
			int y;
	
			point(int x, int y) {
				this.x = x;
				this.y = y;
			}
	
			public String toString() {
				return "(" + x + "," + y + ")";
			}
	
		}

			public static int getorientation(point p1, point p2, point p3) {
			int val = (p2.y - p1.y) * (p3.x - p1.x) - (p3.y - p1.y) * (p2.x - p1.x);
			return val == 0 ? 0 : val > 0 ? 1 : -1;
		}
}


