package first;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class personal extends JFrame {

	private JPanel contentPane;
	private JTextField weight;
	private JTextField height;
	private JTextField age;
	private JButton confirm;
	private JButton cancle;
	public static String[] personinfo;
	JRadioButton 남 = new JRadioButton("\uB0A8");
	JRadioButton 여 = new JRadioButton("\uC5EC");
	JRadioButton none = new JRadioButton("거의 움직이지않음");
	JRadioButton less = new JRadioButton("적당히 돌아다님");
	JRadioButton somtimes = new JRadioButton("가끔운동함");
	JRadioButton everyday = new JRadioButton("매일운동함");
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */

	public void get(String[] a)
	{
		this.personinfo=a;
		weight.setText(personinfo[0]);
		height.setText(personinfo[1]);
		age.setText(personinfo[2]);
		if(personinfo[3].equals("m"))
		{
			남.setSelected(true);
		}
		else if(personinfo[3].equals("f"))
		{
			여.setSelected(true);
		}
		if(personinfo[4].equals("1.2"))
		{
			none.setSelected(true);
		}
		else if(personinfo[4].equals("1.35"))
		{
			less.setSelected(true);
		}
		else if(personinfo[4].equals("1.5"))
		{
			somtimes.setSelected(true);
		}
		else if(personinfo[4].equals("1.7"))
		{
			everyday.setSelected(true);
		}
		
	}

	/**
	 * Create the frame.
	 */
	public personal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 230, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		weight = new JTextField();
		weight.setBounds(82, 10, 116, 21);
		contentPane.add(weight);
		weight.setColumns(10);
		
		height = new JTextField();
		height.setBounds(82, 55, 116, 21);
		contentPane.add(height);
		height.setColumns(10);
		
		age = new JTextField();
		age.setBounds(82, 99, 116, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		
		남.setBounds(82, 129, 45, 23);
		contentPane.add(남);
		
		여.setBounds(142, 129, 64, 23);
		contentPane.add(여);
		
		ButtonGroup gender=new ButtonGroup();
		gender.add(여);
		gender.add(남);
		
		confirm = new JButton("적용");
		confirm.setBounds(13, 264, 82, 23);
		Confirm confir2=new Confirm();
		confirm.addActionListener(confir2);
		contentPane.add(confirm);
		
		cancle = new JButton("취소");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe frame=new mainframe();
				frame.setVisible(true);
				dispose();
			}
		});
		cancle.setBounds(120, 264, 82, 23);
		contentPane.add(cancle);
		
		
		none.setBounds(23, 157, 152, 23);
		contentPane.add(none);
		
		
		less.setBounds(23, 182, 152, 23);
		contentPane.add(less);
		
		somtimes.setBounds(23, 207, 121, 23);
		contentPane.add(somtimes);
		
		
		everyday.setBounds(23, 232, 121, 23);
		contentPane.add(everyday);
		ButtonGroup move=new ButtonGroup();
		move.add(none);
		move.add(less);
		move.add(somtimes);
		move.add(everyday);
		
		lblNewLabel = new JLabel("몸무게");
		lblNewLabel.setBounds(13, 13, 57, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("키");
		lblNewLabel_1.setBounds(13, 58, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("나이");
		lblNewLabel_2.setBounds(13, 102, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("성별");
		lblNewLabel_3.setBounds(13, 133, 57, 15);
		contentPane.add(lblNewLabel_3);
	}
	class Confirm implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("확인");
			boolean how = true;
			if (weight.getText().equals("")&how) {
				how = false;
				JOptionPane.showMessageDialog(null, "몸무게를 입력해 주세요");
			} else if (!weight.getText().equals("") & how) {
				try {
					double c = Double.parseDouble(weight.getText());
				} catch (Exception eee) {
					how = false;
					JOptionPane.showMessageDialog(null, "몸무게에 '숫자'를 입력해 주세요");
				}
			}
			// ----------------------------------------
			if (height.getText().equals("")&how) {
				how = false;
				JOptionPane.showMessageDialog(null, "키를 입력해 주세요");
			} else if (!height.getText().equals("") & how) {
				try {
					double c = Double.parseDouble(height.getText());
				} catch (Exception eee) {
					how = false;
					JOptionPane.showMessageDialog(null, "키에 '숫자'를 입력해 주세요");
				}
			}
			// -------------------------------------------
			if (age.getText().equals("")&how) {
				how = false;
				JOptionPane.showMessageDialog(null, "나이를 입력해 주세요");
			} else if (!age.getText().equals("") & how) {
				try {
					
					int c = Integer.parseInt(age.getText());
				} catch (Exception eee) {
					how = false;
					JOptionPane.showMessageDialog(null, "나이에 '정수'를 입력해 주세요");
				}
			}
			// -------------------------
			if (남.isSelected()&how) {
			} else if (여.isSelected()&how) {
			} else if(how){
				how = false;
				JOptionPane.showMessageDialog(null, "성별을 선택해주세요");
			}
			double howmany=0;
			if (none.isSelected()&how) {
				howmany=1.2;
			} else if (less.isSelected()&how) {
				howmany=1.35;
			}  else if (somtimes.isSelected()&how) {
				howmany=1.5;
			}  else if (everyday.isSelected()&how) {
				howmany=1.7;
			} else if(how){
				how = false;
				JOptionPane.showMessageDialog(null, "활동량을 선택해주세요");
			}
			if (how) {
				File person = new File("person.txt");
				FileWriter information = null;
				try {
					BufferedWriter make=new BufferedWriter(new FileWriter("person.txt",false));
					make.write(weight.getText());
					make.write("	");
					make.write(height.getText());
					make.write("	");
					make.write(age.getText());
					make.write("	");
					if (남.isSelected()) {
						make.write("m");
					} else if (여.isSelected()) {
						make.write("f");
					}
					make.write("	");
					make.write(Double.toString(howmany));
					make.flush();
					make.close();
					dispose();
					mainframe frame=new mainframe();
					frame.setVisible(true);
					
				} catch (Exception ee) {
					System.out.println("오류");
				}
			}
		}
	}
}
