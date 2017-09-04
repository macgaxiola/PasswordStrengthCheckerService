package src.pwd.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Stopwatch;

/**
 * 
 *	File Utils reads and load data from files
 *  
 *  @author Mac - mac.gaxiola@gmail.com
 */
public class FileUtils {
	
	private static Map<String, ArrayList<String>> dictionaries;
	private static ArrayList<String> strenghtPasswordsSuggestions;
    
	public static InputStream getInputStreamForDiccionary(String file) throws FileNotFoundException{
		InputStream path = FileUtils.class.getClassLoader().getResourceAsStream(StringConstants.FILEREADER_DICCIONARY_PATH 
				   + file + StringConstants.FILREADER_EXTENSION_TEXT);
		return path;
	}
	
	public static InputStream getInputStreamForFile(String file) throws FileNotFoundException{
		InputStream path = FileUtils.class.getClassLoader().getResourceAsStream(StringConstants.FILEREADER_RESOURCE_PATH 
				   + file + StringConstants.FILREADER_EXTENSION_TEXT);
		return path;
	}
	
	/**
	 * Loads a list of passwords that are consider strength against the attacks used on this project.
	 */
	public static void loadPwdSuggestions() {
		String filename = StringConstants.PWD_SUGGESTION_FILE;
		strenghtPasswordsSuggestions = new ArrayList<String>();
		try{
			InputStream is;
			BufferedReader br = null;
			try{
				is = getInputStreamForFile(filename);
				if(is != null){
					br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
					String line;
					while ((line = br.readLine()) != null) {
						strenghtPasswordsSuggestions.add(line);
					}
				}
			}finally {
				if(br != null){
					br.close();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Error while reading " + filename);
		}	
	}
	
	/**
	 * Reads the dictionary data
	 * @return map contained each entry the dictionary and dictionary content.
	 */
	public static void loadDictionary() {
		Stopwatch timer = Stopwatch.createUnstarted();
    	timer.start();
		StringHelper.logMsg( StringHelper.getString("Main.msg.starting.diccionary"));
		Map<String, ArrayList<String>> freqLists = new HashMap<String, ArrayList<String>>();
		for (String filename:  StringConstants.DICTIONARY_FILES) {
			ArrayList<String> words = new ArrayList<String>();
			//words.ensureCapacity(40000000);
			try{
				InputStream is;
				BufferedReader br = null;
				try{
					is = getInputStreamForDiccionary(filename);
					if(is != null){
						br = new BufferedReader(new InputStreamReader(is, "UTF8"));
						String line;
						while ((line = br.readLine()) != null) {
							words.add(line);
						}
						freqLists.put(filename, words);
					}
				}finally {
					if(br != null){
						br.close();
					}
				}
			} catch (IOException e) {
				throw new RuntimeException("Error while reading " + filename);
			}
		}
		dictionaries =  freqLists;
    	timer.stop();
		StringHelper.logMsg( StringHelper.getString("Main.msg.finishing.diccionary") + timer +" |seconds: "+timer.elapsed(TimeUnit.SECONDS));
	}
	
	/**
	 * Returns the dictionaries
	 */
	public static Map<String, ArrayList<String>> getDictionaries() {
		return dictionaries;
	}
	
	/**
	 * Returns the dictionary data
	 */
	public static ArrayList<String> getDictionaryInfo(String dictionary) {
		return dictionaries.get(dictionary);
	}
	
	/**
	 * Returns a password considered strength enough
	 * @return the pws
	 */
	public static String getRandomPws() {
		Collections.shuffle(strenghtPasswordsSuggestions);
		return strenghtPasswordsSuggestions.get(0);
	}
}
