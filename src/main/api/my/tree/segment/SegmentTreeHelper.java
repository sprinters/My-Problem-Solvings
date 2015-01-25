package main.api.my.tree.segment;

import main.api.my.utils.mis.misutils.MiscUtils;
import main.api.my.utils.number.MyIntegerUtils;

/**
 * * @author sandeepandey
 */
public class SegmentTreeHelper {

    private static int nextPowerOfTwo      =   0;
    private static int steps               =   0;
    private static int mappedValueWithStep =   0;
    private static int totalSize ;
    public static void init(int size,boolean shouldDebug) {
        calculateSize(size,shouldDebug);
    }


    /**
     *
     * @param len
     * @return
     */
    private static void calculateSize(int len,boolean shouldDebug) {
        nextPowerOfTwo = (int) MiscUtils.nextPowerOfTwoByBitShift(len);
        steps           =   MiscUtils.stepsRequiredToMakeItOne(nextPowerOfTwo);
        mappedValueWithStep = (int) (MyIntegerUtils.power(2l, steps - 1) -1);
        if(shouldDebug) {
            System.out.print("In calculate Size method ,following information have been processed.\n");
            System.out.println("Next Power Of Two is::"+nextPowerOfTwo);
            System.out.println("Step Count is::"+steps);
            System.out.println("Mapped Value with step is::"+mappedValueWithStep);
            System.out.println("------------------------------");
        }
        totalSize = nextPowerOfTwo + mappedValueWithStep;
    }


    public static int getTotalNodeCount() {
        return totalSize;
    }

    public static int getFirstLeafPosition() {
        return mappedValueWithStep;
    }

    public static int getLeafNodeCount() {
        return nextPowerOfTwo;
    }

}
