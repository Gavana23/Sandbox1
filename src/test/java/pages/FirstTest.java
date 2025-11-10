package pages;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
   public String trialCode(int number) {
       if (number %3 == 0 && number %5 == 0) {
           return "S";
       } else if (number %5 == 0) {
           return "M";
       } else if (number %3 == 0) {
           return "T";
       } else return "FAIL";
   }

   @Test
    public void letterTest() {
       String actualResult = trialCode(9);
       assertEquals(actualResult, "T");
   }

    @Test
    public void letterSecondTest() {
        String actualResult = trialCode(10);
        assertEquals(actualResult, "M");
    }

    @Test
    public void letterThirdTest() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "S");
    }

    @Test
    public void letterFourthTest() {
        String actualResult = trialCode(1);
        assertEquals(actualResult, "FAIL");
    }

}
