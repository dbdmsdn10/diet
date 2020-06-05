package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;

public class FoodSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String[][] food;
	private JScrollPane scrollPane;
	JButton btnNewButton = new JButton("\uAC80\uC0C9");
	DefaultListModel listModel = new DefaultListModel();
	JList list;
	JRadioButton Frozen = new JRadioButton("냉동, 과자, 기타등등");
	JRadioButton ingredient = new JRadioButton("요리 재료, 과일, 생것");
	JRadioButton orderingFood = new JRadioButton("식당, 가게 상품등");
	JRadioButton cook = new JRadioButton("일반적 요리, 음식");
	JRadioButton back = new JRadioButton("초기화");
	JList EatThing = new JList();
	Integer findarray[];
	SearchAction search = new SearchAction();
	private JTextField Nutrients;
	Integer[] find2 = {};

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 922, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 906, 472);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\uCE7C\uB85C\uB9AC \uC591\uC744 \uC54C\uACE0 \uC2F6\uC740 \uC74C\uC2DD\uC758 \uC774\uB984\uC744 \uC785\uB825\uD558\uC2DC\uC624");
		lblNewLabel.setBounds(12, 10, 305, 15);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(12, 39, 405, 23);
		panel.add(textField);
		textField.setColumns(10);

		btnNewButton.setBounds(456, 39, 172, 23);
		btnNewButton.addActionListener(search);
		panel.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 199, 405, 263);
		panel.add(scrollPane);

		listModel = new DefaultListModel();

		findarray = new Integer[food.length - 4];
		for (int i = 4; i < food.length; i++) {

			listModel.addElement(food[i][5] + "   " + food[i][10] + "g");
			findarray[i - 4] = i;
		}

		list = new JList(listModel);

		scrollPane.setViewportView(list);

		Nutrients = new JTextField();
		Nutrients.setBounds(456, 116, 275, 21);
		panel.add(Nutrients);
		Nutrients.setColumns(10);

		Frozen.setBounds(12, 77, 157, 23);
		panel.add(Frozen);

		ingredient.setBounds(12, 115, 157, 23);
		panel.add(ingredient);

		orderingFood.setBounds(220, 77, 135, 23);
		panel.add(orderingFood);

		cook.setBounds(220, 115, 135, 23);
		panel.add(cook);

		back.setBounds(451, 77, 121, 23);
		panel.add(back);
		back.setSelected(true);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(Frozen);
		btnG.add(ingredient);
		btnG.add(orderingFood);
		btnG.add(cook);
		btnG.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("검색 결과");
		lblNewLabel_1.setBounds(12, 174, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("먹은것");
		lblNewLabel_2.setBounds(489, 174, 57, 15);
		panel.add(lblNewLabel_2);
		
		JButton EatConfirm = new JButton("적용");
		EatConfirm.setBounds(759, 115, 97, 23);
		panel.add(EatConfirm);
		
		JButton btnNewButton_2 = new JButton("종료");
		btnNewButton_2.setBounds(721, 39, 135, 23);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(489, 199, 405, 263);
		panel.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(EatThing);
		
		JButton Delet = new JButton("삭제");
		Delet.setBounds(759, 148, 97, 23);
		panel.add(Delet);

		Category frozen2 = new Category();
		Category ingredient2 = new Category();
		Category orderingFood2 = new Category();
		Category cook2 = new Category();
		Category back2 = new Category();

		frozen2.gettxt(Frozen.getText());
		ingredient2.gettxt(ingredient.getText());
		orderingFood2.gettxt(orderingFood.getText());
		cook2.gettxt(cook.getText());
		back2.gettxt(back.getText());

		Frozen.addActionListener(frozen2);
		ingredient.addActionListener(ingredient2);
		orderingFood.addActionListener(orderingFood2);
		cook.addActionListener(cook2);
		back.addActionListener(back2);
		Eat eat=new Eat();
		EatConfirm.addActionListener(eat);
		Delet2 del=new Delet2();
		Delet.addActionListener(del);
		
		
		
		
		JListSelect select = new JListSelect();
		list.addListSelectionListener(select);
	}

	public class Category implements ActionListener {
		String name;

		public void gettxt(String name) {
			this.name = name;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			int check = 0;
			findint find2 = new findint();
			DefaultListModel model = new DefaultListModel();

			findarray = find2.findPerCategory2(food, 5, name);
			if (e.getSource() == orderingFood) {
				for (int i = 0; i < findarray.length; i++) {
					model.addElement(food[findarray[i]][5] + "   " + food[findarray[i]][7] + "    "
							+ food[findarray[i]][10] + "g");
					check++;
				}
			} else {
				for (int i = 0; i < findarray.length; i++) {
					model.addElement(food[findarray[i]][5] + "   " + food[findarray[i]][10] + "g");
					check++;
				}
			}
			if (check == 0) {
				JOptionPane.showMessageDialog(null, "이 식픔을 찾을 수 없음(다시 입력해 보십시오)");
			} else {
				list.setModel(model);
			}

		}

	}

	public class SearchAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Integer[] find;
			int check = 0;
			if (e.getSource() == btnNewButton) {
				list.removeAll();
				DefaultListModel model = new DefaultListModel();

				findint find2 = new findint();

				find = find2.findPerCategory(food, textField.getText(), 5, findarray);
				if (orderingFood.isSelected()) {
					for (int i = 0; i < find.length; i++) {
						model.addElement(food[find[i]][5] + "    " + food[find[i]][7] + "    "
								+ food[find[i]][10] + "g");
						check++;
					}
				} else {
					for (int i = 0; i < find.length; i++) {
						model.addElement(food[find[i]][5] + "    " + food[find[i]][10] + "g");
						check++;
					}
				}
				if (check == 0) {
					JOptionPane.showMessageDialog(null, "이 식픔을 찾을 수 없음(다시 입력해 보십시오)");
				} else {
					list.setModel(model);
				}

			}
		}
	}
	public class Eat implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ListModel model=EatThing.getModel();
			DefaultListModel model2 = new DefaultListModel();
			if(model.getSize()<1) {}
			else {
				model2 =(DefaultListModel) model;
			}
			model2.addElement(food[findarray[list.getSelectedIndex()]][5] + "  "
						+ food[findarray[list.getSelectedIndex()]][14]+"kcal");
			EatThing.setModel(model2);
		}
		
	}
	public class Delet2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ListModel model=EatThing.getModel();
			DefaultListModel model2 = new DefaultListModel();
			if(model.getSize()<1) {}
			else {
				model2 =(DefaultListModel) model;
			}
			if (EatThing.getSelectedIndex() != -1) {
				model2.remove(EatThing.getSelectedIndex());
				EatThing.setModel(model2);
			}
		}
		
	}

	class JListSelect implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (list.getSelectedIndex() != -1) {

				Nutrients.setText(food[findarray[list.getSelectedIndex()]][5] + "  "
						+ food[findarray[list.getSelectedIndex()]][14]+"kcal");
			}

		}

	}
}
