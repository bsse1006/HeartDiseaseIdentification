package ml;

import java.util.Comparator;

public class Distance
{
    private double distance;
    private double num;

    private DataPoint testPoint;
    private DataPoint trainingPoint;

    public Distance(DataPoint testPoint, DataPoint trainingPoint) {
        this.testPoint = testPoint;
        this.trainingPoint = trainingPoint;

        calcDistance();
    }

    private void calcDistance ()
    {
        //Distance using only selected features
        distance = Math.sqrt(
                Math.pow(testPoint.getAge()-trainingPoint.getAge(),2)+
                //Math.pow(testPoint.getSex()-trainingPoint.getSex(),2)+
                Math.pow(testPoint.getCp()-trainingPoint.getCp(),2)+
                //Math.pow(testPoint.getTrestbps()-trainingPoint.getTrestbps(),2)+
                //Math.pow(testPoint.getChol()-trainingPoint.getChol(),2)+
                //Math.pow(testPoint.getFbs()-trainingPoint.getFbs(),2)+
                Math.pow(testPoint.getRestecg()-trainingPoint.getRestecg(),2)+
                //Math.pow(testPoint.getThalach()-trainingPoint.getThalach(),2)+
                Math.pow(testPoint.getExang()-trainingPoint.getExang(),2)+
                //Math.pow(testPoint.getOldpeak()-trainingPoint.getOldpeak(),2)+
                Math.pow(testPoint.getSlope()-trainingPoint.getSlope(),2)+
                Math.pow(testPoint.getCa()-trainingPoint.getCa(),2)+
                Math.pow(testPoint.getThal()-trainingPoint.getThal(),2)
        );

        num = trainingPoint.getNum();
    }

    public double getDistance() {
        return distance;
    }

    public double getNum() {
        return num;
    }
}
