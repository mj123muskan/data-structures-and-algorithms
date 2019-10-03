package coordinategeometry;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;





public class quickhull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(convexhull(p));

	}

	public static ArrayList<point> convexhull(point[] p) {
		ArrayList<point> hull=new ArrayList<>();
		int minxi = 0, maxxi = 0;
		for(int i=1;i<p.length;i++)
		{
		if(p[i].x<p[minxi].x)
		{
			minxi=i;
		}
		
		if(p[i].x>p[maxxi].x)
		{
			maxxi=i;
		}
		}
		
		
		point p1=p[minxi];
		point p2=p[maxxi];
		hull.add(p1);
		hull.add(p2);
		ArrayList<point> p1p2=new ArrayList<>();
		ArrayList<point> p2p1=new ArrayList<>();
		for(int i=0;i<p.length;i++)
		{
			if(p[i]==p1 || p[i]==p2)
			{
				continue;
			}else
			{
				if(getorientation(p1, p2, p[i])<0)
				{
					p1p2.add(p[i]);
				}else
				{
					p2p1.add(p[i]);
				}
			}
		}
		
		quickhull(p1,p2,p1p2,hull);
		quickhull(p2,p1,p2p1,hull);
		return hull;
		
		

	}

	private static void quickhull(point p1, point p2, ArrayList<point> p1p2, ArrayList<point> hull) {
		if(p1p2.size()==0)
		{
			return;
		}else if(p1p2.size()==1)
		{
			int insertidx=hull.indexOf(p2);
			hull.add(insertidx, p1p2.get(0));
			return;
		}
		
		int insertidx=hull.indexOf(p2);
		
		point fp=null;
		
		for(point p:p1p2)
		{
			if(fp==null)
			{
				fp=p;
			}else
			{
				if(getperpendiculardistance(p1,p2,p)>getperpendiculardistance(p1,p2,fp))
				{
					fp=p;
				}
			}
		}
		
		hull.add(insertidx, fp);
		
		
		ArrayList<point> p1fp=new ArrayList<>();
		ArrayList<point> fpp2=new ArrayList<>();
		
		for(point pp:p1p2)
		{
			if(pp==fp)
			{
				continue;
			}else
			{
				if(getorientation(p1, p2, pp)<0)
				{
					p1fp.add(pp);
				}else
				{
					fpp2.add(pp);
				}
			}
		}
		
		quickhull(p1, fp, p1fp, hull);
		quickhull(fp, p2, fpp2, hull);
	}

	private static int getperpendiculardistance(point p1, point p2, point p3) {
		// TODO Auto-generated method stub
		 return Math.abs((p3.y - p1.y) * (p2.x - p1.x) - (p2.y - p1.y) * (p3.x - p1.x));
	}
	
	public static class point {
		int x;
		int y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + x + ", " + y + ")";
		}

	}

		public static int getorientation(point p1, point p2, point p3) {
		int val = (p2.y - p1.y) * (p3.x - p1.x) - (p3.y - p1.y) * (p2.x - p1.x);
		return val == 0 ? 0 : val > 0 ? 1 : -1;
	}

}
