package decorator;

import com.company.Pizza;

public abstract class AppetizerDecorator extends PizzaDecorator{


    public AppetizerDecorator(Pizza meal) {
        super(meal);
    }
    public String mealDesc(){
        return super.mealDesc();
    }
    public  double price(){
        return super.price() + 100.00;
    }

}
