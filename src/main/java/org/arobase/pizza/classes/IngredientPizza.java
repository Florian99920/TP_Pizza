package org.arobase.pizza.classes;

import org.arobase.pizza.MyImage;

public class IngredientPizza implements Pizza {

    protected Pizza pizza;

    protected double prix;

    protected String description;

    protected String nomImage;

    protected IngredientPizza(Pizza pizza, double prix, String description, String nomImage) {
        this.pizza = pizza;
        this.prix = prix;
        this.description = description;
        this.nomImage = nomImage;
    }


    @Override
    public MyImage getPizzaIm() {
        MyImage im = pizza.getPizzaIm();
        im.superposer(this.nomImage);
        return im;
    }

    @Override
    public double getCout() {
        return this.pizza.getCout() + this.prix;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " - " + this.description;
    }
}
