package labs.lab4.src;

import java.util.ArrayList;
import java.util.HashMap;

public class Translator {
    
    public Translator(HashMap< String, String > dict, int forward) {
        this.dict = dict;
        this.forward = forward;
    }
    
    public Translator(HashMap< String, String > dict) {
        this(dict, 10);
    }
    
    public HashMap< String, String > getDict() {
        return dict;
    }
    
    public int getForwardValue() {
        return forward;
    }
    
    public void setDict(HashMap< String, String > newDict) {
        dict = newDict;
    } 
    
    public void setForwardValue(int forward) {
        this.forward = forward;
    }
    
    public ArrayList< String > translate(ArrayList< String > text) {
        ArrayList< String > translatedText = new ArrayList();
        for (int i = 0; i < text.size(); ++i) {
            String largestExpr = new String();
            int shift = 0;
            for (int j = i; j < i + forward && j < text.size(); ++j) {
                String expr = new String();
                for (int k = i; k <= j; ++k) {
                    expr += (k == j) ? text.get(k) : text.get(k) + " ";    
                }
                if (dict.containsKey(expr)) {
                    largestExpr = expr;
                    shift =  j - i;
                }
            }
            if (largestExpr.isEmpty()) {
                translatedText.add(text.get(i));
                
            } else {
                translatedText.add(dict.get(largestExpr));
                i += shift;
            }
        }
        return translatedText;  
    }
    
    private HashMap< String, String > dict;
    private static int forward;
}
