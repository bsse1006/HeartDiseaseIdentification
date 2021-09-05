package ml;

import parsing.DataParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CrossValidation
{
    private List<DataPoint> points = new ArrayList<DataPoint>();
    private List<DataPoint> trainingPoints = new ArrayList<DataPoint>();
    private List<DataPoint> testPoints = new ArrayList<DataPoint>();

    private int truePositive=0;
    private int falsePositive=0;
    private int trueNegative=0;
    private int falseNegative=0;

    private double accuracy;
    private double recall;
    private double precision;
    private double fScore;

    public void doCrossValidation () throws FileNotFoundException
    {
        DataParser dataParser = new DataParser();
        try {
            dataParser.parseTrainingData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        points = dataParser.getAllPoints();

        //randomize
        Collections.shuffle(points);

        for (int i=0; i<10; i++)
        {
            for (int j=0; j<points.size(); j++)
            {
                if (j%10==i)
                {
                    testPoints.add(points.get(j));
                }
                else
                {
                    trainingPoints.add(points.get(j));
                }
            }

            for (int j=0; j<testPoints.size(); j++)
            {
                Knn knn = new Knn(trainingPoints, testPoints.get(j));

                if (knn.isAccurate())
                {
                    if (knn.getResult()==true)
                    {
                        truePositive++;
                    }
                    else
                    {
                        trueNegative++;
                    }
                }
                else
                {
                    if (knn.getResult()==true)
                    {
                        falsePositive++;
                    }
                    else
                    {
                        falseNegative++;
                    }
                }
            }
            trainingPoints.clear();
            testPoints.clear();
        }

        System.out.println("TP          : "+truePositive);
        System.out.println("TN          : "+trueNegative);
        System.out.println("FP          : "+falsePositive);
        System.out.println("FN          : "+falseNegative);
        System.out.println();

        calculateAccuracy();
        calculatePrecision();
        calculateRecall();
        calculateFScore();
    }

    public void calculateAccuracy ()
    {
        accuracy = ((double)trueNegative+truePositive)/((double)trueNegative+truePositive+falseNegative+falsePositive);
    }

    public void calculateRecall ()
    {
        recall = (double)truePositive/((double)truePositive+falseNegative);
    }

    public void calculatePrecision ()
    {
        precision = (double)truePositive/((double)truePositive+falsePositive);
    }

    public void calculateFScore ()
    {
        fScore = (2*precision*recall)/(precision+recall);
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getRecall() {
        return recall;
    }

    public double getPrecision() {
        return precision;
    }

    public double getfScore() {
        return fScore;
    }
}
