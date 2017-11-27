package shiyan1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShortTest2 {

	String str = "hello hello hello a a a a a a a a a a a a a my friend friend friend";
	Draw myGraph = new Draw();
	Tree myPicture = new Tree(str);
	
	@Before
	public void setUp() throws Exception {
	}

	//正常的节点1
	@Test
	public void testShortroad1() {
		assertTrue(myPicture.shortroad("hello", "a"));
		assertEquals(2,myPicture.shortLength);
	}

	//正常的节点2
	@Test
	public void testShortroad2() {
		assertTrue(myPicture.shortroad("my", "friend"));
		assertEquals(2,myPicture.shortLength);
	}
	
	//正常的节点2
	@Test
	public void testShortroad2_() {
		assertTrue(myPicture.shortroad("hello", "friend"));
		assertEquals(2,myPicture.shortLength);
	}
	
	//两个不存在的节点
	@Test
	public void testShortroad3() {
		assertFalse(myPicture.shortroad("abcd","efgh"));
	}
	
	//一个不存在一个存在节点
	@Test
	public void testShortroad4() {
		assertFalse(myPicture.shortroad("friend", "hello"));
	}
	
	//不可达的节点
	@Test
	public void testShortroad5() {
		assertFalse(myPicture.shortroad("hello", "posture"));
	}
	
	//自己到自己
	@Test
	public void testShortroad6() {
		assertFalse(myPicture.shortroad("a", "a"));
	}

	//正常3
	@Test
	public void testShortroad7() {
		assertTrue(myPicture.shortroad("require", "not"));
		assertEquals(5,myPicture.shortLength);
	}
}
