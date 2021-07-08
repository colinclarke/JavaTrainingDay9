package com.hcl.day9;

public class Number implements Runnable {

	int num;

	public Number(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("Begin running thread " + Thread.currentThread().getName());
		for (int i = 0; i < 5; i++) {
			System.out.println(num * (i + 1));
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " Finished running");
	}

}
