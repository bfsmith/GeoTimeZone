package com.github.bfsmith.geotimezone.test.app;

import com.github.bfsmith.geotimezone.TimeZoneLookup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SyncTest {
  @Test
  public void testThreadSafety() {
    List<Thread> threads = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      threads.add(new Thread(new Run()));
    }
    for (Thread thread : threads) {
      thread.start();
    }
    for (Thread thread : threads) {
      while(thread.isAlive()) {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static class Run implements Runnable {
    @Override
    public void run() {
      TimeZoneLookup timeZoneLookup = new TimeZoneLookup();
      Random random = new Random();
      for (int i = 0; i < 100000; i++) {
        timeZoneLookup.getTimeZone(random.nextDouble() * 900 - 45, random.nextDouble() * 180 - 90);
      }
    }
  }
}
