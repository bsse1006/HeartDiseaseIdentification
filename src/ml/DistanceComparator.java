package ml;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Distance> {
    public int compare(Distance d1, Distance d2)
    {
        if(d1.getDistance()-d2.getDistance()>0)
            return 1;
        else
            return -1;
    }
}
