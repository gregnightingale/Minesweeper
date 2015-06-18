package test;

import minesweeper.game.Configuration;
import minesweeper.game.Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test1 {

	Configuration config;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		config = new Configuration();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1D() throws Exception {
		
		config.setBombsTotal(5);
		config.setDimensions(2);
		config.setWidth(5);
		config.setHeight(5);
		
		Game game = new Game(config);

		game = new Game(config);
		game.play();
	}

}
