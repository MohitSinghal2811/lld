package jsonParser.element;

public class JsonFalse implements JsonElement{
	boolean value = false;

	@Override
	public String toString() {
		return "false";
	}

}
