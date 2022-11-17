package org.arobase.pizza;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.arobase.pizza.controller.ControlDebutCommande;
import org.arobase.pizza.controller.ControlPizzaCour;
import org.arobase.pizza.model.ModeleCommande;
import org.arobase.pizza.vue.VueCommIm;
import org.arobase.pizza.vue.VueCommPrix;
import org.arobase.pizza.vue.VueCommText;

public class Principale_IGTP7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        ModeleCommande modeleCommande = new ModeleCommande();

        String [] ingredients={"Fromage","Champignons","Chorizo","Oeuf","Oignons","Olives noires","Olives vertes","Roquette"};
       // String[] fidelite = {"Nouveau client", "Cliente avec carte", "Client adhérent"};
        Button[] bIngr;
        BorderPane bp= new BorderPane();
        bp.setPadding(new Insets(10));


        // Panneau situe au nord de l'IG contenant les 2 boutons
        // permettant le choix de la base des pizzas et le niveau de fidelite du client
        HBox pnord = new HBox(20);
        pnord.setPadding(new Insets(10));
        pnord.setAlignment(Pos.CENTER);

        ComboBox<String> choixFidelite = new ComboBox<String>( );
        choixFidelite .getItems().add("Nouveau client");
        choixFidelite .getItems().add("Client adhérent");
        choixFidelite .getItems().add("Cliente avec carte");
        choixFidelite.setValue("Nouveau client");

        Button  addPizzaCreme= new Button(" Ajouter une pizza fond creme ");
        ControlDebutCommande controlPizzaCreme = new ControlDebutCommande("creme", modeleCommande);
        addPizzaCreme.setOnAction(controlPizzaCreme);
        Button addPizzaTomate= new Button(" Ajouter une pizza fond tomate ");
        ControlDebutCommande controlPizzaTomate = new ControlDebutCommande("tomate", modeleCommande);
        addPizzaTomate.setOnAction(controlPizzaTomate);
        pnord.getChildren().addAll(choixFidelite, addPizzaCreme, addPizzaTomate);
        bp.setTop(pnord); //place pnord en haut de l'IG


        // Panneau au centre de l'IG contenant la vision du choix des pizzas
        // ainsi que les boutons pour ajouter des ingredients
        BorderPane pcentral= new BorderPane();
        pcentral.setMaxHeight(300);

        //--> Le panneau avec la vision des images des pizzas
        VueCommIm visionComm = new VueCommIm(modeleCommande );
        ControlPizzaCour controlPizzaCour = new ControlPizzaCour(modeleCommande);
        visionComm.setOnMouseClicked(controlPizzaCour);
        pcentral.setCenter(visionComm);
        //--> Le panneau contenant les boutons des ingredrients
        GridPane pingr= new GridPane();
        pingr.setAlignment(Pos.CENTER);
        pingr.setHgap(10);
        bIngr= new Button[8];
        for(int i=0;i<ingredients.length;i++){
            bIngr[i]=new Button(ingredients[i]);
            bIngr[i].setMinSize(100,40);
            pingr.add(bIngr[i],i,0);
        }
       // pingr.setPreferredSize(new Dimension(935,50));
        pcentral.setBottom(pingr);
        bp.setCenter(pcentral); //place pcentral au centre de l'IG

        // Panneau au sud de l'IG dans lequel se trouve l'affichage
        // du contenu de la commande et son prix
        BorderPane psud= new BorderPane();
        psud.setMinHeight(300);
        psud.setPadding(new Insets(20, 0, 0, 10));

        Label l1= new Label("Votre commande");
        psud.setTop(l1);

        VueCommText commtxt= new VueCommText(modeleCommande );

      //  commtxt.setPreferredSize(new Dimension(935,200));
        psud.setLeft(commtxt);
        //Mettre un panneau VBox
        VBox vb= new VBox();
        vb.setAlignment(Pos.CENTER);
        VueCommPrix txtBas = new VueCommPrix(modeleCommande );
        vb.getChildren().add(txtBas);
        psud.setBottom(vb);
        bp.setBottom(psud);


        Scene scene = new Scene(bp,935,670);
        stage.setTitle("Commande de pizzas");
        stage.setScene(scene);
        stage.show();
    }
}
