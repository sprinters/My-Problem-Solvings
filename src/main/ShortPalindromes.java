package main;

import java.util.HashMap;
import java.util.Map;

public class ShortPalindromes {

    Map<String,String> cache    =   new HashMap<String,String>();

    public String shortest(String base) {

        if(cache.containsKey(base)) {
            return cache.get(base);
        }

        char start  =   base.charAt(0);
        char end    =   base.charAt(base.length()-1);

        if(isPalindrome(base)) {
            cache.put(base,base);
        } else if(base.charAt(0)    ==  base.charAt(base.length()-1)) {
            cache.put(base,start + shortest(base.substring(1,base.length()-1)) + start);
        } else {

            cache.put(base,min(start + shortest(base.substring(1)) + start,
                    end+shortest(base.substring(0,base.length()-1)) + end)) ;


        }

        return cache.get(base);
    }


    public String min(String first,String second) {

        if(first.length() > second.length()) {
            return second;
        } else if(second.length() > first.length()) {
            return first;
        }

        return first.compareTo(second) < 0 ? first:second;


    }


    public boolean isPalindrome(String candidate) {
        return candidate.equals(new StringBuilder(candidate).reverse().toString());
    }
}
