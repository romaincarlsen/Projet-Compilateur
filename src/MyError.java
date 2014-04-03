
public class MyError {

    public static void report(String title, ParseException error) {
        Yaka.error = true;
        TokenMgrError tokenError = new TokenMgrError(
            title+", ligne "+YakaTokenManager.currentLine+" :\n"+error.getMessage()+"\n",
            TokenMgrError.LEXICAL_ERROR
        );
        Writer.errorln(tokenError.getMessage());
    }

}
