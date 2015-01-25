package main.hackerearth.openfuture;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.text.DecimalFormat;

public class Task6 {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    public void solve(int testNumber, InputReader in, OutputWriter out) {



        int speedCount = in.readInt();
        int[] speedAt = IOUtils.readIntArray(in,speedCount);
        int[] cusumptionAt = IOUtils.readIntArray(in,speedCount);
        int targetFuel = in.readInt();

        Double maxDistance = Double.MIN_VALUE;

        for(int at = 0; at < speedCount ; at++) {

            Double tmp = Double.valueOf(targetFuel)/Double.valueOf(cusumptionAt[at]);
            maxDistance = Math.max(maxDistance,tmp * Double.valueOf(speedAt[at]));

        }

        out.printLine(decimalFormat.format(maxDistance));


    }
}
