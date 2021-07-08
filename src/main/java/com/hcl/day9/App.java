package com.hcl.day9;

import java.time.LocalTime;

public class App {
	public static void main(String[] args) {
//		try {
//			interThreadCommExample();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		changeNameAndSleep();
//		demoThread();
		printMultiples();
	}

	public static void interThreadCommExample() throws InterruptedException {
		InterThreadComm e1 = new InterThreadComm();
		Thread e2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					e1.even();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread e3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					e1.odd();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		e2.start();
		e3.start();
		e2.join(); // necessary for both threads?
		e3.join();
	}

	public static void changeNameAndSleep() {
		Thread t1 = Thread.currentThread();
		t1.setName("Thread 1");
		System.out.println(t1.getName());
		System.out.println(LocalTime.now());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(LocalTime.now());
	}

	@SuppressWarnings("unused")
	public static void demoThread() {
		DemoThread1 d1 = new DemoThread1();
		DemoThread1 d2 = new DemoThread1();
		DemoThread1 d3 = new DemoThread1();
	}

	public static void printMultiples() {
		Thread[] threads = { new Thread(new Number(2), "Harold"), new Thread(new Number(5), "Bobby"),
				new Thread(new Number(8), "Chris") };
		for (Thread thread : threads) {
			System.out.printf("Thread %s is in state %s\n", thread.getName(), thread.getState());
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Thread %s is in state %s\n", thread.getName(), thread.getState());
		}

	}
}
