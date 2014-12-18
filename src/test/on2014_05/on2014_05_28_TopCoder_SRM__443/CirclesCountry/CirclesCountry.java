package test.on2014_05.on2014_05_28_TopCoder_SRM__443.CirclesCountry;



public class CirclesCountry {
    public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {


        /**
         * We have to find those circle count which have one point outside from the circle and
         * other point inside the circle.first lets sort the circles on the basis of increasing radius.
         *
         */

         int minCut =   0;
         for(int i  =   0;i < X.length ; i++) {

             int xAt    =   X[i];
             int yAt    =   Y[i];
             int rAt    =   R[i];


             boolean f1 =   isInsideCircle(xAt,yAt,rAt,x1,y1);
             boolean f2 =   isInsideCircle(xAt,yAt,rAt,x2,y2);

             if(f1 != f2) {
                minCut++;
             }

         }
         return minCut;
    }


    public boolean isInsideCircle(int x,int y,int r,int tmpX,int tmpY) {

        return (x-tmpX) * (x-tmpX) + (y-tmpY) * (y-tmpY) <= r * r;



    }
}
