package org.arobase.pizza.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import org.arobase.pizza.model.ModeleCommande;

public class ControlPizzaCour implements EventHandler<MouseEvent> {

    private String typePizza;

    private ModeleCommande modeleCommande;

    public ControlPizzaCour(ModeleCommande modeleCommande) {
        this.modeleCommande = modeleCommande;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        int x = (int) (mouseEvent.getX()/225);
        modeleCommande.setNumPizzaCourante(x);
    }

}
