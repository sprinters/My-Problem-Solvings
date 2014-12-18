package main.hackerrank.special.weekly.year_2014.june.third;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class AcmIcpcTeam {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int peopleCount =   in.readInt();
        int topicCount  =   in.readInt();
        int optimalTeamCount    =   0;
        int optimalTopicCount   =   0;

        String[] topicDetails   = IOUtils.readStringArray(in,peopleCount);

        for(int i   =   0;i < peopleCount-1 ; i++) {
            for(int j   =   i+1 ; j < peopleCount ; j++) {

                int tmpCount    =   0;
                for(int k   =   0;k < topicDetails[i].length() ; k++) {
                    if(topicDetails[i].charAt(k) == '1' || topicDetails[j].charAt(k)    ==  '1') {
                        tmpCount++;
                    }
                }

                if(tmpCount > optimalTopicCount) {
                    optimalTopicCount   =   tmpCount;
                    optimalTeamCount    =   1;
                } else if(tmpCount  ==  optimalTopicCount) {

                    optimalTeamCount++;
                }

            }
        }

        out.printLine(optimalTopicCount);
        out.printLine(optimalTeamCount);



    }
}
