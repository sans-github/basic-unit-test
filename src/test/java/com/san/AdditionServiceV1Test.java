package com.san;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionServiceV1Test {

  static AdditionService additionService;

  @BeforeAll
  static void setUp() {
    additionService = new AdditionServiceImpl();
  }

  @Test
  void testAdd() {
    int num1 = 3;
    int num2 = 4;

    int actual = additionService.add(num1, num2);
    int expected = ArithmeticUtils.addAndCheck(num1, num2);

    assertEquals(actual, expected);
  }

}
