package pizza;

import com.company.Pizza;

public class beefPizza implements Pizza {
    @Override
    public double price() {
        return 500.0;
    }

    @Override
    public String mealDesc() {
        return "Beef Pizza";
    }
}
