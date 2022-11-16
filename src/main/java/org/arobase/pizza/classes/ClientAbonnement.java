package com.example.demo.classes;

/**
 * classe representant un client abonné
 */
public class ClientAbonnement implements StrategyFidelite{

    public ClientAbonnement(){};

    /**
     * taux du prix de la commande pour un client abonné
     * @return taux
     */
    @Override
    public double getTaux() {
        return 0.7;
    }
}
