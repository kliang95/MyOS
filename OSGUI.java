
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OSGUI {
	
	public static JPanel userPanel; 
	public static JPanel diskPanel;
	public static JPanel printPanel;
	
	private static void addUserToPanel(Container pane){ 
		pane.setLayout (new BoxLayout(pane, BoxLayout.Y_AXIS)); 
		for (int i=0; i<4; i++){ 
			String printName = "User" + (i+1) + ": Nothing"; 
			addLabel (printName, pane, Global.userL, i); 
		}
	}
	
	private static void addDiskToPanel(Container pane){ 
		pane.setLayout (new BoxLayout(pane, BoxLayout.Y_AXIS)); 
		for (int i=0; i<2; i++){ 
			String printName = "Disk" + (i+1) + ": Nothing"; 
			addLabel (printName, pane, Global.diskL, i); 
		}
	}
	
	private static void addPrinterToPanel(Container pane){ 
		pane.setLayout (new BoxLayout(pane, BoxLayout.Y_AXIS)); 
		for (int i=0; i<3; i++){ 
			String printName = "Printer" + (i+1) + ": Nothing"; 
			addLabel (printName, pane, Global.printL, i); 
		}
	}
	
	private static void addLabel(String text, Container pane, JLabel[] labelArray, int indx) {
		JLabel label = new JLabel(text); 
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		labelArray[indx] = label;
		pane.add(label);
	}

	public static void updatePanel (String text, JLabel label){
		label.setText(text);
	}
	
	public static void createGUI() {
		JFrame f = new JFrame("CS141 OS");
		f.setSize(500,250); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userPanel = new JPanel(); 
		userPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		f.add (userPanel, BorderLayout.NORTH); 
		addUserToPanel(userPanel);
		
		diskPanel = new JPanel(); 
		diskPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		f.add (diskPanel, BorderLayout.CENTER); 
		addDiskToPanel(diskPanel);
		
		printPanel = new JPanel(); 
		printPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		f.add(printPanel, BorderLayout.SOUTH); 
		addPrinterToPanel(printPanel);
		
		f.setVisible(true);
	}


}
