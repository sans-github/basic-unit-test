package com.san;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdditionServiceV3Test {

  static AdditionService additionService;

  @BeforeAll
  static void setUp() {
    additionService = new AdditionServiceImpl();
  }

  @ParameterizedTest(name = "{0}+{1}")
  @CsvSource({ "2, 3", "2, 32354", "23423, 1073741823", "1, 3", "16, 6", "233, 3", "644, 4", "1073741823, 2", "1073741998, 4"})
  void testAddPositives(int num1, int num2) {
    exectuteAndAssert(num1, num2);
  }

  @ParameterizedTest(name = "{0}+{1}")
  @CsvSource({ "-2, -5", "-23523, -1073741823", "-7, -3", "-1, -3", "-16, -6", "-233, -3", "-644, -4", "-1073741823, -2", "-1073741998, -4"})
  void testAddNegatives(int num1, int num2) {
    exectuteAndAssert(num1, num2);
  }

  @ParameterizedTest(name = "{0}+{1}")
  @CsvSource({ "2147483647, 1", "34455, 2147483000", "-2147483648, -1", "-11, -2147483648"})
  void testOverflow(int num1, int num2) {
    executeAndAssertException(num1, num2);
  }
  
  private void exectuteAndAssert(int num1, int num2) {
    int actual = additionService.add(num1, num2);
    int expected = ArithmeticUtils.addAndCheck(num1, num2);

    assertEquals(actual, expected);
  }

  private void executeAndAssertException(int num1, int num2) {
    final MathArithmeticException exception = assertThrows(MathArithmeticException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        exectuteAndAssert(num1, num2);
      }
    }, "MathArithmeticException was expected.");
    assertTrue(exception.getMessage().contains("overflow in addition"));
  }
}
