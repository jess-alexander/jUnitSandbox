package com.jess.banking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jess on 5/12/17.
 */
public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count ="+count++);
    }
    @org.junit.Before
    public void setup(){
        account = new BankAccount("Jess","Alexander",1000.00, BankAccount.CHECKING);
        System.out.println("running a test....");
    }

    @org.junit.Test
    public void isChecking_true() throws Exception {
        assertTrue("The account is NOT a checking account",account.isChecking());
    }

    @org.junit.Test
    public void isSavings_false() throws Exception{
        assertFalse("The account is a CHECKING account",account.isSavings());
    }

    @org.junit.Test
    public void deposit() throws Exception {
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
        // the third param is a range of error. 0 means exactly the same

    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
        // the third param is a range of error. 0 means exactly the same

    }

    // change annotation to expect an exception because withdrawing 600 from a non-branch location is not allowed
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException");
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200.00, true);
        // the third param is a range of error. 0 means exactly the same
        assertEquals(1200, account.getBalance(),0);
    }

    @org.junit.Test
    public void getBalance_withdrawl() throws Exception {
        account.withdraw(200.00, true);
        // the third param is a range of error. 0 means exactly the same
        assertEquals(800, account.getBalance(),0);
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after any test class. Count = "+count++);
    }

    @org.junit.After
    public void teardown(){
        System.out.println("Count = "+count++);
    }
}