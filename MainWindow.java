// website of example code: https://levelup.gitconnected.com/realtime-charts-with-javafx-ed33c46b9c8d
// github code : https://github.com/kasvith/javafxrealtimechartsdemo
// Java fx example needs to be expanded upon and tweaked to be fit for purpose 

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//Libraries for button 
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;

//Libraries for the file menu with duplicates deleted
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.control.Menu;
// import javafx.scene.control.MenuBar;
// import javafx.scene.control.MenuItem;
// import javafx.stage.FileChooser;
// import javafx.stage.FileChooser.ExtensionFilter;

// public class FileMenu extends Application {
//     public void start(Stage stage) {
//         //Creating a menu
//         Menu fileMenu = new Menu("File");
//         //Creating menu Items
//         MenuItem item = new MenuItem("Open Image");
//         fileMenu.getItems().addAll(item);
//         //Creating a File chooser
//         FileChooser fileChooser = new FileChooser();
//         fileChooser.setTitle("Open Image");
//         fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
//         //Adding action on the menu item
//         item.setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent event) {
//               //Opening a dialog box
//               fileChooser.showOpenDialog(stage);
//         }});
//         //Creating a menu bar and adding menu to it.
//         MenuBar menuBar = new MenuBar(fileMenu);
//         menuBar.setTranslateX(3);
//         menuBar.setTranslateY(3);
//         //Setting the stage
//         Group root = new Group(menuBar);
//         Scene scene = new Scene(root, 595, 355, Color.BEIGE);
//         stage.setTitle("File Chooser Example");
//         stage.setScene(scene);
//         stage.show();
//      }

public class MainWindow extends Application {
    final int WINDOW_SIZE = 10;
    private ScheduledExecutorService scheduledExecutorService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Realtime Chart Demo");

        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis(); // we are gonna plot against time
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time in Seconds (s)");
        xAxis.setAnimated(false); // axis animations are removed
        yAxis.setLabel("Voltage in Volts (V)");
        yAxis.setAnimated(false); // axis animations are removed

        //creating the line chart with two axis created above
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Oscilloscope Graphical User Interface"); // Title for the 
        lineChart.setAnimated(false); // disable animations

        //defining which "Mode" to display data (AC/DC/RMS mode etc...)
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("DC Voltage Waveform");

        // add series to chart
        lineChart.getData().add(series);

        // setup scene
        Scene scene = new Scene(lineChart, 800, 600);
        primaryStage.setScene(scene);

        // show the stage
        primaryStage.show();

        // this is used to display time in HH:mm:ss format
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        // setup a scheduled executor to periodically put data into the chart
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // put dummy data onto graph per second -- REPLACE WITH THE WAVEFORM DATA
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // get a random integer between 0-10
            Integer random = ThreadLocalRandom.current().nextInt(10);

            // Update the chart
            Platform.runLater(() -> {
                // get current time
                Date now = new Date();
                // put random number with current time
                series.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), random));

                if (series.getData().size() > WINDOW_SIZE)
                    series.getData().remove(0);
            });
        }, 0, 1, TimeUnit.SECONDS);



    //Creating a Button to resume the waveform
    // public void start(Stage stage) {
    //   Button button = new Button();
    //   //Setting text to the button
    //   button.setText("Play");
    //   //Setting the location of the button
    //   button.setTranslateX(150);
    //   button.setTranslateY(60);
    //   //Setting the stage
    //   Group root = new Group(button);
    //   Scene scene = new Scene(root, 595, 150, Color.BEIGE);
    //   stage.setTitle("Play");
    //   stage.setScene(scene);
    //   stage.show();
    //   }
    //   //Creating a Button to stop and freeze the 
    //   public class ButtonExample extends Application {
    //     @Override
    //   Button button = new Button();
    //   //Setting Stop text to the button
    //   button.setText("Stop");
    //   //Setting the location of the button
    //   button.setTranslateX(150);
    //   button.setTranslateY(60);
    //   //Setting the stage
    //   Group root = new Group(button);
    //   Scene scene = new Scene(root, 795, 150, Color.BEIGE);
    //   stage.setTitle("Stop");
    //   stage.setScene(scene);
    //   stage.show();
    //   }
    //  Creating a Button
    //  public class ButtonExample extends Application {
    //    @Override
    //   Button button = new Button();
    //   //Setting screenshot for the button
    //   button.setText("Screenshot");
    //   //Setting the location of the button
    //   button.setTranslateX(150);
    //   button.setTranslateY(60);
    //   //Setting the stage
    //   Group root = new Group(button);
    //   Scene scene = new Scene(root, 195, 250, Color.BEIGE);
    //   stage.setTitle("Screenshot");
    //   stage.setScene(scene);
    //   stage.show();
    //   }
    }
}

     