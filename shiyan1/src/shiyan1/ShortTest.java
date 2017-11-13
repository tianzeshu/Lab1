package shiyan1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShortTest {
	String str = "I want more long-term friendship" + 
			" I want more long-term friendship, not that rare meteor, not a shadowy snow shadow butterfly, but the most lasting friendships, like fish and water intimacy, date, month, day and night change." + 
			"I want more solid friendship, not a misunderstanding and awkward can provoke the root of friendship is not a rose and thorns hurt others even a trace of regret. Breeding firm friendship, then returns to the situation, is this world the simplicity of friendship, it is like a sacred artifacts, magic facilities will be able to turn their swords into plowshares." + 
			"I want to make friendship both gorgeous and simple, gorgeous noble Simplicity elegant and it does not require any very hot aromatic statement to praise it, and do not need to use any the leisurely express slow movement to praise it, it's living the same life The moist, posture colored."
			+ "k c k";		
	GraphViz myGraph = new GraphViz();
	Picture myPicture = new Picture(str);
	
	//�����Ľڵ�
	@Test
	public void testShortroad1() {
		assertTrue(myPicture.shortroad("want", "the"));
		assertEquals(2,myPicture.shortLength);
		assertEquals("want to the ",myPicture.shortR);
	}

	//һ���սڵ�
	@Test
	public void testShortroad2() {
		assertFalse(myPicture.shortroad("", "the"));
		assertEquals("�����˿��ַ���!",myPicture.shortR);
	}
	
	//�����սڵ�
	@Test
	public void testShortroad3() {
		assertFalse(myPicture.shortroad("", ""));
		assertEquals("�����˿��ַ���!",myPicture.shortR);
	}
	
	//���������ڵĽڵ�
	@Test
	public void testShortroad4() {
		assertFalse(myPicture.shortroad("abcd","efgh"));
		assertEquals("δ�ҵ��ڵ�!",myPicture.shortR);
	}
	
	//һ��������һ�����ڽڵ�
	@Test
	public void testShortroad5() {
		assertFalse(myPicture.shortroad("colored", "abcd"));
		assertEquals("δ�ҵ��ڵ�!",myPicture.shortR);
	}
	
	//���ɴ�Ľڵ�
	@Test
	public void testShortroad6() {
		assertFalse(myPicture.shortroad("colored", "posture"));
		assertEquals("���ɴ�!",myPicture.shortR);
	}
	
	//�Լ����Լ�
	@Test
	public void testShortroad7() {
		assertFalse(myPicture.shortroad("colored", "colored"));
		assertEquals("���ɴ�!",myPicture.shortR);
	}
	
	@Test
	public void testShortroad8() {
		assertTrue(myPicture.shortroad("k", "k"));
		assertEquals("k c k ",myPicture.shortR);
	}

	
}