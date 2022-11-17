package org.arobase.pizza.vue;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.arobase.pizza.model.ModeleCommande;
import org.arobase.pizza.model.Sujet;

public class VueCommText extends Label implements Observateur {

    public VueCommText(ModeleCommande m) {
        super("Aucune commande en cours");
        m.enregistrerObservateur(this);
        this.setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public void actualiser(Sujet s) {
        // TODO Auto-generated method stub
    }
}
