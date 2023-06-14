package labs.lab4.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Lab4 {
    
    public static HashMap< String, String > getDictionary(String path) throws FileReadException, InvalidFileFormatException {
        
        HashMap< String, String > dict;
        
        try (BufferedReader buff = new BufferedReader(new FileReader(path))) {
            String line;
            dict = new HashMap();
            while ((line = buff.readLine()) != null) {
                int delimiter = line.indexOf('|');
                if (delimiter == -1) {
                    throw new InvalidFileFormatException("Wrong format of the dictionary " + path);
                }
                String key = line.substring(0, delimiter - 1);
                String value = line.substring(delimiter + 1);
                dict.put(key, value);
            }
        } catch (IOException ex) {
            throw new FileReadException("Unable to read from the dictionary " + path);
        }
        return dict;
    }
    
    public static ArrayList< String > getTextFromFile(String path) throws FileReadException {
        ArrayList< String > text;
        try (BufferedReader buff = new BufferedReader(new FileReader(path))) {
            text = new ArrayList();
            String line;
            while ((line = buff.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word: words) {
                    text.add(word.toLowerCase());
                }
            }
        } catch (IOException ex) {
            throw new FileReadException("Unable to read text from file " + path);
        }
        return text;
    }

    public static void main(String[] args) {
        String pathToDictionary = args[0];
        String pathToText = args[1];
        try {
            HashMap< String, String > dict = getDictionary(pathToDictionary);
            ArrayList< String > text = getTextFromFile(pathToText);
            Translator translator = new Translator(dict);
            ArrayList< String > translatedText = translator.translate(text);
            for (String word: translatedText) {
                System.out.println(word);
            }          
        }
        catch (FileReadException | InvalidFileFormatException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
