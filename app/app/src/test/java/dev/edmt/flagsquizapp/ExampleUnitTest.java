package dev.edmt.flagsquizapp;

import android.view.View;

import org.junit.Test;

import dev.edmt.flagsquizapp.Common.Common;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    public class ExampleUnitTest {
        @Test
        public void addition_isCorrect() throws Exception {
            Common = new Common();

            int expected = 4;
            assertEquals(expected, 1);
        }
    }
}