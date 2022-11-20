package org.arobase.pizza.classes;


import org.arobase.pizza.MyImage;

/**
 * classe representant une pizza base tomate
 */
public class PizzaFromageBlanc implements Pizza{

    /**
     * prix de la pizza
     */
    private double prix;

    /**
     * nom de l'image de la pizza
     */
    private String nomIm;

    /**
     * description de la pizza
     */
    private String description;


    /**
     * constructeur par defaut
     */
    public PizzaFromageBlanc(){
        this.prix = 7;
        this.nomIm = "fond_creme.png";
        this.description = "pizza base fromage blanc";
    }


    /**
     * image de la pizza
     * @return image de la pizza
     */
    @Override
    public MyImage getPizzaIm() {
        return new MyImage(this.nomIm, null);
    }

    /**
     * cout
     * @return cout de la pizza
     */
    @Override
    public double getCout() {
        return this.prix;
    }

    /**
     * description
     * @return description de la pizza
     */
    @Override
    public String getDescription() {
        return this.description;
    }
}
