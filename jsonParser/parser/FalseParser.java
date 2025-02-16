package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonFalse;
import jsonParser.exception.JsonParseException;

public class FalseParser implements Parser {

	@Override
	public JsonFalse parse(BufferedReader bReader) throws IOException, JsonParseException {
		Parser parser = new MultiCharacterTokenParser(new JsonFalse());
		return (JsonFalse) parser.parse(bReader);
	}
	
}
