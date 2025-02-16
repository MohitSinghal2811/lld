package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonElement;
import jsonParser.exception.JsonParseException;

public interface Parser {

	public JsonElement parse(BufferedReader bReader) throws JsonParseException, IOException;
}
