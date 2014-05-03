/**
 * 
 */
package common.factory;

/**
 * @author sai
 *
 */
public class OSInfo {

	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static boolean isMacOS(){
		return OS.indexOf("mac")>=0&&OS.indexOf("os")>0&&OS.indexOf("x")<0;
	}
	
	public static boolean isWindows(){
		return OS.indexOf("windows")>=0;
	}
	
	public static boolean isLinux(){
		return OS.indexOf("linux")>=0;
	}
}
