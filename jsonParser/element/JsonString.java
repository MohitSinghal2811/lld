package jsonParser.element;

public class JsonString implements JsonElement{
	
	private String string;

	public JsonString(String string){
		this.string = string;
	}
	
	public String toString(){
		return string;
	}

}
