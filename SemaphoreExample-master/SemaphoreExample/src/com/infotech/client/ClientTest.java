package com.infotech.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.infotech.connections.Connection;

public class ClientTest {
	
	public static void main(String args[]) {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newCachedThreadPool();
			
			for (int i = 1; i <=300; i++) {
				executorService.submit(new Runnable() {
					
					@Override
					public void run() {
						Connection.getConnection().connect();
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(executorService != null)
				executorService.shutdown();
		}
	}
}
