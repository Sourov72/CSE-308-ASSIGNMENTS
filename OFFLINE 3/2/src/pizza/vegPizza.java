package pizza;

import com.company.Pizza;

public class vegPizza implements Pizza {
    @Override
    public double price() {
        return 300.0;
    }

    @Override
    public String mealDesc() {
        return "Veg Pizza";
    }
}
