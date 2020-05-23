package first;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Exerciseframe extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	String[][] mettable = null;
	Integer[] find = null;
	JList list = new JList();
	private JTextField mettext;
	private JTextField metvalue;
	long time = 0, preTime = 0, pauseTime = 0, time2 = 0, time3 = 0;
	private JTextField timetext;
	TimeThread timeTh = new TimeThread();
	private JTextField textField;
	public JTextField kcal;
	private JTextField txtKcal;
	String[] personinfo;
	double used = 0;
	private JTextField txtStopwatch;
	private JTextField textField_1;
	private JTextField want;
	private JTextField textField_3;
	double savecalcori = 0;
	private JTextField secondtime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exerciseframe frame = new Exerciseframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void get(String[] personinfo, double savecalcori) {
		this.personinfo = personinfo;
		this.savecalcori = savecalcori;
	}

	/**
	 * Create the frame.
	 */
	public Exerciseframe() {

		File met = new File("mettable.txt");
		try {
			BufferedReader met3 = new BufferedReader(new FileReader(met));
			String line;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				String[] a = line.split("	");
				mettablearray.add(a);
			}
			mettable = mettablearray.toArray(new String[mettablearray.size()][]);
		} catch (IOException q) {// 파일 읽기 오류
			System.out.println(q.getMessage());
		} catch (Exception e) {
			System.out.println("오류");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		name = new JTextField();
		name.setBounds(12, 10, 116, 21);
		contentPane.add(name);
		name.setColumns(10);

		JButton search = new JButton("\uAC80\uC0C9");
		search1 search2 = new search1();
		search.addActionListener(search2);
		search.setBounds(140, 9, 97, 23);
		contentPane.add(search);
		DefaultListModel model = new DefaultListModel();
		find = new Integer[mettable.length];
		for (int i = 0; i < mettable.length; i++) {
			model.addElement(mettable[i][0]);
			find[i] = i;
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 41, 116, 299);
		contentPane.add(scrollPane);
		list.setEnabled(true);
		scrollPane.setViewportView(list);
		list.setModel(model);

		mettext = new JTextField();
		mettext.setEnabled(false);
		mettext.setBackground(Color.WHITE);
		mettext.setText("운동강도");
		mettext.setBounds(140, 42, 60, 21);
		mettext.setForeground(Color.black);
		contentPane.add(mettext);
		mettext.setColumns(10);

		metvalue = new JTextField();
		metvalue.setBackground(Color.WHITE);
		metvalue.setEnabled(false);
		metvalue.setBounds(212, 42, 60, 21);
		contentPane.add(metvalue);
		metvalue.setColumns(10);

		timetext = new JTextField();
		timetext.setEnabled(false);
		timetext.setBounds(256, 126, 148, 21);
		contentPane.add(timetext);
		timetext.setColumns(10);

		JButton 시작 = new JButton("시작");
		시작.setBounds(140, 157, 97, 23);
		contentPane.add(시작);

		JButton 중지 = new JButton("중지");
		중지.setBounds(249, 157, 97, 23);
		contentPane.add(중지);

		JButton 멈춤 = new JButton("멈춤");
		멈춤.setBounds(358, 157, 97, 23);
		contentPane.add(멈춤);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEnabled(false);
		textField.setText("소비칼로리");
		textField.setBounds(140, 190, 75, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		kcal = new JTextField();
		kcal.setBackground(Color.WHITE);
		kcal.setEnabled(false);
		kcal.setBounds(230, 190, 116, 21);
		contentPane.add(kcal);
		kcal.setColumns(10);

		txtKcal = new JTextField();
		txtKcal.setBackground(Color.WHITE);
		txtKcal.setEnabled(false);
		txtKcal.setText("kcal");
		txtKcal.setBounds(368, 190, 36, 21);
		contentPane.add(txtKcal);
		txtKcal.setColumns(10);

		JButton back = new JButton("돌아가기");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					timeTh.interrupt();
					BufferedWriter make = new BufferedWriter(new FileWriter("usedcalori.txt", false));
					make.write(Double.toString(savecalcori + Double.parseDouble(kcal.getText())));
					make.flush();
					make.close();
				} catch (Exception ee) {
				}
				mainframe frame = new mainframe();
				frame.setVisible(true);
				dispose();
			}
		});
		back.setBounds(457, 317, 97, 23);
		contentPane.add(back);

		txtStopwatch = new JTextField();
		txtStopwatch.setForeground(Color.BLACK);
		txtStopwatch.setBackground(Color.WHITE);
		txtStopwatch.setEnabled(false);
		txtStopwatch.setText("stopwatch");
		txtStopwatch.setBounds(140, 126, 108, 21);
		contentPane.add(txtStopwatch);
		txtStopwatch.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("빼고싶은 칼로리");
		textField_1.setBackground(Color.WHITE);
		textField_1.setEnabled(false);
		textField_1.setBounds(140, 99, 108, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		want = new JTextField();
		want.setBounds(256, 99, 148, 21);
		contentPane.add(want);
		want.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("kcal");
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(406, 99, 36, 21);
		contentPane.add(textField_3);

		JButton carculbutton = new JButton("계산하기");
		carculbutton.setBounds(457, 98, 86, 23);
		contentPane.add(carculbutton);

		secondtime = new JTextField();
		secondtime.setEnabled(false);
		secondtime.setColumns(10);
		secondtime.setBounds(229, 229, 148, 21);
		contentPane.add(secondtime);
		JListSelect select = new JListSelect();
		list.addListSelectionListener(select);

		stopwatchstart start = new stopwatchstart();
		stopwatchpause pause = new stopwatchpause();
		stopwatchstop stop = new stopwatchstop();
		Backto backto = new Backto();
		시작.addActionListener(start);

		중지.addActionListener(pause);
		멈춤.addActionListener(stop);
		back.addActionListener(backto);
		Carculate carcul = new Carculate();
		carculbutton.addActionListener(carcul);

	}

	class search1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			list.removeAll();
			// TODO Auto-generated method stub
			findint a = new findint();
			find = a.find(mettable, name.getText());
			DefaultListModel model = new DefaultListModel();
			for (int i = 0; i < find.length; i++) {
				model.addElement(mettable[find[i]][0]);
			}
			list.setModel(model);
		}
	}

	class JListSelect implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (list.getSelectedIndex() != -1) {
				metvalue.setText(mettable[find[list.getSelectedIndex()]][1]);
			}

		}

	}

	class stopwatchstart implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!metvalue.getText().equals("")) {
				if (timeTh == null || !timeTh.isAlive()) {
					if (time != 0)
						preTime = System.currentTimeMillis() - time;
					else {
						preTime = System.currentTimeMillis();
						try {
							BufferedWriter make = new BufferedWriter(new FileWriter("usedcalori.txt", false));
							make.write(Double.toString(used + Double.parseDouble(kcal.getText())));
						} catch (Exception ee) {
						}
					}
					pauseTime = System.currentTimeMillis();
					timeTh = new TimeThread();
					timeTh.start();
				}
			} else {
				JOptionPane.showMessageDialog(null, "'운동'을 선택해주세요");
			}
		}

	}

	class stopwatchpause implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (timeTh.isAlive()) {
				timeTh.interrupt();
				list.setEnabled(true);
				used = Double.parseDouble(kcal.getText());
			}

		}

	}

	class stopwatchstop implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (timeTh.isAlive()) {
				list.setEnabled(true);
				timeTh.interrupt();
			}
			pauseTime = 0;
			time = 0;
			used = 0;
		}
	}

	class Backto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	class Carculate implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String a = want.getText();
			boolean c = true;

			if (want.getText().equals("") & c) {
				JOptionPane.showMessageDialog(null, "내용을 입력해주세요");
				c = false;
			}
			double b = 0;
			if (c) {
				try {
					b = Double.parseDouble(a);
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "'숫자'를 입력해주세요");
					c = false;
				}
			}
			String met = metvalue.getText();
			if (met.equals("") & c) {
				JOptionPane.showMessageDialog(null, "'운동'을 선택해주세요");
				c = false;
			}
			if (c) {
				double met2 = Double.parseDouble(a);
				double hcar = Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0]) * 60
						/ 200;
				double mincar = Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0]) / 200;
				double seccar = Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0]) / 12000;
				double mscar = Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0])
						/ 1200000;
				int hour = 0, min = 0, sec = 0, ms = 0;
				if (met2 > hcar) {
					boolean htime = true;
					int l = 1;
					while (htime) {
						l++;
						if (met2 < mincar * l) {
							hour = l - 1;
							met2 = met2 - hcar * hour;
							htime = false;
						}
					}
				}
				if (met2 > mincar) {
					boolean mintime = true;
					int l = 1;
					while (mintime) {
						l++;
						if (met2 < mincar * l) {
							min = l - 1;
							met2 = met2 - mincar * min;
							mintime = false;
						}
					}
				}
				if (met2 > seccar) {
					boolean sectime = true;
					int l = 1;
					while (sectime) {
						l++;
						if (met2 < seccar * l) {
							sectime = false;
							sec = l - 1;
							met2 = met2 - seccar * sec;
						}
					}
				}
				if (met2 > mscar) {
					boolean mstime = true;
					int l = 1;
					while (mstime) {
						l++;
						if (met2 < mscar * l) {
							mstime = false;
							ms = l - 1;
							met2 = met2 - mscar * ms;
						}
					}
				}
				time3=hour*1000 * 60 * 60;
				time3 += 1000 * 60 * min;
				time3 += sec * 1000 + ms * 10;
				secondtime.setText(toTime(time3));

			}

		}

	}

	// ----------------------------------------------------------------------
	class TimeThread extends Thread {
		public void run() {
			try {
				while (!Thread.currentThread().isInterrupted()) {
					list.setEnabled(false);
					list.setFocusable(false);
					sleep(10);

					time = System.currentTimeMillis() - preTime;
					timetext.setText(toTime(time));
					time2 = System.currentTimeMillis() - pauseTime;
					double mincar = (Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0])
							/ 200) * (int) (time2 / 1000.0 / 60.0);
					double seccar = (Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0])
							/ 12000) * (int) (time2 % (1000.0 * 60) / 1000.0);
					double msseccar = (Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0])
							/ 1200000) * (int) (time2 % 1000 / 10);
					double kkk = Math.round((mincar + seccar + msseccar) * 100) / 100.0;

					kcal.setText(Double.toString(Math.round((kkk + used) * 100) / 100.0));

				}
			} catch (Exception e) {
			}
		}
	}

	public String toTime(long time) {
		int h = (int) (time / 1000.0/60.0/60.0);
		int m = (int) (time / 1000.0 / 60.0);
		int s = (int) (time % (1000.0 * 60) / 1000.0);
		int ms = (int) (time % 1000 / 10.0);

		return String.format("%02d : %02d : %02d : %02d", h, m, s, ms);
	}
}
