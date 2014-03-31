package gsp420;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class WindowUITest extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("UI Test");
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		jf.add(new WindowUITest());
		jf.setVisible(true);
	}
	
	public void displayResult(String s, ActionEvent e) {
		System.out.println(s+" "+e);
	}

	public WindowUITest() {
		setLayout(new BorderLayout());
		add(new JLabel("hi"), BorderLayout.NORTH);
		add(new JTextField("lo"), BorderLayout.SOUTH);
		add(new JTextArea("hello"), BorderLayout.CENTER);
		add(new JPasswordField("left"), BorderLayout.WEST);
//		add(new JButton("east"), BorderLayout.EAST);
		// using more functional-style programming with anonymous classes
		abstract class MnemonicButton extends AbstractAction {
			private static final long serialVersionUID = 0L;
			public MnemonicButton(String text, ImageIcon icon, String desc, Integer mnemonic) {
			    super(text, icon);
			    putValue(SHORT_DESCRIPTION, desc);
			    putValue(MNEMONIC_KEY, mnemonic);
			}
		}
		ImageIcon dwarficon = createImageIcon("dwarf.png");
		String tooltip = "This is the east button.";
		int altKeyEvent = new Integer(KeyEvent.VK_E);
		AbstractAction eastAction = new MnemonicButton("east", dwarficon, tooltip, altKeyEvent) {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
		        displayResult(getValue(MNEMONIC_KEY).toString(), e);
		    }
		};
		add(new JButton(eastAction), BorderLayout.EAST);
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path) {
		try {
			// TODO make this less... hacky
		    java.net.URL imgURL = new java.net.URL(getClass().getResource("")+"../../"+path);
			ImageIcon icon = new ImageIcon(imgURL);
	        return icon;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}