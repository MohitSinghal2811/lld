package jsonParser.element;

import java.util.HashMap;
import java.util.Map;

public class JsonObject implements JsonElement {
	
	Map<String, JsonElement> elements;

	public JsonObject(){
		elements = new HashMap<>();
	}

	public String toString(){
		return elements.toString();
	}

	public void addField(JsonString string, JsonElement element){
		elements.put(string.toString(), element);
	}
		
}
