package PokemonFX.src.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PokemonController implements Initializable{

    @FXML
    private Button buscarPokemon;

    @FXML
    private void Pokemon(){
        System.out.println("Hola");
    }

    @FXML
    private Button buscarCombate;

    @FXML
    private void Combate(){
        System.out.println("Buenas");
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {    
    }
    
}
