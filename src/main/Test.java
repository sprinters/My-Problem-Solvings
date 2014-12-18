package main;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


            int[] a = IOUtils.readIntArray(in,3);
            int N   =   in.readInt();
            int sum    =    0;

            List<Integer> list    =    new ArrayList<Integer>();

            for(Integer i : a) {
                list.add(i);
            }

            List<Integer> tmp    =    new ArrayList<Integer>();

            for(int i    =    0;i < N ; i++) {
                for(int j=0;j < list.size()-1 ; j++) {

                    int diff    =    list.get(j+1)-list.get(j);
                    tmp.add(diff);
                }

                list    =    tmp;
                out.printLine(list);
                tmp =   new ArrayList<Integer>();

            }
            out.printLine(list);
            for(Integer i : list) {
                sum+=i;
            }

           out.printLine(sum);
        }
    }

