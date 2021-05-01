package decorator;

import com.company.Pizza;

public class Coke extends DrinkDecorator {
    public Coke(Pizza newmeal) {
        super(newmeal);
    }

    @Override
    public String mealDesc() {
        return super.mealDesc() + " with Coke";
    }

    @Override
    public double price(){
        return super.price() + 30.0;
    }


}
