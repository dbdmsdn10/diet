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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class Exerciseframe {

	public JPanel contentPane;
	private JTextField name;
	String[][] mettable = null;
	Integer[] find = null;
	JList list = new JList();
	JList list2 = new JList();
	private JTextField metvalue;
	long time = 0, preTime = 0, pauseTime = 0, time2 = 0, time3 = 0;
	JTextField dayusdecal = new JTextField();
	private JTextField timetext;
	TimeThread timeTh = new TimeThread();
	public JTextField kcal;
	String[] personinfo;
	double used = 0;
	private JTextField want;
	double savecalcori = 0, nowcalcori = 0;
	JButton 시작 = new JButton("시작");
	boolean DoOr = false;
	mainframe frame;
	String whatdo[] = new String[3];;
	long savelist[];
	String Whatdo[][] = null;

	/**
	 * Launch the application.
	 */

	public void get(String[] personinfo, double savecalcori,String[][] mettable) {
		this.personinfo = personinfo;
		this.savecalcori = savecalcori;
		this.nowcalcori=savecalcori;
		dayusdecal.setText(Double.toString(savecalcori));
		this.savelist=new long[mettable.length];
		DefaultListModel model = new DefaultListModel();
		find = new Integer[mettable.length];
		for (int i = 0; i < mettable.length; i++) {
			model.addElement(mettable[i][0]);
			find[i] = i;
		}
		list.setModel(model);
	}

	/**
	 * Create the frame.
	 */
	public void haveto(double nowcar) {
		want.setText(Double.toString(-nowcar));
	}

	public Exerciseframe(mainframe frame) {
		this.frame = frame;
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent k) {
				try {
					timeTh.interrupt();
					BufferedWriter make = new BufferedWriter(new FileWriter("usedcalori.txt", false));
					make.write(Double.toString(Math.round(nowcalcori * 100) / 100.0));
					make.flush();
					make.close();
				} catch (Exception ee) {
				}
				JPanel panel = frame.Panel();
				frame.setContentPane(panel);
				frame.setBounds(100, 100, panel.getWidth(), panel.getHeight());
				frame.search(frame);
				try {
					savelist[Integer.parseInt(whatdo[0])] += time2;
					BufferedWriter make = new BufferedWriter(new FileWriter("dayusedcalori.txt", false));
					for (int i = 0; i < savelist.length; i++) {
						if (savelist[i] == 0) {
							continue;
						} else {
							make.write(i + "	" + savelist[i] + "\n");
						}
					}
					make.flush();
					make.close();
				} catch (Exception ee) {
				}
			}
		});
		// -----------------------
		
		// ---------------------------
		File met2 = new File("dayusedcalori.txt");
		try {
			BufferedReader met3 = new BufferedReader(new FileReader(met2));
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

			list2.setModel(model);

		} catch (IOException q) {// 파일 읽기 오류
			System.out.println(q.getMessage());
		} catch (Exception e) {
			System.out.println("오류");
		}
		// --------------------------
		contentPane = new JPanel();
		contentPane.setBounds(100, 100, 582, 395);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		JButton carculbutton = new JButton("계산하기");
		carculbutton.setBounds(468, 72, 86, 23);
		JButton search = new JButton("검색");
		search.setBounds(140, 9, 97, 23);
		metvalue = new JTextField();
		metvalue.setBounds(202, 42, 60, 21);
		시작 = new JButton("시작");
		시작.setBounds(140, 132, 97, 23);
		JButton 중지 = new JButton("중지");
		중지.setBounds(249, 135, 97, 23);
		JButton 멈춤 = new JButton("멈춤");
		멈춤.setBounds(358, 135, 97, 23);
		kcal = new JTextField();
		kcal.setBounds(230, 165, 116, 21);
		JButton back = new JButton("돌아가기");
		back.setBounds(457, 9, 97, 23);
		want = new JTextField();
		want.setBounds(249, 73, 148, 21);
		JLabel lblNewLabel = new JLabel("운동강도");
		lblNewLabel.setBounds(140, 45, 57, 15);
		JLabel lblNewLabel_1 = new JLabel("빼고싶은 칼로리");
		lblNewLabel_1.setBounds(140, 73, 108, 15);
		JLabel lblNewLabel_2 = new JLabel("StopWatch");
		lblNewLabel_2.setBounds(140, 107, 97, 15);
		JLabel lblNewLabel_3 = new JLabel("소비칼로리");
		lblNewLabel_3.setBounds(140, 165, 97, 15);
		JLabel lblNewLabel_4 = new JLabel("Kcal");
		lblNewLabel_4.setBounds(358, 168, 57, 15);
		JLabel lblNewLabel_5 = new JLabel("Kcal");
		lblNewLabel_5.setBounds(413, 76, 57, 15);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 41, 116, 299);
		name = new JTextField();
		name.setBounds(12, 10, 116, 21);
		timetext = new JTextField();
		timetext.setEditable(false);
		timetext.setBounds(249, 104, 148, 21);
		contentPane.add(name);
		contentPane.add(search);
		contentPane.add(scrollPane);
		contentPane.add(metvalue);
		contentPane.add(timetext);
		contentPane.add(시작);

		contentPane.add(중지);

		contentPane.add(멈춤);

		contentPane.add(back);

		contentPane.add(want);
		want.setColumns(10);

		contentPane.add(carculbutton);

		contentPane.add(lblNewLabel);

		contentPane.add(lblNewLabel_1);

		contentPane.add(lblNewLabel_2);

		contentPane.add(lblNewLabel_3);

		contentPane.add(lblNewLabel_4);

		contentPane.add(lblNewLabel_5);
		contentPane.add(kcal);

		dayusdecal.setBounds(413, 42, 116, 21);
		contentPane.add(dayusdecal);
		dayusdecal.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("오늘 소비한 칼로리");
		lblNewLabel_6.setBounds(296, 45, 119, 15);
		contentPane.add(lblNewLabel_6);

		JScrollPane todayusedlist = new JScrollPane();
		todayusedlist.setBounds(140, 235, 414, 111);
		contentPane.add(todayusedlist);

		JLabel lblNewLabel_7 = new JLabel("오늘한 운동들");
		lblNewLabel_7.setBounds(140, 210, 97, 15);
		contentPane.add(lblNewLabel_7);
		name.setColumns(10);

		search1 search2 = new search1();
		search.addActionListener(search2);

		
		list.setEnabled(true);
		scrollPane.setViewportView(list);
		

		list2.setEnabled(true);
		todayusedlist.setViewportView(list2);
		// list2.setModel(model);

		metvalue.setEditable(false);
		metvalue.setBackground(Color.WHITE);

		metvalue.setColumns(10);

		timetext.setColumns(10);

		kcal.setEditable(false);
		kcal.setBackground(Color.WHITE);

		kcal.setColumns(10);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					timeTh.interrupt();
					BufferedWriter make = new BufferedWriter(new FileWriter("usedcalori.txt", false));
					make.write(Double.toString(Math.round(nowcalcori * 100) / 100.0));
					make.flush();
					make.close();
				} catch (Exception ee) {
				}
				JPanel panel = frame.Panel();
				frame.setContentPane(panel);
				frame.setBounds(100, 100, panel.getWidth(), panel.getHeight());
				frame.search(frame);
				try {
					savelist[Integer.parseInt(whatdo[0])] += time2;
					BufferedWriter make = new BufferedWriter(new FileWriter("dayusedcalori.txt", false));
					for (int i = 0; i < savelist.length; i++) {
						if (savelist[i] == 0) {
							continue;
						} else {
							make.write(i + "	" + savelist[i] + "\n");
						}
					}
					make.flush();
					make.close();
				} catch (Exception ee) {
				}

			}
		});

		JListSelect select = new JListSelect();
		list.addListSelectionListener(select);

		stopwatchstart start = new stopwatchstart();
		stopwatchpause pause = new stopwatchpause();
		stopwatchstop stop = new stopwatchstop();

		시작.addActionListener(start);

		중지.addActionListener(pause);
		멈춤.addActionListener(stop);

		Carculate carcul = new Carculate();
		carculbutton.addActionListener(carcul);

	}

	class search1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			list.removeAll();
			// TODO Auto-generated method stub
			findint a = new findint();
			find = a.find(mettable, name.getText(), 0, 0);
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
				whatdo[0] = Integer.toString(find[list.getSelectedIndex()]);
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
				whatdo[1] = toTime(time2);

				savelist[Integer.parseInt(whatdo[0])] += time2;
				DefaultListModel model = new DefaultListModel();

				for (int i = 0; i < savelist.length; i++) {
					if (savelist[i] == 0) {
						continue;
					} else {
						model.addElement(mettable[i][0] + "   " + toTime(savelist[i]) + "\n");
					}
				}
				list2.setModel(model);
			}
			
		}

	}

	class stopwatchstop implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (timeTh.isAlive()) {
				list.setEnabled(true);
				timeTh.interrupt();
				savecalcori = nowcalcori;
				pauseTime = 0;
				time = 0;
				used = 0;
				whatdo[1] = toTime(time2);

				savelist[Integer.parseInt(whatdo[0])] += time2;
				DefaultListModel model = new DefaultListModel();

				for (int i = 0; i < savelist.length; i++) {
					if (savelist[i] == 0) {
						continue;
					} else {
						model.addElement(mettable[i][0] + "   " + toTime(savelist[i]));
					}
				}

				list2.setModel(model);
			}

		}
	}

	class Carculate implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (used != 0) {
				JOptionPane.showMessageDialog(null, "아직 운동중입니다");
			} else {
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
					double hcar = Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0]) * 60
							/ 200;
					double mincar = Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0])
							/ 200;
					double seccar = Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0])
							/ 12000;
					double mscar = Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0])
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
					time3 = hour * 1000 * 60 * 60;
					time3 += 1000 * 60 * min;
					time3 += sec * 1000 + ms * 10;
					DoOr = true;
					timetext.setText(toTime(time3));
				}

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
					if (DoOr) {// 스톱워치 역으로
						time = time3 - (System.currentTimeMillis() - preTime);

					} else {
						time = System.currentTimeMillis() - preTime;
					}
					timetext.setText(toTime(time));
					time2 = System.currentTimeMillis() - pauseTime;
					double hcar = (Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0]) * 60
							/ 200) * (int) (time2 / 1000.0 / 60.0 / 60);
					double mincar = (Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0])
							/ 200) * (int) (time2 / 1000.0 / 60.0);
					double seccar = (Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0])
							/ 12000) * (int) (time2 % (1000.0 * 60) / 1000.0);
					double msseccar = (Double.parseDouble(metvalue.getText()) * 3.5 * Double.parseDouble(personinfo[0])
							/ 1200000) * (int) (time2 % 1000 / 10);
					double kkk = Math.round((hcar + mincar + seccar + msseccar) * 100) / 100.0;
					nowcalcori = (Math.round((savecalcori + kkk + used) * 100) / 100.0);
					kcal.setText(Double.toString(Math.round((kkk + used) * 100) / 100.0));
					dayusdecal.setText(Double.toString(nowcalcori));
					if (time < 0) {
						JOptionPane.showMessageDialog(null, "시간종료");
						DoOr = false;
						interrupt();
					}
				}
			} catch (Exception e) {
			}
		}
	}

	public String toTime(long time) {
		int h = (int) (time / 1000.0 / 60.0 / 60.0);
		int m = (int) (time / 1000.0 / 60.0);
		int s = (int) (time % (1000.0 * 60) / 1000.0);
		int ms = (int) (time % 1000 / 10.0);

		return String.format("%02d : %02d : %02d : %02d", h, m, s, ms);
	}
}
