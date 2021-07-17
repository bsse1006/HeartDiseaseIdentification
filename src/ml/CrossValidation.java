package ml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CrossValidation
{
    /*private List<DataPoint> points = new ArrayList<DataPoint>();
    private List<DataPoint> trainingPoints = new ArrayList<DataPoint>();
    private List<DataPoint> testPoints = new ArrayList<DataPoint>();

    public void getTestAndTrainingData (File file) throws FileNotFoundException {

        Scanner cin = new Scanner(file);

        while (cin.hasNextLine())
        {
            String temp = cin.nextLine();

            Scanner tempScanner = new Scanner(temp).useDelimiter(",");

            DataPoint dataPoint = new DataPoint(tempScanner.nextDouble(),
                    tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),
                    tempScanner.next());
            points.add(dataPoint);

            tempScanner.close();
        }
        cin.close();

        for(int i=0; i<points.size()/10; i++)
        {
            Random rand = new Random();
            int temp = rand.nextInt(points.size());
            if(points.get(temp)==null)
            {
                i--;
                continue;
            }
            testPoints.add(points.get(temp));
            points.set(temp,null);
        }

        for(int i=0; i<points.size(); i++)
        {
            if(points.get(i)==null)
                continue;

            trainingPoints.add(points.get(i));
        }
    }

    public List<DataPoint> getTrainingPoints() {
        return trainingPoints;
    }

    public List<DataPoint> getTestPoints() {
        return testPoints;
    }*/
}
