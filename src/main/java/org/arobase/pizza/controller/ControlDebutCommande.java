package org.arobase.pizza.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.arobase.pizza.model.ModeleCommande;

public class ControlDebutCommande implements EventHandler<ActionEvent> {

    private String typePizza;

    private ModeleCommande modeleCommande;

    public ControlDebutCommande(String typePizza, ModeleCommande modeleCommande) {
        this.typePizza = typePizza;
        this.modeleCommande = modeleCommande;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modeleCommande.ajouterPizza(typePizza);
    }
}
