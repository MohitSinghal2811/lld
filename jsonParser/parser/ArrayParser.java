package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.Tokensier;
import jsonParser.element.JsonArray;
import jsonParser.element.JsonCharacter;
import jsonParser.element.JsonElement;
import jsonParser.exception.JsonParseException;

public class ArrayParser implements Parser{

	@Override
	public JsonArray parse(BufferedReader bReader) throws JsonParseException, IOException {
		JsonArray array = new JsonArray();
		Parser parser = new ValueParser();
		JsonElement value = parser.parse(bReader);

		if((value instanceof JsonCharacter) && value.toString().equals("]")){
			return array;
		}
		
		while(true){

			if(ValueParser.isValidValue(value)){
				array.add(value);
			}
			else {
				throw new JsonParseException(value.toString());
			}

			JsonElement lastToken = Tokensier.getNextToken(bReader);
			if((lastToken instanceof JsonCharacter) && lastToken.toString().equals("]")){
				break;
			}

			if(!(lastToken instanceof JsonCharacter) || !lastToken.toString().equals(",")){
				throw new JsonParseException(lastToken.toString());
			}

			value = parser.parse(bReader);
			
		}

		return array;
	}
	
}
