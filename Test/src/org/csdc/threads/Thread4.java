package org.csdc.threads;

import java.util.Map;

public class Thread4 implements Runnable {
	Map<String, Integer> map = null;
	
	public Thread4(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "Thread4").start();
	}

	@Override
	public void run() {
		map.put("D", 4);
		System.out.println("thread4 Sleeping");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
