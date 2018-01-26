package multithreading;

import java.util.HashMap;
import java.util.Map;

public class ThreadTest {
	
	static Integer folderRSN = 125;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Process processThread = new Process(folderRSN);
		
		Thread peopleThread = new Thread(new People(folderRSN));
		Thread propertyThread = new Thread(new Property(folderRSN));
		
		peopleThread.start();
		propertyThread.start();
		processThread.start();
		
	}
}

class People implements Runnable{

	Integer folderRSN;
	Map<Integer, String> peopleMap = new HashMap<>();
	
	{
		peopleMap.put(12345, "Tom");
		peopleMap.put(12379, "Smith");
		peopleMap.put(125, "Jack");
		peopleMap.put(19, "Van");
		peopleMap.put(45, "Harry");
	}
	
	public People(Integer folderRSN) {
		this.folderRSN = folderRSN;
	}
	
	@Override
	public void run() {
		if(peopleMap.containsKey(folderRSN)) {
			System.out.println("People Found: "+peopleMap.get(folderRSN));
		}else {
			System.err.println("People Not Found.");
		}
	}
}


class Property implements Runnable{

	Integer folderRSN;
	Map<Integer, String> propertyMap = new HashMap<>();
	
	{
		propertyMap.put(12345, "Delhi");
		propertyMap.put(12379, "Mumbai");
		propertyMap.put(125, "kolkata");
		propertyMap.put(19, "Ahamdabad");
		propertyMap.put(45, "Rishikesh");
	}
	
	public Property(Integer folderRSN) {
		this.folderRSN = folderRSN;
	}
	
	@Override
	public void run() {
		if(propertyMap.containsKey(folderRSN)) {
			System.out.println("Property Found: "+propertyMap.get(folderRSN));
		}else {
			System.err.println("Property Not Found.");
		}
	}
}

class Process extends Thread{

	Integer folderRSN;
	Map<Integer, String> processMap = new HashMap<>();
	
	{
		processMap.put(12345, "Product liability");
		processMap.put(12379, "Folder Status Change");
		processMap.put(125, "EF Process For Reviews");
		processMap.put(19, "EF Process for Inspections");
		processMap.put(45, "2017 Test Process");
	}
	
	public Process(Integer folderRSN) {
		this.processMap = processMap;
		this.folderRSN = folderRSN;
	}
	
	@Override
	public void run() {
		if(processMap.containsKey(folderRSN)) {
			System.out.println("Process Found: "+processMap.get(folderRSN));
		}else {
			System.err.println("Process Not Found.");
		}
	}
}