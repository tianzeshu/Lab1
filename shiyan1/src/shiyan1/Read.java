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
		 * buffer = new StringBuffer(); while (ch != -1) { // 读取成功
		 * buffer.append((char) ch); ch = reader.read(); } str =
		 * change(buffer.toString()); str = filter(str);
		 * System.out.println(str);
		 * 
		 * Picture myPicture = new Picture(str); myPicture.showPicture();
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("请输入桥接词的两侧词语:"); String s1 = scanner.nextLine();
		 * String s2 = scanner.nextLine();
		 * 
		 * myPicture.Bridge(s1,s2); System.out.println("请输入根据桥接词生成文本的初始文本:");
		 * String s3 = scanner.nextLine(); myPicture.newtext(s3);
		 * myPicture.emptyQueue(); System.out.println("请输入查询最短路径的两个词语:"); s1 =
		 * scanner.nextLine(); s2 = scanner.nextLine(); myPicture.shortroad(s1,
		 * s2); //if (myPicture.calcShortestPath(s1, s2) &&
		 * myPicture.showShortestPath(s1, s2) != 0)
		 * //System.out.println("最短路径长度是" + myPicture.minlen); String s4 =
		 * myPicture.randomWalk(); System.out.println("随机游走结果:" + s4);
		 * write(s4); reader.close(); scanner.close(); } catch
		 * (FileNotFoundException e) { System.out.println("要读取的文件不存在：" +
		 * e.getMessage()); } catch (IOException e) {
		 * System.out.println("文件读取错误：" + e.getMessage()); }
		 */
	}

	

	public static String change(String s) {
		// 替换非字母字符为空格
		String REGEX = "[^A-Za-z]";
		String REPLACE = " ";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(s);
		s = m.replaceAll(REPLACE);
		// 大写转化小写
		String Lowstr = s.toLowerCase();
		return Lowstr;
	}

	public static String filter(String s) {
		// 删除多余的空格
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
			System.out.println("写入成功!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}