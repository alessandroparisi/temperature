


import org.junit.* ;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.* ;

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
     
     //Test if changeUnits is changing the units and values correctly.
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
     @Test
     public void test_changeUnits_CelciusToCelcius(){
         System.out.println("Test if method changeUnits, changes the units of temperature from Celcius to Celcius and stores the correct value");
         Temperature temp = new Temperature(-32, Temperature.Units.CELSIUS); 
         temp.changeUnits(Temperature.Units.CELSIUS);
         assertTrue(inPrecision(temp.getValue(), -32));
     }
     @Test
     public void test_changeUnits_CelciusToFahrenheit(){
         System.out.println("Test if method changeUnits, changes the units of temperature from Celcius to Fahrenheit and stores the correct value");
         Temperature temp = new Temperature(2.32, Temperature.Units.CELSIUS); 
         temp.changeUnits(Temperature.Units.FAHRENHEIT);
         assertTrue(inPrecision(temp.getValue(), (275.47 * 9.0/5.0 - 459.67))); 
     }
     @Test
     public void test_changeUnits_CelciusToKelvin(){
         System.out.println("Test if method changeUnits, changes the units of temperature from Celcius to Kelvin and stores the correct value");
         Temperature temp = new Temperature(-22.77, Temperature.Units.CELSIUS); 
         temp.changeUnits(Temperature.Units.KELVIN);
         assertTrue(inPrecision(temp.getValue(), 250.38)); 
     }
     @Test
     public void test_changeUnits_FahrenheitToCelcius(){
         System.out.println("Test if method changeUnits, changes the units of temperature from Fahrenheit to Celcius and stores the correct value");
         Temperature temp = new Temperature(80.1, Temperature.Units.FAHRENHEIT); 
         temp.changeUnits(Temperature.Units.CELSIUS);
         assertTrue(inPrecision(temp.getValue(), (299.87 - 273.15)));  
     }
     @Test
     public void test_changeUnits_FahrenheitToFahrenheit(){
         System.out.println("Test if method changeUnits, changes the units of temperature from Fahrenheit to Fahrenheit and stores the correct value");
         Temperature temp = new Temperature(32.2, Temperature.Units.FAHRENHEIT); 
         temp.changeUnits(Temperature.Units.FAHRENHEIT);
         assertTrue(inPrecision(temp.getValue(), 32.2));
     }
     @Test
     public void test_changeUnits_FahrenheitToKelvin(){
         System.out.println("Test if method changeUnits, changes the units of temperature from Fahrenheit to Kelvin and stores the correct value");
         Temperature temp = new Temperature(22, Temperature.Units.FAHRENHEIT); 
         temp.changeUnits(Temperature.Units.KELVIN);
         assertTrue(inPrecision(temp.getValue(), ((22 + 459.67) * 5.0/9.0)));
     }
     
      //Testing if the method toString appropriatly converts the unit to a its respective string
     @Test
      public void test_convertUnitsToString_celcius (){
          System.out.println("Test if method unitsToString is converting Celcius to °C");
          Temperature temp = new Temperature(0, Temperature.Units.CELSIUS); 					
          assertTrue(temp.unitsToString().equals("°C")); 		
       }
     @Test
      public void test_convertUnitsToString_fahrenheit (){
          System.out.println("Test if method unitsToString is converting Fahrenheit to °F");
          Temperature temp = new Temperature(-1, Temperature.Units.FAHRENHEIT);							
          assertTrue(temp.unitsToString().equals("°F")); 		  
       }
     @Test
     
      public void test_convertUnitsToString_kelvin (){
          System.out.println("Test if method unitsToString is converting KELVIN to K");
          Temperature temp = new Temperature(22, Temperature.Units.KELVIN);   							
          assertTrue(temp.unitsToString().equals("K")); 		    
       }
      
     public boolean inPrecision(double expVal, double thVal){
    	 return ((expVal < (thVal + precision)) && (expVal  > (thVal - precision)));
     }
      
}
