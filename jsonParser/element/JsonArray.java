package jsonParser.element;

import java.util.ArrayList;
import java.util.List;

public class JsonArray implements JsonElement {
	List<JsonElement> elements;

	public JsonArray(){
		elements = new ArrayList<>();
	}

	@Override
	public String toString() {
		return elements.toString();
	}

	public void add(JsonElement element){
		elements.add(element);
	}

}
