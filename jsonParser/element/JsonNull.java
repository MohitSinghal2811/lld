package jsonParser.element;

public class JsonNull implements JsonElement{
	Object value = null;

	@Override
	public String toString() {
		return "null";
	}


}
