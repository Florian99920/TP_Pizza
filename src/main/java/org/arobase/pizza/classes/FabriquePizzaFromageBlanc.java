package org.arobase.pizza.classes;

public class FabriquePizzaFromageBlanc implements FabriquePizza{
    @Override
    public Pizza fabriquerPizza() {
        return new PizzaFromageBlanc();
    }
}
