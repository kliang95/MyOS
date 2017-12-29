
public class PrintJobThread extends Thread{
	//call resource manager
	private int freePrinter;
	private FileInfo fileIn; 
	public StringBuffer toPrint; 
	
	public PrintJobThread(FileInfo f){ 
		this.fileIn = f;
		toPrint = new StringBuffer(); 
	}
	
	@Override
	public void run(){
		try {
			freePrinter = Global.printManage.request(); 
			for (int i=0; i<fileIn.fileLength; i++){ 
					Printer p = new Printer(freePrinter); 
					OS.Disks[fileIn.diskNumber].read(fileIn.startingSector+i, toPrint);
					OSGUI.updatePanel("Printer"+(freePrinter+1)+": Printing " + toPrint.toString(), Global.printL[freePrinter]);
					p.print(toPrint);
			}
			Global.printManage.release(freePrinter); 
			OSGUI.updatePanel("Printer"+(freePrinter+1)+": Nothing", Global.printL[freePrinter]);

		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
	}


	
}
