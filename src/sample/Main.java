package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ml.DataPoint;
import ml.Knn;
import parsing.DataParser;

import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);


        // Place nodes in the pane
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

        Button btAdd = new Button("Submit");
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



            DataParser dataParser = new DataParser();
            try {
                dataParser.parseTrainingData();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Knn knn = new Knn(dataParser.getTrainingPoints(), dataPoint);



            if (knn.getResult())
            {
                Alert a =  new Alert(Alert.AlertType.WARNING, "See a doctor immediately.", ButtonType.OK);
                a.show();
            }
            else
            {
                Alert a =  new Alert(Alert.AlertType.INFORMATION, "Relax. You are fine.", ButtonType.OK);
                a.show();
            }

            /*GridPane cpane = new GridPane();
            cpane.setAlignment(Pos.CENTER);
            cpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            cpane.setHgap(5.5);
            cpane.setVgap(5.5);
            Label resultTrue = new Label("See a doctor immediately.");
            Label resultFalse = new Label("Relax. You are fine.");

            if (knn.getResult())
                cpane.add(resultTrue,1,1);
            else
                cpane.add(resultFalse,1,1);*/

            /*Scene scene = new Scene(cpane);
            primaryStage.setTitle("Result"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show();*/
        });
        pane.add(btAdd, 1, 18);
        //GridPane.setHalignment(btAdd, HPos.RIGHT);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 1000, 500);
        primaryStage.setTitle("Heart Disease Identifier"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
}
