/**
 * 
 */
package edu.virginia.cs.cs4501.dgm3df;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dgm3df
 * I downloaded this code from the Internet
 * With the exception of some getters/setters,
 * all code is in its original form.
 */
public class Connect4Test {

	cli Cli;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		Cli = new cli();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	    System.setErr(null);
	}


	@Test
	public void testPlayerWinsHorizontal() {
		Cli.my_grid.set_matrix(new int[][]{{0,0,0,0,0,0,},
										   {0,0,0,0,0,0,},
										   {0,0,0,0,0,0,},
										   {0,0,0,0,0,0,},
										   {0,0,0,0,0,0,},
										   {2,2,2,0,0,0,},
										   {1,1,1,0,0,0,}});
		logic Logic = new logic(Cli.my_grid);
		assertTrue(Logic.set_and_check(6,3,1));
	}
	
	@Test
	public void testPlayerWinsVertical() {
		Cli.my_grid.set_matrix(new int[][]{{0,0,0,1,1,1},
										   {0,0,0,2,2,2},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0}});
		String data = "1";
		InputStream stdin = System.in;
		try {
		  Cli.input = new Scanner((new ByteArrayInputStream(data.getBytes())));
		  Cli.runtime();
		} finally {
		  System.setIn(stdin);
		}
		assertTrue(Cli.getHasWon());
	}
	
	@Test
	public void testPlayerWinsDiagonalToUpRight() {
		Cli.my_grid.set_matrix(new int[][]{{0,0,0,0,1,1},
										   {0,0,0,2,1,2},
										   {0,0,0,1,2,1},
										   {0,0,0,2,2,1},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0}});
		String data = "4";
		InputStream stdin = System.in;
		try {
			Cli.input = new Scanner((new ByteArrayInputStream(data.getBytes())));
			Cli.runtime();
		} finally {
			System.setIn(stdin);
		}
		
		assertTrue(Cli.getHasWon());
										   
	}
	
	@Test
	public void testPlayerWinsDiagonalToUpLeft() {
		Cli.my_grid.set_matrix(new int[][]{{0,0,0,2,2,1},
										   {0,0,0,1,2,2},
										   {0,0,0,2,1,1},
										   {0,0,1,2,2,1},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0},
										   {0,0,0,0,0,0}});
		String data = "1";
		InputStream stdin = System.in;
		try {
			Cli.input = new Scanner((new ByteArrayInputStream(data.getBytes())));
			Cli.runtime();
		} finally {
			System.setIn(stdin);
		}
		assertTrue(Cli.getHasWon());
	}
	
	@Test
	public void testDraw(){
		Cli.my_grid.set_matrix(new int[][]{{1,2,1,1,2,1},
										   {2,1,2,2,1,2},
										   {1,2,1,1,2,1},
										   {2,1,2,2,1,2},
										   {1,2,1,1,2,1},
										   {2,1,2,2,1,2},
										   {0,2,1,1,2,1}});
		Cli.setCurrentPlayer(2);
		Cli.my_logic.setCellsLeft(1);
		String data = "7";
		InputStream stdin = System.in;
		try {
			Cli.input = new Scanner((new ByteArrayInputStream(data.getBytes())));
			Cli.runtime();
		} finally {
			System.setIn(stdin);
		}
		
		assertTrue(Cli.getHasDraw());
		
	}

}
