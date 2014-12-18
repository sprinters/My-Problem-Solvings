package test.on2014_02.on2014_02_25_TopCoder_SRM__538.EvenRoute;



public class EvenRoute {
    public String isItPossible(int[] x, int[] y, int wantedParity) {

        for(int i   =   0;i < x.length ; i++) {


            if(Math.abs(x[i]+y[i]) % 2 == wantedParity) {
                return "CAN";
            }
        }
        return "CANNOT";
    }
}
