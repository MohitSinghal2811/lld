package jsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import jsonParser.exception.JsonParseException;
import jsonParser.parser.JsonParser;

public class Main {
	public static void main(String args[]) throws JsonParseException, IOException{

		File folder = new File("jsonParser/test");

		if(folder.exists() && folder.isDirectory()){
			File[] files = folder.listFiles();

			for(File file: files){
				BufferedReader bReader = new BufferedReader(new FileReader(file));
				JsonParser parser = new JsonParser();
				try {
					parser.parse(bReader);
					System.out.println("Valid " + file.getName());
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					System.out.println("Invalid " + file.getName());
				}
			}
		}

		
	}
}
