public class OS {

	public static UserThread[] Users = new UserThread[Global.NUMBER_OF_USERS]; 
	public static Disk[] Disks = new Disk[Global.NUMBER_OF_DISKS];
	public static Printer[] Printers = new Printer[Global.NUMBER_OF_PRINTERS];
	
	public static void main(String[] args) throws Exception {
		for (int i=0; i<Global.NUMBER_OF_USERS; i++)
			Users[i] = new UserThread(i+1);
		
		for (int i=0; i<Global.NUMBER_OF_DISKS; i++){
			Disks[i] = new Disk(); 
		}
		
		for (int i=0; i<Global.NUMBER_OF_PRINTERS; i++)
			Printers[i] = new Printer(i+1); 
		
		Global.direct = new DirectoryManager();
		
		Global.diskManage = new ResourceManager(Global.NUMBER_OF_DISKS); 
		Global.printManage = new ResourceManager(Global.NUMBER_OF_PRINTERS); 		
		Global.directManage = new DirectoryManager(); // new ResourceManager(1); 
		
		OSGUI.createGUI();
		
		for (int i=0; i<Global.NUMBER_OF_USERS; i++){
			System.out.println("Starting users"); 
			Users[i].start();
		}
	}
}
