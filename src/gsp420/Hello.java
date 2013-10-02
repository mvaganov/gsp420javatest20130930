package gsp420;
import java.awt.Color;
import java.awt.Graphics;	// newer stuff is JavaFX
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Hello extends JPanel
	implements MouseListener {

	// minecraft uses the LWJGL, which is pretty good.
	Image img;
	
	public Hello() {}
	public void methodThatDoesNothing(){}
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println("!");
		JFrame jf = new JFrame("My Frame");
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new Hello("hi"));
		jf.setVisible(true);
	}
	/**
	 * Draws {@link #m_message} in a window.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(m_message, 
				(int)click.x, (int)click.y);
		g.setColor(Color.red);
		g.drawLine(5, 10, (int)click.x, (int)click.y);
		g.drawImage(img, (int)click.x, (int)click.y, 
				null);
	}
	public Hello(String m) {
		m_message = m;
		addMouseListener(this);
		img = Toolkit.getDefaultToolkit().
				createImage("dwarf.png");
	}
	/** a very simple 2D vector class */
	class Vec2
	{
		float x, y;
		Vec2(int x, int y){ this.x=x;this.y=y;}
	}
	Vec2 click = new Vec2(0, 0);
	@Override
	public void mousePressed(MouseEvent e) {
		click.x = e.getX();
		click.y = e.getY();
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// m_message
	/**
	 * <i>Whatever</i> I type <b>here</b> is useful <br>
	 * for documentation.
	 * <table border = 5><tr><td>1</td><td>2</td></tr>
	 * <tr><td>3</td></tr></table>
	 * <img src="http://codegiraffe.com/images/icon_colored.png">
	 */
	public String m_message;
}
