package com.teamnet.zerotohero;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;

import static javax.management.Query.not;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Iordan.Serdin on 7/10/2017.
 */
public class MyUnitTest {
    @Test
    public void testConcatenate(){
        MyUnit m=new MyUnit();
        String result=m.concatenate("one","two");
        assertEquals("onetwo",result);
    }
    @Test
    public void testConcatenateNulls(){
        MyUnit m=new MyUnit();
        String result=m.concatenate(null,null);
        assertEquals(null,result);

        String result2=m.concatenate("one",null);
        assertEquals("one",result2);
    }

    @Test
    public void testGetBoolean(){
        MyUnit m=new MyUnit();
        //assertTrue(m.getBoolean());   //assertTrue este daca metoda e true
       // assertNotNull(m.getBoolean());
        //assertTrue((Boolean)m.getBoolean() instanceof Boolean);
        //assertThat()    //verifica ca
        assertThat(123,is(123));
        //assertThat("a",not(is("b")));
        //assertThat("a",not(is("b")));
    }


}
