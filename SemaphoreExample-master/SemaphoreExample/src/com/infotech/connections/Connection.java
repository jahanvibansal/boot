package com.infotech.connections;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection INSTANCE = new Connection();
	private int noOfCoonections;
	
	private Semaphore semaphore = new Semaphore(10, true);
	private Connection() {
		 
	 }
	
	public static Connection getConnection() {
		return INSTANCE;
	}
	
	public void connect() {
		
		try {
			semaphore.acquire();
			synchronized (this) {
				noOfCoonections++;
				System.out.println("Current connection:"+noOfCoonections);
			}
			
			Thread.sleep(2000);
			
			synchronized (this) {
				noOfCoonections--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(semaphore != null)
				semaphore.release();
		}
		
	}
}
