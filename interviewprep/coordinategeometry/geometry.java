package coordinategeometry;

public class geometry {

	public static void main(String[] args) {
		point p1 = new point(2, 2);
		point p2 = new point(-2, -2);
		point p3 = new point(2, -2);
		point p4 = new point(-2, 2);
		int val = getorientation(p1, p2, p3);
		if (val > 0) {
			System.out.println("clockwise");
		} else if (val == 0) {
			System.out.println("collinear");
		} else {
			System.out.println("anticlockwise");
		}
		System.out.println(intersection(p1, p2, p3, p4));
	}

	public static int getorientation(point p1, point p2, point p3) {
		int val = (p2.y - p1.y) * (p3.x - p1.x) - (p3.y - p1.y) * (p2.x - p1.x);
		return val == 0 ? 0 : val > 0 ? 1 : -1;
	}

	public static boolean intersection(point p1, point p2, point p3, point p4) {
		if ((getorientation(p1, p2, p3) != getorientation(p1, p2, p4))
				&& (getorientation(p3, p4, p1) != getorientation(p3, p4, p2))) {
			return true;
		} else
			return false;
	}

}
