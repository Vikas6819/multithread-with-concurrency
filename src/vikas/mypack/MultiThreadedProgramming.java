package vikas.mypack;

class Task1 extends Thread {

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Executing Task1");
		}

	}

}

class Task2 extends Thread{
	
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Executing Task2");
		}

	}	
}

public class MultiThreadedProgramming {

	public static void main(String[] args) {
		
		Task1 t1=new Task1();
		Task2 t2=new Task2();
		
		t1.start();
		t2.start();

	}

}
//Here output will not be in fixed manner