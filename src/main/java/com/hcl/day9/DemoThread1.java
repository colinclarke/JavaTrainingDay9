package com.hcl.day9;

public class DemoThread1 extends Thread {

	public DemoThread1() {
		this.start();
	}

	@Override
	public void run() {
		System.out.println("Running child thread in loop");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
