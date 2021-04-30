package application;

//Imported modules for JavafX and others
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.lang.Math;

// Main Class

public class Main extends Application {
	boolean playing = false;		
	double y_range = 5;
	double y_lower = -5;
	double x_range = 500;
	double x_lower = 0;
	double time = -10000;
	double count = 0;
	String cursor_voltage;
	int MAX = 11000;
	boolean x_zooming = false;
	boolean y_zooming = false;
	double voltage = 0;
	String voltage_measured = "";
	String voltage_measuredB = "";
	public String bot_voltage = "0";
	public String top_voltage = "0";
	boolean A_Visible = true;
	boolean B_Visible = true;
	boolean Sum_visible = false;
	boolean Mult_visible = false;
	boolean Cur_visible = false;
	
	double line = 0;
	VoltageMeasurer cur_dif = new VoltageMeasurer();
	
	private ScheduledExecutorService scheduledExecutorService;

	public static void main(String[] args) {
		launch(args);
	}
	
	double x_scaler = x_range / 8; 		//These two lines ensure the xand y range
	double y_scaler = 2 * y_range / 8;	// stays relative to the values (8 "boxes" shown in grid lines)


	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Oscilloscope");
		Pane layout = new Pane();	// creates a new pane in which GUi is shown 

		Button exit_button = new Button("Exit");	// Created an "exit button"
		exit_button.setLayoutX(50);
		exit_button.setLayoutY(1100);
		exit_button.setPrefSize(100, 50);
		layout.getChildren().add(exit_button);	// Adds button to pane

		exit_button.setOnAction(e -> Platform.exit());	// Functionality of exit button (closes program)

		// Move right button
		Button right = new Button(">");
		right.setLayoutX(700);
		right.setLayoutY(875);
		right.setPrefSize(50, 50);
		layout.getChildren().add(right);

		// Move left button
		Button left = new Button("<");
		left.setLayoutX(600);
		left.setLayoutY(875);
		left.setPrefSize(50, 50);
		layout.getChildren().add(left);

		// Move up button
		Button up = new Button("^");
		up.setLayoutX(650);
		up.setLayoutY(825);
		up.setPrefSize(50, 50);
		layout.getChildren().add(up);

		// Move down button
		Button down = new Button("v");
		down.setLayoutX(650);
		down.setLayoutY(925);
		down.setPrefSize(50, 50);
		layout.getChildren().add(down);

		// Play button 
		Button playButton = new Button("Play");
		playButton.setLayoutX(100);
		playButton.setLayoutY(840);
		playButton.setPrefSize(70, 50);
		layout.getChildren().add(playButton);

		// Pause button
		Button pauseButton = new Button("Pause");
		pauseButton.setLayoutX(180);
		pauseButton.setLayoutY(840);
		pauseButton.setPrefSize(100, 50);
		layout.getChildren().add(pauseButton);

		// Zoom X and Y checkboxs

		CheckBox xcheckbox = new CheckBox("Toggle Zoom X");
		CheckBox ycheckbox = new CheckBox("Toggle Zoom Y");

		xcheckbox.setLayoutX(420);
		xcheckbox.setLayoutY(1000);
		layout.getChildren().add(xcheckbox);

		ycheckbox.setLayoutX(280);
		ycheckbox.setLayoutY(1000);
		layout.getChildren().add(ycheckbox);

		// Summed plot Button

		Button Sum = new Button("Channel A + Channel B");
		Sum.setLayoutX(920);
		Sum.setLayoutY(940);
		layout.getChildren().add(Sum);

		// Multiply plot Button

		Button Mult = new Button("Channel A x Channel B");
		Mult.setLayoutX(920);
		Mult.setLayoutY(990);
		layout.getChildren().add(Mult);

		// Channels Buttons

		Button ChannelA = new Button("Channel A");
		Button ChannelB = new Button("Channel B");

		ChannelA.setLayoutX(920);
		ChannelA.setLayoutY(850);
		layout.getChildren().add(ChannelA);

		ChannelB.setLayoutX(920);
		ChannelB.setLayoutY(890);
		layout.getChildren().add(ChannelB);
		
		// Cursor buttons
		
		Button Cursors = new Button(" Display Cursors");
		Cursors.setLayoutX(920);
		Cursors.setLayoutY(810);
		layout.getChildren().add(Cursors);
		
		
		// defining the axes
		final NumberAxis xAxis = new NumberAxis(x_lower, x_range, x_range / 8);
		final NumberAxis yAxis = new NumberAxis(-y_range, y_range, 2 * y_range / 8);
		
		
		
		//Functionality of buttons and checkboxes

		up.setOnAction(value -> {
			y_lower = y_lower + y_scaler;  // scales the y axis lower and upper value by 'y_scaler'
			y_range = y_range + y_scaler;  // both lower and upper added to as to "move up" on graph

			yAxis.setUpperBound(y_range);
			yAxis.setLowerBound(y_lower);

		});

		down.setOnAction(value -> {
			y_lower = y_lower - y_scaler; // scales the y axis lower and upper value by  - 'y_scaler'
			y_range = y_range - y_scaler; // both lower and upper subtarcted to as to "move down" on graph

			yAxis.setUpperBound(y_range);
			yAxis.setLowerBound(y_lower);

		});

		right.setOnAction(value -> {
			x_lower = x_lower + x_scaler; // Likewise for left and right, mirrors the previous up and down
			x_range = x_range + x_scaler; // functions but for the x-axis

			xAxis.setUpperBound(x_range);
			xAxis.setLowerBound(x_lower);
			MAX = MAX + MAX;	// Max value increases as we are able to "see" the areas of the graph (moving right)
								// this value is used so that the graph is only plotted as we see it ensuring thr graph isnt being plotted infinitely 
								// causing lag.

		});

		left.setOnAction(value -> {
			x_lower = x_lower - x_scaler;
			x_range = x_range - x_scaler;

			xAxis.setUpperBound(x_range);
			xAxis.setLowerBound(x_lower);

		});

		playButton.setOnAction(value -> {
			playing = true;		// play button simply sets playing variable to true

		});

		pauseButton.setOnAction(value -> {

			playing = false;	// alternately pause button sets 'playing' to false.

		});

		xAxis.setLabel("Time in Milliseconds (ms)");	// Headings for x-axis
		xAxis.setAnimated(false); // axis animations are removed
		yAxis.setLabel("Voltage in Volts (V)");	// Heading for y-axis
		yAxis.setAnimated(false); // axis animations are removed

		// creating the line chart with two axis created above
		final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis); // creates a JavaFX linechart
		lineChart.setTitle("Oscilloscope Graphical User Interface"); // Title for the linechart
		lineChart.setAnimated(false); // disable animations
		lineChart.setHorizontalZeroLineVisible(true); // sets grid lines 
		lineChart.setVerticalGridLinesVisible(true);  
		lineChart.setVerticalZeroLineVisible(true);
		lineChart.setCreateSymbols(false); // removes the linechart symbols for the plotted lines giving a "clean" line

		
		XYChart.Series<Number, Number> series = new XYChart.Series<>(); // creates a series for the first channel
		XYChart.Series<Number, Number> seriesB = new XYChart.Series<>();// creates a series for the second channel
		
		XYChart.Series<Number, Number> cur_top = new XYChart.Series<>();// creates the top cursor
		XYChart.Series<Number, Number> cur_bottom = new XYChart.Series<>();// creates the bottom cursor

		XYChart.Series<Number, Number> sum_series = new XYChart.Series<>(); // series for the sum of the two previous series
		XYChart.Series<Number, Number> mult_series = new XYChart.Series<>(); // series for the multiplication of previous two series

		lineChart.setLegendVisible(false); // removes linechart legend
		

		lineChart.setOnScroll(new EventHandler<ScrollEvent>() { // events occurs on mouse scroll

			public void handle(ScrollEvent event) {

				boolean XisSelected = xcheckbox.isSelected(); // gets boolean values for when x and y checkboxes are selected 
				boolean YisSelected = ycheckbox.isSelected();

				if (XisSelected == true && YisSelected == false) { // X = true Y = False (zoom X)

					if (x_range > MAX) {
						MAX = MAX + MAX;

					}

					double deltaY = event.getDeltaY();

					if (deltaY < 0) {	// "if scrolling in"
						x_range = x_range - x_scaler;

					}

					else if (deltaY > 0) { // "if scrolling out"
						x_range = x_range + x_scaler;
					}

					xAxis.setUpperBound(x_range);

				}

				else if (YisSelected == true && XisSelected == false) { //(Y = true X = False (zoom y)

					if (x_range > MAX) {
						MAX = MAX + MAX;

					}

					double deltaY = event.getDeltaY();

					if (deltaY < 0) {	// "if scrolling in"
						y_range = y_range - y_scaler;
						y_scaler = 2*y_range/8;

					}

					else if (deltaY > 0) { // "if scrolling out"
						y_range = y_range + y_scaler; 
						
					}

					yAxis.setUpperBound(y_range);
					yAxis.setLowerBound(-y_range);
					y_lower = -y_range;

				}

				else if (YisSelected == true && XisSelected == true) { // Y = true X = true (Zooming x and y axis)

					if (x_range > MAX) {
						MAX = MAX + MAX;

					}

					double deltaY = event.getDeltaY();

					if (deltaY < 0) { // "if scrolling in"
						x_range = x_range - x_scaler;
						x_scaler = x_range/8;

					}

					if (deltaY < 0) { // "if scrolling out"
						y_range = y_range - y_scaler;
						x_range = x_range - x_scaler;

					}

					else if (deltaY > 0) {
						y_range = y_range + y_scaler;
						x_range = x_range + x_scaler;

					}

					xAxis.setUpperBound(x_range);
					yAxis.setUpperBound(y_range);
					yAxis.setLowerBound(-y_range);
					y_lower = -y_range;

				}

				yAxis.setTickUnit((2 * y_range / 8)); // Sets range of y axis to 2 x +ve y_range / 8 to ensure
													  // 8 segments in the grid at all times. (2 x because y axis has the same y_range above 0
													  // as below, for example if y_range = 5 then we have a range of -5 to 5 and so a "range" of 10

				xAxis.setTickUnit((x_range / 8)); // Ensures 8 grid segments in x-axis
			}

		});
		

		
		
		// setup scene
		Scene scene = new Scene(layout, 1600, 1200);

		primaryStage.setScene(scene);

		scene.getStylesheets().add("application/application.css");

		// show the stage
		primaryStage.show();

		// add series to chart
		lineChart.getData().add(series);
		lineChart.getData().add(seriesB);
		
		// adds cursors to chart
		lineChart.getData().add(cur_top);
		lineChart.getData().add(cur_bottom);
		
		
		lineChart.getData().add(sum_series);
		lineChart.getData().add(mult_series);

		layout.getChildren().add(lineChart); // add linechart to stage

		lineChart.setPrefSize(1500, 800);
		lineChart.setCursor(Cursor.CROSSHAIR); // changes mouse appearance 

		Label label = new Label(""); // creates two labels, empty for now as given text later
		Label labelB = new Label("");
		
		Label labeltop = new Label("");
		Label labelbottom = new Label("");
		Label labeltotal = new Label("");

		ChannelA.setOnAction(value -> { // actions for two channel buttons ***

			if (B_Visible == true) {
				series.getNode().setVisible(false);
				B_Visible = false;
			}

			else if (B_Visible == false) {
				series.getNode().setVisible(true);
				B_Visible = true;
			}

		});

		ChannelB.setOnAction(value -> { // *** Channel A and B can be toggles on or off with two buttons

			if (B_Visible == true) {
				seriesB.getNode().setVisible(false);
				B_Visible = false;
			}

			else if (B_Visible == false) {
				seriesB.getNode().setVisible(true);
				B_Visible = true;
			}

		});

		Sum.setOnAction(value -> { // Sum of two channels can also be toggled in the same way

			if (Sum_visible == true) {
				sum_series.getNode().setVisible(false);
				Sum_visible = false;
			}

			else if (Sum_visible == false) {
				sum_series.getNode().setVisible(true);
				Sum_visible = true;
			}

		});

		Mult.setOnAction(value -> { // Product of two channels can also be toggled in the same way

			if (Mult_visible == true) {
				mult_series.getNode().setVisible(false);
				Mult_visible = false;
			}

			else if (Mult_visible == false) {
				mult_series.getNode().setVisible(true);
				Mult_visible = true;
			}
		});

		Cursors.setOnAction(value -> { // Cursors can be toggled in the same way

			if (Cur_visible == true) {
				cur_top.getNode().setVisible(false);
				cur_bottom.getNode().setVisible(false);
				
				Cur_visible = false;
			}

			else if (Cur_visible == false) {
				cur_top.getNode().setVisible(true);
				cur_bottom.getNode().setVisible(true);
				Cur_visible = true;
			}
		});
		

		sum_series.getNode().setVisible(false); // sum and product of two channels initially not visible 
		mult_series.getNode().setVisible(false);
		
		cur_top.getNode().setVisible(false); // cursors not initially visible
		cur_bottom.getNode().setVisible(false);
		
		
		// setup a scheduled executor to periodically put data into the chart
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		// put dummy data onto graph per millisecond -- REPLACE WITH THE WAVEFORM DATA
		scheduledExecutorService.scheduleAtFixedRate(() -> {

			// Update the chart
			Platform.runLater(() -> {

				// plots graph
				if (playing == true && time < MAX) {
					
					
											                         // TEST SIGNALS //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					int scale = 100;

					double voltageA = 5 * Math.sin(count / (180 / Math.PI));

					// double voltageB = Math.random() * (5 - -5 + 1) + -5;				// UNCOMMENT DIFFERENT LINES TO CREATE DIFFERENT TEST SIGNALS

					// double voltageB = -(5 * Math.sin(count / (180 / Math.PI)));		// "LINE" IS JUST AN ARBITARY VARIABLE TO BE GIVEN VALUES TO CREATE
																						// DIFFRENT CURVES
					// double voltageB = line;

					line = line + 0.007;
					
					
					
					double voltageB = Math.exp(line);
					
					
					double summed_V = voltageA + voltageB;

					double mult_V = voltageA * voltageB;

					count = count + 10;

					time = time + scale;
					
					
					Data<Number, Number> dataA = new Data<>(time, voltageA);
					Data<Number, Number> dataB = new Data<>(time, voltageB);
					
					// Data for the top and bottom cursor
					Data<Number, Number> cur_topdata = new Data<>(time, 3);
					Data<Number, Number> cur_botdata = new Data<>(time, -3);
					
					Data<Number, Number> sum_data = new Data<>(time, summed_V);
					
					Data<Number, Number> mult_data = new Data<>(time, mult_V);
					
					series.getData().add(dataA);
					seriesB.getData().add(dataB);
					cur_bottom.getData().add(cur_botdata);
					cur_top.getData().add(cur_topdata);
					mult_series.getData().add(mult_data);
					sum_series.getData().add(sum_data);
					
					// sets the initial voltage values for the top and bottom cursor
					cur_dif.setBot_voltage(cur_botdata.getYValue().doubleValue());
					cur_dif.setTop_voltage(cur_topdata.getYValue().doubleValue());

					
					
					
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					seriesB.getNode().setOnMouseClicked(eventB -> { // On mouse click (on series line) the voltage (y value) is given to label 

						Point2D mouseSceneCoords = new Point2D(eventB.getSceneX(), eventB.getSceneY());
						double y = yAxis.sceneToLocal(mouseSceneCoords).getY();
						
						voltage_measuredB = (yAxis.getValueForDisplay(y)).toString();

						labelB.setText(voltage_measuredB + " V");
						labelB.setLayoutX(1100);
						labelB.setLayoutY(900);

					});

					series.getNode().setOnMouseClicked(event -> { // On mouse click (on other series line) the voltage (y value) is gven to label

						Point2D mouseSceneCoords = new Point2D(event.getSceneX(), event.getSceneY());
						double y = yAxis.sceneToLocal(mouseSceneCoords).getY();

						voltage_measured = (yAxis.getValueForDisplay(y)).toString();
						
						label.setText(voltage_measured + " V");
						label.setLayoutX(1100);
						label.setLayoutY(1000);
						
						
;
					});
					
					

					// Top and bottom cursors controlled by dragging the mouse
					
					
					cur_top.getNode().setOnMouseDragged(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							
							// Gets the y-axis value of the top cursor
							Point2D mouseSceneCoords = new Point2D(event.getSceneX(), event.getSceneY());
							double y = yAxis.sceneToLocal(mouseSceneCoords).getY();
						
							// Moves the top cursor to the position of the mouse
							// Checks to see if the top and bottom cursor are close
							// Won't allow the top and bottom cursor to overlap if so
							for (XYChart.Data<Number, Number> cur_topdata : cur_top.getData()) {
								if (cur_dif.calculateDifDb() > 0.05) {
									cur_topdata.setYValue(yAxis.getValueForDisplay(y));
									top_voltage = (yAxis.getValueForDisplay(y)).toString();								
									cur_dif.setTop_voltage(yAxis.getValueForDisplay(y).doubleValue());
								} else if (cur_dif.calculateDifDb() <= 0.05) {
									if ((yAxis.getValueForDisplay(y).doubleValue() > cur_dif.get_topvoltage())) {
										cur_topdata.setYValue(yAxis.getValueForDisplay(y));
										top_voltage = (yAxis.getValueForDisplay(y)).toString();								
										cur_dif.setTop_voltage(yAxis.getValueForDisplay(y).doubleValue());
									}
								}
							}
						}
						
												
					});
					
					cur_bottom.getNode().setOnMouseDragged(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							
							// Gets the y-axis value of the bottom cursor
							Point2D mouseSceneCoords = new Point2D(event.getSceneX(), event.getSceneY());
							double y = yAxis.sceneToLocal(mouseSceneCoords).getY();														
																					
							// Moves the bottom cursor to the position of the mouse
							// Checks to see if the top and bottom cursor are close
							// Won't allow the top and bottom cursor to overlap if so
							for (XYChart.Data<Number, Number> cur_botdata : cur_bottom.getData()) {
								if (cur_dif.calculateDifDb() > 0.05) {
									
									cur_botdata.setYValue(yAxis.getValueForDisplay(y));
									cur_dif.setBot_voltage((yAxis.getValueForDisplay(y).doubleValue()));
									bot_voltage = (yAxis.getValueForDisplay(y)).toString();
								} else if (cur_dif.calculateDifDb() <= 0.05) {
									
									if ((yAxis.getValueForDisplay(y).doubleValue() < cur_dif.get_topvoltage())) {
										
										cur_botdata.setYValue(yAxis.getValueForDisplay(y));
										cur_dif.setBot_voltage((yAxis.getValueForDisplay(y).doubleValue()));
										bot_voltage = (yAxis.getValueForDisplay(y)).toString();
										
									}
								}
							}
							
											
						}
																		
					});
					

				}
				
				if(Cur_visible == true)					
				{
					cursor_voltage = cur_dif.calculateDifStr();					
					
					labeltotal.setText("Voltage between cursors:  " + cursor_voltage + "V");
					labeltotal.setLayoutX(1100);
					labeltotal.setLayoutY(780);;
					
					labeltop.setText("Top cursor:       " + cur_dif.get_topvoltage() + "V");
					labeltop.setLayoutX(1100);
					labeltop.setLayoutY(800);
					
					labelbottom.setText("Bottom cursor:  " + cur_dif.get_botvoltage() + "V");
					labelbottom.setLayoutX(1100);
					labelbottom.setLayoutY(820);
				}
				else
				{
					labeltotal.setText("");
					labeltop.setText("");
					labelbottom.setText("");
				}
				
			});
			
		}, 0, 1, TimeUnit.MILLISECONDS);

		labelB.setTextFill(Color.web("YELLOW")); // Formats label colour and text
		label.setTextFill(Color.web("BLUE"));
		
		labeltop.setTextFill(Color.web("GREEN")); 
		labelbottom.setTextFill(Color.web("RED"));
		labeltotal.setTextFill(Color.web("YELLOW"));
		
		label.setFont(new Font("Arial", 30));
		labelB.setFont(new Font("Arial", 30));
		labeltotal.setTextFill(Color.web("YELLOW"));
		
		labeltop.setFont(new Font("Arial", 15));
		labelbottom.setFont(new Font("Arial", 15));
		labeltotal.setFont(new Font("Arial", 15));

		layout.getChildren().add(label); // places two labels on the pane
		layout.getChildren().add(labelB);
		
		layout.getChildren().add(labeltop); // labels for cursor display
		layout.getChildren().add(labelbottom);
		layout.getChildren().add(labeltotal);
	}

	public class VoltageMeasurer
	{
		double bot_voltage;
		double top_voltage;
		String cursor_total_str;
		double cur_total_db;
	public String calculateDifStr()
	{		
		cursor_total_str = Double.toString(top_voltage - bot_voltage);
		return cursor_total_str;
	}
	public double calculateDifDb()
	{		
		cur_total_db = top_voltage - bot_voltage;
		return cur_total_db;
	}

	public double get_botvoltage() {
		return bot_voltage;		
	}

	public double get_topvoltage() {
		return top_voltage;
	}
	public void setBot_voltage(double bot_voltage) {
		this.bot_voltage = bot_voltage;
	}
	public void setTop_voltage(double top_voltage) {
		this.top_voltage = top_voltage;
	}
	}





}