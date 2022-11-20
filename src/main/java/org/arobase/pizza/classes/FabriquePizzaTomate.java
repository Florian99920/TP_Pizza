package org.arobase.pizza.classes;

public class FabriquePizzaTomate implements FabriquePizza{
    @Override
    public Pizza fabriquerPizza() {
        return new PizzaTomate();
    }
}
