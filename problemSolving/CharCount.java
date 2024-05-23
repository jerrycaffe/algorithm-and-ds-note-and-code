package problemSolving;

import java.util.HashMap;

class CharCount {
    // Write a function which takes in a string an returns counts of each character
    // in the string
    static HashMap<String, Integer> naiveCharCount(String str) {
        HashMap<String, Integer> result = new HashMap<>();
        // convert the given string to array of strings
        // iterate through each of the string, for each string look for other occurrence
        // of the string into lower case within the given the converted array of strings
        // check if the current value exists within the result map, if it does
        // increament the value and if it does not add it with an initial value of 1
        // return the result

        String[] newStr = str.split("");
        for (int i = 0; i < newStr.length; i++) {
            int count = 1;

            for (int j = i + 1; j < newStr.length; j++) {
                if (newStr[i].equalsIgnoreCase(newStr[j])) {
                    count++;
                }

            }
            if (result.get(newStr[i].toLowerCase()) == null)
                result.put(newStr[i].toLowerCase(), count);
        }
        return result;
    }

    static HashMap<String, Integer> charCount(String str) {
        HashMap<String, Integer> result = new HashMap<>();
        String[] newStr = str.split("");
        for (int i = 0; i < newStr.length; i++) {
            Integer prevValue = result.get(newStr[i].toLowerCase());
            if (prevValue != null && newStr[i].matches("[a-z0-9]")) {
                prevValue++;
                result.put(newStr[i].toLowerCase(), prevValue);
            } else if(newStr[i].matches("[a-z0-9]"))
                result.put(newStr[i].toLowerCase(), 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(charCount("Jerry adeleye"));
    }

}