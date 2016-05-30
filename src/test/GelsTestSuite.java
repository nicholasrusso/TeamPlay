package test;

import org.junit.experimental.theories.suppliers.TestedOnSupplier;

/*
 * Test Type: Test Suite of unit tests and integration tests for classes in User Package.
 * Author: Charlie Gels
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestUser.class, TestEmail.class, TestEditorPasswordField.class,
    TestEditorTextField.class, TestRegistration.class})
public class GelsTestSuite {

}