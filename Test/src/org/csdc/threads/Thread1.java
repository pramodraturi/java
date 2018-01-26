package org.csdc.threads;

import java.util.Map;

public class Thread1 implements Runnable {
	Map<String, Integer> map = null;
	
	public Thread1(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "Thread1").start();
	}

	@Override
	public void run() {
		map.put("A", 1);
		System.out.println("thread1 Sleeping");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
