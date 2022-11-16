package org.arobase.pizza.vue;


import org.arobase.pizza.model.Sujet;

public interface Observateur {
    public void actualiser(Sujet s);
}
