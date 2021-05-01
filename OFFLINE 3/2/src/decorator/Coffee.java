package decorator;


import com.company.Pizza;

public class Coffee extends DrinkDecorator {
    public Coffee(Pizza newmeal) {
        super(newmeal);
    }

    @Override
    public String mealDesc() {
        return super.mealDesc() + " with Coffee";
    }

    public double price(){
        return super.price() + 60.00;
    }
}
