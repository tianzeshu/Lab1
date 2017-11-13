package shiyan1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class randomWalkTest {
	String str = "You are my friends."
			+ "You are the best person in the world!"
			+ "You have the most money in the world and the biggest house!";	
	GraphViz myGraph = new GraphViz();
	Picture myPicture = new Picture(str);
	
	//System.out.println(myPicture.randomWalk("colored"));
	//myGraph.createDotGraph(myPicture.graph(), "GraphTestNew");
	
	@Test
	public void testRandomWalk1() {
		myPicture.randomWalk("house");
		assertEquals("没有出边!",myPicture.howEnd);
	}
	
	@Test
	public void testRandomWalk2() {
		myPicture.randomWalk("you");
		assertEquals("重复边!",myPicture.howEnd);
	}
	
	@Test
	public void testRandomWalk3() {
		myPicture.randomWalk("what");
		assertEquals("输入的位置有误!",myPicture.howEnd);
	}
	
	
	@Test
	public void testRandomWalk4() {
		myPicture.randomWalk("");
		assertEquals("输入为空!",myPicture.howEnd);
	}

}
