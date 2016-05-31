package test;

/*
 * Test Type: Test Suite of unit tests and integration tests.
 * Author: Spencer Sprowls
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDefender.class, TestForward.class, TestGoalKeeper.class, TestMidfielder.class})
public class SprowlsTestSuite {

}