

import java.util.List;

class Employee{

    private String etype;
    private String name;

    public Employee(String etype, String name) {
        this.etype = etype;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEtype() {
        return etype;
    }


    public void lookup(account a){
        System.out.print(a.getName() + "'s ");
        a.query();
    }

    public double appLoan(List<account> loanList){
        account Account;
        double fund = 0;

        if(loanList.size() == 0){
            System.out.println("No Loan Approval pending");
        }

        for(int i = 0; i < loanList.size(); i++){
            Account = loanList.get(i);
            fund += (double) Account.gettLoan();
            Account.loanSuccess();
            System.out.println("Loan for " + Account.getName() + " approved");

        }
        loanList.clear();
        return fund;

    }


    public double changeInrate(double type, double newrate, String atype){
        System.out.println("You don't have permission for this operation");
        return type;
    }


    public void fundCheck(double fund){
        System.out.println("You don't have permission for this operation");

    }

}

class Director extends Employee{

    public Director(String etype, String name) {
        super(etype, name);
    }

    public double changeInrate(double type, double newrate, String atype){
        if(newrate > 0){
            type = newrate;
            if(atype.equals("Student"))
                System.out.println("Student Account Interest Rate changed successfully");
            else if(atype.equals("Savings"))
                System.out.println("Savings Account Interest Rate changed successfully");
            else
                System.out.println("Fixed Deposit Account Interest Rate changed successfully");
        }
        else
            System.out.println("Invalid Value");

        return type;

    }

    public void fundCheck(double fund){
        System.out.println("Internal Fund is " + fund + "$");
    }


}

class Officer extends Employee{

    public Officer(String etype, String name) {
        super(etype, name);
    }
}

class Cashier extends Employee{

    public Cashier(String etype, String name) {
        super(etype, name);
    }

    public double appLoan(List<account> loanList){
        double fund = 0;
        System.out.println("You don't have permission for this operation");
        return fund;
    }
}