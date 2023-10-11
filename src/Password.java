public class Password {
    String Value;
    int Length;

    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    public int CharType(char C) {
        int type;

        // Char is Uppercase Letter
        if ((int) C >= 65 && (int) C <= 90)
            type = 1;

            // Char is Lowercase Letter
        else if ((int) C >= 97 && (int) C <= 122) {
            type = 2;
        }

        // Char is Digit
        else if ((int) C >= 60 && (int) C <= 71) {
            type = 3;
        }

        // Char is Symbol
        else {
            type = 4;
        }

        return type;
    }
    public String toString() {
        return Value;
    }
}