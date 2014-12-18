package main;

import java.util.Arrays;
import java.util.Comparator;

public class TwoWaysSorting {
    public String sortingMethod(String[] stringList) {


        String[] original   =   new String[stringList.length];

        System.arraycopy(stringList,0,original,0,stringList.length);

        String[] backup =   new String[stringList.length];
        System.arraycopy(stringList,0,backup,0,stringList.length);
        boolean  okay1  =   false;
        boolean  okay2  =   false;

        Arrays.sort(stringList,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.compareTo(o2);

            }
        });

        Arrays.sort(backup,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() > o2.length()) {
                    return 1;
                } else if(o1.length() < o2.length()) {
                    return -1;
                }

                return 0;

            }
        });


        okay1   = Arrays.equals(original,stringList);
        okay2   =   Arrays.equals(original,backup);


        if(okay1 && okay2) {
            return "both";
        } if(!okay1 && !okay2) {
            return "none";
        } if(okay1 && !okay2) {
            return "lexicographically";
        }
        return "lengths";

    }
}
