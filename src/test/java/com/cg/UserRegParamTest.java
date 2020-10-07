package com.cg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UserRegParamTest {
    private String email;
    private boolean expectedOutput;
    private UserReg userReg;

    public UserRegParamTest(String email, boolean expectedOutput) {
        this.email = email;
        this.expectedOutput = expectedOutput;
    }
    @Before
    public void initialize(){
        userReg = new UserReg("Abhishek", "Das", "abh.100@gmail.co", "91 9953503212", "Abhishek@1");
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][] {{"abc@yahoo.com", true} ,
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc@gmail.com.com", true},
                {"abc", false},
                {"abc@.com.my", false},
                {"abc123@gmail.a", false},
                {"abc123@.com", false},
                {"abc123@.com.com", false},
                {".abc@abc.com", false},
                {"abc()*@gmail.com", false},
                {"abc@%*.com", false},
                {"abc..2002@gmail.com", false},
                {"abc.@gmail.com", false},
                {"abc@abc@gmail.com", false},
                {"abc@gmail.com.1a", false},
                {"abc@gmail.com.aa.au", false}});
    }

    @Test
    public void testEmailSamples(){
        Assert.assertEquals(expectedOutput, userReg.validateEmail(email));
    }
}
