package jsonParser.element;

public class JsonTrue implements JsonElement{
	boolean value = true;

	@Override
	public String toString() {
		return "true";
	}


}
