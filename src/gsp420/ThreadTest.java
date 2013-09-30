package gsp420;
public class ThreadTest implements Runnable {
	public String message = "message";
	private int numberOfTimes = 10;
	public ThreadTest(String m)
	{
		message = m;
	}
	void DoTheThing()
	{
		for(int i = 0; i < numberOfTimes; ++i)
		{
			System.out.println(i+" "+message);
		}
	}
	public void run(){DoTheThing();}
	public static void main(String[] args)
	{
		Thread t = new Thread(new ThreadTest("a"));
		Thread t2 = new Thread(new ThreadTest("b"));
		t.start();
		t2.start();
	}
}
