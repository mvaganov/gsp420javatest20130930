package gsp420;

public class ThreadTest {
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
	public static void main(String[] args)
	{
		ThreadTest t = new ThreadTest("a");
		ThreadTest t2 = new ThreadTest("b");
		t.DoTheThing();
		t2.DoTheThing();
	}
}
