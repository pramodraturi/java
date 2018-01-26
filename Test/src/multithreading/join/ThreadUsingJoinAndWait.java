package multithreading.join;

import java.util.HashMap;
import java.util.Map;

public class ThreadUsingJoinAndWait {
	
	static Integer folderRSN = 125;
	public static String output = "";
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ProcessTest processThread = new ProcessTest(folderRSN);
		
		Thread peopleThread = new Thread(new PeopleTest(folderRSN));
		Thread propertyThread = new Thread(new PropertyTest(folderRSN));
		
		peopleThread.start();
		peopleThread.join();
		propertyThread.start();
		propertyThread.join();
		processThread.start();
		processThread.join();
		
		System.out.println("Output : "+ output);
	}
}

class PeopleTest implements Runnable{

	Integer folderRSN;
	Map<Integer, String> peopleMap = new HashMap<>();
	
	{
		peopleMap.put(12345, "Tom");
		peopleMap.put(12379, "Smith");
		peopleMap.put(125, "Jack");
		peopleMap.put(19, "Van");
		peopleMap.put(45, "Harry");
	}
	
	public PeopleTest(Integer folderRSN) {
		this.folderRSN = folderRSN;
	}
	
	@Override
	public void run() {
		synchronized (ThreadUsingJoinAndWait.output) {
			if(peopleMap.containsKey(folderRSN)) {
				ThreadUsingJoinAndWait.output = ThreadUsingJoinAndWait.output + " People Found: "+peopleMap.get(folderRSN);
			}else {
				ThreadUsingJoinAndWait.output = ThreadUsingJoinAndWait.output +" People Not Found.";
			}
		}
	}
}


class PropertyTest implements Runnable{

	Integer folderRSN;
	Map<Integer, String> propertyMap = new HashMap<>();
	
	{
		propertyMap.put(12345, "Delhi");
		propertyMap.put(12379, "Mumbai");
		propertyMap.put(125, "kolkata");
		propertyMap.put(19, "Ahamdabad");
		propertyMap.put(45, "Rishikesh");
	}
	
	public PropertyTest(Integer folderRSN) {
		this.folderRSN = folderRSN;
	}
	
	@Override
	public void run() {
		synchronized (ThreadUsingJoinAndWait.output) {
			if(propertyMap.containsKey(folderRSN)) {
				ThreadUsingJoinAndWait.output = ThreadUsingJoinAndWait.output + ", Property Found: "+propertyMap.get(folderRSN);
			}else {
				ThreadUsingJoinAndWait.output = ThreadUsingJoinAndWait.output + ", Property Not Found.";
			}
		}
	}
}

class ProcessTest extends Thread{

	Integer folderRSN;
	Map<Integer, String> processMap = new HashMap<>();
	
	{
		processMap.put(12345, "Product liability");
		processMap.put(12379, "Folder Status Change");
		processMap.put(125, "EF Process For Reviews");
		processMap.put(19, "EF Process for Inspections");
		processMap.put(45, "2017 Test Process");
	}
	
	public ProcessTest(Integer folderRSN) {
		this.folderRSN = folderRSN;
	}
	
	@Override
	public void run() {
		synchronized (ThreadUsingJoinAndWait.output) {
			if(processMap.containsKey(folderRSN)) {
				ThreadUsingJoinAndWait.output = ThreadUsingJoinAndWait.output +", Process Found: "+processMap.get(folderRSN);
			}else {
				ThreadUsingJoinAndWait.output = ThreadUsingJoinAndWait.output +", Process Not Found.";
			}
		}
		
	}
}