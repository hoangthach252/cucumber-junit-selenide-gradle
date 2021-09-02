package utils;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataHelper {

    public static String getRegExrMatchingGroup(String inputString, String pattern, int matchingGroup) {
        String result = null;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inputString);

        if (m.find()) {
            result = m.group(matchingGroup);
        }
        return result;
    }

    public static String[] splitStringToArrayByDelimiter(String inputStr, String delimiter) {
        String[] listString = inputStr.split(delimiter);
        for (int i = 0; i < listString.length; i++)
            listString[i] = listString[i].trim();
        return listString;
    }

    public static String[] convertStringListToArray(String inputStr) {
        return splitStringToArrayByDelimiter(inputStr, ",");
    }

    public static float convertStringToFloat(String floatString) {
        return Float.parseFloat(floatString);
    }

    public static int convertStringToInt(String intString) {
        return Integer.parseInt(intString);
    }

    /**
     * Round to certain number of decimals
     */
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    /**
     * Note that this method will change permanently the order of input List
     */
    public static boolean isEqualIgnoringOrder(List<String> list1, List<String> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    public static List<String> getUniqueListFromList(List<String> stringList) {
        return Arrays.asList(new LinkedHashSet<>(stringList).toArray(new String[]{}));
    }

    public static String removeCharactersFromString(String inputStr, String... removedChars) {
        for (String removedChar : removedChars) {
            inputStr = inputStr.replace(removedChar, "");
        }
        return inputStr;
    }

    /*
     * Using substring to get text from inputStr
     * from: location of first character from string which want to get
     * char: last character from string which want to get
     * */
    public static String getSubString(String inputStr, int from, char character) {
        return inputStr.substring(from, inputStr.indexOf(character));
    }

    /*
     * @param beginIndex:  the beginning index, inclusive.
     * @param endIndex  :  the ending index, exclusive.
     * */
    public static String getSubString(String inputStr, int beginIndex, int endIndex) {
        return inputStr.substring(beginIndex, endIndex);
    }
}