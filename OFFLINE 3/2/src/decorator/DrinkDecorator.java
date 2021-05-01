package decorator;

import com.company.Pizza;

public abstract class DrinkDecorator extends PizzaDecorator{
    public DrinkDecorator(Pizza meal) {
        super(meal);
    }
    public String mealDesc(){
        return super.mealDesc();
    }
    public  double price(){
        return super.price();
    }
}
