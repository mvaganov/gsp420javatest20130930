package gsp420;
public class ThreadTest implements Runnable {
	public String message = "message";
	private int numberOfTimes = 10;
	static boolean working = false;
	/** jsut a global to act like a door. */
	static Object sync = new Object();
	public ThreadTest(String m)
	{
		message = m;
	}
	void DoTheThing()
	{
//		// really crappy semaphore
//		while(working) {
//			try{Thread.sleep(1);}
//			catch(Exception e){}
//		}
//		working = true;
		synchronized(sync)
		{
			// embarassingly parellel
			for(int i = 0; i < numberOfTimes; ++i)
			{
				System.out.print(message);
			}
			System.out.println();
		}
//		working = false;
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
		abstract class temp implements Runnable{
			ThreadTest t;
			public temp(ThreadTest t)
			{
				this.t = t;
			}
		}
		// wrap tests with a thread
		for(int i = 0; i < count; ++i)
		{
			// "normal" way to thread
//			threads[i] = new Thread(tests[i]);
			// more functional programming style
			threads[i] = new Thread(
				new temp(tests[i]){
					public void run(){
						t.DoTheThing();
					}
				}
			);
		}
		// start the threads
		for(int i = 0; i < count; ++i)
		{
			threads[i].start();
		}
	}
}
