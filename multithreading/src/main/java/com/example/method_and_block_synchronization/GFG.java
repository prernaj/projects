package com.example.method_and_block_synchronization;


import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Geek gk = new Geek();
        List<String> list = new ArrayList<>();
        gk.geekName("prerna", list);
        System.out.println(gk.name);
    }
}
