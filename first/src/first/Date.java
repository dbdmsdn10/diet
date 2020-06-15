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

	public static void save(mainframe frame, double nowcar, JTextField showcar, double original) {
		String date = "past.txt";
		SimpleDateFormat turn = new SimpleDateFormat("yyyy MM dd");
		Calendar time = Calendar.getInstance();
		String time2 = turn.format(time.getTime());
		String past = null;
		try {
			BufferedReader dateb = new BufferedReader(new FileReader(date));
			String line;
			boolean what = false;
			while ((line = dateb.readLine()) != null) {
				if (line.equals(time2)) {
					what = true;
				} else {
					past = line;
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
				String[] year = past.split(" ");
				File year2 = new File("date");
				File year3 = new File("date/" + year[0]);
				File year4 = new File("date/" + year[0] + "/" + year[1]);
				File year5 = new File("date/" + year[0] + "/" + year[1] + "/" + year[2]);
				if (year2.isDirectory()) {
					if (year3.isDirectory()) {
						if (year4.isDirectory()) {
							year5.mkdir();
						} else {
							year4.mkdir();
							year5.mkdir();
						}
					} else {
						year3.mkdir();
						year4.mkdir();
						year5.mkdir();
					}
				} else {
					year2.mkdir();
					year3.mkdir();
					year4.mkdir();
					year5.mkdir();
				}

				String list[] = { "breakfast.txt", "dayusedcalori.txt", "dinner.txt", "lunch.txt", "snack.txt",
						"totalkcal.txt", "usedcalori.txt", "pastcar.txt" };
				for (int i = 0; i < list.length; i++) {// 파일들 이동
					File file = new File(list[i]);
					if (file.exists()) {
						File year6 = new File("date/" + year[0] + "/" + year[1] + "/" + year[2] + "/" + list[i]);
						if (file.renameTo(year6)) {
						} else {
						}
					} else {

					}

				}

				if (nowcar < 0) {
					try {
						BufferedWriter make = new BufferedWriter(new FileWriter(list[7], false));
						double nowcar2 = -nowcar;
						if (nowcar2 > 500) {
							nowcar2 = 500;
						}
						make.write(Double.toString(nowcar2));
						make.flush();
						make.close();
						showcar.setText(Double.toString(original - nowcar2) + " kcal");
					} catch (Exception e) {
						System.out.println("showcar입력오류");
					}
				} else {
					showcar.setText(Double.toString(original));
				}
				frame.search(frame);
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
