package org.arobase.pizza.vue;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import org.arobase.pizza.controler.Sujet;

public class VueCommPrix extends Label implements Observateur {

    public VueCommPrix() {
        super("Pas de commande en cours");
        this.setFont(new Font("Times", 16));
    }

    @Override
    public void actualiser(Sujet s) {
        // TODO Auto-generated method stub
    }
}
