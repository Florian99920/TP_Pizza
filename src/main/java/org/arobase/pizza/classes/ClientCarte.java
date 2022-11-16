package org.arobase.pizza.classes;

/**
 * classe representant un client ayant une carte
 */
public class ClientCarte implements StrategyFidelite {


    public ClientCarte(){};

    /**
     * taux du prix de la commande pour un client avec une carte
     * @return taux
     */
    @Override
    public double getTaux() {
        return 0.9;
    }
}
