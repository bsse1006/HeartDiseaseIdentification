package ml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knn
{
    private List<DataPoint> trainingPoints;
    private DataPoint testingPoint;
    List<Distance> resultPoints = new ArrayList<>();
    private boolean result;

    public Knn(List<DataPoint> trainingPoints, DataPoint testingPoint) {
        this.trainingPoints = trainingPoints;
        this.testingPoint = testingPoint;
        doKNN();
    }

    public void doKNN ()
    {
        for (DataPoint trainingPoint: trainingPoints)
        {
            Distance distance = new Distance(testingPoint,trainingPoint);
            resultPoints.add(distance);
        }
        Collections.sort(resultPoints,Distance.distanceComparator);

        this.result = isDiseasePresent();
    }

    public boolean isDiseasePresent ()
    {
        double classAbsent=0, classPresent=0;

        for (int i=0; i<5; i++)
        {
            if (resultPoints.get(i).getNum()==0)
                classAbsent += (1.0 / (i + 1));
            else
                classPresent += (1.0 / (i + 1));
        }

        if(classAbsent>classPresent)
            return false;
        else
            return true;
    }

    public boolean getResult() {
        return result;
    }
}
