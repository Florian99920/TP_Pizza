package org.arobase.pizza.vue;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import org.arobase.pizza.model.ModeleCommande;
import org.arobase.pizza.model.Sujet;

public class VueCommPrix extends Label implements Observateur {

    public VueCommPrix(ModeleCommande m) {
        super("Pas de commande en cours");
        m.enregistrerObservateur(this);
    }

    @Override
    public void actualiser(Sujet s) {
        ModeleCommande m = (ModeleCommande) s;
        if (m.getListePizza().isEmpty()) {
            this.setText("Pas de commande en cours");
        } else {
            this.setText("Prix total : " + m.getPrixCommande() + " euros");
        }
    }
}
