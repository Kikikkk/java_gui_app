package labs.lab4.src;

public class InvalidFileFormatException extends Exception{
    public InvalidFileFormatException(String errorMessage) {
        super(errorMessage);    
    }
}