public class Disk
{
	static final int NUM_SECTORS = 1024;
	public static StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	public int currSector;
	
	public Disk(){ 
		currSector=0;
		for (int i=0; i<NUM_SECTORS; i++){ 
			sectors[i] = new StringBuffer(NUM_SECTORS);
		}
	}
	
	public Disk(int capacity){
		currSector=0;
		for (int i=0; i<capacity; i++){ 
			sectors[i] = new StringBuffer(capacity);
		}
	}
	
    public void write(int sector, StringBuffer data) {
		try{    	
			if (sectors[sector].length() != 0)
					sectors[sector].delete(0,sectors[sector].length());
			sectors[sector].append(data); 
			if (sector >= currSector){ 
				currSector += 1; 
			}
			Thread.sleep(200);
		} catch(InterruptedException e){
			e.printStackTrace();
		}

    }
    
    public void read(int sector, StringBuffer data) {  		
		try{
	    	if (data.length() != 0){ 
	    		data.delete(0, data.length()); 
	    	}
			data.append(sectors[sector]);  
			Thread.sleep(200);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
    }

}
