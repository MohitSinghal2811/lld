package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.Tokensier;
import jsonParser.element.JsonEOF;
import jsonParser.element.JsonElement;
import jsonParser.exception.JsonParseException;

public class JsonParser implements Parser{

	@Override
	public JsonElement parse(BufferedReader bReader) throws JsonParseException, IOException {

		Parser parser = new ValueParser();
		JsonElement jsonElement = parser.parse(bReader);
		if(!ValueParser.isValidValue(jsonElement)){
			throw new JsonParseException(jsonElement.toString());
		}

		JsonElement jsonElement2 = Tokensier.getNextToken(bReader);
		if( ! ( jsonElement2 instanceof JsonEOF )){
			throw new JsonParseException("Unexpected token" + jsonElement2.toString());
		}

		return jsonElement;

	}
	
}
