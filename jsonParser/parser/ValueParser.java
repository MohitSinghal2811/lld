package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;
import jsonParser.Tokensier;
import jsonParser.element.JsonArray;
import jsonParser.element.JsonCharacter;
import jsonParser.element.JsonElement;
import jsonParser.element.JsonFalse;
import jsonParser.element.JsonNull;
import jsonParser.element.JsonNumber;
import jsonParser.element.JsonObject;
import jsonParser.element.JsonString;
import jsonParser.element.JsonTrue;
import jsonParser.exception.JsonParseException;

public class ValueParser implements Parser{

	@Override
	public JsonElement parse(BufferedReader bReader) throws JsonParseException, IOException {
		JsonElement token = Tokensier.getNextToken(bReader);
		if((token instanceof JsonCharacter) && token.toString().equals("{")){
			return new ObjectParser().parse(bReader);
		}
		if((token instanceof JsonCharacter) && token.toString().equals("[")){
			return new ArrayParser().parse(bReader);
		}

		return token;

	}

	public static boolean isValidValue(JsonElement token){
		return (token instanceof JsonFalse) || (token instanceof JsonTrue) || (token instanceof JsonNull) || (token instanceof JsonNumber) || (token instanceof JsonString) || (token instanceof JsonObject) || (token instanceof JsonArray);
	}
	
}
