package jsonParser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonCharacter;
import jsonParser.element.JsonEOF;
import jsonParser.element.JsonElement;
import jsonParser.exception.JsonParseException;
import jsonParser.parser.StringParser;
import jsonParser.parser.TrueParser;
import jsonParser.parser.FalseParser;
import jsonParser.parser.NullParser;
import jsonParser.parser.NumberParser;
import jsonParser.parser.Parser;

public class Tokensier {
	public static JsonElement getNextToken(BufferedReader bReader) throws JsonParseException, IOException{
		int c;
		do{
			bReader.mark(1);
			c = bReader.read();
		}while(isWhiteSpace(c));
		Parser parser;
		switch (c) {
			case '{':
				return new JsonCharacter('{');
			case '}':
				return new JsonCharacter('}');
			case '[':
				return new JsonCharacter('[');
			case ']': 
				return new JsonCharacter(']');
			case ',':
				return new JsonCharacter(',');
			case ':': 
				return new JsonCharacter(':');
			case '\"':
				parser = new StringParser();
				return parser.parse(bReader);
			case 't':
				parser = new TrueParser();
				return parser.parse(bReader);
			case 'f': 
				parser = new FalseParser();
				return parser.parse(bReader);
			case 'n':
				parser = new NullParser();
				return parser.parse(bReader);
			case -1:
				return new JsonEOF();
			default:
				if(Character.isDigit(c) || c == '-'){
					parser = new NumberParser();
					bReader.reset();
					return parser.parse(bReader);
				}
			throw new JsonParseException("Unexpected token " + (char)c);
		}
	}

	public static boolean isWhiteSpace(int c){
		switch (c) {
			case ' ':
				return true;
			case '\n':
				return true;
			case '\t': 
				return true;
			case '\r':
				return true;
			default:
				return false;
		}
	}

}
