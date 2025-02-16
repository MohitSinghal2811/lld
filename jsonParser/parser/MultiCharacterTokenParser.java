package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonElement;
import jsonParser.exception.JsonParseException;

public class MultiCharacterTokenParser implements Parser {
	JsonElement token;

	MultiCharacterTokenParser(JsonElement token){
		this.token = token;
	}
	@Override
	public JsonElement parse(BufferedReader bReader) throws JsonParseException, IOException {
		int currentPos = 1;
		String tokenString = token.toString();
		while(currentPos < tokenString.length()){
			int ch = bReader.read();
			if(tokenString.charAt(currentPos) != ch){
				throw new JsonParseException(Character.toString(ch));
			}
			currentPos++;
		}
		return token;
	}

}
