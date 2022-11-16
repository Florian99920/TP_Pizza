package org.arobase.pizza.model;

import org.arobase.pizza.classes.*;
import org.arobase.pizza.vue.Observateur;

import java.util.ArrayList;
import java.util.List;

/**
 * classe representant le modele d'une commande
 */
public class ModeleCommande implements Sujet {


    /**
     * nombre de pizza dans la commande
     */
    private int nbPizza;

    /**
     * numero de la pizza courante
     */
    private int numPizzaCourante;

    /**
     * prix de la commande
     */
    private double prixCommande;

    /**
     * liste des pizzas de la commande
     */
    private List<Pizza> listePizza;

    /**
     * liste des observateurs
     */
    private List<Observateur> observateurs;


    /**
     * niveau de fidelite du client
     */
    private StrategyFidelite taux;




    /**
     * constructeur par defaut
     */
    public ModeleCommande(){
        this.nbPizza = 0;
        this.prixCommande= 0;
        this.numPizzaCourante = 0;
        this.listePizza = new ArrayList<>();
        this.observateurs = new ArrayList<>();
        this.taux = new ClientNouveau();
    }

    /**
     * permet d'ajouter une pizza a la commande
     * @param s base de la pizza
     */
    public void ajouterPizza(String s){
        // s'il y a deja 4 pizza return
        if (this.nbPizza == 4){return;}
        // on cree la pizza en fonction de sa base
        Pizza pizza;
        if (s.equalsIgnoreCase("tomate")){
            pizza = new PizzaTomate();
        }else{
            pizza = new PizzaCreme();
        }
        // on ajoute la pizza a la commande
        this.listePizza.add(pizza);
        // on augmente le nombre de pizza
        this.nbPizza += 1;
        // on change le num de la pizza courante
        this.numPizzaCourante = this.listePizza.indexOf(pizza);

        this.notifierObservateur();
    }


    /**
     * calcul le prix de la commande
     */
    public void calculPrixCommande(){
        // on reinitialise le prix de la commande a 0
        this.prixCommande = 0;
        // on parcourt la liste des pizza
        // on ajoute leurs prix au prix de la commande
        for (Pizza p : this.listePizza){
            this.prixCommande += p.getCout();
        }

        // on multiplie ensuite le prix de la commande par le taux de fideliter du client
        this.prixCommande *= this.taux.getTaux();
    }


    /**
     * nombre de pizza
     * @return nombre de pizza de la commande
     */
    public int getNbPizza(){
        return this.nbPizza;
    }

    /**
     * prix de la commande
     * @return prix de la commande
     */
    public double getPrixCommande() {
        return this.prixCommande;
    }

    /**
     * liste des pizzas
     * @return liste des pizzas de la commande
     */
    public List<Pizza> getListePizza() {
        return this.listePizza;
    }

    /**
     * numero de la pizza courante
     * @return numero de la pizza courante
     */
    public int getNumPizzaCourante() {
        return this.numPizzaCourante;
    }

    /**
     * met a jour le numero de la pizza courant
     * @param i numero de la pizza
     */
    public void setNumPizzaCourante(int i){
        this.numPizzaCourante = i;
    }


    /**
     * met a jour le niveau de fidelite du client
     * @param f fidleite du client
     */
    public void setFidelite(StrategyFidelite f){
        this.taux = f;
    }





    /**
     * permet d'enregister un observateur
     * @param o observateur à enregistrer
     */
    @Override
    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    /**
     * permet de supprimer un observateur
     * @param o observateur a supprimer
     */
    @Override
    public void supprimerObservateur(Observateur o) {
        this.observateurs.remove(o);
    }

    /**
     * permet de notifier les observateurs
     */
    @Override
    public void notifierObservateur() {
        for (Observateur o: this.observateurs){
            o.actualiser(this);
        }
    }




}
