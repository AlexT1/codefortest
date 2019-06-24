package com.alexstudy.baseextend;

/**
 * @ClassName SyncDemo
 * @Description
 * @Author AlexTong
 * @Date 2019/4/13
 */
public class SynchDemo implements Runnable {
    static int k;                                 // value default is 0
    public void run()
    {
        synchronized(this)
        {
            for(int i = 0; i < 10000; i++)
            {
                k++;		                        // increments by one
                k--;                                    // decrements by one
            }
        }
    }
    public static void main(String[] args) {
        SynchDemo sd = new SynchDemo();
        Thread bundle[] = new Thread[100];
        for(int i=0; i<bundle.length; i++)
        {
            bundle[i] = new Thread(sd);
            bundle[i].start();
        }
        System.out.print("Final result: " + k);
    }
}