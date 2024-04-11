package main;

public class PasswordGenerator {
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "+*ç%&/()=?!@#";
    
    //Errors
    public static boolean TOOLONG = false;
    
    public String generate(int length){
        TOOLONG = false;
        if(length > 350){
            TOOLONG = true;
            return "";
        }
        String finalS = "";
        do{
            if (length == 0) length = (int)(Math.random() * 11) + 16;
            for(int i = 0; i < length; i++){
                int cat = (int)(Math.random() * 4);
                if(cat == 0){
                    char c = UPPERCASE.charAt((int)(Math.random() * 26));
                    finalS += c;
                }
                else if(cat == 1){
                    char c = LOWERCASE.charAt((int)(Math.random() * 26));
                    finalS += c;
                }
                else if(cat == 2){
                    char c = NUMBERS.charAt((int)(Math.random() * 10));
                    finalS += c;
                }
                else{
                    char c = SYMBOLS.charAt((int)(Math.random() * 13));
                    finalS += c;
                }
            }
        }
        while(checkStrength(finalS) <= 6);
        
        
        return finalS;
    }
    
    public int checkStrength(String s){
        int l = s.length();
        int score = 0;
        if(l > 4) score++;
        if (l > 7) score++;
        if (l > 10) score++;
        if(l >= 16) score++;
        
        boolean containsUpper = false;
        boolean containsLower = false;
        boolean containsNumber = false;
        boolean containsSymbol = false;
        
        for(int i = 0; i < l; i++){
            char c = s.charAt(i);
            String d = Character.toString(c);
            if(UPPERCASE.contains(d) == true)containsUpper = true;
            else if(LOWERCASE.contains(d) == true)containsLower = true;
            else if(NUMBERS.contains(d) == true)containsNumber = true;
            else containsSymbol = true;
        }
        if(containsUpper == true)score++;
        if(containsLower == true)score++;
        if(containsNumber == true)score++;
        if(containsSymbol == true)score++;
        
        return score;
    }
    
    public static void main(String[] args) {
    }
    
}
