package com.testing;

import com.binarysearch.bisearchesA;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

class bisearchesATest {
    bisearchesA B;

    @BeforeEach
    void setUp() {
        B = new bisearchesA();
    }

    private void InfiniteLoopTest(Executable ex){
        assertTimeoutPreemptively(ofSeconds(6), ex);
    }

    private void step1_MakeOdd(){
        B.arr.add(2);
        B.arr.add(3);
        B.arr.add(5);
    }

    private void step2_MakeEven(){
        B.arr.add(7);
    }

    @Test
    void valuePos() {
        step1_MakeOdd();
        InfiniteLoopTest(()->{
            B.valuePos(2);
            B.valuePos(3);
            B.valuePos(5);
            B.valuePos(1);
            B.valuePos(4);
            B.valuePos(7);
        });
        assertEquals(0,B.valuePos(2));
        assertEquals(1,B.valuePos(3));
        assertEquals(2,B.valuePos(5));
        assertEquals(-1,B.valuePos(1));
        assertEquals(-1,B.valuePos(4));
        assertEquals(-1,B.valuePos(7));

        step2_MakeEven();
        InfiniteLoopTest(()->{
            B.valuePos(2);
            B.valuePos(3);
            B.valuePos(5);
            B.valuePos(7);
            B.valuePos(1);
            B.valuePos(11);
        });
        assertEquals(0,B.valuePos(2));
        assertEquals(1,B.valuePos(3));
        assertEquals(2,B.valuePos(5));
        assertEquals(3,B.valuePos(7));
        assertEquals(-1,B.valuePos(1));
        assertEquals(-1,B.valuePos(4));
        assertEquals(-1,B.valuePos(6));
        assertEquals(-1,B.valuePos(11));
    }

    @Test
    void insertPos() {
        step1_MakeOdd();
        InfiniteLoopTest(()->{
            B.insertPos(1);
            B.insertPos(2);
            B.insertPos(3);
            B.insertPos(4);
            B.insertPos(5);
            B.insertPos(6);
        });
        assertEquals(0,B.insertPos(1));
        assertEquals(0,B.insertPos(2));
        assertEquals(1,B.insertPos(3));
        assertEquals(2,B.insertPos(4));
        assertEquals(2,B.insertPos(5));
        assertEquals(3,B.insertPos(6));

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
    }

    @Test
    void nextLowestPos() {
        step1_MakeOdd();
        InfiniteLoopTest(()->{
            B.nextLowestPos(1);
            B.nextLowestPos(2);
            B.nextLowestPos(3);
            B.nextLowestPos(4);
            B.nextLowestPos(5);
            B.nextLowestPos(6);
        });
        assertEquals(-1,B.nextLowestPos(1));
        assertEquals(-1,B.nextLowestPos(2));
        assertEquals(0,B.nextLowestPos(3));
        assertEquals(1,B.nextLowestPos(4));
        assertEquals(1,B.nextLowestPos(5));
        assertEquals(2,B.nextLowestPos(6));

        step2_MakeEven();
        InfiniteLoopTest(()->{
            B.nextLowestPos(1);
            B.nextLowestPos(2);
            B.nextLowestPos(3);
            B.nextLowestPos(4);
            B.nextLowestPos(5);
            B.nextLowestPos(6);
            B.nextLowestPos(7);
            B.nextLowestPos(8);
        });
        assertEquals(-1,B.nextLowestPos(1));
        assertEquals(-1,B.nextLowestPos(2));
        assertEquals(0,B.nextLowestPos(3));
        assertEquals(1,B.nextLowestPos(4));
        assertEquals(1,B.nextLowestPos(5));
        assertEquals(2,B.nextLowestPos(6));
        assertEquals(2,B.nextLowestPos(7));
        assertEquals(3,B.nextLowestPos(8));
    }

    @Test
    void nextHighestPos() {
        step1_MakeOdd();
        InfiniteLoopTest(()->{
            B.nextHighestPos(1);
            B.nextHighestPos(2);
            B.nextHighestPos(3);
            B.nextHighestPos(4);
            B.nextHighestPos(5);
            B.nextHighestPos(6);
        });
        assertEquals(0,B.nextHighestPos(1));
        assertEquals(1,B.nextHighestPos(2));
        assertEquals(2,B.nextHighestPos(3));
        assertEquals(2,B.nextHighestPos(4));
        assertEquals(-1,B.nextHighestPos(5));
        assertEquals(-1,B.nextHighestPos(6));

        step2_MakeEven();
        InfiniteLoopTest(()->{
            B.nextHighestPos(1);
            B.nextHighestPos(2);
            B.nextHighestPos(3);
            B.nextHighestPos(4);
            B.nextHighestPos(5);
            B.nextHighestPos(6);
            B.nextHighestPos(7);
            B.nextHighestPos(8);
        });
        assertEquals(0,B.nextHighestPos(1));
        assertEquals(1,B.nextHighestPos(2));
        assertEquals(2,B.nextHighestPos(3));
        assertEquals(2,B.nextHighestPos(4));
        assertEquals(3,B.nextHighestPos(5));
        assertEquals(3,B.nextHighestPos(6));
        assertEquals(-1,B.nextHighestPos(7));
        assertEquals(-1,B.nextHighestPos(8));
    }
}