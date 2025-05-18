import org.junit.Assert;
import org.junit.Test;

public class TestClass {

     public Calculator calc = new Calculator();

     @Test
     public void TestAddGeneral() {
          Assert.assertEquals(30, calc.add(20, 10));
     }

     @Test
     public void TestAddNegative() {
          Assert.assertEquals(-1, calc.add(10, -1));
     }

     @Test
     public void TestAddNegative2() {
          Assert.assertEquals(-1, calc.add(-65, 2));
     }

     @Test
     public void TestAddMax() {
          Assert.assertEquals(-1, calc.add(1, Integer.MAX_VALUE));
     }

     // ------------- sub-------------------
     @Test
     public void TestSubGeneral() {
          Assert.assertEquals(22, calc.sub(30, 8));
     }

     @Test
     public void TestSubNegative() {
          Assert.assertEquals(-1, calc.sub(-30, 8));
     }

     @Test
     public void TestSubNegative2() {
          Assert.assertEquals(-1, calc.sub(14, -3));
     }

     // ------------- div-------------------
     @Test
     public void TestDivGeneral() {
          Assert.assertEquals(5, calc.divide(25, 5));
     }

     @Test
     public void TestDivZero() {
          Assert.assertEquals(-1, calc.divide(25, 0));
     }

     // ------------- sum-------------------
     @Test
     public void TestSumGeneral(){
          Assert.assertEquals(54,calc.sum(18,3));
     }
     @Test
     public void TestSumMax(){
          Assert.assertEquals(-1,calc.sum(Integer.MAX_VALUE, 3));

     }
}
