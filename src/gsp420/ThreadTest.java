package gsp420;
public class ThreadTest implements Runnable {
	public String message = "message";
	/** how many times to print the message */
	private int numberOfTimes = 10;
	
	/** a pretty gross fake semaphore */
	static volatile boolean working = false;
	
	/** just a global to act like a door. */
	static Object sync = new Object();
	
	/** @param m what message to repeat */
	public ThreadTest(String m) {
		message = m;
	}
	/** important functionality */
	void printMessage() {
		for(int i = 0; i < numberOfTimes; ++i) {
			System.out.print(message);
		}
		System.out.println();
	}
	/** proxy for run(), using a homebrew semaphore */
	void DoTheThing() {
		// really crappy semaphore - it *almost* works. it's orderly *most* of the time
		while(working) {
			try{Thread.sleep(1);}catch(Exception e){}
		}
		working = true;
		printMessage();
		working = false;

	}
	/** proxy for run, using the correct Java synchronized keyword as a semaphore */
	void DoTheThingCorrectly() {
		// using the correct Java solution
		synchronized(sync) {
			printMessage();
		}
	}
	/** the method executed by the running thread */
	public void run() {
		//DoTheThing();
		DoTheThingCorrectly();
	}
	
	public static void main(String[] args) {
		final int count = 10;
		final boolean usingFunctionalExample = true;
		Thread[] threads = new Thread[count];
		ThreadTest[] tests = new ThreadTest[count];

		if(!usingFunctionalExample) {
			// create tests
			for(int i = 0; i < count; ++i) {
				tests[i] = new ThreadTest(""+(char)('a'+i));
			}
			// wrap tests with a thread
			for(int i = 0; i < count; ++i) {
				// "normal" way to thread
				threads[i] = new Thread(tests[i]);
			}
			// start the threads
			for(int i = 0; i < count; ++i) {
				threads[i].start();
			}
		} else {
			abstract class temp implements Runnable{
				ThreadTest t;
				public temp(ThreadTest t) {
					this.t = t;
				}
			}
			// wrap tests with a thread
			for(int i = 0; i < count; ++i) {
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
			for(int i = 0; i < count; ++i) {
				threads[i].start();
			}
		}
	}
}
