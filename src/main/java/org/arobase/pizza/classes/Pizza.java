package com.example.demo.classes;

import com.example.demo.MyImage;

/**
 * interface representant une pizza
 */
public interface Pizza {

    /**
     * pour aavoir l'image de la pizza
     * @return l'image de la pizza
     */
    public MyImage getPizzaIm();

    /**
     * get le cout de la pizza
     * @return cout de la pizza
     */
    public double getCout();

    /**
     * description de la pizza
     * @return description de la pizza
     */
    public String GetDescription();


}
