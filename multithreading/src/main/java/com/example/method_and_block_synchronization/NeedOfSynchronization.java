package com.example.method_and_block_synchronization;

public class NeedOfSynchronization {
    public static void main(String[] args) {
        Multithread t = new Multithread();
        t.increment();
        System.out.println(t.getValue());
    }
}

/**
 * In above example three operations are performed:

Fetch the value of variable i.
Increment the fetched value.
And store the increased value of i to its location.
Here,

1st thread fetches the value of i. (Currently value i is 0) and increases it by one, so value of variable i becomes 1.
Now 2nd thread accesses the value of i that would be 0 as 1st thread did not store it back to its location.
And 2nd thread also increment it and store it back to its location. And 1st also store it.
Finally value of variable i is 1. But it should be 2 by the effect of both threads. That’s why we need to synchronize the access to shared variable i.
 */


