package vikas.mypack;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

	private BlockingQueue<Integer> bq = null;

	Producer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		
		
		System.out.println("Producer Thread...");
		while(true) {
			synchronized (bq) {
				if(bq.size()==5) {
					System.out.println("Queue is full....Calling Wait Method..");
					try {
						bq.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random ran=new Random();
				int val=ran.nextInt();
				System.out.println("Producer ...Adding Item :: "+val);
				bq.add(val);
				bq.notify();	
			}
			
		}
	}

}

class Consumer implements Runnable {
	
	private BlockingQueue<Integer> bq = null;

	Consumer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Consumer Thread...");
		while(true) {
			synchronized (bq) {
				if(bq.size()==0) {
					System.out.println("Queue is empty....Calling Wait Method..");
					try {
						bq.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Consuming Item ..."+bq.remove());
				bq.notify();	
			}
			
			
		}
	}
}

public class ProducerConsumerDemo {

	public static void main(String[] args) {

		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);
		Producer prod=new Producer(bq);
		Consumer con=new Consumer(bq);
		Thread t1=new Thread(prod);
		Thread t2=new Thread(con);
		t1.start();
		t2.start();
	}

}
