package com.infotech.client;

import java.util.concurrent.Semaphore;

public class Test {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		semaphore.release();
		System.out.println(semaphore.availablePermits());
	}

}
