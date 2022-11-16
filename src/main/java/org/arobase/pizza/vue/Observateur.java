package org.arobase.pizza.vue;

import org.arobase.pizza.controler.Sujet;

public interface Observateur {
    public void actualiser(Sujet s);
}
