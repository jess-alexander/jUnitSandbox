package com.jess.utilities;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jess on 5/12/17.
 */
@RunWith(Parameterized.class)
public class RemovePairsParameterized {

    private Utilities utilParam;
    private String input;
    private String output;

    public RemovePairsParameterized(String input, String output){
        this.input = input;
        this.output = output;
    }


    @Before
    public void setup(){
        utilParam = new Utilities();

    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG","AB8EFG"},
                {"112233445566","123456"},
                {"ZYZQQB","ZYZQB"},
                {"A","A"}
        });
    }

    @org.junit.Test
    public void removePairs_param(){
        assertEquals(output, utilParam.removePairs(input));
    }

}
