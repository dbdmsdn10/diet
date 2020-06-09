package first;

import java.util.ArrayList;

public class findint {
	public Integer[] find(String[][] a, String b, int d, int start) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		for (int i = start; i < a.length; i++) {
			if (a[i][d].contains(b)) {
				c.add(i);
			}
		}

		Integer[] answer = c.toArray(new Integer[c.size()]);
		return answer;
	}

	public Integer[] findPerCategory2(String[][] a, int d, String name) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		boolean what = true;
		if (name.equals("냉동, 과자, 기타등등")) {
			for (int i = 4; i < a.length; i++) {
				if (a[i][3].equals("가공식품")) {
					try {
						Double.parseDouble(a[i][14]);
						c.add(i);
					} catch (Exception e) {
					}
				}
			}
		} else if (name.equals("요리 재료, 과일, 생것")) {
			for (int i = 4; i < a.length; i++) {
				if (a[i][3].equals("농축산물") || a[i][3].equals("수산물")) {
					try {
						Double.parseDouble(a[i][14]);
						c.add(i);
					} catch (Exception e) {
					}
				}
			}

		} else if (name.equals("식당, 가게 상품등")) {
			for (int i = 4; i < a.length; i++) {
				if (a[i][3].equals("외식") && a[i][4].equals("상용제품")) {
					try {
						Double.parseDouble(a[i][14]);
						c.add(i);
					} catch (Exception e) {
					}
				}
			}

		} else if (name.equals("일반적 요리, 음식")) {
			for (int i = 4; i < a.length; i++) {
				if (a[i][3].equals("외식") && a[i][4].equals("품목대표")) {
					try {
						Double.parseDouble(a[i][14]);
						c.add(i);
					} catch (Exception e) {
					}
				}
			}

		} else {
			what = false;
		}
		Integer[] answer = {};
		if (what) {
			answer = c.toArray(new Integer[c.size()]);
		} else {
			answer = new Integer[a.length - 4];
			for (int i = 4; i < a.length; i++) {
				answer[i - 4] = i;

			}

		}
		return answer;
	}

	public Integer[] findPerCategory(String[][] a, String b, int d, Integer[] Array) {
		ArrayList<Integer> c = new ArrayList<Integer>();

		for (int i = 0; i < Array.length; i++) {
			if (a[Array[i]][d].contains(b)) {
				c.add(Array[i]);
			}
		}

		Integer[] answer = c.toArray(new Integer[c.size()]);
		return answer;
	}
}
