package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pokemon.Combate;

public class controladorPantallaCaptura implements Initializable {

        @FXML
        private Button btnCapturar;

        private Button btnCombate;
        private Button btnEntrenar;
        @FXML
        private Button btnPokedex;

        @FXML
        private void goToPc(ActionEvent event) throws IOException {

                root = FXMLLoader
                                .load(getClass().getResource("..//vistas/pcPokemon.fxml"));
                Scene scene = new Scene(root);

                primaryStage.setScene(scene);
                primaryStage.show();

        }

        private Button btnFuncional;
        private Button btnPesado;
        private Button btnOnirico;
        private Button btnFurioso;

        @FXML

        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {

        }

}
