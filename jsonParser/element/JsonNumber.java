package jsonParser.element;

public class JsonNumber implements JsonElement{
	
	private Number number;

	public JsonNumber(Number number){
		this.number = number;
	}

	public String toString(){
		return number.toString();
	}
}
