package com.epam.output.controllers;

import com.epam.tosses.TossSimulator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainWindowController {
	//-----------------------------------------------------------------------------fields
	private TossSimulator tossSimulator = new TossSimulator();
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//-----------------------------------------------------------------------------fields
	@FXML
	private TextField promptTextField;

	@FXML
	private Button startButton;

	@FXML
	private TextField headCountTextField;

	@FXML
	private TextField tailCountTextField;
	//-----------------------------------------------------------------------------initialization
	@FXML
	void initialize() {
		this.promptTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if(isEmpty(newValue)) {
				this.startButton.setDisable(true);
				this.promptTextField.setStyle("-fx-control-inner-background: white;");
			} else if (!(this.isDigit(newValue)) ||
							(Integer.valueOf(newValue) > TossSimulator.TOSSBOUND)) {
				this.promptTextField.setText(oldValue);
			}else {
				this.startButton.setDisable(false);
				this.promptTextField.setStyle("-fx-control-inner-background: white;");
			}
		});

		this.startButton.setOnAction(buttonAction -> this.startButtonOnAction());
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//-----------------------------------------------------------------------------
	//-----------------------------------------------------------------------------methods
	private void startButtonOnAction()
	{
		this.tossSimulator.reset();
		this.tossSimulator.startToss(Integer.valueOf(this.promptTextField.getText()));
		this.headCountTextField.setText(String.valueOf(this.tossSimulator.getHeadsCount()));
		this.tailCountTextField.setText(String.valueOf(this.tossSimulator.getTailsCount()));
	}

	private boolean isDigit(String S)
	{
		if('0' == S.charAt(0)) {
			return false;
		}
		//------------------------------------is string is digit
		for(int i = 0; i < S.length(); i++) {
			if(!(Character.isDigit(S.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	private boolean isEmpty(String S)
	{
		return 0 == S.length();
	}

}