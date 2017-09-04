package src.pwd.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import src.pwd.analyze.result.Result;
import src.pwd.entity.Password;

/**
 * Contains string constants
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class StringConstants {

	public static final String FILEREADER_RESOURCE_PATH = "src/pwd/resources/";
	public static final String FILEREADER_DICCIONARY_PATH = FILEREADER_RESOURCE_PATH + "dictionaries/";
	
	public static final String FILREADER_EXTENSION_TEXT = ".txt";
	
	public static final String MOSTCOMMONWORDS_FILE = "10k_most_common";

	public static final String DICCIONARYATTACK_FILE_WORDS =  "dictionary"; // available words: 3192154

	public static final Map<Character, Character> L33T_TABLE = new HashMap<Character, Character>();
    static {
        L33T_TABLE.put('4', 'a');
        L33T_TABLE.put('@', 'a');
        L33T_TABLE.put('8', 'b');

        L33T_TABLE.put('(', 'c');
        L33T_TABLE.put('{', 'c');
        L33T_TABLE.put('[', 'c');
        L33T_TABLE.put('<', 'c');
        
        L33T_TABLE.put('3', 'e');
        L33T_TABLE.put('6', 'g');
        L33T_TABLE.put('9', 'g');

        L33T_TABLE.put('1', 'i'); 
        L33T_TABLE.put('!', 'i'); 
        L33T_TABLE.put('|', 'i');

        //L33T_TABLE.put('1', 'l');
        //L33T_TABLE.put('|', 'l');
        L33T_TABLE.put('7', 'l');

        L33T_TABLE.put('0', 'o');

        L33T_TABLE.put('$', 's');
        L33T_TABLE.put('5', 's');

        L33T_TABLE.put('+', 't');
        L33T_TABLE.put('7', 't');

        L33T_TABLE.put('%', 'x');
        
        L33T_TABLE.put('2', 'z');
    }
    
    public static final String [] INTERNATIONAL_CHARACTERS = {
	    		"á","â","ý","¢","¬","È","Ó","Þ",
	    		"é","ê","ỳ","£","®","É","Ô","ß",
	    		"í","î","ŷ","¥","»","Ê","Õ","å",
	    		"ó","ô","ÿ","§","À","Ë","Ö","æ",
	    		"ú","û","ñ","¨","Á","Ì","Ø","ð",
	    		"à","ä","ñ","´","Â","Í","Ù","ø",
	    		"è","ë","ç","©","Ã","Î","Ú","þ",
	    		"ì","ï","Ç ","º","Ä","Ï","Û",
	    		"ò","ö","¡","ª","Å","Ð","Ü",
	    		"ù","ü","¿","«","Æ","Ò","Ý"
    };
    
	public static final Map<Character, Character> INTERNATIONAL_CHARACTERS_TABLE = new HashMap<Character, Character>();
    static {

    	INTERNATIONAL_CHARACTERS_TABLE.put('ª', 'a');
    	INTERNATIONAL_CHARACTERS_TABLE.put('æ', 'a');
    	INTERNATIONAL_CHARACTERS_TABLE.put('Å', 'a');
    	INTERNATIONAL_CHARACTERS_TABLE.put('Æ', 'a');
    	
    	INTERNATIONAL_CHARACTERS_TABLE.put('¢', 'c');
    	INTERNATIONAL_CHARACTERS_TABLE.put('ç', 'c');
    	INTERNATIONAL_CHARACTERS_TABLE.put('Ç', 'c');
    	INTERNATIONAL_CHARACTERS_TABLE.put('©', 'c');
    	
    	INTERNATIONAL_CHARACTERS_TABLE.put('£', 'e');
    	
    	INTERNATIONAL_CHARACTERS_TABLE.put('¥', 'y');
    	INTERNATIONAL_CHARACTERS_TABLE.put('§', 's');
    	
    	INTERNATIONAL_CHARACTERS_TABLE.put('Þ', 'p');
    	INTERNATIONAL_CHARACTERS_TABLE.put('ß', 'b');
    	
    	INTERNATIONAL_CHARACTERS_TABLE.put('þ', 'b');
    	
    	INTERNATIONAL_CHARACTERS_TABLE.put('ð', 'o');
    	INTERNATIONAL_CHARACTERS_TABLE.put('ø', 'o');
    	
    	
        L33T_TABLE.put('1', 'i'); 
        L33T_TABLE.put('!', 'i'); 
        L33T_TABLE.put('|', 'i');

        //L33T_TABLE.put('1', 'l');
        //L33T_TABLE.put('|', 'l');
        L33T_TABLE.put('7', 'l');

        L33T_TABLE.put('0', 'o');

        L33T_TABLE.put('$', 's');
        L33T_TABLE.put('5', 's');

        L33T_TABLE.put('+', 't');
        L33T_TABLE.put('7', 't');

        L33T_TABLE.put('%', 'x');
        
        L33T_TABLE.put('2', 'z');
    }
    
    public static final String [] SPECIAL_CHARACTERS = {
    		"_","+","?",
		    "!",",","@",
		    "#","-","[",
		    "$",".","\\",
		    "%","/","]",
		    "&",":","^",
		    "'",";","`",
		    "(","<","{",
		    ")","=","|",
		    "*",">","}",
		    "~","x"," "
    };
    
    public static final String [] NUMBERS ={
    		"0","1",
    		"2","3",
    		"4","5",
		    "6","7",
		    "8","9"
    };
    
    /**
     * Total of: 98,091,994
     */
    public static final String[] DICTIONARY_FILES = {
    		MOSTCOMMONWORDS_FILE,
    		DICCIONARYATTACK_FILE_WORDS
    };
    
    public static final String PWD_SUGGESTION_FILE = "passwordSuggestion";
    public static final String BRUTE_FORCE_ATTACK_PC = "PC";
    public static final String BRUTE_FORCE_ATTACK_CLUSTER = "Cluster";
    public static final String BRUTE_FORCE_ATTACK_DISTRIBUTED = "Distributed";
    public static final String BRUTE_FORCE_ATTACK_SUPERCOMPUTER = "SuperComputer";
    
	public static final String NEWLINE = "<br>";
	public static final String H_1 = "<h4 class=\"centerAnswer\">";
	public static final String H_2 = "</h4>";
	public static final String P_1 = "<p>";
	public static final String P_2 = "</p>";
	public static final String STRONG_1 = "<strong>";
	public static final String STRONG_2 = "</strong>";
	public static final String TABLE_PATTERN = "<caption>Tabla de equivalencia de patrones</caption><table class=\"table table-striped table-hover\"><thead><th>Patrón</th><th>Símbolo</th></thead>"
			+ "<tbody>"
			+ "<tr><td>Número</td><td>#</td></tr>"
			+ "<tr><td>Mayúscula</td><td>M</td></tr>"
			+ "<tr><td>Minúscula</td><td>m</td></tr>"
			+ "<tr><td>Símbolo</td><td>%</td></tr>"
			+ "<tr><td>Caracter internacional</td><td>ß</td></tr>"
			+ "<tbody>"
			+ "</table>";
    
    public static StringBuilder getFirstFormattedFeedback(Password password){
    	StringBuilder builder = new StringBuilder();
    	builder.append(StringHelper.getString("Suggestions.password.analized"));
    	builder.append(StringConstants.H_1);
    	builder.append(password.getPassword());
    	builder.append(StringConstants.H_2);
    	builder.append(StringHelper.getString("Suggestions.password.pattern"));
    	builder.append(StringConstants.H_1);
    	builder.append(password.getPasswordPattern());
    	builder.append(StringConstants.H_2);
    	builder.append(TABLE_PATTERN);
    	builder.append(NEWLINE);
    	
    	return builder;
    }
    
    public static StringBuilder getSecondFormatterFeedback(Result result ,StringBuilder builder){
    	builder.append(StringConstants.NEWLINE);
    	builder.append(StringConstants.P_1);
    	builder.append(StringHelper.getString("Suggestions.password.timerequired_1"));
    	builder.append(StringConstants.STRONG_1);
    	//builder.append(result.getAnalyzisTime() +  " segundos ");
    	//builder.append(TimeUtils.formatTime(result.getAnalyzisTime()) + " segundos ");
    	builder.append(TimeUtils.formatTime(result.getAnalyzisTime()) );
    	builder.append(StringConstants.STRONG_2);
    	builder.append(StringHelper.getString("Suggestions.password.timerequired_2"));
    	
    	return builder;
    }
    
    public static StringBuilder getWordList(int index, StringBuilder builder, String list){
    	ArrayList<String> dictionary = FileUtils.getDictionaryInfo(list);
    	int foundindex = index;
    	int fromIndex = foundindex > 10 ? index - 10:0;
    	int toIndex = foundindex >= dictionary.size() ? dictionary.size() :foundindex+10;
    	List<String> subList = dictionary.subList(fromIndex, toIndex);
    	builder.append(StringHelper.getString("BasicCheck.suggestion.list.open_clean"));
    	for(String element: subList){
    		fromIndex++;
    		if(fromIndex == foundindex){
    			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.open_del") +fromIndex +": " + element + StringHelper.getString("BasicCheck.suggestion.list.item.close_del") );
    		}else{
    			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.open") +fromIndex +": " + element + StringHelper.getString("BasicCheck.suggestion.list.item.close") );	    			
    		}
    	}
    	builder.append(StringHelper.getString("BasicCheck.suggestion.list.close"));
    	
    	return builder;
    }
    
    
}
