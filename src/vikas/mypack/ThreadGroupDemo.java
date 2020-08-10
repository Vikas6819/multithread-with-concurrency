package vikas.mypack;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		
		//Custom Thread Group
		ThreadGroup tGroup=new ThreadGroup("Custom");
		ThreadGroup tSubGroup=new ThreadGroup(tGroup,"CustomSubGrp");
		System.out.println(tGroup.getParent().getName());
		System.out.println(tSubGroup.getParent().getName());
		
	}

}
