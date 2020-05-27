package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class FoodSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ArrayList<String> food = new ArrayList<String>();
	private JScrollPane scrollPane;
	JButton btnNewButton = new JButton("\uAC80\uC0C9");
	
	Action a = new Action();
	
	public static void main(String[] args) {
		
		File cal = new File("food calory.txt");
		ArrayList<String> getFood = new ArrayList<String>();
		String line;
	
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(cal));
			while (reader.readLine()!=null) {
				line = reader.readLine() + "  cal";
				getFood.add(line);
			//System.out.println(line);
				
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodSearch frame = new FoodSearch(getFood);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FoodSearch(ArrayList f) {
		this.food = f;
		setTitle("Health Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 598, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uCE7C\uB85C\uB9AC \uC591\uC744 \uC54C\uACE0 \uC2F6\uC740 \uC74C\uC2DD\uC758 \uC774\uB984\uC744 \uC785\uB825\uD558\uC2DC\uC624");
		lblNewLabel.setBounds(12, 10, 305, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 39, 329, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton.setBounds(400, 38, 172, 23);
		btnNewButton.addActionListener(a);
		panel.add(btnNewButton);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 94, 404, 243);
		panel.add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		
		for(String element : food) {
			System.out.println(element);
			listModel.addElement(element);
		}
		JList list = new JList(listModel);
		
		scrollPane.setViewportView(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(400, 94, 17, 241);
		panel.add(scrollBar);
	}
	
		public class Action implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton ) {
					
					for(String element : food) {
						//System.out.println(element);
						if(textField.getText().contains(element)) {
							System.out.println("hello");
							System.out.println(element);
							
						}
						else {
							System.out.println("Nao tem ");
						}
					}
				}
				
			}
			
		}
	
}
