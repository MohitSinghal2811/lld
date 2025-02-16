package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonString;
import jsonParser.exception.JsonParseException;

public class StringParser implements Parser {

	StringBuilder sb;

	public StringParser(){
		sb = new StringBuilder();
	}
	@Override
	public JsonString parse(BufferedReader bReader) throws IOException, JsonParseException {
		int ch = bReader.read();
		while(ch != '\"'){
			if(ch == '\\'){
				ch = bReader.read();
				switch(ch){
					case '"':
						sb.append('"');
						break;
					case '\\':
						sb.append('\\');
						break;
					case '/':
						sb.append('/');
						break;
					case 'b':
						sb.append('\b');
						break;
					case 'f':
						sb.append('\f');
						break;
					case 'n':
						sb.append('\n');
						break;
					case 'r':
						sb.append('\r');
						break;
					case 't':
						sb.append('\t');
						break;
					case 'u':
						sb.append((char) Integer.parseInt(readHexDigits(bReader), 16));
						break;
					default: 
						throw new JsonParseException(Character.toString(ch));
				}	
			}
			else {
				if(Character.isISOControl(ch)){
					throw new JsonParseException(Character.toString(ch));
				}
				sb.append((char)ch);
			}
			ch = bReader.read();
		}
		return new JsonString(sb.toString());
	}

	String readHexDigits(BufferedReader bReader) throws IOException{
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while(count < 4){
			int c = bReader.read();
			if( (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f') || ( c >= '0' && c <= '9')){
				sb.append((char)c);
			}
			else {
				throw new JsonParseException(Character.toString(c));
			}
			count++;
		}
		return sb.toString();
	}
	
}
