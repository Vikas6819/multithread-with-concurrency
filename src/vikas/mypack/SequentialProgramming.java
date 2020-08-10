package vikas.mypack;

class Worker1 {

	public void method1() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Inside Method1");
		}

	}

}

class Worker2{
	
	public void method2() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Inside Method2");
		}

	}	
}
public class SequentialProgramming {

	public static void main(String[] args) {
		
		Worker1 w1=new Worker1();
		Worker2 w2=new Worker2();
		
		w1.method1();
		w2.method2();

	}

}
//Here output will be in sequential manner i.e first method1 of worker1 class will be executed followed by method2 of worker2 class
