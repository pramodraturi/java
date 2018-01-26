package org.csdc.threads;

import java.util.Map;

public class Thread2 implements Runnable {
	Map<String, Integer> map = null;
	
	public Thread2(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "Thread2").start();
	}

	@Override
	public void run() {
		map.put("B", 2);
		System.out.println("thread2 Sleeping");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
