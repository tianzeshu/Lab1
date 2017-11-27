package shiyan1;

import shiyan1.Tree.ENode;
import shiyan1.Tree.VNode;

public class ShortestSheet {
	public static String s;
	public static Tree mytree = new Tree(s);
	int[][] shortDistance = new int[mytree.mVexs.length][mytree.mVexs.length];
	int[][] shortPath = new int[mytree.mVexs.length][mytree.mVexs.length];
	ShortestSheet(Tree oldtree)
	{
		mytree = oldtree;
	}
	
	public boolean shortroad(String s1, String s2) {
		boolean sign3=false, sign4=false;
		if(s1.equals("")||s2.equals("")) {
			System.out.println("输入了空字符串!");

			return false;
		}
		for (int i = 0; i < mytree.mVexs.length; i++) {
			if (s1.equals(mytree.mVexs[i].data))
				sign3 = true;
			if (s2.equals(mytree.mVexs[i].data))
				sign4 = true;
		}
		if (sign3 && sign4) {
			int sign1 = 0, sign2 = 0;
			int[][] sr = new int[mytree.mVexs.length][mytree.mVexs.length];
			int[][] rr = new int[mytree.mVexs.length][mytree.mVexs.length];
			for (int i = 0; i < mytree.mVexs.length; i++) {
				for (int j = 0; j < mytree.mVexs.length; j++) {
					rr[i][j] = -1;
					sr[i][j] = 100;
				}
			}
			for (int i = 0; i < mytree.mVexs.length; i++) {
				mytree.newtest = mytree.mVexs[i].firstEdge;
				while (mytree.newtest != null) {
					for (int j = 0; j < mytree.mVexs.length; j++) {
						if (mytree.newtest.ivex.equals(mytree.mVexs[j].data)) {
							sr[i][j] = mytree.newtest.weight;
							mytree.newtest = mytree.newtest.nextEdge;
							break;
						}

					}
				}
			}
			for (int h = 0; h < mytree.mVexs.length; h++) {
				for (int i = 0; i < mytree.mVexs.length; i++) {
					for (int j = 0; j < mytree.mVexs.length; j++) {
						if (sr[i][j] > (sr[i][h] + sr[h][j])) {
							sr[i][j] = (sr[i][h] + sr[h][j]);
							rr[i][j] = h;
						}
					}
				}
			}
			for (int i = 0; i < mytree.slen; i++) {
				if (s1.equals(mytree.mVexs[i].data)) {
					sign1 = i;
				}
				if (s2.equals(mytree.mVexs[i].data)) {
					sign2 = i;
				}
			}

			if (sr[sign1][sign2] == 100) {
				System.out.println("不可达!");

				return false;
			}
			System.out.println("最短路径长度:" + sr[sign1][sign2]);

			System.out.print("最短路径是:" + mytree.mVexs[sign1].data + " ");

			sout(sign1, sign2, sr, rr);
			System.out.print("\n");
			return true;
			/*
			 * String[] ss = new String[100]; int cnt = 0; while(rr[sign1][sign2] !=
			 * -1) { ss[cnt++] = mVexs[rr[sign1][sign2]].data;
			 * sign2=rr[sign1][sign2]; } for(int i = cnt - 1; i >= 0; i--)
			 * System.out.print(ss[i]+" "); System.out.print(s2+"\n");
			 */
		} else {
			System.out.println("未找到节点!");

			return false;
		}
		
	}
	
	public void sout(int s1, int s2, int[][] sr, int[][] rr) {
		int tmp;
		if (rr[s1][s2] == -1) {
			System.out.print(mytree.mVexs[s2].data + " ");

		} else {
			tmp = rr[s1][s2];
			sout(s1, tmp, sr, rr);
			sout(tmp, s2, sr, rr);
		}
	}
	
}
