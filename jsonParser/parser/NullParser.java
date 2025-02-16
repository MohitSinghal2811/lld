package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonElement;
import jsonParser.element.JsonNull;
import jsonParser.exception.JsonParseException;

public class NullParser implements Parser{

	@Override
	public JsonElement parse(BufferedReader bReader) throws JsonParseException, IOException {
		Parser parser = new MultiCharacterTokenParser(new JsonNull());
		return (JsonNull) parser.parse(bReader);
	}
	
}
