package first;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public  class teat {
	public static void main(String args[]) {
		SimpleDateFormat turn = new SimpleDateFormat("yyyy MM dd");
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat mon = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		System.out.println(turn.format(cal.getTime()));
		String years=null;
		String mons=null;
		String days=null;
		for(int i=0;i<365;i++)
		{
			String year00=turn.format(cal.getTime());
			String[] year0 = year00.split(" ");
			File year2 = new File("date");
			File year3 = new File("date/" + year0[0]);
			File year4 = new File("date/" + year0[0] + "/" + year0[1]);
			File year5 = new File("date/" + year0[0] + "/" + year0[1] + "/" + year0[2]);
			System.out.println("date/" + year0[0] + "/" + year0[1] + "/" + year0[2]);
			if (year2.isDirectory()) {
				if (year3.isDirectory()) {
					if (year4.isDirectory()) {
						year5.mkdir();
					} else {
						year4.mkdir();
						year5.mkdir();
					}
				} else {
					year3.mkdir();
					year4.mkdir();
					year5.mkdir();
				}
			} else {
				year2.mkdir();
				year3.mkdir();
				year4.mkdir();
				year5.mkdir();
			}
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
	}
}
