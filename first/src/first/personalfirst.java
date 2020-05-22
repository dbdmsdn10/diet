package first;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import first.personal.Confirm;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class personalfirst extends JFrame {

	private JPanel contentPane;
	private JTextField weight;
	private JTextField height;
	private JTextField age;
	private JTextField q4;
	private JTextField q5;
	private JTextField q6;
	private JTextField q7;
	private JButton confirm;
	private JButton cancle;
	ButtonGroup gender = new ButtonGroup();
	JRadioButton 여 = new JRadioButton("\uC5EC");
	JRadioButton 남 = new JRadioButton("\uB0A8");
	JRadioButton none = new JRadioButton("거의 움직이지않음");
	JRadioButton less = new JRadioButton("적당히 돌아다님");
	JRadioButton somtimes = new JRadioButton("가끔운동함");
	JRadioButton everyday = new JRadioButton("매일운동함");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personalfirst frame = new personalfirst();
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
	public personalfirst() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		q4 = new JTextField();
		q4.setBackground(Color.WHITE);
		q4.setEditable(false);
		q4.setEnabled(false);
		q4.setText("\uBAB8\uBB34\uAC8C");
		q4.setForeground(Color.BLACK);
		q4.setBounds(13, 10, 57, 21);
		contentPane.add(q4);
		q4.setColumns(10);
		
		q5 = new JTextField();
		q5.setBackground(Color.WHITE);
		q5.setText("\uD0A4");
		q5.setForeground(Color.BLACK);
		q5.setEnabled(false);
		q5.setEditable(false);
		q5.setColumns(10);
		q5.setBounds(13, 55, 57, 21);
		contentPane.add(q5);
		
		q6 = new JTextField();
		q6.setBackground(Color.WHITE);
		q6.setText("\uB098\uC774");
		q6.setForeground(Color.BLACK);
		q6.setEnabled(false);
		q6.setEditable(false);
		q6.setColumns(10);
		q6.setBounds(13, 99, 57, 21);
		contentPane.add(q6);
		
		q7 = new JTextField();
		q7.setBackground(Color.WHITE);
		q7.setText("\uC131\uBCC4");
		q7.setForeground(Color.BLACK);
		q7.setEnabled(false);
		q7.setEditable(false);
		q7.setColumns(10);
		q7.setBounds(13, 130, 57, 21);
		contentPane.add(q7);
		
		
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
				System.exit(0);
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
		everyday.setBounds(23, 232, 121, 23);
		contentPane.add(everyday);
		ButtonGroup move=new ButtonGroup();
		move.add(none);
		move.add(less);
		move.add(somtimes);
		move.add(everyday);
	}


	class Confirm implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
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
			//-----------------------------------------
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
					BufferedWriter make=new BufferedWriter(new FileWriter("person.txt",true));
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
				} catch (Exception ee) {
					System.out.println("실패");
				}
				mainframe frame=new mainframe();
				frame.setVisible(true);
				dispose();
			}
		}
	}

}
