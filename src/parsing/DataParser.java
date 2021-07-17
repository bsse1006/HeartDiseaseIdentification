package parsing;

import ml.DataPoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataParser
{
    private List<DataPoint> trainingPoints = new ArrayList<>();

    public void parseTrainingData () throws FileNotFoundException
    {
        Scanner cin = new Scanner(new File("src/files/processed.cleveland.data"));

        while (cin.hasNextLine())
        {
            String temp = cin.nextLine();

            Scanner tempScanner = new Scanner(temp).useDelimiter(",");

            DataPoint dataPoint = new DataPoint(
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble(),
                    tempScanner.nextDouble()
            );

            //System.out.println(dataPoint);

            trainingPoints.add(dataPoint);

            tempScanner.close();
        }

        cin.close();
    }

    public List<DataPoint> getTrainingPoints() {
        return trainingPoints;
    }

    @Override
    public String toString() {
        return "DataParser{" +
                "trainingPoints=" + trainingPoints +
                '}';
    }
}
