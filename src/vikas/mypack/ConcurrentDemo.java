package vikas.mypack;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentDemo extends Thread{

	private static CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		ConcurrentDemo conDemo=new ConcurrentDemo();
		
		list.add("Vikas");
		list.add("Suneet");
		list.add("Akshay");
		
		Iterator<String> itr=list.iterator();
		conDemo.start();
		while(itr.hasNext()) {
			String name=itr.next();
			System.out.println("List Value ..."+name);
			Thread.sleep(100);
		}
		System.out.println(list);

	}
	@Override
	public void run() {
		list.add("Vinay");//this will throw Concurrent Modification Exception..
	}
}
