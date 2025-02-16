package jsonParser.element;

public class JsonCharacter implements JsonElement{
	char c;

	public JsonCharacter(char c){
		this.c = c;
	}
	@Override
	public String toString() {
		return Character.toString(c);
	}
}
