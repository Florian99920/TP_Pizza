package org.arobase.pizza.vue;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.arobase.pizza.controler.Sujet;

public class VueCommText extends Label implements Observateur {

    public VueCommText() {
        super("Aucune commande en cours");
        this.setFont(new Font("Times", 14));
        this.setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public void actualiser(Sujet s) {
        // TODO Auto-generated method stub
    }
}
