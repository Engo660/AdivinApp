package adivina.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	private Label adivinoLabel;
	private Button comprobarButton;
	private TextField numeroText;
	private VBox root;
	int a = numeroAleatorio(1,100);
	int i = 1;

	public static int numeroAleatorio(int d, int h) {
		int resultado;
		double x;
		x = Math.random();
		resultado = (int) (x * (h - d + 1) + d);
		return resultado;
	}

	public void start(Stage primaryStage) throws Exception {
		
		adivinoLabel = new Label();
		adivinoLabel.setText("Introduce un numero del 1 al 100");
		
		numeroText = new TextField();
		numeroText.setMaxWidth(150);

		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onAdivinar(e));
		comprobarButton.setDefaultButton(true);

		root = new VBox();
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(numeroText, adivinoLabel, comprobarButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onAdivinar(ActionEvent e) {

		if (numeroText.getText().isBlank() || Character.isLetter(numeroText.getText().charAt(0))) {
			Alert alert3 = new Alert(AlertType.ERROR);
			alert3.setTitle("AdivinApp");
			alert3.setHeaderText("Error");
			alert3.setContentText("El numero introducido no es valido");
			alert3.showAndWait();
		} else if (Integer.parseInt(numeroText.getText()) == a) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Has ganado!");
			alert.setContentText("Solo te ha llevado " + i + " intentos" + "\n\nVuelve a jugar y hazlo mejor");
			alert.showAndWait();
		} else {
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setTitle("AdivinApp");
			alert2.setHeaderText("Has fallado");
			i++;
			if (a < Integer.parseInt(numeroText.getText())) {
				alert2.setContentText("El numero a adivinar es menor que " + numeroText.getText());
			} else {
				alert2.setContentText("El numero a adivinar es mayor que " + numeroText.getText());
			}
			alert2.showAndWait();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
