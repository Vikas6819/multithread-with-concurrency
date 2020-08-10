package vikas.mypack;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExceptionDemo extends Thread {

	private static ArrayList<String> list=new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		ConcurrentModificationExceptionDemo excp=new ConcurrentModificationExceptionDemo();
		list.add("Vikas");
		list.add("Suneet");
		list.add("Akshay");
		
		Iterator<String> itr=list.iterator();
		excp.start();
		while(itr.hasNext()) {
			String name=itr.next();
			System.out.println("List Value ..."+name);
			Thread.sleep(100);
		}

	}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add("Vinay");//this will throw Concurrent Modification Exception..
	}

}
