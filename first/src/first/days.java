package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	private JTextField morningt;
	private JTextField luncht;
	private JTextField dinnert;
	private JTextField snackt;
	private JTextField totalt;
	int total=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					days frame = new days();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public days() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("아침");
		btnNewButton.setBounds(12, 186, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("점심");
		btnNewButton_1.setBounds(131, 186, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("저녁");
		btnNewButton_2.setBounds(253, 186, 97, 23);
		contentPane.add(btnNewButton_2);
		
		morningt = new JTextField();
		morningt.setEditable(false);
		morningt.setBounds(12, 139, 97, 21);
		contentPane.add(morningt);
		morningt.setColumns(10);
		morningt.setHorizontalAlignment(JTextField.CENTER);
		
		luncht = new JTextField();
		luncht.setEditable(false);
		luncht.setColumns(10);
		luncht.setBounds(131, 139, 97, 21);
		contentPane.add(luncht);
		luncht.setHorizontalAlignment(JTextField.CENTER);
		
		dinnert = new JTextField();
		dinnert.setEditable(false);
		dinnert.setColumns(10);
		dinnert.setBounds(253, 139, 97, 21);
		contentPane.add(dinnert);
		dinnert.setHorizontalAlignment(JTextField.CENTER);
		
		snackt = new JTextField();
		snackt.setEditable(false);
		snackt.setBounds(378, 139, 116, 21);
		contentPane.add(snackt);
		snackt.setColumns(10);
		snackt.setHorizontalAlignment(JTextField.CENTER);
		
		
		JButton btnNewButton_3 = new JButton("간식 및 야식");
		btnNewButton_3.setBounds(378, 186, 116, 23);
		contentPane.add(btnNewButton_3);
		
		totalt = new JTextField();
		totalt.setEditable(false);
		totalt.setBounds(12, 36, 463, 61);
		Font font=new Font("돋움",1, 20);
		totalt.setFont(font);
		totalt.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(totalt);
		totalt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("섭취한 칼로리");
		lblNewLabel.setBounds(12, 11, 88, 15);
		contentPane.add(lblNewLabel);
		//---------------------
		File breakfast = new File("breakfast.txt");
		try {
			BufferedReader breakfast2 = new BufferedReader(new FileReader(breakfast));
			String line;
			double kar=0;
			while ((line = breakfast2.readLine()) != null) {
				String[] a = line.split("	");
				kar+=Double.parseDouble(a[1]);//
				
			}
			morningt.setText(kar+" kcal");
			total+=kar;
		} catch (IOException q) {// 파일 읽기 오류
			morningt.setText("null");
		} catch (Exception e) {
			System.out.println("오류");
		}
		//----------------------
		File lunch = new File("lunch.txt");
		try {
			BufferedReader lunch2 = new BufferedReader(new FileReader(lunch));
			String line;
			double kar=0;
			while ((line = lunch2.readLine()) != null) {
				String[] a = line.split("	");
				kar+=Double.parseDouble(a[1]);//
				
			}
			luncht.setText(kar+" kcal");
			total+=kar;
		} catch (IOException q) {// 파일 읽기 오류
			luncht.setText("null");
		} catch (Exception e) {
			System.out.println("오류");
		}
		//------------------------
		File dinner = new File("dinner.txt");
		try {
			BufferedReader dinner2 = new BufferedReader(new FileReader(dinner));
			String line;
			double kar=0;
			while ((line = dinner2.readLine()) != null) {
				String[] a = line.split("	");
				kar+=Double.parseDouble(a[1]);//
				
			}
			dinnert.setText(kar+" kcal");
			total+=kar;
		} catch (IOException q) {// 파일 읽기 오류
			dinnert.setText("null");
		} catch (Exception e) {
			System.out.println("오류");
		}
		//---------------------
		File snack = new File("snack.txt");
		try {
			BufferedReader snack2 = new BufferedReader(new FileReader(snack));
			String line;
			double kar=0;
			while ((line = snack2.readLine()) != null) {
				String[] a = line.split("	");
				kar+=Double.parseDouble(a[1]);//
				
			}
			snackt.setText(kar+" kcal");
			total+=kar;
		} catch (IOException q) {// 파일 읽기 오류
			snackt.setText("null");
		} catch (Exception e) {
			System.out.println("오류");
		}
		totalt.setText(total+" kcal");
	}
}