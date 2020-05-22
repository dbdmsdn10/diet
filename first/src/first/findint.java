package first;

import java.util.ArrayList;

public class findint {
	public Integer[] find(String[][] a, String b) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++)
		{
			if(a[i][0].contains(b))
			{
				c.add(i);
			}
		}
		
		Integer[] answer=c.toArray(new Integer[c.size()]);
		return answer;
	}
}
