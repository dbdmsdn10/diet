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
	long time = 0, preTime = 0, pauseTime=0, time2=0;
	private JTextField timetext;
	TimeThread timeTh = new TimeThread();
	private JTextField textField;
	private JTextField kcal;
	private JTextField txtKcal;
	String[] personinfo;
	double used = 0;

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

	public void get(String[] personinfo) {
		this.personinfo = personinfo;
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
		setBounds(100, 100, 531, 474);
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
		scrollPane.setBounds(12, 41, 116, 353);
		contentPane.add(scrollPane);
		list.setEnabled(true);
		scrollPane.setViewportView(list);
		list.setModel(model);

		mettext = new JTextField();
		mettext.setBackground(Color.WHITE);
		mettext.setEditable(false);
		mettext.setEnabled(false);
		mettext.setText("운동강도");
		mettext.setBounds(140, 42, 60, 21);
		contentPane.add(mettext);
		mettext.setColumns(10);

		metvalue = new JTextField();
		metvalue.setBackground(Color.WHITE);
		metvalue.setEnabled(false);
		metvalue.setEditable(false);
		metvalue.setBounds(212, 42, 60, 21);
		contentPane.add(metvalue);
		metvalue.setColumns(10);

		timetext = new JTextField();
		timetext.setBounds(212, 73, 148, 21);
		contentPane.add(timetext);
		timetext.setColumns(10);

		JButton 시작 = new JButton("시작");
		시작.setBounds(140, 106, 97, 23);
		contentPane.add(시작);

		JButton 중지 = new JButton("중지");
		중지.setBounds(249, 106, 97, 23);
		contentPane.add(중지);

		JButton 멈춤 = new JButton("멈춤");
		멈춤.setBounds(358, 106, 97, 23);
		contentPane.add(멈춤);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setText("소비칼로리");
		textField.setBounds(140, 190, 75, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		kcal = new JTextField();
		kcal.setBackground(Color.WHITE);
		kcal.setEnabled(false);
		kcal.setEditable(false);
		kcal.setBounds(230, 190, 116, 21);
		contentPane.add(kcal);
		kcal.setColumns(10);

		txtKcal = new JTextField();
		txtKcal.setBackground(Color.WHITE);
		txtKcal.setEnabled(false);
		txtKcal.setEditable(false);
		txtKcal.setText("kcal");
		txtKcal.setBounds(368, 190, 36, 21);
		contentPane.add(txtKcal);
		txtKcal.setColumns(10);

		JButton back = new JButton("돌아가기");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe frame = new mainframe();
				frame.setVisible(true);
				dispose();
			}
		});
		back.setBounds(406, 402, 97, 23);
		contentPane.add(back);
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
			if (timeTh == null || !timeTh.isAlive()) {
				if (time != 0)
					preTime = System.currentTimeMillis() - time;
				else
					preTime = System.currentTimeMillis();
				pauseTime=System.currentTimeMillis();
				timeTh = new TimeThread();
				timeTh.start();
			}
		}

	}

	class stopwatchpause implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (timeTh.isAlive()) {
				timeTh.interrupt();
				list.setEnabled(true);
				used=Double.parseDouble( kcal.getText());
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
			pauseTime=0;
			time = 0;
			used = 0;
		}
	}

	class Backto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
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
					time2=System.currentTimeMillis() - pauseTime;
					double kkk = Math.round(Double.parseDouble(metvalue.getText()) * 35 * Double.parseDouble(personinfo[0]) / 12000
							* (time2 % (1000.0 * 60) / 1000.0) * 100) / 100.0;
					
					kcal.setText(Double.toString(Math.round((kkk+used)*100)/100.0));
				}
			} catch (Exception e) {
			}
		}
	}

	public String toTime(long time) {
		int m = (int) (time / 1000.0 / 60.0);
		int s = (int) (time % (1000.0 * 60) / 1000.0);
		int ms = (int) (time % 1000 / 10.0);

		return String.format("%02d : %02d : %02d", m, s, ms);
	}
}
