package frequencyCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UncommonFromSentence {
    // break array1 into array of strings
    // check if the value was in the hasmap, if yes increase the number if no store
    // each word into an hashmap
    // break array2 into array of strings
    // for array perform the same operation to it
    // loop through the hasmap and see the element which appears just once, create
    // an array and add in the value

    static String[] solution(String str1, String str2) {
        String[] strArr1 = str1.split(" ");
        String[] strArr2 = str2.split(" ");

        Map<String, Integer> stock = new HashMap<String, Integer>();
        for (int i = 0; i < strArr1.length; i++) {
            Integer prevValue = stock.get(strArr1[i]);
            if (prevValue != null) {
                prevValue++;
            } else
                prevValue = 1;

            stock.put(strArr1[i], prevValue);
        }

        for (int i = 0; i < strArr2.length; i++) {
            Integer prevValue = stock.get(strArr2[i]);
            if (prevValue != null) {
                prevValue++;
            } else
                prevValue = 1;

            stock.put(strArr2[i], prevValue);
        }
        ArrayList<String> resuList = new ArrayList<>();
        for (Map.Entry<String, Integer> set : stock.entrySet()) {
            if (set.getValue() == 1)
                resuList.add(set.getKey());
        }
        String[] result = new String[resuList.size()];
        return resuList.toArray(result);
    }

    public static void main(String[] args) {
        String arr1 = "the name of my school is ijebu";
        String arr2 = "the name of my school is ibadan";
        System.out.println(Arrays.toString((solution(arr1, arr2))));
    }
}
