package decorator;

import com.company.Pizza;

public class FrenchFry extends AppetizerDecorator {
    public FrenchFry(Pizza newmeal) {
        super(newmeal);
    }

    @Override
    public String mealDesc() {
        return super.mealDesc() + " with FrenchFry";
    }

}
