/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;
import org.junit.rules.ExpectedException;

public class TemperatureTest {

	  // Add multiple tests to check all functions of
	  // {@Code Temperature} class.

		//Testing the 2-input constructor if it is storing the values correctly (converting to and from kelvin)
		
		double precision = 0.1;
		
		@Rule
		public ExpectedException exception = ExpectedException.none();
		
	     @Test
	     public void test_constructor_taking2inputs_storingCelcius_positive (){
	        System.out.println("Test if the constructor is storing the right values when taking celcius and result is positive");
	        Temperature temp = new Temperature(40, Temperature.Units.CELSIUS);
	        assertTrue(inPrecision(temp.getValue(), 40));
	     }	
	     @Test
	     public void test_constructor_taking2inputs_storingCelcius_negative (){
	        System.out.println("Test if the constructor is storing the right values when taking celcius and result is negative");
	        Temperature temp = new Temperature(-10.5, Temperature.Units.CELSIUS);
	        assertTrue(inPrecision(temp.getValue(), -10.5));
	     }
	     @Test (expected = IllegalArgumentException.class)
	     public void test_constructor_taking2inputs_storingCelcius_pastBoundary (){
	         System.out.println("Test if the constructor is storing the right value when taking celcius and result is not valid");
	         Temperature temp = new Temperature(-280, Temperature.Units.CELSIUS);
	      }
	     @Test 
	     public void test_constructor_taking2inputs_storingKelvin_positive (){
	         System.out.println("Test if the constructor is storing the right value when taking kelvin and result is positive");
	         Temperature temp = new Temperature(27.3, Temperature.Units.KELVIN);
	         assertTrue(inPrecision(temp.getValue(), 27.3));
	      }
	     @Test
	     public void test_constructor_taking2inputs_storingKelvin_boundary (){
	         System.out.println("Test if the constructor is storing the right values when taking kelvin and result is on the boundary");
	         Temperature temp = new Temperature(0, Temperature.Units.KELVIN);
	         assertTrue(inPrecision(temp.getValue(), 0));
	      }
	     @Test (expected = IllegalArgumentException.class)
	     public void test_constructor_taking2inputs_storingKelvin_pastBoundary (){
	         System.out.println("Test if the constructor is storing the right values when taking kelvin and result is not valid");
	         Temperature temp = new Temperature(-1, Temperature.Units.KELVIN);
	      }
	     @Test
	     public void test_constructor_taking2inputs_storingFahrenheit_positive (){
	         System.out.println("Test if the constructor is storing the right values when taking fahrenheit and result is positive");
	         Temperature temp = new Temperature(11.5, Temperature.Units.FAHRENHEIT);
	         assertTrue(inPrecision(temp.getValue(), 11.5));
	      }
	     @Test
	     public void test_constructor_taking2inputs_storingFahrenheit_negative (){
	         System.out.println("Test if the constructor is storing the right values when taking fahrenheit and result is negative");
	         Temperature temp = new Temperature(-25, Temperature.Units.FAHRENHEIT);
	         assertTrue(inPrecision(temp.getValue(), -25));
	      }
	     @Test (expected = IllegalArgumentException.class)
	     public void test_constructor_taking2inputs_storingFahrenheit_pastBoundary (){
	         System.out.println("Test if the constructor is storing the right values when taking fahrenheit and result is not valid");
	         Temperature temp = new Temperature(-550, Temperature.Units.FAHRENHEIT);
	      }
	     
	     //Testing the 2-input constructor if it is storing the units correctly
	     
	     @Test
	     public void test_constructor_taking2inputs_storingUnits_celcius (){
	        System.out.println("Test if the constructor is storing the right units");
	        Temperature temp = new Temperature(100, Temperature.Units.CELSIUS);
	        assertTrue(temp.getUnits() == Temperature.Units.CELSIUS);
	     }
	     @Test
	     public void test_constructor_taking2inputs_storingUnits_kelvin (){
	        System.out.println("Test if the constructor is storing the right units");
	        Temperature temp = new Temperature(100, Temperature.Units.KELVIN);
	        assertTrue(temp.getUnits() == Temperature.Units.KELVIN);
	     }
	     @Test
	     public void test_constructor_taking2inputs_storingUnits_fahrenheit (){
	        System.out.println("Test if the constructor is storing the right units");
	        Temperature temp = new Temperature(100, Temperature.Units.FAHRENHEIT);
	        assertTrue(temp.getUnits() == Temperature.Units.FAHRENHEIT);
	     }
	     
	     //Test if changeUnits is changing the units and values correctly
	     
	     @Test
	     public void test_changeUnits_KelvinToCelcius(){
	         System.out.println("Test if method changeUnits, changes the units of temperature from Kelvin to Celsius and stores the correct value");
	         Temperature temp = new Temperature(20, Temperature.Units.KELVIN); 
	         temp.changeUnits(Temperature.Units.CELSIUS);
	         assertTrue(inPrecision(temp.getValue(), 20-273.15));
	     }
	     @Test
	     public void test_changeUnits_KelvinToFahrenheit(){
	         System.out.println("Test if method changeUnits, changes the units of temperature from Kelvin to Fahrenheit and stores the correct value");
	         Temperature temp = new Temperature(40.1, Temperature.Units.KELVIN); 
	         temp.changeUnits(Temperature.Units.FAHRENHEIT);
	         assertTrue(inPrecision(temp.getValue(), (40.1 * 9.0/5.0 - 459.67)));
	     }
	     @Test
	     public void test_changeUnits_KelvinToKelvin(){
	         System.out.println("Test if method changeUnits, changes the units of temperature from Kelvin to Kelvin and stores the correct value");
	         Temperature temp = new Temperature(46.0, Temperature.Units.KELVIN); 
	         temp.changeUnits(Temperature.Units.KELVIN);
	         assertTrue(inPrecision(temp.getValue(), 46.0));
	     }
}
