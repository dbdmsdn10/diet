package first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;

public class Date {

	public static void save(double nowcar, JTextField showcar, double original) {
		String date = "past.txt";
		SimpleDateFormat turn = new SimpleDateFormat("yyyy.MM.dd");
		Calendar time = Calendar.getInstance();
		String time2 = turn.format(time.getTime());

		try {
			BufferedReader dateb = new BufferedReader(new FileReader(date));
			String line;
			boolean what = false;
			while ((line = dateb.readLine()) != null) {
				if (line.equals(time2)) {
					what = true;
				} else {
				}
			}
			dateb.close();
			if (what) {
			} else {// 날짜가 다르다면
				try {
					BufferedWriter make = new BufferedWriter(new FileWriter(date, false));
					make.write(time2);
					make.flush();
					make.close();
				} catch (Exception e) {
					System.out.println("생성문제");
				}

				String list[] = { "usedcalori.txt", "snack.txt", "lunch.txt", "dinner.txt", "breakfast.txt",
						"pastcar.txt", "totalkcal.txt" };
				for (int i = 0; i < list.length; i++) {// 파일들 삭제
					File file = new File(list[i]);

					if (file.exists()) {
						if (file.delete()) {
						} else {
							System.out.println(list[i]);
						}
					} else {

					}

				}

				if (nowcar < 0) {
					try {
						BufferedWriter make = new BufferedWriter(new FileWriter(list[5], false));
						double nowcar2 = -nowcar;
						if(nowcar2>500)
						{
							nowcar2=500;
						}
						make.write(Double.toString(nowcar2));
						make.flush();
						make.close();
						showcar.setText(Double.toString(original - nowcar2)+ " kcal");
					} catch (Exception e) {
						System.out.println("showcar입력오류");
					}
				} else {
					showcar.setText(Double.toString(original));
				}
			}
		} catch (IOException q) {// 파일 읽기 오류
			try {
				BufferedWriter make = new BufferedWriter(new FileWriter(date, false));
				make.write(time2);
				make.flush();
				make.close();
			} catch (Exception e) {
				System.out.println("생성문제");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("날짜문제");
		}

	}
}
