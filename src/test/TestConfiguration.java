package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import minesweeper.game.Configuration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestConfiguration {

	static Configuration config;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("creating new Configuration class");
		config = new Configuration();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testGetDimensions() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDimensions() {
		try {
			config.setDimensions(0);
			fail("Exception not thrown!");
		} catch (Exception e) {
		}

		try {
			config.setDimensions(Configuration.MAX_DIMENSIONS + 1);
			fail("Exception not thrown!");
		} catch (Exception e) {
		}
	}

	@Test
	public void testGetMaxX() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWidth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxY() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxZ() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDepth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBombsTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testBombs() {

		try {
			config.setBombsTotal(0);
			fail("Exception not thrown!");
		} catch (Exception e) {
		}

		try {
			config.setBombsTotal(-1);
			fail("Exception not thrown!");
		} catch (Exception e) {
		}
		
		try {
			config.setBombsTotal(5);
			assertEquals(5,config.getBombsTotal());
		} catch (Exception e) {
			fail("Should not have encountered exception!");
		}
		
	}

}
