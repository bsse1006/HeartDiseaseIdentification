package parsing;

import ml.DataPoint;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataParser
{
    private List<DataPoint> allPoints = new ArrayList<>();

    private double [] maxvalues = new double [13];
    private double [] minvalues = new double [13];

    public void populateMinMaxArraysWithDummy ()
    {
        for (int i=0; i<13; i++)
        {
            minvalues[i]=Double.MAX_VALUE;
            maxvalues[i]=Double.MIN_VALUE;
        }
    }

    public void populateMinMaxArray ()
    {
        for (DataPoint dataPoint: allPoints)
        {
            if (dataPoint.getAge()>maxvalues[0])
                maxvalues[0]=dataPoint.getAge();
            if (dataPoint.getAge()<minvalues[0])
                minvalues[0]=dataPoint.getAge();

            if (dataPoint.getSex()>maxvalues[1])
                maxvalues[1]=dataPoint.getSex();
            if (dataPoint.getSex()<minvalues[1])
                minvalues[1]=dataPoint.getSex();

            if (dataPoint.getCp()>maxvalues[2])
                maxvalues[2]=dataPoint.getCp();
            if (dataPoint.getCp()<minvalues[2])
                minvalues[2]=dataPoint.getCp();

            if (dataPoint.getTrestbps()>maxvalues[3])
                maxvalues[3]=dataPoint.getTrestbps();
            if (dataPoint.getTrestbps()<minvalues[3])
                minvalues[3]=dataPoint.getTrestbps();

            if (dataPoint.getChol()>maxvalues[4])
                maxvalues[4]=dataPoint.getChol();
            if (dataPoint.getChol()<minvalues[4])
                minvalues[4]=dataPoint.getChol();

            if (dataPoint.getFbs()>maxvalues[5])
                maxvalues[5]=dataPoint.getFbs();
            if (dataPoint.getFbs()<minvalues[5])
                minvalues[5]=dataPoint.getFbs();

            if (dataPoint.getRestecg()>maxvalues[6])
                maxvalues[6]=dataPoint.getRestecg();
            if (dataPoint.getRestecg()<minvalues[6])
                minvalues[6]=dataPoint.getRestecg();

            if (dataPoint.getThalach()>maxvalues[7])
                maxvalues[7]=dataPoint.getThalach();
            if (dataPoint.getThalach()<minvalues[7])
                minvalues[7]=dataPoint.getThalach();

            if (dataPoint.getExang()>maxvalues[8])
                maxvalues[8]=dataPoint.getExang();
            if (dataPoint.getExang()<minvalues[8])
                minvalues[8]=dataPoint.getExang();

            if (dataPoint.getOldpeak()>maxvalues[9])
                maxvalues[9]=dataPoint.getOldpeak();
            if (dataPoint.getOldpeak()<minvalues[9])
                minvalues[9]=dataPoint.getOldpeak();

            if (dataPoint.getSlope()>maxvalues[10])
                maxvalues[10]=dataPoint.getSlope();
            if (dataPoint.getSlope()<minvalues[10])
                minvalues[10]=dataPoint.getSlope();

            if (dataPoint.getCa()>maxvalues[11])
                maxvalues[11]=dataPoint.getCa();
            if (dataPoint.getCa()<minvalues[11])
                minvalues[11]=dataPoint.getCa();

            if (dataPoint.getThal()>maxvalues[12])
                maxvalues[12]=dataPoint.getThal();
            if (dataPoint.getThal()<minvalues[12])
                minvalues[12]=dataPoint.getThal();
        }
    }

    public void scaleTrainingData ()
    {
        populateMinMaxArraysWithDummy();
        populateMinMaxArray();

        for (DataPoint dataPoint: allPoints)
        {
            scaleData(dataPoint);
        }
    }

    public void scaleData (DataPoint dataPoint)
    {
        dataPoint.setAge((dataPoint.getAge()-minvalues[0])/(maxvalues[0]-minvalues[0]));
        dataPoint.setAge((dataPoint.getSex()-minvalues[1])/(maxvalues[1]-minvalues[1]));
        dataPoint.setAge((dataPoint.getCp()-minvalues[2])/(maxvalues[2]-minvalues[2]));
        dataPoint.setAge((dataPoint.getTrestbps()-minvalues[3])/(maxvalues[3]-minvalues[3]));
        dataPoint.setAge((dataPoint.getChol()-minvalues[4])/(maxvalues[4]-minvalues[4]));
        dataPoint.setAge((dataPoint.getFbs()-minvalues[5])/(maxvalues[5]-minvalues[5]));
        dataPoint.setAge((dataPoint.getRestecg()-minvalues[6])/(maxvalues[6]-minvalues[6]));
        dataPoint.setAge((dataPoint.getThalach()-minvalues[7])/(maxvalues[7]-minvalues[7]));
        dataPoint.setAge((dataPoint.getExang()-minvalues[8])/(maxvalues[8]-minvalues[8]));
        dataPoint.setAge((dataPoint.getOldpeak()-minvalues[9])/(maxvalues[9]-minvalues[9]));
        dataPoint.setAge((dataPoint.getSlope()-minvalues[10])/(maxvalues[10]-minvalues[10]));
        dataPoint.setAge((dataPoint.getCa()-minvalues[11])/(maxvalues[11]-minvalues[11]));
        dataPoint.setAge((dataPoint.getThal()-minvalues[12])/(maxvalues[12]-minvalues[12]));
    }

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

            allPoints.add(dataPoint);

            tempScanner.close();
        }

        cin.close();

        scaleTrainingData();
    }

    public List<DataPoint> getAllPoints() {
        return allPoints;
    }

    @Override
    public String toString() {
        return "DataParser{" +
                "allPoints=" + allPoints +
                '}';
    }
}
