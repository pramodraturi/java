package org.csdc.threads;

import java.util.Map;

public class Thread3 implements Runnable {
	Map<String, Integer> map = null;
	
	public Thread3(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "Thread3").start();
	}

	@Override
	public void run() {
		map.put("C", 3);
		System.out.println("thread3 Sleeping");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
