package coordinategeometry;

public class intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		point p1 = new point(0, 9);
		point p2 = new point(5, -4);
		point p3 = new point(1, 1);
		point p4 = new point(16, 16);
		System.out.println(intersection(p1, p2, p3, p4));

	}

	public static boolean intersection(point p1, point p2, point p3, point p4) {
		 int o1 = orientation.getorientation(p1, p2, p3);
		 int o2 = orientation.getorientation(p1, p2, p4);
		 int o3 = orientation.getorientation(p3, p4, p1);
		 int o4 = orientation.getorientation(p3, p4, p2);
		//
//		int o1 = getorientation(p1, p2, p3);
//		int o2 = getorientation(p1, p2, p4);
//		int o3 = getorientation(p3, p4, p1);
//		int o4 = getorientation(p3, p4, p2);
		if ((o1 != o2) && (o3 != o4)) {
			return true;
		}

		if (o1 == 0 && onsegment(p1, p2, p3)) {
			return true;
		} else if (o2 == 0 && onsegment(p1, p2, p4)) {
			return true;
		} else if (o3 == 0 && onsegment(p3, p4, p1)) {
			return true;
		} else if (o4 == 0 && onsegment(p3, p4, p2)) {
			return true;
		}
		return false;
	}

	// if p3 lies between p1 and p2
	private static boolean onsegment(point p1, point p2, point p3) {
		int minx = Math.min(p1.x, p2.x);
		int miny = Math.min(p1.y, p2.y);
		int maxx = Math.max(p1.x, p2.x);
		int maxy = Math.max(p1.y, p2.y);
		if (p3.x >= minx && p3.y >= miny && p3.x <= maxx && p3.y <= maxy) {
			return true;
		} else
			return false;
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
//			return "(" + x + "," + y + ")";
//		}
//
//	}

//	public static int getorientation(point p1, point p2, point p3) {
//		int val = (p2.y - p1.y) * (p3.x - p1.x) - (p3.y - p1.y) * (p2.x - p1.x);
//		return val == 0 ? 0 : val > 0 ? 1 : -1;
//	}

}
