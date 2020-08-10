package vikas.mypack;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		
		ConcurrentHashMap<Integer, String> conHashMap=new ConcurrentHashMap<>();
		conHashMap.put(1, "A");
		conHashMap.put(2, "B");
		conHashMap.put(3, "C");
		conHashMap.put(4, "D");
		conHashMap.put(5, "E");
		
		Iterator<Integer> itr=conHashMap.keySet().iterator();
		
		while(itr.hasNext()) {
			
			String value=conHashMap.get(itr.next());
			System.out.println("Value :: "+value);
		}
		

	}

}
