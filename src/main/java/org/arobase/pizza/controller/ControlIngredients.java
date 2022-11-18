package org.arobase.pizza.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.arobase.pizza.model.ModeleCommande;

public class ControlIngredients implements EventHandler<ActionEvent> {

    private int typeIngredient;

    private ModeleCommande modeleCommande;

    public ControlIngredients(int typeIngredient, ModeleCommande modeleCommande) {
        this.typeIngredient = typeIngredient;
        this.modeleCommande = modeleCommande;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modeleCommande.choixIngredient(typeIngredient);
    }
}
