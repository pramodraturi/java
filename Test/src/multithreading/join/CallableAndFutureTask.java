package multithreading.join;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTask {
	
	static Integer folderRSN = 125;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FutureTask[] futureTasks = new FutureTask[3]; 
		
		futureTasks[0] = new FutureTask<String>(new People(folderRSN));
		futureTasks[1] = new FutureTask<String>(new Property(folderRSN));
		futureTasks[2] = new FutureTask<String>(new Process(folderRSN));
		
		Thread t1 = new Thread(futureTasks[0]);
		Thread t2 = new Thread(futureTasks[2]);
		Thread t3 = new Thread(futureTasks[1]);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			String finalOutput = futureTasks[0].get().toString() +", "+ futureTasks[1].get().toString() +", "+futureTasks[2].get().toString();
			System.out.println("Output: "+finalOutput);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class People implements Callable<String>{

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
	public String call() {
		if (peopleMap.containsKey(folderRSN)) {
			return "People: " + peopleMap.get(folderRSN);
		} else {
			return "People Not Found.";
		}
	}
}


class Property implements Callable<String>{

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
	public String call() {
		if(propertyMap.containsKey(folderRSN)) {
			return "Property Found: "+propertyMap.get(folderRSN);
		}else {
			return "Property Not Found.";
		}
	}
}

class Process implements Callable<String>{

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
	public String call() {
		if(processMap.containsKey(folderRSN)) {
			return "Process Found: "+processMap.get(folderRSN);
		}else {
			return "Process Not Found.";
		}
	}
}