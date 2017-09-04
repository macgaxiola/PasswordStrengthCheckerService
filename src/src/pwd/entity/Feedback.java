package src.pwd.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Feedback entity
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class Feedback {
	private List<String> suggestions;
	
	public Feedback() {
		this.suggestions = new ArrayList<String>();
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}

	public void addSuggestions(String suggestion) {
		suggestions.add(suggestion);
	}
}
