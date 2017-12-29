import java.io.BufferedReader; 
import java.io.FileReader;

class UserThread
    extends Thread
{
	StringBuffer buffer = new StringBuffer(); 
	int num; 
    private String filename; 
	public UserThread(int id)
    {
		num = id; 
    	filename = "USER"+Integer.toString(id); 
    }
	
	
	@Override
	public void run(){ 
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			int index;
			String line=null;
			while ((line = br.readLine()) !=  null){ 
				buffer.append(line); 
				if ((index = buffer.indexOf(".save")) > -1) { 
					System.out.println("saving"); 
					//gets file to save to
					String toSave = buffer.substring(index+5).toString();
					toSave = toSave.replace(" ", ""); 
					buffer.delete(0,buffer.length());
					OSGUI.updatePanel("User"+num+": Saving to " + toSave, Global.userL[num-1]);

					//saves all lines between .save and .end into free disk
					FileInfo fileIn = new FileInfo(); 
					fileIn.diskNumber = Global.diskManage.request();
					fileIn.startingSector = DiskManager.getFreeSector(fileIn.diskNumber); 
					fileIn.fileLength = 0;
					int sector = fileIn.startingSector; 
					while ((line = br.readLine()) !=  null){ 
						buffer.append(line);
						if (buffer.indexOf(".end") > -1) {
							break;
						}
						fileIn.fileLength++; 
						OS.Disks[fileIn.diskNumber].write(sector,buffer);
						OSGUI.updatePanel("Disk"+(fileIn.diskNumber+1)+": Saving "+buffer.toString(), Global.diskL[fileIn.diskNumber]);
						sector++;
						buffer.delete(0,buffer.length());
					}
					buffer.delete(0,buffer.length());
					buffer.append(toSave); 
					
					//release disk and enter save file to Directory Manager
					Global.diskManage.release(fileIn.diskNumber);
					OSGUI.updatePanel("Disk"+fileIn.diskNumber+": Nothing", Global.diskL[fileIn.diskNumber]);
					Global.direct.enter(buffer, fileIn);	
				}
	    	  
				//sets up PrintJobThread for parallel print jobs
				else if ((index = buffer.indexOf(".print")) > -1){ 
					String toPrint = buffer.substring(index+6).toString();
					toPrint = toPrint.replace(" ", ""); 
					buffer.delete(0,buffer.length());
					FileInfo fileIn = DirectoryManager.lookup(buffer.append(toPrint)); 
					OSGUI.updatePanel("User"+num+": Printing to " + buffer.toString(), Global.userL[num-1]);
					PrintJobThread printT = new PrintJobThread(fileIn); 
					printT.run(); 
					OSGUI.updatePanel("User"+num+": Nothing", Global.userL[num-1]);

				}
				buffer.delete(0,buffer.length());
			}
			br.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
