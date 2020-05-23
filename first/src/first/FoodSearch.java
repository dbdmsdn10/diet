package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FoodSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	//String[] comidas  = {"arroz","feijao", "macarrao", "Carne"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodSearch frame = new FoodSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FoodSearch() {
		String[][] comidas  = {{"arroz","100g"},{"feijao ,"200g"}, "macarrao", "Carne"
								"100g", "200g",  "300g",    "400g"}
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
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setBounds(400, 38, 172, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(12, 95, 406, 213);
		panel.add(table);
	}
}
