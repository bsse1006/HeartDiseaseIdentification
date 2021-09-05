package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ml.CrossValidation;
import ml.DataPoint;
import ml.Knn;
import parsing.DataParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class UserInterface
{
    private Stage primaryStage;

    public UserInterface (Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void showUserInterface ()
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        /*double acc = 0;
        double pre = 0;
        double rec = 0;
        double f = 0;*/

        CrossValidation crossValidation = new CrossValidation();
        try {
            crossValidation.doCrossValidation();

            /*for (int j=0; j<300; j++)
            {
                CrossValidation crossValidation = new CrossValidation();
                crossValidation.doCrossValidation();
                acc = acc + crossValidation.getAccuracy();
                pre = pre + crossValidation.getPrecision();
                rec = rec + crossValidation.getRecall();
                f = f + crossValidation.getfScore();
            }

            acc = acc/300.0;
            pre = pre/300.0;
            rec = rec/300.0;
            f = f/300.0;*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Accuracy    : " + crossValidation.getAccuracy());
        System.out.println("Precision   : " + crossValidation.getPrecision());
        System.out.println("Recall      : " + crossValidation.getRecall());
        System.out.println("F1 Score    : " + crossValidation.getfScore());

        String showAccuracy = "Accuracy    :  " + new DecimalFormat("##.###").format(crossValidation.getAccuracy()) + "\n" +
                "Precision    :  " + new DecimalFormat("##.###").format(crossValidation.getPrecision()) + "\n" +
                "Recall         :  " + new DecimalFormat("##.###").format(crossValidation.getRecall()) + "\n" +
                "F1 Score     :  " + new DecimalFormat("##.###").format(crossValidation.getfScore()) + "\n";

        FileInputStream input = null;
        try {
            input = new FileInputStream("src/files/infoIcon2.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        ImageView iw = new ImageView(i);
        iw.setFitHeight(30);
        iw.setFitWidth(30);
        Button b = new Button("", iw);
        b.setMinSize(30, 30);
        b.setMaxSize(30, 30);

        b.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Evaluation Metrics");
            alert.setTitle("Heart Disease Identifier");
            alert.setContentText(showAccuracy);
            alert.show();
        });
        pane.add(b, 2, 18);


        // Other nodes in the pane
        pane.add(new Label("Age:"), 0, 0);
        TextField age = new TextField();
        pane.add(age, 1, 0);

        pane.add(new Label("Sex:"), 0, 1);
        ToggleGroup sexGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        male.setToggleGroup(sexGroup);
        female.setToggleGroup(sexGroup);
        pane.add(male, 1, 1);
        pane.add(female, 2, 1);

        pane.add(new Label("Chest Pain Type:"), 0, 2);
        ToggleGroup cpGroup = new ToggleGroup();
        RadioButton typicalAngina = new RadioButton("Typical Angina");
        RadioButton atypicalAngina = new RadioButton("Atypical Angina");
        RadioButton nonAnginalPain = new RadioButton("Non Anginal Pain");
        RadioButton asymptomatic = new RadioButton("Asymptomatic");
        typicalAngina.setToggleGroup(cpGroup);
        atypicalAngina.setToggleGroup(cpGroup);
        nonAnginalPain.setToggleGroup(cpGroup);
        asymptomatic.setToggleGroup(cpGroup);
        pane.add(typicalAngina, 1, 2);
        pane.add(atypicalAngina, 2, 2);
        pane.add(nonAnginalPain, 1, 3);
        pane.add(asymptomatic, 2, 3);

        pane.add(new Label("Resting Blood Pressure (in mm Hg):"), 0, 4);
        TextField trestbps = new TextField();
        pane.add(trestbps, 1, 4);

        pane.add(new Label("Serum Cholestoral (in mg/dl):"), 0, 5);
        TextField chol = new TextField();
        pane.add(chol, 1, 5);

        pane.add(new Label("Fasting Blood Sugar (in mg/dl):"), 0, 6);
        TextField fbs = new TextField();
        pane.add(fbs, 1, 6);

        pane.add(new Label("Resting Electrocardiographic Results:"), 0, 7);
        ToggleGroup restecgGroup = new ToggleGroup();
        RadioButton normal = new RadioButton("Normal");
        RadioButton sttWaveAbnormality = new RadioButton("ST-T Wave Abnormality");
        RadioButton leftVentricularHypertrophy = new RadioButton("Left Ventricular Hypertrophy");
        normal.setToggleGroup(restecgGroup);
        sttWaveAbnormality.setToggleGroup(restecgGroup);
        leftVentricularHypertrophy.setToggleGroup(restecgGroup);
        pane.add(normal, 1, 7);
        pane.add(sttWaveAbnormality, 2, 7);
        pane.add(leftVentricularHypertrophy, 3, 7);

        pane.add(new Label("Maximum Heart Rate Achieved:"), 0, 8);
        TextField thalach = new TextField();
        pane.add(thalach, 1, 8);

        pane.add(new Label("Exercise Induced Angina:"), 0, 9);
        ToggleGroup exangGroup = new ToggleGroup();
        RadioButton yes = new RadioButton("Yes");
        RadioButton no = new RadioButton("No");
        yes.setToggleGroup(exangGroup);
        no.setToggleGroup(exangGroup);
        pane.add(yes, 1, 9);
        pane.add(no, 2, 9);

        pane.add(new Label("ST Depression induced by exercise relative to rest:"), 0, 10);
        TextField oldpeak = new TextField();
        pane.add(oldpeak, 1, 10);

        pane.add(new Label("Slope of the peak exercise ST segment:"), 0, 11);
        ToggleGroup slopeGroup = new ToggleGroup();
        RadioButton upSloping = new RadioButton("Upsloping");
        RadioButton flat = new RadioButton("Flat");
        RadioButton downSloping = new RadioButton("Downsloping");
        upSloping.setToggleGroup(slopeGroup);
        flat.setToggleGroup(slopeGroup);
        downSloping.setToggleGroup(slopeGroup);
        pane.add(upSloping, 1, 11);
        pane.add(flat, 2, 11);
        pane.add(downSloping, 3, 11);

        pane.add(new Label("Number of major vessels (0-3) colored by flourosopy:"), 0, 12);
        ToggleGroup caGroup = new ToggleGroup();
        RadioButton ca0 = new RadioButton("0");
        RadioButton ca1 = new RadioButton("1");
        RadioButton ca2 = new RadioButton("2");
        RadioButton ca3 = new RadioButton("3");
        ca0.setToggleGroup(caGroup);
        ca1.setToggleGroup(caGroup);
        ca2.setToggleGroup(caGroup);
        ca3.setToggleGroup(caGroup);
        pane.add(ca0, 1, 12);
        pane.add(ca1, 2, 12);
        pane.add(ca2, 1, 13);
        pane.add(ca3, 2, 13);

        pane.add(new Label("Thal:"), 0, 14);
        ToggleGroup thalGroup = new ToggleGroup();
        RadioButton normalThal = new RadioButton("Normal");
        RadioButton fixedDefect = new RadioButton("Fixed Defect");
        RadioButton reversableDefect = new RadioButton("Reversable Defect");
        normalThal.setToggleGroup(thalGroup);
        fixedDefect.setToggleGroup(thalGroup);
        reversableDefect.setToggleGroup(thalGroup);
        pane.add(normalThal, 1, 14);
        pane.add(fixedDefect, 2, 14);
        pane.add(reversableDefect, 3, 14);

        //diagnosis of heart disease

        Button btAdd = new Button("Generate Result");
        btAdd.setDefaultButton(true);
        btAdd.setOnAction(event -> {

            DataPoint dataPoint = new DataPoint();

            dataPoint.setAge(Double.parseDouble(age.getText()));

            if (male.isSelected())
                dataPoint.setSex(1);
            else if (female.isSelected())
                dataPoint.setSex(0);

            if (typicalAngina.isSelected())
                dataPoint.setCp(1);
            else if (atypicalAngina.isSelected())
                dataPoint.setCp(2);
            else if (nonAnginalPain.isSelected())
                dataPoint.setCp(3);
            else if (asymptomatic.isSelected())
                dataPoint.setCp(4);

            dataPoint.setTrestbps(Double.parseDouble(trestbps.getText()));

            dataPoint.setChol(Double.parseDouble(chol.getText()));

            if (Double.parseDouble(fbs.getText())>120)
                dataPoint.setFbs(1);
            else
                dataPoint.setFbs(0);

            if (normal.isSelected())
                dataPoint.setRestecg(0);
            else if (sttWaveAbnormality.isSelected())
                dataPoint.setRestecg(1);
            else if (leftVentricularHypertrophy.isSelected())
                dataPoint.setRestecg(2);

            dataPoint.setThalach(Double.parseDouble(thalach.getText()));

            if (yes.isSelected())
                dataPoint.setExang(1);
            else if (no.isSelected())
                dataPoint.setExang(0);

            dataPoint.setOldpeak(Double.parseDouble(oldpeak.getText()));

            if (upSloping.isSelected())
                dataPoint.setSlope(1);
            else if (flat.isSelected())
                dataPoint.setSlope(2);
            else if (downSloping.isSelected())
                dataPoint.setSlope(3);

            if (ca0.isSelected())
                dataPoint.setCa(0);
            else if (ca1.isSelected())
                dataPoint.setCa(1);
            else if (ca2.isSelected())
                dataPoint.setCa(2);
            else if (ca3.isSelected())
                dataPoint.setCa(3);

            if (normalThal.isSelected())
                dataPoint.setThal(3);
            else if (fixedDefect.isSelected())
                dataPoint.setThal(6);
            else if (reversableDefect.isSelected())
                dataPoint.setThal(7);


            String additionalInfo = "";

            if (dataPoint.getTrestbps()<60)
                additionalInfo += "Your resting blood pressure is too low.\n";
            else if (dataPoint.getTrestbps()>90)
                additionalInfo += "Your resting blood pressure is too high.\n";
            if (dataPoint.getChol()>200)
                additionalInfo += "Your serum cholesterol is too high.\n";
            if (Double.parseDouble(fbs.getText())>120)
                additionalInfo += "Your fasting blood sugar indicates diabetes.\n";
            else if (Double.parseDouble(fbs.getText())>100)
                additionalInfo += "Your fasting blood sugar indicates prediabetes.\n";
            if (dataPoint.getThalach()>220-dataPoint.getAge())
                additionalInfo += "Your maximum heart rate is dangerous.\n";

            if (additionalInfo.length()!=0)
                additionalInfo = "Additional Health Information:\n" + additionalInfo;


            DataParser dataParser = new DataParser();
            try {
                dataParser.parseTrainingData();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            dataParser.scaleData(dataPoint);

            Knn knn = new Knn(dataParser.getAllPoints(), dataPoint);



            if (knn.getResult())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Risk of Heart Disease");
                alert.setTitle("Heart Disease Identifier");
                alert.setContentText("Please seek medical advice about heart disease immediately.\n\n"+additionalInfo);
                alert.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("No Risk of Heart Disease");
                alert.setTitle("Heart Disease Identifier");
                alert.setContentText("You are not at risk for heart disease.\n\n"+additionalInfo);
                alert.show();
            }
        });
        btAdd.setMinSize(150,30);
        btAdd.setMaxSize(150,30);
        pane.add(btAdd, 1, 18);

        Scene scene = new Scene(pane, 1000, 500);
        primaryStage.setTitle("Heart Disease Identifier");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
