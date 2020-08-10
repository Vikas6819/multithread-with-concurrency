package vikas.mypack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	
	private String taskName;

	Task(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		
		
		for(int i=0;i<5;i++) {
			System.out.println("Task Name :: "+this.taskName+" :: Value :: "+i);
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

public class FixedThreadPool {

	public static void main(String[] args) {
		
		int coreSize=Runtime.getRuntime().availableProcessors();
		System.out.println("Available Processor Size :: "+coreSize);
		ExecutorService service=Executors.newFixedThreadPool(coreSize);
		
		for(int i=1;i<=10;i++) {
			service.execute(new Task("Task"+i));
		}
		service.shutdown();
	}

}
