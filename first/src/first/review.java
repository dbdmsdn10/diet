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
import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.Choice;

public class review {

	public JPanel contentPane;
	private JTextField totaleat;
	private JTextField totalwork;
	private JTextField penalty;
	JList daylist, morninglist, lunchlist, dinnerlist, snacklist, worklist;
	String daylist2[] = null;
	static String daylist3[] = null;
	String Food[][];
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

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public review() {
		startyear.removeAll();
		startmon.removeAll();
		startday.removeAll();
		endyear.removeAll();
		endmon.removeAll();
		endday.removeAll();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 670, 470);

		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 33, 89, 388);
		contentPane.add(scrollPane);

		daylist = new JList();
		scrollPane.setViewportView(daylist);

		JLabel lblNewLabel = new JLabel("날짜");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(126, 33, 89, 158);
		contentPane.add(scrollPane_1);

		morninglist = new JList();
		scrollPane_1.setViewportView(morninglist);

		JLabel lblNewLabel_1 = new JLabel("아침");
		lblNewLabel_1.setBounds(126, 10, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("점심");
		lblNewLabel_1_1.setBounds(227, 11, 57, 15);
		contentPane.add(lblNewLabel_1_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(227, 33, 89, 158);
		contentPane.add(scrollPane_1_1);

		lunchlist = new JList();
		scrollPane_1_1.setViewportView(lunchlist);

		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(328, 33, 89, 158);
		contentPane.add(scrollPane_1_1_1);

		dinnerlist = new JList();
		scrollPane_1_1_1.setViewportView(dinnerlist);

		JLabel lblNewLabel_1_1_1 = new JLabel("저녁");
		lblNewLabel_1_1_1.setBounds(328, 11, 57, 15);
		contentPane.add(lblNewLabel_1_1_1);

		JScrollPane scrollPane_1_1_2 = new JScrollPane();
		scrollPane_1_1_2.setBounds(429, 32, 89, 159);
		contentPane.add(scrollPane_1_1_2);

		snacklist = new JList();
		scrollPane_1_1_2.setViewportView(snacklist);

		JLabel lblNewLabel_1_1_2 = new JLabel("간식");
		lblNewLabel_1_1_2.setBounds(429, 10, 57, 15);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_2 = new JLabel("운동한것");
		lblNewLabel_2.setBounds(126, 218, 57, 15);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(125, 243, 292, 167);
		contentPane.add(scrollPane_2);

		worklist = new JList();
		scrollPane_2.setViewportView(worklist);

		totaleat = new JTextField();
		totaleat.setEditable(false);
		totaleat.setBounds(429, 268, 116, 21);
		contentPane.add(totaleat);
		totaleat.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("먹은 칼로리총량");
		lblNewLabel_3.setBounds(429, 243, 89, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("운동 총량");
		lblNewLabel_3_1.setBounds(429, 299, 89, 15);
		contentPane.add(lblNewLabel_3_1);

		totalwork = new JTextField();
		totalwork.setEditable(false);
		totalwork.setColumns(10);
		totalwork.setBounds(429, 324, 116, 21);
		contentPane.add(totalwork);

		JLabel lblNewLabel_3_1_1 = new JLabel("그날 패널티");
		lblNewLabel_3_1_1.setBounds(429, 355, 89, 15);
		contentPane.add(lblNewLabel_3_1_1);

		penalty = new JTextField();
		penalty.setEditable(false);
		penalty.setColumns(10);
		penalty.setBounds(429, 380, 116, 21);
		contentPane.add(penalty);

		back.setBounds(530, 10, 97, 23);
		contentPane.add(back);

		JLabel lblNewLabel_4 = new JLabel("시작기간");
		lblNewLabel_4.setBounds(561, 57, 57, 15);
		contentPane.add(lblNewLabel_4);

		startyear.setBounds(561, 78, 63, 21);
		contentPane.add(startyear);

		startmon.setBounds(561, 105, 63, 21);
		contentPane.add(startmon);

		startday.setBounds(561, 132, 63, 21);

		daycar.setBounds(561, 379, 97, 23);
		contentPane.add(daycar);
		contentPane.add(startday);

		endyear.setBounds(561, 218, 63, 21);
		contentPane.add(endyear);

		endmon.setBounds(561, 241, 63, 21);
		contentPane.add(endmon);

		endday.setBounds(561, 268, 63, 21);
		contentPane.add(endday);

		JLabel lblNewLabel_5 = new JLabel("종료기간");
		lblNewLabel_5.setBounds(561, 197, 57, 15);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("년도");
		lblNewLabel_6.setBounds(632, 83, 26, 15);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("월");
		lblNewLabel_7.setBounds(630, 111, 28, 15);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("일");
		lblNewLabel_8.setBounds(635, 138, 23, 15);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("년도");
		lblNewLabel_9.setBounds(630, 218, 28, 15);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("월");
		lblNewLabel_10.setBounds(630, 245, 28, 15);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("일");
		lblNewLabel_11.setBounds(630, 274, 28, 15);
		contentPane.add(lblNewLabel_11);

	}

	public void get(String[][] Food, String mettable[][]) {
		this.Food = Food;
		this.mettable = mettable;
		savelist = new long[mettable.length];
	}

	public static void carcul(review frame, mainframe frame2) {

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

		DefaultListModel model = new DefaultListModel();
		int[] startset = new int[3];// 0년도 1월 2날짜
		int[] nowset = new int[3];
		boolean differyear = true;
		boolean differday = true;
		ArrayList<Integer> daylist = new ArrayList<Integer>();
		ArrayList<Integer> monlist = new ArrayList<Integer>();
		for (int i = 0; i < frame.daylist2.length; i++) {
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
			model.addElement(frame.daylist2[i]);
		}

		frame.daylist.setModel(model);
		aaa select = new aaa();
		select.get(frame);
		frame.daylist.addListSelectionListener(select);
		// ---------------------------------------------------
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
				DefaultListModel model2 = new DefaultListModel();

				for (int i = 0; i < frame.daylist2.length; i++) {
					model2.addElement(frame.daylist2[i]);
				}
				frame.daylist.setModel(model2);

			}
		});
		frame.daylist3 = frame.daylist2.clone();
		ChoiceEvent choice = new ChoiceEvent(frame, frame.daylist3);
		startyear.addItemListener(choice);
		startmon.addItemListener(choice);
		endyear.addItemListener(choice);
		endmon.addItemListener(choice);
	}

	public void OpenFile(String file, review frame) {

		try {
			File file2 = new File("date/" + file + "/breakfast.txt");

			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;
			DefaultListModel model = new DefaultListModel();

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				model.addElement(Food[Integer.parseInt(a[i])][5] + "  " + Food[Integer.parseInt(a[i])][14] + "kcal");
			}
			frame.morninglist.setModel(model);
		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file2 = new File("date/" + file + "/lunch.txt");
			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;
			DefaultListModel model = new DefaultListModel();

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				model.addElement(Food[Integer.parseInt(a[i])][5] + "  " + Food[Integer.parseInt(a[i])][14] + "kcal");
			}
			frame.lunchlist.setModel(model);
		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file2 = new File("date/" + file + "/dinner.txt");
			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;
			DefaultListModel model = new DefaultListModel();

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				model.addElement(Food[Integer.parseInt(a[i])][5] + "  " + Food[Integer.parseInt(a[i])][14] + "kcal");
			}
			frame.dinnerlist.setModel(model);
		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file2 = new File("date/" + file + "/snack.txt");
			BufferedReader dinner2 = new BufferedReader(new FileReader(file2));
			String line;
			DefaultListModel model = new DefaultListModel();

			String a[] = null;
			while ((line = dinner2.readLine()) != null) {
				a = line.split(",");
			}

			for (int i = 0; i < a.length; i++) {
				model.addElement(Food[Integer.parseInt(a[i])][5] + "  " + Food[Integer.parseInt(a[i])][14] + "kcal");
			}
			frame.snacklist.setModel(model);
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
				savelist[(int) Long.parseLong(a[0])] = Long.parseLong(a[1]);
			}
			DefaultListModel model = new DefaultListModel();

			for (int i = 0; i < savelist.length; i++) {
				if (savelist[i] == 0) {
					continue;
				} else {
					model.addElement(mettable[i][0] + "   " + toTime(savelist[i]));
				}
			}

			frame.worklist.setModel(model);
		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		// -----------------------------------------------
		try {
			File file2 = new File("date/" + file + "/totalkcal.txt");
			BufferedReader met3 = new BufferedReader(new FileReader(file2));
			String line;
			String a = null;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				a = line;
			}

			frame.totaleat.setText(a + " kcal");
		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file2 = new File("date/" + file + "/usedcalori.txt");
			BufferedReader met3 = new BufferedReader(new FileReader(file2));
			String line;
			String a = null;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				a = line;
			}

			frame.totalwork.setText(a + " kcal");
		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			File file2 = new File("date/" + file + "/pastcar.txt");
			BufferedReader met3 = new BufferedReader(new FileReader(file2));
			String line;
			String a = null;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				a = line;
			}

			frame.penalty.setText(a + " kcal");
		} catch (IOException q) {// 파일 읽기 오류
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// --------------------------------------------

	// { "breakfast.txt", "dayusedcalori.txt", "dinner.txt", "lunch.txt",
	// "snack.txt", "totalkcal.txt",
	// "usedcalori.txt", "pastcar.txt" };
	public String toTime(long time) {
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
		for (int i = 0; i < resul2 + 1; i++) {

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
		return daylistmodel;

	}
}

class aaa implements ListSelectionListener {
	review re;

	public void get(review re) {
		this.re = re;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (re.daylist.getSelectedIndex() != -1) {

			re.OpenFile(re.daylist2[re.daylist.getSelectedIndex()], re);
		}

	}
}
