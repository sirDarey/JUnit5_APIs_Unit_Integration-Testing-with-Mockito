package sirdarey;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS) // Use this line or (don't use it but make 'beforeAll' and 'afterAll' static)
class MathFunctionsTest {

	MathFunctions mathFunctions;
	
	@BeforeAll
	void beforeAll () {
		System.out.println("Before All runs before any method of a Test Class runs");
	}
	
	@BeforeEach //runs before each method of a test class
	void beforeEach () {
		mathFunctions =  new MathFunctions();
	}
	
	@AfterEach
	void afterEach () {
		System.out.println("After Each runs after each method in a Test Class");
	}
	
	@AfterAll
	void afterAll () {
		System.out.println("After All runs after all methods of a Test Class are done running");
	}
	
	@Test
	@Tag("sumTag") //Use this to tag the test cases you want to selectively run
	void testSum() {
		int expected = 50;
		int actual = mathFunctions.sum(10, 40);
		assertEquals(expected, actual);
	}
	
	@Test
	void testReturnArray () {
		int [] expected = {5,6,7};
		int [] actual = mathFunctions.returnArray();
		assertArrayEquals(expected, actual, ()-> "Error Message");
	}

	@Test
	@DisplayName("Divide Test") // To explicitly give a name to a test for trace purpose in case it fails
	@Disabled //to  disable a running a test
	void testDivide () {
		int a = 25, b = 5, c = 0;
		
		// AssertAll
		assertAll( ()-> assertEquals(5, mathFunctions.divide(a, b)),
				   ()-> assertThrows(ArithmeticException.class, ()-> mathFunctions.divide(a, c))
				);
				
		assumeTrue(c == 0);  //ALL statements below this line will run only if this assumption is true
		assertThrows(ArithmeticException.class, ()-> mathFunctions.divide(a, c));
		System.out.println("***** Runs if assumption is true ******"); //this will NOT run if assumption is FALSE
	}
	
	@Test
	@RepeatedTest(value = 5)
	void repeatMe () {
		System.out.println("\n **I am repeated**\n");
	}
}
