package com.testing;

import com.binarysearch.*;
import org.junit.*;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertEquals;


public abstract class bisearchTest {
    protected abstractBisearch B;

    private void InfiniteLoopTest(Executable ex){
        assertTimeoutPreemptively(ofSeconds(10), ex);
    }

    private void step1_MakeOdd(){
        B.arr.add(2);
        B.arr.add(3);
        B.arr.add(5);
        B.arr.add(7);
        B.arr.add(11);
    }

    private void step2_MakeEven(){
        B.arr.add(13);
    }

    @Test
    public void valuePos() {
        step1_MakeOdd();
        InfiniteLoopTest(()->{
            B.valuePos(2);
            B.valuePos(3);
            B.valuePos(5);
            B.valuePos(7);
            B.valuePos(11);
            B.valuePos(1);
            B.valuePos(4);
            B.valuePos(6);
            B.valuePos(8);
            B.valuePos(9);
            B.valuePos(10);
            B.valuePos(12);
        });
        assertEquals(0,B.valuePos(2));
        assertEquals(1,B.valuePos(3));
        assertEquals(2,B.valuePos(5));
        assertEquals(3,B.valuePos(7));
        assertEquals(4,B.valuePos(11));
        assertEquals(-1,B.valuePos(1));
        assertEquals(-1,B.valuePos(4));
        assertEquals(-1,B.valuePos(6));
        assertEquals(-1,B.valuePos(8));
        assertEquals(-1,B.valuePos(9));
        assertEquals(-1,B.valuePos(10));
        assertEquals(-1,B.valuePos(12));

        step2_MakeEven();
        InfiniteLoopTest(()->{
            B.valuePos(2);
            B.valuePos(3);
            B.valuePos(5);
            B.valuePos(7);
            B.valuePos(11);
            B.valuePos(13);
            B.valuePos(1);
            B.valuePos(4);
            B.valuePos(6);
            B.valuePos(8);
            B.valuePos(9);
            B.valuePos(10);
            B.valuePos(12);
        });
        assertEquals(0,B.valuePos(2));
        assertEquals(1,B.valuePos(3));
        assertEquals(2,B.valuePos(5));
        assertEquals(3,B.valuePos(7));
        assertEquals(4,B.valuePos(11));
        assertEquals(5,B.valuePos(13));
        assertEquals(-1,B.valuePos(1));
        assertEquals(-1,B.valuePos(4));
        assertEquals(-1,B.valuePos(6));
        assertEquals(-1,B.valuePos(8));
        assertEquals(-1,B.valuePos(9));
        assertEquals(-1,B.valuePos(10));
        assertEquals(-1,B.valuePos(12));
        assertEquals(-1,B.valuePos(14));
    }

    @Test
    public void insertPos() {
        step1_MakeOdd();
        InfiniteLoopTest(()->{
            B.insertPos(1);
            B.insertPos(2);
            B.insertPos(3);
            B.insertPos(4);
            B.insertPos(5);
            B.insertPos(6);
            B.insertPos(7);
            B.insertPos(8);
        });
        assertEquals(0,B.insertPos(1));
        assertEquals(0,B.insertPos(2));
        assertEquals(1,B.insertPos(3));
        assertEquals(2,B.insertPos(4));
        assertEquals(2,B.insertPos(5));
        assertEquals(3,B.insertPos(6));
        assertEquals(3,B.insertPos(7));
        assertEquals(4,B.insertPos(8));
        assertEquals(4,B.insertPos(9));
        assertEquals(4,B.insertPos(10));
        assertEquals(4,B.insertPos(11));
        assertEquals(5,B.insertPos(12));

        step2_MakeEven();
        InfiniteLoopTest(()->{
            B.insertPos(1);
            B.insertPos(2);
            B.insertPos(3);
            B.insertPos(4);
            B.insertPos(5);
            B.insertPos(6);
            B.insertPos(7);
            B.insertPos(8);
        });
        assertEquals(0,B.insertPos(1));
        assertEquals(0,B.insertPos(2));
        assertEquals(1,B.insertPos(3));
        assertEquals(2,B.insertPos(4));
        assertEquals(2,B.insertPos(5));
        assertEquals(3,B.insertPos(6));
        assertEquals(3,B.insertPos(7));
        assertEquals(4,B.insertPos(8));
        assertEquals(4,B.insertPos(9));
        assertEquals(4,B.insertPos(10));
        assertEquals(4,B.insertPos(11));
        assertEquals(5,B.insertPos(12));
        assertEquals(5,B.insertPos(13));
        assertEquals(6,B.insertPos(14));
    }

    @Test
    public void nextLowestPos() {
        step1_MakeOdd();
        assertEquals(-1,B.nextLowestPos(1));
        assertEquals(-1,B.nextLowestPos(2));
        assertEquals(0,B.nextLowestPos(3));
        assertEquals(1,B.nextLowestPos(4));
        assertEquals(1,B.nextLowestPos(5));
        assertEquals(2,B.nextLowestPos(6));
        assertEquals(2,B.nextLowestPos(7));
        assertEquals(3,B.nextLowestPos(8));
        assertEquals(3,B.nextLowestPos(9));
        assertEquals(3,B.nextLowestPos(10));
        assertEquals(3,B.nextLowestPos(11));
        assertEquals(4,B.nextLowestPos(12));

        step2_MakeEven();
        assertEquals(-1,B.nextLowestPos(1));
        assertEquals(-1,B.nextLowestPos(2));
        assertEquals(0,B.nextLowestPos(3));
        assertEquals(1,B.nextLowestPos(4));
        assertEquals(1,B.nextLowestPos(5));
        assertEquals(2,B.nextLowestPos(6));
        assertEquals(2,B.nextLowestPos(7));
        assertEquals(3,B.nextLowestPos(8));
        assertEquals(3,B.nextLowestPos(9));
        assertEquals(3,B.nextLowestPos(10));
        assertEquals(3,B.nextLowestPos(11));
        assertEquals(4,B.nextLowestPos(12));
        assertEquals(4,B.nextLowestPos(13));
        assertEquals(5,B.nextLowestPos(14));
    }

    @Test
    public void nextHighestPos() {
        step1_MakeOdd();
        assertEquals(0,B.nextHighestPos(1));
        assertEquals(1,B.nextHighestPos(2));
        assertEquals(2,B.nextHighestPos(3));
        assertEquals(2,B.nextHighestPos(4));
        assertEquals(3,B.nextHighestPos(5));
        assertEquals(3,B.nextHighestPos(6));
        assertEquals(4,B.nextHighestPos(7));
        assertEquals(4,B.nextHighestPos(8));
        assertEquals(4,B.nextHighestPos(9));
        assertEquals(4,B.nextHighestPos(10));
        assertEquals(-1,B.nextHighestPos(11));
        assertEquals(-1,B.nextHighestPos(12));

        step2_MakeEven();
        assertEquals(0,B.nextHighestPos(1));
        assertEquals(1,B.nextHighestPos(2));
        assertEquals(2,B.nextHighestPos(3));
        assertEquals(2,B.nextHighestPos(4));
        assertEquals(3,B.nextHighestPos(5));
        assertEquals(3,B.nextHighestPos(6));
        assertEquals(4,B.nextHighestPos(7));
        assertEquals(4,B.nextHighestPos(8));
        assertEquals(4,B.nextHighestPos(9));
        assertEquals(4,B.nextHighestPos(10));
        assertEquals(5,B.nextHighestPos(11));
        assertEquals(5,B.nextHighestPos(12));
        assertEquals(-1,B.nextHighestPos(13));
        assertEquals(-1,B.nextHighestPos(14));
    }
}