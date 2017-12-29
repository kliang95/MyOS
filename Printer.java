import java.io.BufferedWriter;
import java.io.FileWriter;

public class Printer
{
	String filename;	
	
    Printer(int id)
    {
    	filename = "PRINTER"+Integer.toString(id+1); 
    }
    
    void print(StringBuffer b)
    {
    	try{
    		BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
			bw.write(b.toString());
			System.out.println(b.toString());
			bw.newLine(); 
			Thread.sleep(2750);
			bw.close();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    

}
