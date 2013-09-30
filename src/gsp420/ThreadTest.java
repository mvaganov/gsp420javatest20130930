package gsp420;

public class ThreadTest {
	
	public String message = "message";
	private int numberOfTimes = 10;
	
	void DoTheThing()
	{
		for(int i = 0; i < numberOfTimes; ++i)
		{
			System.out.println(i+" "+message);
		}
	}
	
	public static void main(String[] args)
	{
		ThreadTest t = new ThreadTest();
		t.DoTheThing();
	}
}
