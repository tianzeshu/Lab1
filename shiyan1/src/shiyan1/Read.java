package shiyan1;

import java.io.*;
import java.util.regex.*;
import java.util.Scanner;

public class Read {
	public static MainWindow window = new MainWindow();
	public static void main(String[] args) throws IOException {
		window.show();
		/*
		 * String str = new String(); try { Reader reader = new
		 * FileReader("input_text.txt"); int ch = reader.read(); StringBuffer
		 * buffer = new StringBuffer(); while (ch != -1) { // ��ȡ�ɹ�
		 * buffer.append((char) ch); ch = reader.read(); } str =
		 * change(buffer.toString()); str = filter(str);
		 * System.out.println(str);
		 * 
		 * Picture myPicture = new Picture(str); myPicture.showPicture();
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("�������ŽӴʵ��������:"); String s1 = scanner.nextLine();
		 * String s2 = scanner.nextLine();
		 * 
		 * myPicture.Bridge(s1,s2); System.out.println("����������ŽӴ������ı��ĳ�ʼ�ı�:");
		 * String s3 = scanner.nextLine(); myPicture.newtext(s3);
		 * myPicture.emptyQueue(); System.out.println("�������ѯ���·������������:"); s1 =
		 * scanner.nextLine(); s2 = scanner.nextLine(); myPicture.shortroad(s1,
		 * s2); //if (myPicture.calcShortestPath(s1, s2) &&
		 * myPicture.showShortestPath(s1, s2) != 0)
		 * //System.out.println("���·��������" + myPicture.minlen); String s4 =
		 * myPicture.randomWalk(); System.out.println("������߽��:" + s4);
		 * write(s4); reader.close(); scanner.close(); } catch
		 * (FileNotFoundException e) { System.out.println("Ҫ��ȡ���ļ������ڣ�" +
		 * e.getMessage()); } catch (IOException e) {
		 * System.out.println("�ļ���ȡ����" + e.getMessage()); }
		 */
	}

	

	public static String change(String s) {
		// �滻����ĸ�ַ�Ϊ�ո�
		String REGEX = "[^A-Za-z]";
		String REPLACE = " ";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(s);
		s = m.replaceAll(REPLACE);
		// ��дת��Сд
		String Lowstr = s.toLowerCase();
		return Lowstr;
	}

	public static String filter(String s) {
		// ɾ������Ŀո�
		String REGEX = "  ";
		String REPLACE = " ";
		Pattern p = Pattern.compile(REGEX);
		while (true) {
			Matcher m = p.matcher(s);
			if (!m.find())
				break;
			s = m.replaceAll(REPLACE);
		}
		return s;
	}

	public static void write(String s) {
		try {
			File file = new File("output_text.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWritter = new FileWriter(file.getName(), false);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(s);
			bufferWritter.close();
			System.out.println("д��ɹ�!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}