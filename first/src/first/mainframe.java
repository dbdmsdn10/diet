package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class mainframe extends JFrame {

	private JTextField calori;
	JButton Exit = new JButton("종료");
	JButton food = new JButton("식단 조회 및 입력");
	JButton work = new JButton("운동 시작");
	JButton editperson = new JButton("개인정보 수정");
	JButton pastb = new JButton("과거 조회");
	public JTextField showcar;

	JTextField eatmount;
	JTextField usedmount;
	JTextField suggest;
	static String[] personinfo;
	public static mainframe frame;

	double UsedCalori = 0, EatKcal = 0, Pastcar = 0;
	Font font = new Font("돋움", 1, 40);
	double nowcar = 0;
	JTextField penalty;
	static String[][] Food = new String[29866][230];
	static String[][] mettable = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		frame = new mainframe();
		search(frame);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public mainframe() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 320);
		setContentPane(Panel());
		File cal = new File("data\\foodcalory.txt");
		String line2 = null;
		String[] aa = new String[230];
		int ii = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(cal));
			while ((line2 = reader.readLine()) != null) {
				aa = line2.split("	");
				Food[ii] = aa;
				ii++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File met = new File("data\\mettable.txt");
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
	}

	public JPanel Panel() {
		JPanel contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setBounds(100, 100, 410, 400);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		food.setBounds(12, 250, 174, 23);
		contentPane.add(food);
		editperson.setBounds(12, 283, 174, 23);
		contentPane.add(editperson);
		Exit.setBounds(207, 283, 174, 23);
		contentPane.add(Exit);
		work.setBounds(207, 250, 174, 23);
		contentPane.add(work);
		showcar = new JTextField();
		showcar.setEditable(false);
		showcar.setBounds(12, 160, 369, 80);
		showcar.setFont(font);
		showcar.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(showcar);

		JLabel 남은양 = new JLabel("남은 칼로리양");
		남은양.setBounds(12, 135, 91, 15);
		contentPane.add(남은양);

		eatmount = new JTextField();
		eatmount.setEditable(false);
		eatmount.setBounds(12, 104, 174, 21);
		contentPane.add(eatmount);
		eatmount.setColumns(10);

		usedmount = new JTextField();
		usedmount.setEditable(false);
		usedmount.setBounds(212, 104, 169, 21);
		contentPane.add(usedmount);
		usedmount.setColumns(10);

		JLabel lblNewLabel = new JLabel("먹은 칼로리 양");
		lblNewLabel.setBounds(12, 76, 115, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("운동한 칼로리양");
		lblNewLabel_1.setBounds(206, 76, 130, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("권장 칼로리양");
		lblNewLabel_2.setBounds(12, 10, 91, 15);
		contentPane.add(lblNewLabel_2);

		suggest = new JTextField();
		suggest.setEditable(false);
		suggest.setBounds(12, 45, 174, 21);
		contentPane.add(suggest);
		suggest.setColumns(10);

		penalty = new JTextField();
		penalty.setEditable(false);
		penalty.setBounds(207, 45, 174, 21);
		contentPane.add(penalty);
		penalty.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("어제 과식에 대한 패널티");
		lblNewLabel_3.setBounds(207, 10, 145, 15);
		contentPane.add(lblNewLabel_3);
		
		pastb.setBounds(12, 316, 174, 23);
		contentPane.add(pastb);
		return contentPane;
	}

	public static void search(mainframe frame) {
		File met = new File("person.txt");
		File used = new File("usedcalori.txt");
		File eatkcal = new File("totalkcal.txt");
		File pastcar = new File("pastcar.txt");
		boolean per = true;
		try {
			BufferedReader met3 = new BufferedReader(new FileReader(met));
			String line;
			while ((line = met3.readLine()) != null) {
				personinfo = line.split("	");
			}
			met3.close();
		} catch (IOException q) {// 파일 읽기 오류

			personalfirst personin = new personalfirst(frame);

			frame.setContentPane(personin.contentPane);
			frame.setBounds(100, 100, personin.contentPane.getWidth(), personin.contentPane.getHeight());
			per = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ------------------------
		if (per) {
			try {
				BufferedReader used2 = new BufferedReader(new FileReader(used));
				String line;
				while ((line = used2.readLine()) != null) {
					frame.UsedCalori = Double.parseDouble(line);
				}
				used2.close();
			} catch (IOException q) {// 파일 읽기 오류
				frame.UsedCalori=0;
			} catch (Exception e) {
				e.printStackTrace();
			}
			// -----------------------
			try {
				BufferedReader used2 = new BufferedReader(new FileReader(eatkcal));
				String line;
				while ((line = used2.readLine()) != null) {
					frame.EatKcal = Double.parseDouble(line);
				}
				used2.close();
			} catch (IOException q) {// 파일 읽기 오류
				frame.EatKcal=0;
			} catch (Exception e) {
				e.printStackTrace();
			}
			// -----------------
			try {
				BufferedReader past2 = new BufferedReader(new FileReader(pastcar));
				String line;
				while ((line = past2.readLine()) != null) {
					frame.Pastcar = Double.parseDouble(line);
				}
				past2.close();
			} catch (IOException q) {// 파일 읽기 오류
				frame.Pastcar=0;
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ------------------

			frame.food.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					days b = new days(frame);
					b.one(Food);
					JPanel a = b.contentPane;
					frame.setContentPane(a);
					a.setBounds(0, 0, a.getWidth(), a.getHeight());
					frame.setBounds(100, 100, a.getWidth(), a.getHeight());

				}
			});

//----------------------------------------

			frame.work.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Exerciseframe b = new Exerciseframe(frame);
					b.get(personinfo, frame.UsedCalori, mettable);

					if (frame.nowcar < 0) {
						b.haveto(frame.nowcar);
					}
					JPanel a = b.contentPane;
					frame.setContentPane(a);
					frame.setBounds(100, 100, a.getWidth(), a.getHeight());

				}
			});

			frame.editperson.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					personal b = new personal(frame);
					b.get(personinfo);
					JPanel a = b.contentPane;
					frame.setBounds(100, 100, a.getWidth(), a.getHeight());
					frame.setContentPane(a);

				}
			});
			//--------------------------------------
			frame.pastb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					review b=new review();
					b.get(Food, mettable);
					b.carcul(b,frame);
					
					
					JPanel a = b.contentPane;
					frame.setBounds(100, 100, a.getWidth(), a.getHeight());
					frame.setContentPane(a);

				}
			});
			
			//------------------------------------------

			double calro = 10 * Double.parseDouble(personinfo[0]) + 6.25 * Double.parseDouble(personinfo[1])
					- 5 * Integer.parseInt(personinfo[2]);
			int gender2 = 0;
			if (personinfo[3].equals("m")) {
				gender2 = 5;
			} else if (personinfo[3].equals("f")) {
				gender2 = -150;
			}
			calro += gender2;
			frame.nowcar = Math.round(
					(calro * Double.parseDouble(personinfo[4]) + frame.UsedCalori - frame.EatKcal - frame.Pastcar)
							* 100)
					/ 100.0;

			double original = Math.round((calro * Double.parseDouble(personinfo[4]) * 100) / 100.0);
			frame.penalty.setText(frame.Pastcar + " kcal");
			frame.suggest.setText(original + " kcal");
			frame.usedmount.setText(Double.toString(Math.round(frame.UsedCalori * 100) / 100.0) + " kcal");
			frame.eatmount.setText(Double.toString(frame.EatKcal) + " kcal");
			frame.showcar.setText(Double.toString(frame.nowcar) + " kcal");
			Date date = new Date();
			date.save(frame, frame.nowcar, frame.showcar, original);

			frame.Exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}

			});
		}
	}
}
