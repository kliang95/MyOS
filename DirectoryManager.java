import java.util.Hashtable;

public class DirectoryManager{ 
	public static Hashtable<StringBuffer, FileInfo> T = new Hashtable<StringBuffer, FileInfo>();
	
	public void enter(StringBuffer key, FileInfo file){
		T.put(key, file);
	}
	public static FileInfo lookup(StringBuffer key){
		return T.get(key);
	}
}