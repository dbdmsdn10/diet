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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import first.Exerciseframe.JListSelect;

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
	String[][] food;
	private JScrollPane scrollPane;
	JButton btnNewButton = new JButton("\uAC80\uC0C9");
	DefaultListModel listModel = new DefaultListModel();
	JList list;

	Integer find[];
	Action a = new Action();
	private JTextField Nutrients;
	Integer[] find2= {};
	public static void main(String[] args) {

		File cal = new File("food calory.txt");
		String line = null;
		String[] a = new String[230];
		String[][] Food = new String[29866][230];

		int i = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(cal));

			while ((line = reader.readLine()) != null) {
				a = line.split("\t");

				for (int j = 0; j < a.length; j++) {
					Food[i][j] = a[j];

				}
				i++;

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
					FoodSearch frame = new FoodSearch(Food);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FoodSearch(String[][] f) {
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

		JLabel lblNewLabel = new JLabel(
				"\uCE7C\uB85C\uB9AC \uC591\uC744 \uC54C\uACE0 \uC2F6\uC740 \uC74C\uC2DD\uC758 \uC774\uB984\uC744 \uC785\uB825\uD558\uC2DC\uC624");
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

		listModel = new DefaultListModel();

		find = new Integer[food.length];
		int k=0;
		for (int i = 4; i < food.length; i++) {

			listModel.addElement(food[i][5] + "   " + food[i][10] + "g");
			find[k++] = i;
		}

		list = new JList(listModel);

		scrollPane.setViewportView(list);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(400, 94, 17, 241);
		panel.add(scrollBar);
		
		Nutrients = new JTextField();
		Nutrients.setBounds(428, 93, 116, 21);
		panel.add(Nutrients);
		Nutrients.setColumns(10);
		
		JListSelect select = new JListSelect();
		list.addListSelectionListener(select);
	}

	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int check = 0;
			if (e.getSource() == btnNewButton)
				list.removeAll();
			DefaultListModel model = new DefaultListModel();

			findint find2 = new findint();
			
			find = find2.find(food, textField.getText(), 5,4);
			for (int i = 0; i < find.length; i++) {
				model.addElement(food[find[i]][5] + "   " + food[find[i]][10] + "g");
				check++;
			}
			if (check == 0) {
				textField.setText("이 식픔을 찾을 수 없음(다시 입력해 보십시오)");
			} else {
				list.setModel(model);
			}
		}

	}
	class JListSelect implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (list.getSelectedIndex() != -1) {

				Nutrients.setText(food[find[list.getSelectedIndex()]][5]+"  "+food[find[list.getSelectedIndex()]][14]);
			}

		}

	}
}
