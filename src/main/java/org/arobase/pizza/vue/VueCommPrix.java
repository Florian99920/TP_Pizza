package org.arobase.pizza.vue;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import org.arobase.pizza.model.ModeleCommande;
import org.arobase.pizza.model.Sujet;

public class VueCommPrix extends Label implements Observateur {

    public VueCommPrix(ModeleCommande m) {
        super("Pas de commande en cours");
        m.enregistrerObservateur(this);
        this.setFont(new Font("Times", 16));
    }

    @Override
    public void actualiser(Sujet s) {
        // TODO Auto-generated method stub
    }
}
