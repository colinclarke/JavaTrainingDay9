package com.hcl.day9;

public class InterThreadComm {

	boolean flag = true;

	synchronized void even() throws InterruptedException {

		for (int i = 2; i <= 10; i += 2) {
			if (!flag) {
				System.out.println("Even waiting...");
				wait();
			}
			if (i % 2 == 0) {
				System.out.println(i + "-even-");
			}
			flag = false;
			notify();
		}
	}

	synchronized void odd() throws InterruptedException {

		for (int i = 3; i <= 10; i += 2) {
			if (flag) {
				System.out.println("Odd waiting...");
				wait();
			}
			if (i % 2 != 0) {
				System.out.println(i + "-odd-");
			}
			flag = true;
			notify();
		}
	}

}

class ItcEven extends Thread {

	private InterThreadComm no;

	public ItcEven(InterThreadComm no) {
		this.no = no;
	}

	@Override
	public void run() {

		try {
			no.even();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ItcOdd extends Thread {

	private InterThreadComm no;

	public ItcOdd(InterThreadComm no) {
		this.no = no;
	}

	@Override
	public void run() {

		try {
			no.odd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}