package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
	private JTextField textField_1;

	static String[] personinfo;
	private JButton editperson;
	public static mainframe frame2;
	double UsedCalori = 0;

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
			System.out.println("오류");
		}
		if (w) {

			mainframe frame = new mainframe();
			frame2 = frame;
			frame.setVisible(true);
		}

	}

	/**
	 * Create the frame.
	 */
	public mainframe() {
		File met = new File("person.txt");
		File used = new File("usedcalori.txt");
		try {
			BufferedReader met3 = new BufferedReader(new FileReader(met));
			String line;
			ArrayList<String[]> mettablearray = new ArrayList<String[]>();
			while ((line = met3.readLine()) != null) {
				personinfo = line.split("	");
				mettablearray.add(personinfo);
			}
		} catch (IOException q) {// 파일 읽기 오류

			personalfirst personin = new personalfirst();
			personin.setVisible(true);
		} catch (Exception e) {
			System.out.println("오류");
		}
		// ------------------------
		try {
			BufferedReader used2 = new BufferedReader(new FileReader(used));
			String line;
			while ((line = used2.readLine()) != null) {
				UsedCalori = Double.parseDouble(line);
			}
		} catch (Exception e) {
			System.out.println("오류");
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		calori = new JTextField();
		calori.setBackground(Color.WHITE);
		calori.setEnabled(false);
		calori.setEditable(false);
		calori.setToolTipText("\uC74C\uC2DD\uC774\uB984");
		calori.setBounds(104, 30, 242, 59);
		contentPane.add(calori);
		calori.setColumns(10);

		JButton btnNewButton = new JButton("\uC74C\uC2DD\uC774\uB984 \uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 118, 123, 23);
		contentPane.add(btnNewButton);

		JButton work = new JButton("\uC6B4\uB3D9\uD558\uAE30");
		work.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exerciseframe b = new Exerciseframe();
				b.get(personinfo,UsedCalori);
				b.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent k) {
						try {
							BufferedWriter make = new BufferedWriter(new FileWriter("usedcalori.txt", false));
							make.write(Double.toString(UsedCalori+Double.parseDouble(b.kcal.getText())));
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

		work.setBounds(277, 118, 97, 23);
		contentPane.add(work);

		textField_1 = new JTextField();
		textField_1.setBounds(147, 119, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

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
		editperson.setBounds(265, 179, 109, 23);
		contentPane.add(editperson);
		double calro = 10 * Double.parseDouble(personinfo[0]) + 6.25 * Double.parseDouble(personinfo[1])
				- 5 * Integer.parseInt(personinfo[2]);
		int gender2 = 0;
		if (personinfo[3].equals("m")) {
			gender2 = 5;
		} else if (personinfo[3].equals("f")) {
			gender2 = -150;
		}
		calro += gender2;
		calori.setText(Double.toString(calro * Double.parseDouble(personinfo[4]) + UsedCalori));

	}

}
