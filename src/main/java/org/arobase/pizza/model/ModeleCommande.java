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

    private static int numeroCommande = 1;




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
        FabriquePizza f;
        // on cree la pizza en fonction de sa base

        if (s.equalsIgnoreCase("tomate")){
            f = new FabriquePizzaTomate();
        }else if(s.equalsIgnoreCase("creme")){
            f = new FabriquePizzaCreme();
        }else{
            f = new FabriquePizzaFromageBlanc();
        }
        Pizza pizza = f.fabriquerPizza();
        // on ajoute la pizza a la commande
        this.listePizza.add(pizza);
        // on augmente le nombre de pizza
        this.nbPizza += 1;
        // on change le num de la pizza courante
        this.numPizzaCourante = this.listePizza.indexOf(pizza);

        this.calculPrixCommande();
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

        this.notifierObservateur();
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
        if (this.listePizza.size() > i){
            this.numPizzaCourante = i;
            this.notifierObservateur();
        }
    }


    /**
     * met a jour le niveau de fidelite du client
     * @param f fidleite du client
     */
    public void setFidelite(StrategyFidelite f){
        this.taux = f;
        this.calculPrixCommande();
    }


    /**
     * desription de la commande
     * @return la description de la commande
     */
    public String getDescriptifCommande(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.listePizza.size(); i++){
            Pizza pizzaCourante = this.listePizza.get(i);
            s.append("Pizza n°").append(i+1);
            s.append(" : ").append(String.format("%.2f", pizzaCourante.getCout())).append(" euros\n");
            s.append(pizzaCourante.getDescription()).append("\n");
        }

        return s.toString();


    }

    public void choixIngredient(int choix){

        Pizza pizzaCourante;

        try {
            pizzaCourante = this.listePizza.get(this.numPizzaCourante);
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        switch (choix) {
            case 0:
                pizzaCourante = new PizzaFromage(pizzaCourante);
                break;
            case 1:
                pizzaCourante = new PizzaChampignons(pizzaCourante);
                break;
            case 2:
                pizzaCourante = new PizzaChorizo(pizzaCourante);
                break;
            case 3:
                pizzaCourante = new PizzaOeuf(pizzaCourante);
                break;
            case 4:
                pizzaCourante = new PizzaOignons(pizzaCourante);
                break;
            case 5:
                pizzaCourante = new PizzaOlivesNoires(pizzaCourante);
                break;
            case 6:
                pizzaCourante = new PizzaOlivesVertes(pizzaCourante);
                break;
            case 7:
                pizzaCourante = new PizzaRoquette(pizzaCourante);
                break;
        }

        this.listePizza.set(this.numPizzaCourante, pizzaCourante);

        this.calculPrixCommande();
    }


    public void retirerDernierePizza(){
        if (this.nbPizza > 0){
            this.listePizza.remove(this.nbPizza-1);
            this.nbPizza -= 1;
            if (this.listePizza.size() == this.numPizzaCourante){
                this.numPizzaCourante -= 1;
            }
            this.calculPrixCommande();
        }
    }


    public void retirerDernierIngredient(){
        if (this.nbPizza > 0) {
            Pizza pizzaCourante = this.listePizza.get(this.numPizzaCourante);
        try {
            IngredientPizza ingredient = (IngredientPizza) pizzaCourante;
            pizzaCourante = ingredient.getPizza();
            this.listePizza.set(this.numPizzaCourante, pizzaCourante);
            this.calculPrixCommande();
        } catch (Exception e) {}
        }
    }


    /**
     * permet de valider la commande
     */
    public void validerCommande(){


        // si il y a une commande en cours
        if (!this.listePizza.isEmpty()) {


            // on affiche la commande
            StringBuilder s = new StringBuilder();
            s.append("Commande n ").append(ModeleCommande.numeroCommande).append(" validee").append("\n");
            s.append(this.getDescriptifCommande());
            s.append("Prix total : ").append(this.getPrixCommande()).append(" euros\n");
            s.append("Merci pour votre commande !").append("\n");

            System.out.println(s);

            // le nombre de pizza est de 0
            this.nbPizza = 0;
            // le prix de la commande passe à 0
            this.prixCommande = 0;
            // la pizza courante est la 0 eme
            this.numPizzaCourante = 0;
            // on supprime toutes les pizzas de la liste des pizza
            this.listePizza.removeAll(this.listePizza);
            // on remet le taux par defaut (nouveau client)
            this.taux = new ClientNouveau();

            // on notifie les observateurs
            this.notifierObservateur();
        }
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
