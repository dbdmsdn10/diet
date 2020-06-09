package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
	JList list = new JList();
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
	Integer[] eatthinglist = {};
	ArrayList<Integer> eatthing = new ArrayList<Integer>();
	String name = "";

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

	public void GetFood(String[][] Food, String what) {
		this.food = Food;
		findarray = new Integer[food.length - 4];
		DefaultListModel model = new DefaultListModel();
		for (int i = 4; i < food.length; i++) {

			model.addElement(food[i][5] + "   " + food[i][10] + "g");
			findarray[i - 4] = i;
		}

		list.setModel(model);

		// ------------------------------
		name = what;
		File cal = new File(what);
		String line = null;
		String[] a;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(cal));

			while ((line = reader.readLine()) != null) {
				a = line.split(",");

				for (int j = 0; j < a.length; j++) {
					eatthing.add(Integer.parseInt(a[j]));
				}
			}
			eatthinglist = eatthing.toArray(new Integer[eatthing.size()]);
			DefaultListModel model2 = new DefaultListModel();
			for (int i = 0; i < eatthinglist.length; i++) {
				model2.addElement(food[eatthinglist[i]][5] + "  " + food[eatthinglist[i]][14] + "kcal");
			}
			EatThing.setModel(model2);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JListSelect select = new JListSelect();
		list.addListSelectionListener(select);
	}

	public FoodSearch() {

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

		JButton endb = new JButton("저장하고 종료");
		endb.setBounds(721, 39, 135, 23);
		panel.add(endb);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(489, 199, 405, 263);
		panel.add(scrollPane_1);

		scrollPane_1.setViewportView(EatThing);

		JButton Delet = new JButton("삭제");
		Delet.setBounds(759, 148, 97, 23);
		panel.add(Delet);

		Category category = new Category();

		Frozen.addActionListener(category);
		ingredient.addActionListener(category);
		orderingFood.addActionListener(category);
		cook.addActionListener(category);
		back.addActionListener(category);
		Eat eat = new Eat();
		EatConfirm.addActionListener(eat);
		Delet2 del = new Delet2();
		Delet.addActionListener(del);

		End end = new End();
		endb.addActionListener(end);

	}

	public class Category implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			int check = 0;
			String name = "";
			findint find2 = new findint();
			DefaultListModel model = new DefaultListModel();
			if (e.getSource() == Frozen) {
				name = Frozen.getText();
			} else if (e.getSource() == ingredient) {
				name = ingredient.getText();
			} else if (e.getSource() == orderingFood) {
				name = orderingFood.getText();
			} else if (e.getSource() == cook) {
				name = cook.getText();
			} else if (e.getSource() == back) {
				name = back.getText();
			}

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
			int check = 0;
			if (e.getSource() == btnNewButton) {
				list.removeAll();
				DefaultListModel model = new DefaultListModel();

				findint find2 = new findint();

				findarray = find2.findPerCategory(food, textField.getText(), 5, findarray);
				if (orderingFood.isSelected()) {
					for (int i = 0; i < findarray.length; i++) {
						model.addElement(food[findarray[i]][5] + "    " + food[findarray[i]][7] + "    "
								+ food[findarray[i]][10] + "g");
						check++;
					}
				} else {
					for (int i = 0; i < findarray.length; i++) {
						model.addElement(food[findarray[i]][5] + "    " + food[findarray[i]][10] + "g");
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

	public class Eat implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			ListModel model = EatThing.getModel();
			DefaultListModel model2 = new DefaultListModel();
			if (model.getSize() < 1) {
			} else {
				model2 = (DefaultListModel) model;
			}
			eatthing.add(findarray[list.getSelectedIndex()]);
			model2.addElement(food[findarray[list.getSelectedIndex()]][5] + "  "
					+ food[findarray[list.getSelectedIndex()]][14] + "kcal");
			EatThing.setModel(model2);
		}

	}

	public class Delet2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ListModel model = EatThing.getModel();
			DefaultListModel model2 = new DefaultListModel();
			if (model.getSize() < 1) {
			} else {
				model2 = (DefaultListModel) model;
			}
			if (EatThing.getSelectedIndex() != -1) {
				eatthing.remove(EatThing.getSelectedIndex());
				model2.remove(EatThing.getSelectedIndex());
				EatThing.setModel(model2);
			}
		}

	}

	public class End implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				BufferedWriter make = new BufferedWriter(new FileWriter(name, false));
				Integer[] eatthinglist = eatthing.toArray(new Integer[eatthing.size()]);

				double kar = 0;
				for (int i = 0; i < eatthinglist.length; i++) {
					make.write(eatthinglist[i] + ",");
					kar += Double.parseDouble(food[eatthinglist[i]][14]);
				}
				make.flush();
				make.close();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			days kk = new days();
			kk.two(food);
			kk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			kk.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent k) {
					try {
						BufferedWriter make = new BufferedWriter(new FileWriter("totalkcal.txt", false));
						make.write(Double.toString(kk.total));
						make.flush();
						make.close();
					} catch (IOException q) {// 파일 읽기 오류

					} catch (Exception e) {
						e.printStackTrace();
					}
					mainframe b = new mainframe();
					b.setVisible(true);
				}
			});
			kk.setVisible(true);
			dispose();

		}
	}

	class JListSelect implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (list.getSelectedIndex() != -1) {

				Nutrients.setText(food[findarray[list.getSelectedIndex()]][5] + "  "
						+ food[findarray[list.getSelectedIndex()]][14] + "kcal");
			}

		}

	}
}
