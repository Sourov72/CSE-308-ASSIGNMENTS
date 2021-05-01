package decorator;

import com.company.Pizza;

public class OnionRings extends AppetizerDecorator {
    public OnionRings(Pizza newmeal) {
        super(newmeal);
    }

    @Override
    public String mealDesc() {
        return super.mealDesc() + " with OnionRings";
    }

}
