


abstract class account{

    private String name;
    private String atype;
    private double inD;
    private double Loan;
    private double tLoan;

    static int ayear = 0;

    account(String name, String atype, double inD){
        this.name = name;
        this.atype = atype;
        this.inD = inD;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public double getInD() {
        return inD;
    }

    public void setInD(double inD) {
        this.inD = inD;
    }

    public double getLoan() {
        return Loan;
    }

    public void setLoan(double loan) {
        Loan += loan;
    }

    public double gettLoan() {
        return tLoan;
    }

    public void settLoan(double tLoan) {
        this.tLoan = tLoan;
    }


    public void deposit(double amount){
        if(amount > 0){
            setInD(getInD() + amount);
            System.out.println(amount + "$ deposited; current balance " + getInD() + "$");
        }
        else
            System.out.println("Invalid Transaction; Current balance " + getInD() + "$");
    }

    public void withdraw(double amount){

        if(getInD() >= amount && amount > 0){
            setInD(getInD() - amount);
            System.out.println("Withdrawal is successful");
        }
        else{
            System.out.println("Withdrawal is unsuccessful as there is not enough deposited money");
        }

    }

    public boolean reqLoan(double amount){
        settLoan(gettLoan() + amount);
        System.out.println("Loan request successful, sent for approval");
        return true;
    }

    public void query(){
        if(getLoan() > 0)
            System.out.println("Current Balance " + getInD() + "$ , loan " + getLoan() + "$");
        else{
            System.out.println("Current Balance " + getInD() + "$");
        }

    }

    public void adjust(double dInterest, double lInterest){
        setInD(getInD() + (getInD() * (dInterest / 100.0)));
        setInD(getInD() - (getLoan() * (lInterest / 100.0)));

        setInD(getInD() - 500.0);

    }



    public void loanSuccess(){
        setInD(getInD() + gettLoan());
        setLoan(getLoan() + gettLoan());
        settLoan(0);

    }

    static void inYear(){
        ayear++;
    }


}



class Student extends account{

    Student(String name, String atype, double inD) {
        super(name, atype, inD);
        System.out.println("Student account for " + getName() + " created; initial balance " + getInD() + "$");
    }



    public void withdraw(double amount){
        if(amount <= 10000 && amount > 0){
            super.withdraw(amount);
        }
        else
            System.out.println("Invalid Transaction; Current balance " + getInD() + "$");
    }

    public boolean reqLoan(double amount){
        if(amount <= 1000 && amount > 0){
            return super.reqLoan(amount);
        }
        else{
            System.out.println("Loan request Unsuccessful");
            return false;
        }
    }

    public void adjust(double dInterest, double lInterest) {

        setInD(getInD() + (getInD() * (dInterest / 100.0)));
        setInD(getInD() - (getLoan() * (lInterest / 100.0)));
    }
}


class Savings extends account{

    Savings(String name, String atype, double inD) {
        super(name, atype, inD);
        System.out.println("Savings account for " + getName() + " created; initial balance " + getInD() + "$");
    }
    public void withdraw(double amount){
        if(amount > 0 && getInD() - amount >= 1000){
            super.withdraw(amount);
        }
        else
            System.out.println("Invalid Transaction; Current balance " + getInD() + "$");
    }

    public boolean reqLoan(double amount){
        if(amount <= 10000 && amount > 0){
            return super.reqLoan(amount);
        }
        else{
            System.out.println("Loan request Unsuccessful");
            return false;
        }
    }

}


class Fixed extends account{

    Fixed(String name, String atype, double inD) {
        super(name, atype, inD);
        System.out.println("Fixed Deposit account for " + getName() + " created; initial balance " + getInD() + "$");
    }

    public void deposit(double amount){
        if(amount >= 50000)
            super.deposit(amount);
        else{
            System.out.println("You can't deposit less than 50000$");
        }
    }
    public void withdraw(double amount){
        if(ayear >= 1 && amount > 0){
            super.withdraw(amount);
        }
        else
            System.out.println("Invalid Transaction; Current balance " + getInD() + "$");
    }

    public boolean reqLoan(double amount){
        if(amount <= 100000 && amount > 0){
            return super.reqLoan(amount);
        }
        else{
            System.out.println("Loan request Unsuccessful");
            return false;
        }
    }

}
