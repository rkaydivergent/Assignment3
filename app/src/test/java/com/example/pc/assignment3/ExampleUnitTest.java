package com.example.pc.assignment3;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }
    /**
     * Test for addition with a negative operand
     */
    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }
    /**
     * Test for addition where the result is negative
     */
    @Test
    public void addTwoNumbersWorksWithNegativeResult() {
        double resultAdd = mCalculator.add(-1d, -17d);
        assertThat(resultAdd, is(equalTo(-18d)));
    }
    /**
     * Test for floating-point addition
     */
    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111d, 1.111d);
        assertThat(resultAdd, is(equalTo(2.222)));
    }

    /**
     * Test for especially large numbers
     */
    @Test
    public void addTwoNumbersBignums() {
        double resultAdd = mCalculator.add(123456781d, 111111111d);
        assertThat(resultAdd, is(equalTo(234567892d)));
    }
    /**
     * Test for simple subtraction
     */
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }

    /**
     * Test for simple subtraction with a negative result
     */
    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 17d);
        assertThat(resultSub, is(equalTo(-16d)));
    }

    /**
     * Test for simple division
     */
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv, is(equalTo(16d)));
    }

    /**
     * Test for divide by zero; must throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void divDivideByZeroThrows() {
        mCalculator.div(32d,0d);
    }

    /**
     * Test for simple multiplication
     */
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));

    }

    /**
     ************************ ASSIGNMENT BELOW*************************************
     *
     * Test for simple power positive operands
     */
    @Test
    public void powPositiveOperands() {
        double resultPow = mCalculator.pow(5d, 2d);
        assertThat(resultPow, is(equalTo(25d)));
    }
    @Test
    public void powNegativeFirst() {
        double resultPow = mCalculator.pow(-5d, 2d);
        assertThat(resultPow, is(equalTo(25d)));
    }
    @Test
    public void powNegativeSecond() {
        double resultPow = mCalculator.pow(5d, -2d);
        assertThat(resultPow, is(equalTo(0.04d)));
    }
    @Test
    public void powZeroFirst() {
        double resultPow = mCalculator.pow(0d, 2d);
        assertThat(resultPow, is(equalTo(0.0d)));
    }
    @Test
    public void powZeroSecond() {
        double resultPow = mCalculator.pow(2d, 0d);
        assertThat(resultPow, is(equalTo(1.0d)));
    }
    @Test (expected =ArithmeticException.class)
    public void powZeroAndNegOne() {
        mCalculator.pow(0d, -1d);
        // double resultPow = mCalculator.pow(0d, -1d);
        //  assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test (expected = ArithmeticException.class)
    public void powNegZeroAndNegative() {
        mCalculator.pow(-0d, -4d);
        //  double resultPow = mCalculator.pow(-0d, -4d);
        //   assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}