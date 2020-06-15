package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

public class review {

	public JPanel contentPane;
	private JTextField totaleat;
	private JTextField totalwork;
	private JTextField penalty;
	JList daylist, morninglist, lunchlist, dinnerlist, snacklist, worklist;
	String daylist2[] = null;
	String Food[][];
	String mettable[][];
	long[] savelist = null;
	JButton back = new JButton("돌아가기");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public review() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 643, 470);

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
		
	}

	public void get(String[][] Food, String mettable[][]) {
		this.Food = Food;
		this.mettable = mettable;
		savelist = new long[mettable.length];
	}

	public static void carcul(review frame,mainframe frame2) {
		SimpleDateFormat turn = new SimpleDateFormat("yyyy MM dd");
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat mon = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");

		Calendar cal = Calendar.getInstance();

		frame.back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel=frame2.Panel();
				frame2.setContentPane(panel);
				frame2.setBounds(100, 100, panel.getWidth(), panel.getHeight());
				frame2.search(frame2);
				
			}
		});
		
		
		
		
		cal.add(Calendar.DAY_OF_MONTH, -365);
		File year2 = new File("date");
		ArrayList<String> daylistmodel = new ArrayList<String>();

		if (year2.isDirectory()) {
			for (int i = 0; i < 365; i++) {
				String time4 = year.format(cal.getTime());

				File year3 = new File("date/" + time4);
				// --------------------------
				if (year3.isDirectory()) {// 연도 확인
					String time5 = mon.format(cal.getTime());
					File year4 = new File("date/" + time4 + "/" + time5);
					if (year4.isDirectory()) {// 달 확인
						String time6 = day.format(cal.getTime());
						File year5 = new File("date/" + time4 + "/" + time5 + "/" + time6);

						if (year5.isDirectory()) {// 일확인

							daylistmodel.add(year.format(cal.getTime()) + "/" + mon.format(cal.getTime()) + "/"
									+ day.format(cal.getTime()));
						} else {

						}
					} else {
						Calendar time = Calendar.getInstance();
						time.set(Integer.parseInt(year.format(cal.getTime())),
								Integer.parseInt(mon.format(cal.getTime())), 1);
						long miner = time.getTime().getTime() - cal.getTime().getTime();
						int result = (int) (miner / (24 * 60 * 60 * 1000));
						cal.add(Calendar.DAY_OF_MONTH, +result);
						i += result;

						cal.add(Calendar.DAY_OF_MONTH, -1);
						i--;
					}

				}
				// ---------------------------------
				else {
					Calendar time = Calendar.getInstance();
					time.set(Integer.parseInt(year.format(cal.getTime())) + 1, 0, 1);
					long miner = time.getTime().getTime() - cal.getTime().getTime();
					int result = (int) (miner / (24 * 60 * 60 * 1000));
					cal.add(Calendar.DAY_OF_MONTH, +result);
					i += result;
					cal.add(Calendar.DAY_OF_MONTH, -1);
					i--;
				}
				cal.add(Calendar.DAY_OF_MONTH, +1);
			}
		} else {

		}
		frame.daylist2 = daylistmodel.toArray(new String[daylistmodel.size()]);
		DefaultListModel model = new DefaultListModel();

		for (int i = 0; i < frame.daylist2.length; i++) {
			model.addElement(frame.daylist2[i]);
		}
		frame.daylist.setModel(model);
		aaa select = new aaa();
		select.get(frame);
		frame.daylist.addListSelectionListener(select);
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
		//-----------------------------------------------
		try {
			File file2 = new File("date/" + file + "/totalkcal.txt");
			BufferedReader met3 = new BufferedReader(new FileReader(file2));
			String line;
			String a = null;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				a=line;
			}

			frame.totaleat.setText(a+" kcal");
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
				a=line;
			}

			frame.totalwork.setText(a+" kcal");
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
				a=line;
			}

			frame.penalty.setText(a+" kcal");
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
