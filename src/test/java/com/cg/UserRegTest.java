package com.cg;

import org.junit.Assert;
import org.junit.Test;

public class UserRegTest {
    UserReg userReg = new UserReg("Abhishek", "Das", "ard.2238@cg.co.in", "91 9876543210", "Abhishek@11");
    @Test
    public void testNames(){
        boolean val_FName = userReg.validateName("Abhishek");
        boolean val_NotFName = userReg.validateName("ab");
        Assert.assertEquals(true, val_FName);
        Assert.assertEquals(false, val_NotFName);
    }

    @Test
    public void testEmail(){
        boolean val_Email = userReg.validateEmail("abhishek.100@cap.co.in");
        boolean val_NotEmail = userReg.validateEmail("@.cap.c");
        Assert.assertEquals(true, val_Email);
        Assert.assertEquals(false, val_NotEmail);
    }

    @Test
    public void testMobile(){
        boolean val_Mobile = userReg.validateMobile("91 9876543210");
        boolean val_NotMobile = userReg.validateMobile("9876543210");
        Assert.assertEquals(true, val_Mobile);
        Assert.assertEquals(false, val_NotMobile);
    }

    @Test
    public void testPassword(){
        boolean val_Pass = userReg.validatePassword("Abhishek@1");
        boolean val_NotPass = userReg.validatePassword("abhishek");
        Assert.assertEquals(true, val_Pass);
        Assert.assertEquals(false, val_NotPass);
    }
}
