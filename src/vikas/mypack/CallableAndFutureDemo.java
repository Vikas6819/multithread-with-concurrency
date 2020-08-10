package vikas.mypack;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

class Work implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		return new Random().nextInt();
	}
	
	
}
public class CallableAndFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		ExecutorService exService=Executors.newSingleThreadExecutor();
		
		Future<Integer> future=exService.submit(new Work());
		int val=future.get();//its a blocking operation ,it will block the execution until it gets result from call method
		//int val=future.get(2000,TimeUnit.MILLISECONDS);
		System.out.println("Output :: "+val);
	}

}
//As get() method call is a blocking operation
//Optionally we can use this method with specifying time limits
//So if we don't get result from that specified time window it will throw exception and will come out of blocking state
