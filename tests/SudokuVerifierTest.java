import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

// added for the task
String test1 = "";
String test2 = "417698563258947587231685431699158643236912758289643571573291684164875293";
String test3 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293123456789";
String test4 = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
String test5 = "143456789256789123789123456471362598892415367365897214534648971617932845928571632";
String test6 = "123456789456789123789123456471632598892514367365897214537961842612348975948275631";
String test7 = "1£3456789912345678891234567789123456678912345567891234456789123345678912234567891";
String test8 = "407369825632158947958724316825437169791586432346912758289643571573291684164875293";

SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);	
	}
	
	@Test
	public void test_NoSudokuTables() {
		int a = v.verify(test1);
		assertEquals("incorrect string", a, -1);	
	}
	
	@Test
	public void test_8numbersPerTable() {
		int a = v.verify(test2);
		assertEquals("incorrect string", a, -1);	
	}
	
	@Test
	public void test_TenSudokuTables() {
		int a = v.verify(test3);
		assertEquals("incorrect string", a, -1);
	}
			
	@Test
	public void test_TwoSameNumbersInOneTable() {
		int a = v.verify(test4);
		assertEquals("incorrect string", a, -2);
	}
	
	@Test
	public void test_TwoSameNumbersInGlobalRow() {
		int a = v.verify(test5);
		assertEquals("incorrect string", a, -3);
	}
	
	@Test
	public void test_TwoSameNumbersInGlobalColumn() {
		int a = v.verify(test6);
		assertEquals("incorrect string", a, -4);
	}
	
	@Test 
	public void test_UnicodeCharacterInSudoku() {
		int a = v.verify(test7);
		assertEquals("incorrect string", a, 1);
	}
	
	@Test
	public void test_ZeroInSudoku() {
		int a = v.verify(test8);
		assertEquals("incorrect string", a, -1);
	}
	
	
}
