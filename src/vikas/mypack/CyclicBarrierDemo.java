package vikas.mypack;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Worker4 extends Thread {

	CyclicBarrier barrier = null;
	String name;

	public Worker4(CyclicBarrier barrier,String name) {

		this.barrier = barrier;
		this.name=name;
	}

	@Override
	public void run() {
		
		System.out.println("Thread .. "+name+" has completed the task");
		try {
			barrier.await();
			
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class CyclicBarrierDemo {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(3, new RunnableAction());
		Worker4 t1=new Worker4(barrier,"Worker1");
		Worker4 t2=new Worker4(barrier,"Worker2");
		Worker4 t3=new Worker4(barrier,"Worker3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class RunnableAction implements Runnable {

	@Override
	public void run() {

		System.out.println("Thank you!");

	}

}