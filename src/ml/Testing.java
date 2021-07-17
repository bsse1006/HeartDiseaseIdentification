package ml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testing
{
    /*List<DataPoint> trainingPoints;
    List<DataPoint> testPoints;
    List<Distance> resultPoints = new ArrayList<>();

    int accurate = 0;
    double accuracy = 0;

    public Testing(List<DataPoint> trainingPoints, List<DataPoint> testPoints) {
        this.trainingPoints = trainingPoints;
        this.testPoints = testPoints;
        doKNN();
    }

    public void doKNN ()
    {
        for(DataPoint dataPoint: testPoints)
        {
            for (DataPoint trainingPoint: trainingPoints)
            {
                Distance distance = new Distance(dataPoint,trainingPoint);
                resultPoints.add(distance);
            }
            Collections.sort(resultPoints,Distance.distanceComparator);

            if(dataPoint.getClassName().equals(calcClassName()))
                accurate++;

            resultPoints.clear();
        }

        accuracy=(double)accurate/testPoints.size();
    }

    public String calcClassName ()
    {
        double classA=0, classB=0, classC=0;

        for (int i=0; i<5; i++)
        {
            if (resultPoints.get(i).getClassName().equals("Iris-setosa"))
                classA += (1.0 / (i + 1));
            else if (resultPoints.get(i).getClassName().equals("Iris-versicolor"))
                classB += (1.0 / (i + 1));
            else if (resultPoints.get(i).getClassName().equals("Iris-virginica"))
                classC += (1.0 / (i + 1));
        }

        if(classA>classB&&classA>classC)
            return "Iris-setosa";
        else if(classB>classC&&classB>classA)
            return "Iris-versicolor";
        else
            return "Iris-virginica";
    }

    public double getAccuracy() {
        return accuracy;
    }*/
}
