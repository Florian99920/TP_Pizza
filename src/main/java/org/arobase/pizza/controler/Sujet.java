package org.arobase.pizza.controler;

import org.arobase.pizza.vue.Observateur;

public interface Sujet {
    public void enregistrerObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notifierObservateur();
}
