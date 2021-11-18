package com.example.method_and_block_synchronization;


import java.io.*;
import java.util.*;

public class Geek {
    String name = "";
    public int count = 0;

    public void geekName(String geek, List<String> list) {

        synchronized(this) {
            name = geek;
            count++;
        }

        list.add(geek);
    }
}
