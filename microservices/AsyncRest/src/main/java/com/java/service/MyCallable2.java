package com.java.service;

import java.util.concurrent.Callable;

public class MyCallable2 implements Callable<Integer>{
@Override
	public Integer call() throws Exception {

			int sum=0;
			for(int i=0; i<=10000; i++) {
					System.out.println(i+ Thread.currentThread().getName());
				sum=sum+i;
				}
				return sum;
	}



}
