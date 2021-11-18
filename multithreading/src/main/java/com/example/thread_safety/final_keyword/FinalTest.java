package com.example.thread_safety.final_keyword;

public class FinalTest {

    final String str = new String("hello");

    void method() {
        str = "world";
    }
    
}

/**
 * Compilation Error in java code :- 
prog.java:14: error: cannot assign a value to final variable str
        str = "world";
        ^
1 error
 */
