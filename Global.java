import javax.swing.JLabel;


public class Global {
	static int NUMBER_OF_USERS = 4;
	static int NUMBER_OF_DISKS = 2;
	static int NUMBER_OF_PRINTERS = 3;

	public static DirectoryManager direct;

	public static ResourceManager diskManage;
	public static ResourceManager printManage;
	public static DirectoryManager directManage;
	
	public static JLabel[] userL = new JLabel[NUMBER_OF_USERS]; 
	public static JLabel[] diskL = new JLabel[NUMBER_OF_DISKS]; 
	public static JLabel[] printL = new JLabel[NUMBER_OF_PRINTERS]; 
}
