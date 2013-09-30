package gsp420;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class WindowUITest extends JPanel {
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("UI Test");
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		jf.add(new WindowUITest());
		jf.setVisible(true);
	}
	public WindowUITest() {
	setLayout(new BorderLayout());
	add(new JLabel("hi"), BorderLayout.NORTH);
	add(new JTextField("lo"), BorderLayout.SOUTH);
	add(new JTextArea("hello"), BorderLayout.CENTER);
	add(new JPasswordField("left"), BorderLayout.WEST);
	add(new JButton("east"), BorderLayout.EAST);
	}
}