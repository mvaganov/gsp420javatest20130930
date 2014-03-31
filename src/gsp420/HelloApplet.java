package gsp420;

import java.applet.Applet;

public class HelloApplet extends Applet {
	private static final long serialVersionUID = 1L;

	public void init()
	{
		add(new Hello("hi.  !"));
	}
}
