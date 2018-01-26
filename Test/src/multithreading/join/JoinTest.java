package multithreading.join;

public class JoinTest {
	
	public static void main(String args[]) throws InterruptedException {
		
		Thread t1 = new Thread(new Thread1(),"Thread 1");
		Thread t2 = new Thread(new Thread2(),"Thread 2");
		Thread t3 = new Thread(new Thread3(),"Thread 3");
		
		//Random execution of threads.
//		t1.start();
//		t2.start();
//		t3.start();
		
		//Sequential execution of threads.
		t1.start();
		t1.join();
		
		t2.start();
		t2.join();
		
		t3.start();
		t3.join();
		
	}
}

class Thread1 implements Runnable{
	
	@Override
	public void run() {
		for(Integer i = 0;i<200;i++) {
			System.out.println(Thread.currentThread().getName() + "- Count: "+i);
		}
	}
}

class Thread2 implements Runnable{
	
	@Override
	public void run() {
		for(Integer i = 0;i<200;i++) {
			System.out.println(Thread.currentThread().getName() + "- Count: "+i);
		}
	}
}

class Thread3 implements Runnable{
	
	@Override
	public void run() {
		for(Integer i = 0;i<200;i++) {
			System.out.println(Thread.currentThread().getName() + "- Count: "+i);
		}
	}
}