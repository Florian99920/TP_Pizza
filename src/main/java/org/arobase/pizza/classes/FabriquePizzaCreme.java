package org.arobase.pizza.classes;

public class FabriquePizzaCreme implements FabriquePizza{
    @Override
    public Pizza fabriquerPizza() {
        return new PizzaCreme();
    }
}
