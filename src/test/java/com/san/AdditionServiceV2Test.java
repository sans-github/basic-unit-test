package com.san;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdditionServiceV2Test {

  static AdditionService additionService;

  @BeforeAll
  static void setUp() {
    additionService = new AdditionServiceImpl();
  }

  @Test
  void testAddSmallPositives() {
    exectuteAndAssert(2, 3);
  }

  @Test
  void testAddSmallAndLargePositives() {
    exectuteAndAssert(2, 32354);
  }

  @Test
  void testAddLargePositives() {
    exectuteAndAssert(23423, Integer.MAX_VALUE / 2);
  }

  @Test
  void testAddNegativePositive() {
    exectuteAndAssert(2, -5);
  }

  @Test
  void testAddNegativeLargePositive() {
    exectuteAndAssert(2, -5);
  }

  @Test
  void testAddLargeNegativePositive() {
    exectuteAndAssert(-Integer.MIN_VALUE / 2, 44);
  }

  @Test
  void testAddSmallNegatives() {
    exectuteAndAssert(-2, -5);
  }

  @Test
  void testAddLargeNegatives() {
    exectuteAndAssert(-Integer.MIN_VALUE / 2, -23523);
  }

  @Test
  void testPositiveOverlow() {
    executeAndAssertException(Integer.MAX_VALUE, 1);
  }

  @Test
  void testNegativeOverlow() {
    executeAndAssertException(Integer.MIN_VALUE, -1);
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
