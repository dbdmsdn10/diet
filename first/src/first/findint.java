package first;

import java.util.ArrayList;

public class findint {
	public Integer[] find(String[][] a, String b,int d,int start) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		for(int i=start;i<a.length;i++)
		{
			if(a[i][d].contains(b))
			{
				c.add(i);
			}
		}
		
		Integer[] answer=c.toArray(new Integer[c.size()]);
		return answer;
	}
	
	public Integer[] findPerCategory(String[][] a, String b,int d,int start,int category) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		if(category == 1) {
			for(int i=start;i<a.length;i++){
				if(a[i][d].contains(b) && (a[i][3].equals("가공식품") && a[i][4].equals("상용제품"))){
				c.add(i);
				}
			}
		}
		else if(category == 2) {
			for(int i=start;i<a.length;i++){
				if(a[i][d].contains(b) && ( a[i][4].equals("품목대표") &&(a[i][3].equals("농축산물") || a[i][3].equals("수산물") ))){
				c.add(i);
				}
			}
			
		}
		else if(category == 3) {
			for(int i=start;i<a.length;i++){
				if(a[i][d].contains(b) && (a[i][3].equals("외식") && a[i][4].equals("상용제품"))){
				c.add(i);
				}
			}
			
		}
		else {
			for(int i=start;i<a.length;i++){
				if(a[i][d].contains(b) && (a[i][3].equals("외식") && a[i][4].equals("품목대표"))){
				c.add(i);
				}
			}
			
		}
		Integer[] answer=c.toArray(new Integer[c.size()]);
		return answer;
	}
}
