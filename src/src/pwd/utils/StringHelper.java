package src.pwd.utils;

import java.util.ResourceBundle;

/**
 * Manage String format and msg.
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class StringHelper {
	
    /**
     * 
     * @param msg
     * @param values
     * @return
     */
	public static String formatSuggestion(String msg , String... values){	
		StringBuilder builder = new StringBuilder(msg);
		for(int index = 0; index < values.length; index++){
			builder.append(values[index]);
			if(index != values.length-1){
				builder.append(",");
			}
		}
		builder.append(StringHelper.getString("BioDataCheck.suggestion.end"));
		return builder.toString();
	}
	
	public static String getString(String msg){
		ResourceBundle bundle = ResourceBundle.getBundle("src.pwd.resources.strings");
		return bundle.getString(msg);
	}
	
	public static void logMsg(String msg){
		System.out.println(msg);
	}
	
	public static String createCliBannerMsg(){
		StringBuilder builder = new StringBuilder();
		builder.append(getString("Main.msg.divider.1"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.1"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.2"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.3"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.4"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.5"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.6"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.7"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.8"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.9"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.10"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.11"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.12"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.13"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.14"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.15"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.div"));
		builder.append("\n");
		builder.append(getString("Main.msg.welcome"));
		builder.append("\n");
		builder.append(getString("Main.msg.banner.bannerInfo.1"));
		builder.append("\n");
	    builder.append(getString("Main.msg.banner.bannerInfo.2"));
	    builder.append("\n");
	    builder.append(getString("Main.msg.banner.div"));
	    builder.append("\n");
		return builder.toString();
	}
	
	public static String cleanCliMsg(){
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("\n");
		return builder.toString();
	}
	
	public static String lineJumpMsg(){
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		return builder.toString();
	}
	
	public static void debug(Class className , String msg){
		System.out.println("["+ className + "] " + msg );
	}
}
