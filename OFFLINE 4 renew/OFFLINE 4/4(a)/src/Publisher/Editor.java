package Publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Users.user;

public abstract class Editor {
    private List<stockAttributes> stockList;
    private stockAttributes stock;
    private String changedvalue;

    Editor(){
        stockList = new ArrayList<stockAttributes>();
        File myObj = new File("file.txt");

        try {
            Scanner Reader = new Scanner(myObj);

            while(Reader.hasNextLine()){

                String fInput = Reader.nextLine();
                String[] Input = fInput.split(" ");
                stock = new stockAttributes();

                stock.setName(Input[0]);
                stock.setCount(Integer.parseInt(Input[1]));
                stock.setPrice(Double.parseDouble(Input[2]));
                stockList.add(stock);

            }

        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
        }
    }

    public stockAttributes stockSearch(String stype){
        for(int i = 0; i < stockList.size(); i++){
            if(stockList.get(i).getName().equals(stype))
                return stockList.get(i);
        }
        return null;
    }

    public int getstockCount(String stype){
        for(int i = 0; i < stockList.size(); i++){
            if(stockList.get(i).getName().equals(stype))
                return stockList.get(i).getCount();

        }
        return 0;
    }

    public void createStockList(){

        File myObj = new File("file.txt");
        try {
            Scanner Reader = new Scanner(myObj);

            while(Reader.hasNextLine()){
                String fInput = Reader.nextLine();
                String[] Input = fInput.split(" ");
                stock = new stockAttributes();
                stock.setName(Input[0]);
                stock.setCount(Integer.parseInt(Input[1]));
                stock.setPrice(Double.parseDouble(Input[2]));
                stockList.add(stock);

            }
            System.out.println("Summation of Integer Numbers is: ");
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
        }
    }

    public void increasePrice(String stockName, double value){
        stock = stockSearch(stockName);
        stock.setPrice(stock.getPrice() + value);
        changedvalue = "Stock " + stockName + "'s price has increased by " + value;

    }

    public void decreasePrice(String stockName, double value){
        stock = stockSearch(stockName);
        stock.setPrice(stock.getPrice() - value);
        changedvalue = "Stock " + stockName + "'s price has decreased by " + value;
    }

    public void changeCount(String stockName, int count){
        stock = stockSearch(stockName);
        stock.setCount(stock.getCount() + count);
        changedvalue = "Stock " + stockName + "'s number has increased by " + count;
    }

    public void change(String changeType, String count, String stockType){
        if(changeType.equals("I"))
            increasePrice(stockType, Double.parseDouble(count));
        else if(changeType.equals("D"))
            decreasePrice(stockType,Double.parseDouble(count));
        else if(changeType.equals("C"))
            changeCount(stockType, Integer.parseInt(count));

    }

    public String show(){
        String line = "Available stocks: " + "\n";

        for(int i = 0; i < stockList.size(); i++){
            line += stockList.get(i).getName() + " " + stockList.get(i).getCount() + " " + stockList.get(i).getPrice() + "\n";
        }
        return line;
    }

    public String notifyy(){
        return changedvalue;
    }

    public abstract void addUser(user User, String s);
    public abstract void removeUser(user User, String s);
    public abstract List<user> getSubscriberList();
}
