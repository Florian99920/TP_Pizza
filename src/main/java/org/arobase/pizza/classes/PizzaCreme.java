package org.arobase.pizza.classes;


import org.arobase.pizza.MyImage;

/**
 * classe representant une pizza base tomate
 */
public class PizzaCreme implements Pizza{

    /**
     * prix de la ^pizza
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
    public PizzaCreme(){
        this.prix = 6;
        this.nomIm = "fond_tomate.png";
        this.description = "pizza base creme";
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
    public String GetDescription() {
        return this.description;
    }
}
