package org.arobase.pizza.vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.arobase.pizza.model.ModeleCommande;
import org.arobase.pizza.model.Sujet;

public class VueCommText extends Label implements Observateur {

    public VueCommText(ModeleCommande m) {
        super("Aucune commande en cours");
        m.enregistrerObservateur(this);
        this.setPadding(new Insets(15));
        this.setTextAlignment(TextAlignment.LEFT);
    }

    @Override
    public void actualiser(Sujet s) {
        ModeleCommande m = (ModeleCommande) s;
        if (m.getListePizza().isEmpty()) {
            this.setText("Aucune commande en cours");
        } else {
            this.setText(m.getDescriptifCommande());
        }
    }
}
