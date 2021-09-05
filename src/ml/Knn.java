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
    private double confidence;

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
        Collections.sort(resultPoints,new DistanceComparator());

        this.result = isDiseasePresent();
    }

    /*public boolean isDiseasePresentUsingWeightedKnn ()
    {
        double classAbsent=0, classPresent=0;

        //k=5
        for (int i=0; i<7; i++)
        {
            if (resultPoints.get(i).getNum()==0)
                classAbsent += (resultPoints.get(14).getDistance()-resultPoints.get(i).getDistance())/(resultPoints.get(14).getDistance()-resultPoints.get(0).getDistance()); //(1.0 / (i + 1));
            else
                classPresent += (resultPoints.get(14).getDistance()-resultPoints.get(i).getDistance())/(resultPoints.get(14).getDistance()-resultPoints.get(0).getDistance());//(1.0 / (i + 1));
        }

        if(classAbsent>classPresent) {
            confidence = classAbsent/classAbsent+classPresent;
            return false;
        }
        else {
            confidence = classPresent/classAbsent+classPresent;
            return true;
        }
    }*/

    public boolean isDiseasePresent ()
    {
        double classAbsent=0, classPresent=0;

        //k=5
        for (int i=0; i<5; i++)
        {
            if (resultPoints.get(i).getNum()==0)
                classAbsent += 1;// (1.0 / (i + 1));
            else
                classPresent += 1;//(1.0 / (i + 1));
        }

        if(classAbsent>classPresent) {
            confidence = classAbsent/classAbsent+classPresent;
            return false;
        }
        else {
            confidence = classPresent/classAbsent+classPresent;
            return true;
        }
    }

    public boolean isAccurate()
    {
        boolean originalClass;
        if (testingPoint.getNum()==0)
        {
            originalClass = false;
        }
        else
        {
            originalClass = true;
        }


        if (originalClass==result)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean getResult() {
        return result;
    }
}
