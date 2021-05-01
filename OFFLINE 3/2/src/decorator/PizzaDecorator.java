package decorator;
import com.company.Pizza;

public abstract class PizzaDecorator implements Pizza {
    private Pizza meal;
    public PizzaDecorator(Pizza meal)  {
        this.meal=meal;
    }
    @Override
    public String mealDesc(){
        return meal.mealDesc();
    }
    @Override
    public double price(){
        return meal.price();
    }
}
