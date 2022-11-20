package org.arobase.pizza.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.arobase.pizza.model.ModeleCommande;

public class ControlValider implements EventHandler<ActionEvent> {

    private ModeleCommande modeleCommande;

    public ControlValider(ModeleCommande modeleCommande) {
        this.modeleCommande = modeleCommande;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modeleCommande.validerCommande();
    }
}
