package test;

/*
 * Test Type: Test Suite of unit tests and integration tests.
 * Author: Michael Haskell
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestTournament.class, TestDraftModel.class})
public class RussoTestSuite {

}