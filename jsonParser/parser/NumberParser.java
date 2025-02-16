package jsonParser.parser;

import java.io.BufferedReader;
import java.io.IOException;

import jsonParser.element.JsonNumber;
import jsonParser.exception.JsonParseException;

public class NumberParser implements Parser {

	StringBuilder sb;

	public NumberParser() {
		sb = new StringBuilder();
	}

	@Override
	public JsonNumber parse(BufferedReader bReader) throws IOException, JsonParseException {
		int ch;
		bReader.mark(1);
		ch = bReader.read();
		if(ch == '-'){
			sb.append('-');
		}
		else {
			bReader.reset();
		}
		return readAfterMinus(bReader);
	}

	void readToDelimiter(BufferedReader bReader) throws IOException, JsonParseException {
		int ch = bReader.read();
		if(!Character.isDigit(ch)){
			throw new JsonParseException(Character.toString(ch));
		}

		while(Character.isDigit(ch)){
			sb.append((char)ch);
			bReader.mark(1);
			ch = bReader.read();
		}
		bReader.reset();
	}

	JsonNumber readFromZero(BufferedReader bReader) throws IOException, JsonParseException {
		int ch;
		bReader.mark(1);
		ch = bReader.read();
		if(ch == '.'){
			sb.append('.');
			return readAfterPeriod(bReader);
		}
		if(ch == 'e' || ch == 'E'){
			sb.append((char)ch);
			return readAfterE(bReader);
		}
		bReader.reset();
		return new JsonNumber(Double.parseDouble(sb.toString()));
	}

	JsonNumber readAfterMinus(BufferedReader bReader) throws IOException, JsonParseException {
		int ch;
		bReader.mark(1);
		ch = bReader.read();
		if(ch == '0'){
			sb.append('0');
			return readFromZero(bReader);
		}
		bReader.reset();
		readToDelimiter(bReader);
		bReader.mark(1);
		ch = bReader.read();
		if(ch == '.'){
			sb.append('.');
			return readAfterPeriod(bReader);
		}
		if(ch == 'e' || ch == 'E'){
			sb.append((char)ch);
			return readAfterE(bReader);
		}
		bReader.reset();
		return new JsonNumber(Double.parseDouble(sb.toString()));
		
	}

	JsonNumber readAfterPeriod(BufferedReader bReader) throws IOException, JsonParseException {
		readToDelimiter(bReader);
		int ch;
		bReader.mark(1);
		ch = bReader.read();
		if(ch == 'e' || ch == 'E'){
			sb.append((char)ch);
			return readAfterE(bReader);
		}
		bReader.reset();
		return new JsonNumber(Double.parseDouble(sb.toString()));
	}

	JsonNumber readAfterE(BufferedReader bReader) throws IOException, JsonParseException {
		bReader.mark(1);
		int ch = bReader.read();
		if(ch == '-' || ch == '+'){
			sb.append((char)ch);
		}
		else {
			bReader.reset();
		}
		readToDelimiter(bReader);
		return new JsonNumber(Double.parseDouble(sb.toString()));
	}
	
}
