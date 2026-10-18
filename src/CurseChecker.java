public class CurseChecker {
    /*
    the program will require a text from txt.file, than it will check if thare are any curse words in it and if yes, than it will sencor it
    (it will censor it even if theres somethink more to the word itself)
    */
    public static String chackerCURSE(String text){


        //word will be diffrent of curse words in the list every loop
        for (String word : CurseWords.cuss_words) {

            //the program checks for the regex ( (?i) ignores case, \\w* will make so even if somethink is writen after or before the word)
            text = text.replaceAll("(?i)" + word + "\\w*", "***");
        }
        return text;

    }


}
