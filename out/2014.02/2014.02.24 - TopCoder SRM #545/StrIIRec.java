package main;

public class StrIIRec {
    public String recovstr(int n, int minInv, String minStr) {

        StringBuilder letter    =   new StringBuilder();

        for(int i   =   0;i < n ; i++) {
            letter  =   letter.append((char)(i+'a'));
        }

        return solve(letter.toString(),minInv,minStr);
    }

    private String solve(String letter, int minInv, String minStr) {

        if("".equals(letter)) {
            return "";
        }


        for(int i   =   0;i < letter.length() ; i++) {

            if(minStr.length() > 0 && minStr.charAt(0) > letter.charAt(i) ) {
                continue;
            }

            int remainingLen    =   letter.length()-1;

            int remainingInv    =   Math.max(minInv-i,0);

            if( (remainingLen* (remainingLen-1)/2) >= remainingInv) {

                String updatedLetter    =   letter.substring(0,i) + letter.substring(i+1);
                String nminStr  ="";
                if(minStr.length() > 0 && minStr.charAt(0) == letter.charAt(i)) {
                    nminStr  =   minStr.substring(1);
                }

                return ""+letter.charAt(i) +solve(updatedLetter,remainingInv,nminStr);
            }
        }
        return "";
    }
}
