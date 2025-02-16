package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonTrue;
import jsonParser.exception.JsonParseException;

public class TrueParser implements Parser {

	@Override
	public JsonTrue parse(BufferedReader bReader) throws JsonParseException, IOException {
		Parser parser = new MultiCharacterTokenParser(new JsonTrue());
		return (JsonTrue) parser.parse(bReader);
	}
	
}
