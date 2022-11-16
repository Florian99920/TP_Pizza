package org.arobase.pizza.classes;

/**
 * classe representant un nouveau client
 */
public class ClientNouveau implements StrategyFidelite {

    public ClientNouveau(){};

    /**
     * taux du prix de la commande pour un nouveau client
     * @return taux
     */
    @Override
    public double getTaux() {
        return 1;
    }
}
