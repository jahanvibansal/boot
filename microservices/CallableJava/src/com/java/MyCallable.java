package com.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService pool= Executors.newSingleThreadExecutor();
		Future<Integer> result=pool.submit(()->{
			return doSum();
		});
		Thread.sleep(10);
		System.out.println("Came without result: "+ Thread.currentThread().getName());
		System.out.println("Will wait for max 1 millisec to get result");
		System.out.println(result.get(1, TimeUnit.MILLISECONDS));
		System.out.println("The task is executed asynchronously! Call to get is blocking");
		pool.shutdown();
	}

	private static Integer doSum() {
		int sum=0;
		for(int i=0; i<=100000000; i++) {
		//	System.out.println(i+ Thread.currentThread().getName());
		sum=sum+i;
		}
		return sum;
	}

}
