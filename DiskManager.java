
public class DiskManager {
	public static int[] diskSector; 

	public DiskManager(){ 
		for (int i=0; i<Global.NUMBER_OF_DISKS; i++){ 
			diskSector[i] = 0; 
		}
	}
	
	public static int getFreeSector(int d){ 
		return OS.Disks[d].currSector; 
	}
	
	//directoryManager? 
}
