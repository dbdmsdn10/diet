package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import first.FoodSearch.JListSelect;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.Choice;

public class statistics {

	public JPanel contentPane;
	String daylist2[] = null;
	static String daylist3[] = null;
	String Food[][];
	int EatFood[];
	String mettable[][];
	long[] savelist = null;
	JButton back = new JButton("돌아가기");
	static Choice startyear = new Choice();
	static Choice startmon = new Choice();
	static Choice startday = new Choice();
	JButton daycar = new JButton("날짜 계산");

	static Choice endyear = new Choice();
	static Choice endmon = new Choice();
	static Choice endday = new Choice();
	private JTextField mosteat;
	private JTextField mostwork;
	private JTextField eatover;
	int penalty = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public statistics() {
		startyear.removeAll();
		startmon.removeAll();
		startday.removeAll();
		endyear.removeAll();
		endmon.removeAll();
		endday.removeAll();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 444, 340);

		contentPane.setLayout(null);

		back.setBounds(330, 13, 97, 23);
		contentPane.add(back);

		JLabel lblNewLabel_4 = new JLabel("시작기간");
		lblNewLabel_4.setBounds(330, 46, 57, 15);
		contentPane.add(lblNewLabel_4);

		startyear.setBounds(330, 67, 63, 21);
		contentPane.add(startyear);

		startmon.setBounds(330, 94, 63, 21);
		contentPane.add(startmon);

		startday.setBounds(330, 121, 63, 21);

		daycar.setBounds(330, 263, 97, 23);
		contentPane.add(daycar);
		contentPane.add(startday);

		endyear.setBounds(330, 169, 63, 21);
		contentPane.add(endyear);

		endmon.setBounds(330, 196, 63, 21);
		contentPane.add(endmon);

		endday.setBounds(330, 223, 63, 21);
		contentPane.add(endday);

		JLabel lblNewLabel_5 = new JLabel("종료기간");
		lblNewLabel_5.setBounds(330, 148, 57, 15);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("년도");
		lblNewLabel_6.setBounds(399, 73, 26, 15);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("월");
		lblNewLabel_7.setBounds(399, 94, 28, 15);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("일");
		lblNewLabel_8.setBounds(399, 121, 23, 15);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("년도");
		lblNewLabel_9.setBounds(399, 169, 28, 15);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("월");
		lblNewLabel_10.setBounds(399, 196, 28, 15);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("일");
		lblNewLabel_11.setBounds(399, 223, 28, 15);
		contentPane.add(lblNewLabel_11);

		JLabel qq = new JLabel("가장 자주 먹은 음식");
		qq.setBounds(12, 67, 135, 15);
		contentPane.add(qq);

		JLabel qqqq = new JLabel("가장 많이한 운동");
		qqqq.setBounds(12, 100, 112, 15);
		contentPane.add(qqqq);

		JLabel qqqqqqqq = new JLabel("과식한적 있던날");
		qqqqqqqq.setBounds(12, 127, 112, 15);
		contentPane.add(qqqqqqqq);

		mosteat = new JTextField();
		mosteat.setEditable(false);
		mosteat.setBounds(159, 67, 165, 21);
		contentPane.add(mosteat);
		mosteat.setColumns(10);

		mostwork = new JTextField();
		mostwork.setEditable(false);
		mostwork.setBounds(159, 94, 165, 21);
		contentPane.add(mostwork);
		mostwork.setColumns(10);

		eatover = new JTextField();
		eatover.setEditable(false);
		eatover.setBounds(159, 121, 165, 21);
		contentPane.add(eatover);
		eatover.setColumns(10);

	}

	public void get(String[][] Food, String mettable[][]) {
		this.Food = Food;
		this.mettable = mettable;
		savelist = new long[mettable.length];
		this.EatFood = new int[Food.length];
	}

	public static void carcul(statistics frame, mainframe frame2) {
		Calendar cal = Calendar.getInstance();
		frame.back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = frame2.Panel();
				frame2.setContentPane(panel);
				frame2.setBounds(100, 100, panel.getWidth(), panel.getHeight());
				frame2.search(frame2);

			}
		});

		File year2 = new File("date");
		ArrayList<String> daylistmodel = new ArrayList<String>();
		Calendar cal2 = (Calendar) cal.clone();
		cal2.add(Calendar.DAY_OF_MONTH, -365);
		if (year2.isDirectory()) {
			daylistmodel = search(cal2, cal);
		} else {

		}
		frame.daylist2 = daylistmodel.toArray(new String[daylistmodel.size()]);

		int[] startset = new int[3];// 0년도 1월 2날짜
		int[] nowset = new int[3];
		boolean differyear = true;
		boolean differday = true;
		ArrayList<Integer> daylist = new ArrayList<Integer>();
		ArrayList<Integer> monlist = new ArrayList<Integer>();
		frame.savelist = new long[frame.savelist.length];
		frame.EatFood = new int[frame.EatFood.length];
		for (int i = 0; i < frame.daylist2.length; i++) {
			OpenFile(frame.daylist2[i], frame);
			String a[] = frame.daylist2[i].split("/");

			if (i == 0) {
				nowset[0] = Integer.parseInt(a[0]);
				nowset[1] = Integer.parseInt(a[1]);
				monlist.add(Integer.parseInt(a[1]));
				frame.startyear.add(a[0]);
				frame.endyear.add(a[0]);

			}
			if (differyear && nowset[0] != Integer.parseInt(a[0])) {
				daylist.removeAll(daylist);
				nowset[0] = Integer.parseInt(a[0]);
				frame.startyear.add(a[0]);
				frame.endyear.add(a[0]);
				frame.startyear.select(1);
				if (differyear) {

					Collections.sort(monlist);
					Integer[] monlist2 = monlist.toArray(new Integer[monlist.size()]);
					monlist.removeAll(monlist);
					for (int j = 0; j < monlist2.length; j++) {
						String q = Integer.toString(monlist2[j]);
						if (monlist2[j] < 10) {
							q = "0" + Integer.toString(monlist2[j]);
						}
						frame.endmon.add(q);
					}

					frame.endmon.select(monlist2.length - 1);
				}
				differyear = false;
			}
			if (differyear && nowset[1] != Integer.parseInt(a[1])) {

				nowset[1] = Integer.parseInt(a[1]);
				monlist.add(Integer.parseInt(a[1]));
				if (differday) {
					Collections.sort(daylist);
					Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
					daylist.removeAll(daylist);
					for (int j = 0; j < daylist2.length; j++) {
						String q = Integer.toString(daylist2[j]);
						if (daylist2[j] < 10) {
							q = "0" + Integer.toString(daylist2[j]);
						}

						frame.endday.add(q);
					}
					frame.endday.select(daylist2.length - 1);

				}
				daylist.removeAll(daylist);
				differday = false;
			}
			if (differday) {
				daylist.add(Integer.parseInt(a[2]));
			}
			// -----------------------------------------------
			if (!differyear && nowset[1] != Integer.parseInt(a[1])) {
				nowset[1] = Integer.parseInt(a[1]);
				monlist.add(Integer.parseInt(a[1]));
				daylist.removeAll(daylist);
			}
			if (!differday) {
				daylist.add(Integer.parseInt(a[2]));
			}
			if (i == frame.daylist2.length - 1) {
				Collections.sort(monlist);
				Integer[] monlist2 = monlist.toArray(new Integer[monlist.size()]);
				monlist.removeAll(monlist);
				for (int j = 0; j < monlist2.length; j++) {
					String q = Integer.toString(monlist2[j]);
					if (monlist2[j] < 10) {
						q = "0" + Integer.toString(monlist2[j]);
					}
					frame.startmon.add(q);
					if (differyear) {
						frame.endmon.add(q);
					}
				}
				if (differyear) {
					frame.endmon.select(monlist2.length - 1);
				}

				Collections.sort(daylist);
				Integer[] daylist2 = daylist.toArray(new Integer[daylist.size()]);
				daylist.removeAll(daylist);
				for (int j = 0; j < daylist2.length; j++) {
					String q = Integer.toString(daylist2[j]);
					if (daylist2[j] < 10) {
						q = "0" + Integer.toString(daylist2[j]);
					}

					frame.startday.add(q);
					if (differday) {
						frame.endday.add(q);
					}
				}
				if (differday) {
					frame.endday.select(daylist2.length - 1);
				}
			}

		}

		long savelistbig[] = new long[2];
		int EatFoodbig[] = new int[2];
		for (int i = 0; i < frame.savelist.length; i++) {
			if (savelistbig[0] < frame.savelist[i]) {
				savelistbig[0] = frame.savelist[i];
				savelistbig[1] = i;
			}
		}
		for (int i = 0; i < frame.EatFood.length; i++) {
			if (EatFoodbig[0] < frame.EatFood[i]) {
				EatFoodbig[0] = frame.EatFood[i];
				EatFoodbig[1] = i;
			}
		}

		if (EatFoodbig[0] != 0) {
			frame.mosteat.setText(frame.Food[EatFoodbig[1]][5] + "  " + EatFoodbig[0] + "번");
		} else {
			frame.mosteat.setText("");
		}
		if (savelistbig[0] != 0) {
			frame.mostwork.setText(frame.mettable[(int) savelistbig[1]][0] + "  " + toTime(savelistbig[0]));
		} else {
			frame.mostwork.setText("");
		}
		if (frame.penalty != 0) {
			frame.eatover.setText(frame.penalty + "번");
		} else {
			frame.eatover.setText("");
		}
		frame.savelist = new long[frame.savelist.length];
		frame.EatFood = new int[frame.EatFood.length];
		frame.penalty = 0;
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		frame.daycar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> daylistmodel = new ArrayList<String>();
				Calendar cal2 = (Calendar) cal.clone();

				cal2.set(Integer.parseInt(frame.startyear.getSelectedItem()),
						Integer.parseInt(frame.startmon.getSelectedItem()) - 1,
						Integer.parseInt(frame.startday.getSelectedItem()));
				Calendar cal3 = Calendar.getInstance();
				cal3.set(Integer.parseInt(frame.endyear.getSelectedItem()),
						Integer.parseInt(frame.endmon.getSelectedItem()) - 1,
						Integer.parseInt(frame.endday.getSelectedItem()));
				if (year2.isDirectory()) {
					daylistmodel = search(cal2, cal3);
				} else {

				}
				frame.daylist2 = daylistmodel.toArray(new String[daylistmodel.size()]);

				frame.savelist = new long[frame.savelist.length];
				frame.EatFood = new int[frame.EatFood.length];

				for (int i = 0; i < frame.daylist2.length; i++) {
					OpenFile(frame.daylist2[i], frame);

				}
				long savelistbig[] = new long[2];
				int EatFoodbig[] = new int[2];
				for (int i = 0; i < frame.savelist.length; i++) {
					if (savelistbig[0] < frame.savelist[i]) {
						savelistbig[0] = frame.savelist[i];
						savelistbig[1] = i;
					}
				}
				for (int i = 0; i < frame.EatFood.length; i++) {
					if (EatFoodbig[0] < frame.EatFood[i]) {
						EatFoodbig[0] = frame.EatFood[i];
						EatFoodbig[1] = i;
					}
				}
				if (EatFoodbig[0] != 0) {
					frame.mosteat.setText(frame.Food[EatFoodbig[1]][5] + "  " + EatFoodbig[0] + "번");
				}
				if (savelistbig[0] != 0) {
					frame.mostwork.setText(frame.mettable[(int) savelistbig[1]][0] + "  " + toTime(savelistbig[0]));
				}
				if (frame.penalty != 0) {
					frame.eatover.setText(frame.penalty + "번");
				}
				frame.penalty = 0;
			}
		});
		frame.daylist3 = frame.daylist2.clone();
		ChoiceEvent choice = new ChoiceEvent(frame, frame.daylist3);
		startyear.addItemListener(choice);
		startmon.addItemListener(choice);
		endyear.addItemListener(choice);
		endmon.addItemListener(choice);
	}

	// ---------------------------------------
//------------------------------------------------------------
	public static void OpenFile(String file, statistics frame) {

		try {
			File file2 = new File("date/" + file + "/breakfast.txt");

			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				frame.EatFood[Integer.parseInt(a[i])]++;
			}

		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file2 = new File("date/" + file + "/lunch.txt");
			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				frame.EatFood[Integer.parseInt(a[i])]++;
			}

		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file2 = new File("date/" + file + "/dinner.txt");
			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				frame.EatFood[Integer.parseInt(a[i])]++;
			}

		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file2 = new File("date/" + file + "/snack.txt");
			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				frame.EatFood[Integer.parseInt(a[i])]++;
			}

		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file2 = new File("date/" + file + "/dayusedcalori.txt");
			BufferedReader met3 = new BufferedReader(new FileReader(file2));
			String line;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				String[] a = line.split("	");
				frame.savelist[(int) Long.parseLong(a[0])] += Long.parseLong(a[1]);
			}

		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		// -----------------------------------------------

		File file2 = new File("date/" + file + "/pastcar.txt");
		if (file2.exists()) {
			frame.penalty++;
		}
	}
	// --------------------------------------------

	// { "breakfast.txt", "dayusedcalori.txt", "dinner.txt", "lunch.txt",
	// "snack.txt", "totalkcal.txt",
	// "usedcalori.txt", "pastcar.txt" };
	public static String toTime(long time) {
		int h = (int) (time / 1000.0 / 60.0 / 60.0);
		int m = (int) (time / 1000.0 / 60.0);
		int s = (int) (time % (1000.0 * 60) / 1000.0);
		int ms = (int) (time % 1000 / 10.0);

		return String.format("%02d : %02d : %02d : %02d", h, m, s, ms);
	}

	public static ArrayList<String> search(Calendar start, Calendar end) {
		SimpleDateFormat turn = new SimpleDateFormat("yyyy MM dd");
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat mon = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		ArrayList<String> daylistmodel = new ArrayList<String>();
		long miner = end.getTime().getTime() - start.getTime().getTime();
		int resul2 = (int) (miner / (24 * 60 * 60 * 1000));
		if (resul2 == 0) {
			resul2 = 1;
		}
		if (miner < 0) {
			JOptionPane.showMessageDialog(null, "시작기간이 종료기간보다 클수없습니다");
		} else {
			for (int i = 0; i < resul2; i++) {

				String time4 = year.format(end.getTime());

				File year3 = new File("date/" + time4);
				// --------------------------
				if (year3.isDirectory()) {// 연도 확인
					String time5 = mon.format(end.getTime());
					File year4 = new File("date/" + time4 + "/" + time5);
					if (year4.isDirectory()) {// 달 확인
						String time6 = day.format(end.getTime());
						File year5 = new File("date/" + time4 + "/" + time5 + "/" + time6);

						if (year5.isDirectory()) {// 일확인
							daylistmodel.add(year.format(end.getTime()) + "/" + mon.format(end.getTime()) + "/"
									+ day.format(end.getTime()));

						} else {

						}
					} else {
						Calendar time = Calendar.getInstance();
						time.set(Integer.parseInt(year.format(end.getTime())),
								Integer.parseInt(mon.format(end.getTime())) - 1, 1);
						long miner2 = end.getTime().getTime() - time.getTime().getTime();
						int result = (int) (miner2 / (24 * 60 * 60 * 1000));
						end.add(Calendar.DAY_OF_MONTH, -result);
						i += result;
					}
				}
				// ---------------------------------
				else {
					Calendar time = Calendar.getInstance();
					time.set(Integer.parseInt(year.format(end.getTime())), 0, 1);
					long miner2 = end.getTime().getTime() - time.getTime().getTime();
					int result = (int) (miner2 / (24 * 60 * 60 * 1000));
					end.add(Calendar.DAY_OF_MONTH, -result);
					i += result;

				}
				end.add(Calendar.DAY_OF_MONTH, -1);
			}
		}
		return daylistmodel;

	}
}