package test;

import java.awt.Point;
import java.util.Scanner;

public class Main2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		for (int i = 0; i < Integer.parseInt(num); i++) {

			int[] rs = new int[2];
			Point one = new Point(scan.nextInt(), scan.nextInt());
			rs[0] = scan.nextInt();
			Point two = new Point(scan.nextInt(), scan.nextInt());
			double lenth = Math.sqrt(Math.pow(one.x - two.x, 2) + Math.pow(one.y - two.y, 2));
			rs[1] = scan.nextInt();
			if (rs[0] > rs[1]) {
				int q = rs[0];
				rs[0] = rs[1];
				rs[1] = q;
			}
			if (lenth > rs[0] && lenth > rs[1]) {
				if (lenth > rs[1] + rs[0]) {
					System.out.println("0");
				} else if (lenth == rs[1] + rs[0]) {
					System.out.println("1");
				} else if (lenth < rs[1] + rs[0]) {
					System.out.println("2");
				}
			} else if (one.equals(two)) {
				if (rs[0] == rs[1]) {
					System.out.println("-1");
				} else if (rs[0] != rs[1]) {
					System.out.println("0");
				}
			} else {
				if (lenth + rs[0] == rs[1]) {
					System.out.println("1");
				} else if (lenth + rs[0] > rs[1]) {
					System.out.println("2");
				} else if (lenth + rs[0] < rs[1]) {
					System.out.println("0");
				}

			}
		}
	}
}
