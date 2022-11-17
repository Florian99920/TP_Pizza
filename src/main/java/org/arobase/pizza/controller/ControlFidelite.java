package org.arobase.pizza.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import org.arobase.pizza.classes.ClientAbonnement;
import org.arobase.pizza.classes.ClientCarte;
import org.arobase.pizza.classes.ClientNouveau;
import org.arobase.pizza.classes.StrategyFidelite;
import org.arobase.pizza.model.ModeleCommande;

public class ControlFidelite implements EventHandler<ActionEvent> {

    private ModeleCommande modeleCommande;

    public ControlFidelite(ModeleCommande modeleCommande) {
        this.modeleCommande = modeleCommande;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ComboBox<String> box = (ComboBox<String>) actionEvent.getSource();
        String type = box.getValue();
        StrategyFidelite strategyFidelite = null;
        switch (type) {

            case "Client adhérent":
                strategyFidelite = new ClientAbonnement();
                break;
            case "Client avec carte":
                strategyFidelite = new ClientCarte();
                break;
            default:
                strategyFidelite = new ClientNouveau();
                break;
        }
        modeleCommande.setFidelite(strategyFidelite);
    }
}
