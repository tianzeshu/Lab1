package shiyan1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class MainWindow {
	public static Read bao = new Read();
	@SuppressWarnings("static-access")
	public static void show() {
		String str = new String();
		Draw myGraph = new Draw();
		try {
			Reader reader = new FileReader("input_text.txt");
			int ch = reader.read();
			StringBuffer buffer = new StringBuffer();
			while (ch != -1) { // ��ȡ�ɹ�
				buffer.append((char) ch);
				ch = reader.read();
			}
			str = bao.change(buffer.toString());
			str = bao.filter(str);
			System.out.println(str);

			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ҫ��ȡ���ļ������ڣ�" + e.getMessage());
		} catch (IOException e) {
			System.out.println("�ļ���ȡ����" + e.getMessage());
		}
		Scanner scanner = new Scanner(System.in);
		String s, s1, s2, s3, s4;
		while (true) {
			System.out.println("��������:\n1.�˳�\n2.����ͼ\n3.չʾͼ\n4.��ѯ�ŽӴ�\n5.�������ı�\n6.��ѯ���·��\n7.��ѯһ�����ʵ������������·��\n8.�������");
			System.out.println("�����빦�����:");
			s = scanner.nextLine();
			Tree myPicture = new Tree(str);
			switch (s) {
			case "1":
				System.out.println("�˳��ɹ�!");
				scanner.close();
				return;
			case "2": {
				// System.out.println(myPicture.graph());
				myGraph.createDotGraph(myPicture.graph(), "Graph1");
				System.out.println("���ɳɹ�!");
				break;
			}
			case "3": {
				myPicture.showPicture();
				break;
			}
			case "4": {
				System.out.println("�������ŽӴʵ��������:");
				s1 = scanner.nextLine();
				s2 = scanner.nextLine();
				myPicture.Bridge(s1, s2);
				break;
			}
			case "5": {
				System.out.println("����������ŽӴ������ı��ĳ�ʼ�ı�:");
				s3 = scanner.nextLine();
				s3 = bao.change(s3);
				s3 = bao.filter(s3);
				myPicture.newtext(s3);
				break;
			}

			case "6": {
				boolean signk = true;
				System.out.println("�������ѯ���·������������:");
				s1 = scanner.nextLine();
				s2 = scanner.nextLine();
				signk = myPicture.shortroad(s1, s2);
				if(signk) {
			        System.out.println("�Ƿ�����ͼ��Y/N");
				    s2 = scanner.nextLine();
				    if (s2.equals("Y")) {
					    myGraph.createDotGraph(myPicture.shortRoadGraph(), "Graph2");
				        System.out.println("ͼ�����ɳɹ�!");
					}
				}
				break;
			}
			case "7": {
				System.out.println("�������ѯ���·����һ������:");
				s1 = scanner.nextLine();
				myPicture.shortroad2(s1);
				break;
			}
			case "8": {
				System.out.println("��������ʼλ��:");
				s3 = scanner.nextLine();
				s4 = myPicture.randomWalk(s3);
				System.out.println("������߽��:" + s4);
				System.out.println("�Ƿ�д���ļ���Y/N");
				s2 = scanner.nextLine();
				if (s2.equals("Y"))
					bao.write(s4);
				System.out.println("�Ƿ�����ͼ��Y/N");
				s2 = scanner.nextLine();
				if (s2.equals("Y"))
					myGraph.createDotGraph(myPicture.randomGraph(s4.split("\\s+")), "Graph3");
				break;
			}
			default:
				System.out.println("�������������ַ�!");
			}
		}
	}
}
