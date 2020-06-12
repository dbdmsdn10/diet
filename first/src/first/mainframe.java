package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class mainframe extends JFrame {

	private JPanel contentPane;
	private JTextField calori;

	static String[] personinfo;
	private JButton editperson;
	public static mainframe frame;
	public JTextField showcar;
	double UsedCalori = 0, EatKcal = 0, Pastcar = 0;
	Font font = new Font("돋움", 1, 40);
	double nowcar = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		File met = new File("person.txt");
		boolean w = true;
		try {
			BufferedReader met3 = new BufferedReader(new FileReader(met));
			String line;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				personinfo = line.split("	");
				mettablearray.add(personinfo);
			}
		} catch (IOException q) {// 파일 읽기 오류
			w = false;
			personalfirst personin = new personalfirst();
			personin.setVisible(true);
		} catch (Exception e) {
			w = false;
		}
		if (w) {
			frame = new mainframe();
			frame.setVisible(true);
		}

	}

	/**
	 * Create the frame.
	 */
	public mainframe() {
		File met = new File("person.txt");
		File used = new File("usedcalori.txt");
		File eatkcal = new File("totalkcal.txt");
		File pastcar = new File("pastcar.txt");
		try {
			BufferedReader met3 = new BufferedReader(new FileReader(met));
			String line;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				personinfo = line.split("	");
				mettablearray.add(personinfo);
			}
			met3.close();
		} catch (IOException q) {// 파일 읽기 오류

			personalfirst personin = new personalfirst();
			personin.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ------------------------
		try {
			BufferedReader used2 = new BufferedReader(new FileReader(used));
			String line;
			while ((line = used2.readLine()) != null) {
				UsedCalori = Double.parseDouble(line);
			}
			used2.close();
		} catch (IOException q) {// 파일 읽기 오류

		} catch (Exception e) {
			e.printStackTrace();
		}
		// -----------------------
		try {
			BufferedReader used2 = new BufferedReader(new FileReader(eatkcal));
			String line;
			while ((line = used2.readLine()) != null) {
				EatKcal = Double.parseDouble(line);
			}
			used2.close();
		} catch (IOException q) {// 파일 읽기 오류

		} catch (Exception e) {
			e.printStackTrace();
		}
		// -----------------
		try {
			BufferedReader past2 = new BufferedReader(new FileReader(pastcar));
			String line;
			while ((line = past2.readLine()) != null) {
				Pastcar = Double.parseDouble(line);
			}
			past2.close();
		} catch (IOException q) {// 파일 읽기 오류

		} catch (Exception e) {
			e.printStackTrace();
		}
		// ------------------
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton food = new JButton("먹은것 조회및 입력하기");
		food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				days b = new days();
				b.one();
				b.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent k) {
						try {
							BufferedWriter make = new BufferedWriter(new FileWriter("totalkcal.txt", false));
							make.write(Double.toString(b.total));
							make.flush();
							make.close();
						} catch (Exception e) {

						}
						mainframe kk = new mainframe();
						kk.setVisible(true);
					}
				});
				b.setVisible(true);
				dispose();
			}
		});
		food.setBounds(12, 118, 174, 23);
		contentPane.add(food);
//----------------------------------------
		JButton work = new JButton("\uC6B4\uB3D9\uD558\uAE30");
		work.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exerciseframe b = new Exerciseframe();
				b.get(personinfo, UsedCalori);
				b.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent k) {
						b.timeTh.interrupt();
						try {
							BufferedWriter make = new BufferedWriter(new FileWriter("usedcalori.txt", false));
							make.write(Double.toString(UsedCalori + Double.parseDouble(b.kcal.getText())));
							make.flush();
							make.close();
						} catch (Exception e) {
						}
						mainframe kk = new mainframe();
						kk.setVisible(true);
					}
				});
				if (nowcar < 0) {
					b.haveto(nowcar);
				}
				b.setVisible(true);
				dispose();
			}
		});

		work.setBounds(226, 118, 174, 23);
		contentPane.add(work);

		editperson = new JButton("개인정보 수정");
		editperson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				personal b = new personal();
				b.get(personinfo);
				b.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent k) {
						mainframe kk = new mainframe();
						kk.setVisible(true);
					}
				});
				b.setVisible(true);
				dispose();
			}
		});
		editperson.setBounds(12, 168, 174, 23);
		contentPane.add(editperson);

		showcar = new JTextField();
		showcar.setEditable(false);
		showcar.setBounds(19, 10, 369, 98);
		contentPane.add(showcar);
		showcar.setFont(font);
		showcar.setHorizontalAlignment(JTextField.CENTER);
		double calro = 10 * Double.parseDouble(personinfo[0]) + 6.25 * Double.parseDouble(personinfo[1])
				- 5 * Integer.parseInt(personinfo[2]);
		int gender2 = 0;
		if (personinfo[3].equals("m")) {
			gender2 = 5;
		} else if (personinfo[3].equals("f")) {
			gender2 = -150;
		}
		calro += gender2;
		nowcar = Math.round((calro * Double.parseDouble(personinfo[4]) + UsedCalori - EatKcal - Pastcar) * 100) / 100.0;
		double original = Math.round((calro * Double.parseDouble(personinfo[4]) * 100) / 100.0);

		showcar.setText(Double.toString(nowcar) + " kcal");
		Date date = new Date();
		date.save(nowcar, showcar, original);

		JButton Exit = new JButton("종료하기");
		Exit.setBounds(226, 168, 174, 23);
		contentPane.add(Exit);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
	}
}
