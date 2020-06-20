package first;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

public class ChoiceEvent implements ItemListener {

	review frame;
	String daylist3[];
	statistics frame2;

	ChoiceEvent(review frame, String daylist3[]) {
		this.frame = frame;
		this.daylist3 = daylist3;

	}

	ChoiceEvent(statistics frame, String daylist3[]) {
		this.frame2 = frame;
		this.daylist3 = daylist3;

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == frame.startyear) {
			int a = 0;
			ArrayList<Integer> monlist = new ArrayList<Integer>();
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();
				if (b[0].equals(choice.getSelectedItem()) && a != Integer.parseInt(b[1])) {
					a = Integer.parseInt(b[1]);
					monlist.add(Integer.parseInt(b[1]));
					if (monlist.size() == 1) {
						day = true;
					} else {
						day = false;
					}
				}
				if (day) {
					daylist.add(Integer.parseInt(b[2]));
				}
			}
			Collections.sort(monlist);
			Integer[] monlist2 = monlist.toArray(new Integer[monlist.size()]);
			frame.startmon.removeAll();
			for (int j = 0; j < monlist2.length; j++) {
				String q = Integer.toString(monlist2[j]);
				if (monlist2[j] < 10) {
					q = "0" + Integer.toString(monlist2[j]);
				}
				frame.startmon.add(q);

			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame.startday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				String q = Integer.toString(daylist2[j]);
				if (daylist2[j] < 10) {
					q = "0" + Integer.toString(daylist2[j]);
				}
				frame.startday.add(q);

			}

		}
		if (e.getSource() == frame.startmon) {

			int a = 0;
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();

				if (b[0].equals(frame.startyear.getSelectedItem()) && (choice.getSelectedItem()).equals(b[1])) {
					daylist.add(Integer.parseInt(b[2]));

				}
			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame.startday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				frame.startday.add(Integer.toString(daylist2[j]));
			}
		}

//----------------------------------------------------end
		if (e.getSource() == frame.endyear) {
			int a = 0;
			ArrayList<Integer> monlist = new ArrayList<Integer>();
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();
				if (b[0].equals(choice.getSelectedItem()) && a != Integer.parseInt(b[1])) {
					a = Integer.parseInt(b[1]);
					monlist.add(Integer.parseInt(b[1]));
					if (monlist.size() == 1) {
						day = true;
					} else {
						day = false;
					}
				}
				if (day) {
					daylist.add(Integer.parseInt(b[2]));
				}
			}
			Collections.sort(monlist);
			Integer[] monlist2 = monlist.toArray(new Integer[monlist.size()]);
			frame.endmon.removeAll();
			for (int j = 0; j < monlist2.length; j++) {
				String q = Integer.toString(monlist2[j]);
				if (monlist2[j] < 10) {
					q = "0" + Integer.toString(monlist2[j]);
				}
				frame.endmon.add(q);

			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame.endday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				String q = Integer.toString(daylist2[j]);
				if (daylist2[j] < 10) {
					q = "0" + Integer.toString(daylist2[j]);
				}
				frame.endday.add(q);

			}

		}
		if (e.getSource() == frame.endmon) {

			int a = 0;
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();

				if (b[0].equals(frame.endyear.getSelectedItem()) && (choice.getSelectedItem()).equals(b[1])) {
					daylist.add(Integer.parseInt(b[2]));

				}
			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame.endday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				frame.endday.add(Integer.toString(daylist2[j]));
			}
		}
		//Choice choice = (Choice) e.getSource();

		// System.out.println(choice.getSelectedIndex());
		// System.out.println(choice.getSelectedItem());
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		if (e.getSource() == frame2.startyear) {
			int a = 0;
			ArrayList<Integer> monlist = new ArrayList<Integer>();
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();
				if (b[0].equals(choice.getSelectedItem()) && a != Integer.parseInt(b[1])) {
					a = Integer.parseInt(b[1]);
					monlist.add(Integer.parseInt(b[1]));
					if (monlist.size() == 1) {
						day = true;
					} else {
						day = false;
					}
				}
				if (day) {
					daylist.add(Integer.parseInt(b[2]));
				}
			}
			Collections.sort(monlist);
			Integer[] monlist2 = monlist.toArray(new Integer[monlist.size()]);
			frame2.startmon.removeAll();
			for (int j = 0; j < monlist2.length; j++) {
				String q = Integer.toString(monlist2[j]);
				if (monlist2[j] < 10) {
					q = "0" + Integer.toString(monlist2[j]);
				}
				frame2.startmon.add(q);

			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame2.startday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				String q = Integer.toString(daylist2[j]);
				if (daylist2[j] < 10) {
					q = "0" + Integer.toString(daylist2[j]);
				}
				frame2.startday.add(q);

			}

		}
		if (e.getSource() == frame2.startmon) {

			int a = 0;
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();

				if (b[0].equals(frame2.startyear.getSelectedItem()) && (choice.getSelectedItem()).equals(b[1])) {
					daylist.add(Integer.parseInt(b[2]));

				}
			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame2.startday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				frame2.startday.add(Integer.toString(daylist2[j]));
			}
		}

//----------------------------------------------------end
		if (e.getSource() == frame2.endyear) {
			int a = 0;
			ArrayList<Integer> monlist = new ArrayList<Integer>();
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();
				if (b[0].equals(choice.getSelectedItem()) && a != Integer.parseInt(b[1])) {
					a = Integer.parseInt(b[1]);
					monlist.add(Integer.parseInt(b[1]));
					if (monlist.size() == 1) {
						day = true;
					} else {
						day = false;
					}
				}
				if (day) {
					daylist.add(Integer.parseInt(b[2]));
				}
			}
			Collections.sort(monlist);
			Integer[] monlist2 = monlist.toArray(new Integer[monlist.size()]);
			frame2.endmon.removeAll();
			for (int j = 0; j < monlist2.length; j++) {
				String q = Integer.toString(monlist2[j]);
				if (monlist2[j] < 10) {
					q = "0" + Integer.toString(monlist2[j]);
				}
				frame2.endmon.add(q);

			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame2.endday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				String q = Integer.toString(daylist2[j]);
				if (daylist2[j] < 10) {
					q = "0" + Integer.toString(daylist2[j]);
				}
				frame2.endday.add(q);

			}

		}
		if (e.getSource() == frame2.endmon) {

			int a = 0;
			ArrayList<Integer> daylist = new ArrayList<Integer>();
			boolean day = false;
			for (int i = daylist3.length - 1; i > 0; i--) {
				String b[];
				b = daylist3[i].split("/");
				Choice choice = (Choice) e.getSource();

				if (b[0].equals(frame2.endyear.getSelectedItem()) && (choice.getSelectedItem()).equals(b[1])) {
					daylist.add(Integer.parseInt(b[2]));

				}
			}
			Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
			frame2.endday.removeAll();
			for (int j = 0; j < daylist2.length; j++) {
				frame2.endday.add(Integer.toString(daylist2[j]));
			}
		}
	}
}
