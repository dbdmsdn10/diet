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
}
