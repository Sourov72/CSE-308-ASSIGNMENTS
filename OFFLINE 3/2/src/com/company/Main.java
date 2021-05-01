package com.company;

import decorator.Coffee;
import decorator.Coke;
import decorator.FrenchFry;
import decorator.OnionRings;
import pizza.beefPizza;
import pizza.vegPizza;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int choice;

        while (true){
            System.out.println("There are total of 5 packages");
            System.out.println("press 1:Beef Pizza with French Fry");
            System.out.println("press 2:Veggi Pizza with Onion Rings");
            System.out.println("press 3:Veggi Pizza with French Fry and Coke");
            System.out.println("press 4:Veggi Pizza with Onion Rings and Coffee");
            System.out.println("press 5:Beef Pizza only");
            System.out.println("press 6:close the program");
            choice = input.nextInt();
            Pizza meal = null;
            if(choice == 1){
                meal = new FrenchFry(new beefPizza());
            }
            else if(choice == 2){
                meal = new OnionRings(new vegPizza());
            }
            else if(choice == 3){
                meal = new Coke(new FrenchFry(new vegPizza()));
            }
            else if(choice == 4){
                meal = new Coffee(new OnionRings(new vegPizza()));
            }
            else if(choice == 5){
                meal = new beefPizza();
            }
            else if(choice == 6){
                break;
            }
            System.out.println(meal.mealDesc());
            System.out.println("Total bill is: " + meal.price());
            System.out.println("\n");
        }


    }
}
