package com.internshala.temp;


		import javafx.beans.value.ChangeListener;
		import javafx.beans.value.ObservableValue;
		import javafx.event.ActionEvent;
		import javafx.event.EventHandler;
		import javafx.fxml.FXML;
		import javafx.fxml.Initializable;
		import javafx.scene.control.*;

		import java.net.URL;
		import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label WelcomeLabel;
	@FXML
	public ChoiceBox<String> choicebox;
	@FXML
	public TextField textfield;
	@FXML
	public Button convert;

	private static final String C_To_F_Text = "Celcius to Faherneit";
	private static final String F_To_C_Text = "Faherneit to Celcius";

	private boolean isC_To_F = true;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choicebox.getItems().add(C_To_F_Text);
		choicebox.getItems().add(F_To_C_Text);

		choicebox.setValue(C_To_F_Text);
		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals(C_To_F_Text)) {
				isC_To_F = true;
			} else {
				isC_To_F = false;
			}
		});

		convert.setOnAction(event -> {
			convertbutton();
		});

	}

	private void convertbutton() {
		String input = textfield.getText();
		float entertemperature = 0.0f;
		try{
			entertemperature = Float.parseFloat(input);

		}catch(Exception ex){
			warnUser();
			return;
		}



		float newtemperature = 0.0f;
		if (isC_To_F) {
			newtemperature = (entertemperature * 9 / 5) + 32;
		} else {
			newtemperature = (entertemperature - 32) * 5 / 9;
		}
		display(newtemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Enter");
		alert.setContentText("Please Enter Valid Temperature");
		alert.show();
	}

	private void display(float newtemperature) {
		String unit = isC_To_F? "F" : "c";
		System.out.println("The new temperature is : " + newtemperature + unit );

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is:" + newtemperature + unit );
		alert.show();
	}
}
