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
		final int count = 10;
		Thread[] threads = new Thread[count];
		ThreadTest[] tests = new ThreadTest[count];
		// create tests
		for(int i = 0; i < count; ++i)
		{
			tests[i] = new ThreadTest(
					""+(char)('a'+i));
		}
		// wrap tests with a thread
		for(int i = 0; i < count; ++i)
		{
			threads[i] = new Thread(tests[i]);
		}
		// start the threads
		for(int i = 0; i < count; ++i)
		{
			threads[i].start();
		}
	}
}
