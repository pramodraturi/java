package multithreading.join;

import java.util.HashMap;
import java.util.Map;

public class SingleThread {
	
	public static Integer folderRSN=125;
	public volatile static String output = "";
	
	public static void main(String args[]) throws InterruptedException {
		
		SingleThreadTest singleThreadTest = new SingleThreadTest();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("1");
				singleThreadTest.getPeople(folderRSN);
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("2");
				singleThreadTest.getProperty(folderRSN);
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("3");
				singleThreadTest.getProcess(folderRSN);
			}
		});
		
		t1.start(); 
//		t1.join();
		t2.start();
//		t2.join();
		t3.start();
//		t3.join();
		
		System.out.println("Final Output:"+ output);
	}
}

class SingleThreadTest{
	
Map<Integer, String> peopleMap = new HashMap<>();
	
	{
		peopleMap.put(12345, "Tom");
		peopleMap.put(12379, "Smith");
		peopleMap.put(125, "Jack");
		peopleMap.put(19, "Van");
		peopleMap.put(45, "Harry");
	}
	
	 Map<Integer, String> propertyMap = new HashMap<>();
	
	{
		propertyMap.put(12345, "Delhi");
		propertyMap.put(12379, "Mumbai");
		propertyMap.put(125, "kolkata");
		propertyMap.put(19, "Ahamdabad");
		propertyMap.put(45, "Rishikesh");
	}
	
	 Map<Integer, String> processMap = new HashMap<>();
	
	{
		processMap.put(12345, "Product liability");
		processMap.put(12379, "Folder Status Change");
		processMap.put(125, "EF Process For Reviews");
		processMap.put(19, "EF Process for Inspections");
		processMap.put(45, "2017 Test Process");
	}
	
	public void getPeople(Integer folderRSN) {
		synchronized(SingleThread.output) {
			System.out.println("t1:"+SingleThread.output);
			if (peopleMap.containsKey(folderRSN)) {
				SingleThread.output = SingleThread.output + ",People: " + peopleMap.get(folderRSN);
			} else {
				SingleThread.output = SingleThread.output + ",People Not Found.";
			}
		}
	}
	
	public void getProperty(Integer folderRSN) {
		synchronized(SingleThread.output) {
			System.out.println("t2:"+SingleThread.output);
			if(propertyMap.containsKey(folderRSN)) {
				SingleThread.output = SingleThread.output + ",Property Found: "+propertyMap.get(folderRSN);
			}else {
				SingleThread.output = SingleThread.output + ",Property Not Found.";
			}
		}
	}
	
	public void getProcess(Integer folderRSN) {
		synchronized(SingleThread.output) {
			System.out.println("t3:"+SingleThread.output);
			if(processMap.containsKey(folderRSN)) {
				SingleThread.output = SingleThread.output + ",Process Found: "+processMap.get(folderRSN);
			}else {
				SingleThread.output = SingleThread.output + ",Process Not Found.";
			}
		}
	}
}