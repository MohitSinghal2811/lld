package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.Tokensier;
import jsonParser.element.JsonCharacter;
import jsonParser.element.JsonElement;
import jsonParser.element.JsonObject;
import jsonParser.element.JsonString;
import jsonParser.exception.JsonParseException;

public class ObjectParser implements Parser {

	@Override
	public JsonObject parse(BufferedReader bReader) throws IOException {
		JsonObject obj = new JsonObject();
		JsonElement key = Tokensier.getNextToken(bReader);
		if((key instanceof JsonCharacter) && key.toString().equals("}")){
			return obj;
		}

		while(true){
			
			if(!(key instanceof JsonString)){
				throw new JsonParseException(key.toString());
			}

			JsonElement colon = Tokensier.getNextToken(bReader);
			if(!(colon instanceof JsonCharacter) || !colon.toString().equals(":")){
				throw new JsonParseException(key.toString());
			}

			Parser parser = new ValueParser();
			JsonElement value = parser.parse(bReader);
			if(ValueParser.isValidValue(value)){
				obj.addField((JsonString)key, value);
			}
			else {
				throw new JsonParseException(value.toString());
			}


			JsonElement lastToken = Tokensier.getNextToken(bReader);
			if((lastToken instanceof JsonCharacter) && lastToken.toString().equals("}")){
				break;
			}

			if(!(lastToken instanceof JsonCharacter) || !lastToken.toString().equals(",")){
				throw new JsonParseException(lastToken.toString());
			}

			key = Tokensier.getNextToken(bReader);
			
		}

		return obj;
	}
	
}
