public class Alphabet {

    //Strings containing every character from every type, which we later add to our pool of available characters.
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~? ";

    public final StringBuilder pool;
    //Initializing StringBuilder

    //Checking which letters should be added(based on the user input) to the pool of available characters in order to generate password.
    public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean symbolsIncluded){

        pool = new StringBuilder();

        if(uppercaseIncluded)
            pool.append(UPPERCASE_LETTERS);
        if(lowercaseIncluded)
            pool.append(LOWERCASE_LETTERS);
        if(numbersIncluded)
            pool.append(NUMBERS);
        if(symbolsIncluded)
            pool.append(SYMBOLS);
    }

    //Fetching the pool of available characters.
    public String getAlphabet()
    {
        return pool.toString();
    }
}
