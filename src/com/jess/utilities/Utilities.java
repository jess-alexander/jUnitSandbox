package com.jess.utilities;

/**
 * Created by Jess on 5/12/17.
 */
public class Utilities {

    // Returns a char array containing every nth char
    //  When souceArray.length < n, return sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {

        if(n>sourceArray.length){
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        //start at index n-1, position n, increment by n
        for (int i = n-1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    //removes pairs of the same character that are next to each other
    // by removing on e occurance of the character
    // EX: "ABBCDEEF" -> "ABCDEF"
    // EX: "ABCBEDDF" -> "ABCBDEF (the two Bs aren't next to each other so it's no problem
    public String removePairs(String source){

        // lf length is less than 2, there are no pairs.
        // if source is equal to null, there are no pairs.
        if(source == null || source.length() < 2 ){
            return source;
        }
        StringBuffer sb = new StringBuffer();
        char[] string = source.toCharArray();

        for(int i=0; i<string.length; i++){
            if(i<string.length-1){
                if(string[i] != string[i+1]){
                    sb.append(string[i]);
                }
            }else{
                sb.append(string[i]);
            }
        }

        return sb.toString();
    }

    //perform a conversion based on some internal business rule.
    public int converter(int a, int b){
        return (a/b) + (a * 30) -2;
    }

    public String nullIfOddLength(String source){
        if(source.length() %2 ==0){
            return source;
        }
        return null;
    }
}
