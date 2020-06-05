package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class days extends JFrame {

	private JPanel contentPane;
	JTextField morningt = new JTextField();
	JTextField luncht = new JTextField();
	JTextField dinnert = new JTextField();
	JTextField snackt = new JTextField();
	JTextField totalt = new JTextField();

	double total = 0;
	static String[][] Food = new String[29866][230];
	JButton morningb = new JButton("아침");
	JButton lunchb = new JButton("점심");
	JButton dinnerb = new JButton("저녁");
	JButton snackb = new JButton("간식 및 야식");
	double morningkar = 0, lunchkar = 0, dinnerkar = 0, snackkar = 0;
	static days frame = new days();
	boolean st = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void one() {
		File cal = new File("food calory.txt");
		String line2 = null;
		String[] aa = new String[230];
		int ii = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(cal));
			while ((line2 = reader.readLine()) != null) {
				aa = line2.split("\t");
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
		carculate();
	}

	public void two(String[][] Food2) {
		Food = Food2;
		carculate();
	}

	/**
	 * Create the frame.
	 */
	public days() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		morningb.setBounds(12, 186, 97, 23);
		contentPane.add(morningb);

		lunchb.setBounds(131, 186, 97, 23);
		contentPane.add(lunchb);

		dinnerb.setBounds(253, 186, 97, 23);
		contentPane.add(dinnerb);

		morningt.setEditable(false);
		morningt.setBounds(12, 139, 97, 21);
		contentPane.add(morningt);
		morningt.setColumns(10);
		morningt.setHorizontalAlignment(JTextField.CENTER);

		luncht.setEditable(false);
		luncht.setColumns(10);
		luncht.setBounds(131, 139, 97, 21);
		contentPane.add(luncht);
		luncht.setHorizontalAlignment(JTextField.CENTER);

		dinnert.setEditable(false);
		dinnert.setColumns(10);
		dinnert.setBounds(253, 139, 97, 21);
		contentPane.add(dinnert);
		dinnert.setHorizontalAlignment(JTextField.CENTER);

		snackt.setEditable(false);
		snackt.setBounds(378, 139, 116, 21);
		contentPane.add(snackt);
		snackt.setColumns(10);
		snackt.setHorizontalAlignment(JTextField.CENTER);

		snackb.setBounds(378, 186, 116, 23);
		contentPane.add(snackb);

		totalt.setEditable(false);
		totalt.setBounds(12, 36, 463, 61);
		Font font = new Font("돋움", 1, 20);
		totalt.setFont(font);
		totalt.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(totalt);
		totalt.setColumns(10);

		JLabel lblNewLabel = new JLabel("섭취한 칼로리");
		lblNewLabel.setBounds(12, 11, 88, 15);
		contentPane.add(lblNewLabel);

		JButton Backb = new JButton("돌아가기");
		Backb.setBounds(378, 243, 116, 23);
		contentPane.add(Backb);

		Open open = new Open();
		morningb.addActionListener(open);
		lunchb.addActionListener(open);
		dinnerb.addActionListener(open);
		snackb.addActionListener(open);
		Back back = new Back();
		Backb.addActionListener(back);
	}

	public void carculate() {
		// ---------------------
		File breakfast = new File("breakfast.txt");
		try {
			BufferedReader breakfast2 = new BufferedReader(new FileReader(breakfast));
			String line;
			while ((line = breakfast2.readLine()) != null) {
				String[] a = line.split(",");
				for (int i = 0; i < a.length; i++) {
					morningkar += Double.parseDouble(Food[Integer.parseInt(a[i])][14]);
				}
			}
			morningt.setText(morningkar + "kcal");
			total += morningkar;
		} catch (IOException q) {// 파일 읽기 오류
			morningt.setText("null");
		} catch (Exception e) {
			System.out.println("오류11");
			e.printStackTrace();
		}
		// ----------------------
		File lunch = new File("lunch.txt");
		try {
			BufferedReader lunch2 = new BufferedReader(new FileReader(lunch));
			String line;

			while ((line = lunch2.readLine()) != null) {
				String[] a = line.split(",");
				for (int i = 0; i < a.length; i++) {
					lunchkar += Double.parseDouble(Food[Integer.parseInt(a[i])][14]);
				}
			}
			luncht.setText(lunchkar + "kcal");
			total += lunchkar;
		} catch (IOException q) {// 파일 읽기 오류
			luncht.setText("null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ------------------------
		File dinner = new File("dinner.txt");
		try {
			BufferedReader dinner2 = new BufferedReader(new FileReader(dinner));
			String line;

			while ((line = dinner2.readLine()) != null) {
				String[] a = line.split(",");
				for (int i = 0; i < a.length; i++) {
					dinnerkar += Double.parseDouble(Food[Integer.parseInt(a[i])][14]);
				}
			}
			dinnert.setText(dinnerkar + "kcal");
			total += dinnerkar;
		} catch (IOException q) {// 파일 읽기 오류
			dinnert.setText("null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ---------------------
		File snack = new File("snack.txt");
		try {
			BufferedReader snack2 = new BufferedReader(new FileReader(snack));
			String line;

			while ((line = snack2.readLine()) != null) {
				String[] a = line.split(",");
				for (int i = 0; i < a.length; i++) {
					snackkar += Double.parseDouble(Food[Integer.parseInt(a[i])][14]);
				}
			}
			snackt.setText(snackkar + "kcal");
			total += snackkar;
		} catch (IOException q) {// 파일 읽기 오류
			snackt.setText("null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		totalt.setText(total + " kcal");
	}

	public class Open implements ActionListener {
		String name;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String sendname = "";
			if (e.getSource() == morningb) {
				name = "breakfast.txt";
			} else if (e.getSource() == lunchb) {
				name = "lunch.txt";
			} else if (e.getSource() == dinnerb) {
				name = "dinner.txt";
			} else if (e.getSource() == snackb) {
				name = "snack.txt";
			}

			FoodSearch b = new FoodSearch();
			b.GetFood(Food, name);
			b.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent k) {
					try {
						BufferedWriter make = new BufferedWriter(new FileWriter(name, false));
						Integer[] eatthinglist = b.eatthing.toArray(new Integer[b.eatthing.size()]);

						double kar = 0;
						for (int i = 0; i < eatthinglist.length; i++) {
							make.write(eatthinglist[i] + ",");
							kar += Double.parseDouble(Food[eatthinglist[i]][14]);
						}
						make.flush();
						make.close();
						if (name.equals("breakfast.txt")) {
							morningkar = kar;
							morningt.setText(kar + "kcal");
						} else if (name.equals("lunch.txt")) {
							lunchkar = kar;
							luncht.setText(kar + "kcal");
						} else if (name.equals("dinner.txt")) {
							dinnerkar = kar;
							dinnert.setText(kar + "kcal");
						} else if (name.equals("snack.txt")) {
							snackkar = kar;
							snackt.setText(kar + "kcal");
						}
						total = 0;
						total = morningkar + lunchkar + dinnerkar + snackkar;
						totalt.setText(total + " kcal");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();

					}
					days kk = new days();
					kk.two(Food);
					kk.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent k) {
							try {
								BufferedWriter make = new BufferedWriter(new FileWriter("totalkcal.txt", false));
								make.write(Double.toString(kk.total));
								make.flush();
								make.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							mainframe b = new mainframe();
							b.setVisible(true);
						}
					});
					kk.setVisible(true);
				}
			});
			b.setVisible(true);
			dispose();
		}
	}

	public class Back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				BufferedWriter make = new BufferedWriter(new FileWriter("totalkcal.txt", false));
				make.write(Double.toString(total));
				make.flush();
				make.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			mainframe b = new mainframe();
			b.setVisible(true);
			dispose();
		}

	}
}