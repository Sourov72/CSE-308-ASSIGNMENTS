

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class bank {
    private double studentInterest;
    private double savingsInterest;
    private double fixedInterest;
    private double loanInterest;
    private double initFund;
    private double interFund;
    private List<account> accountList;
    private List<Employee> employeeList;
    private List<account> loanList;
    Scanner input;
    static int year = 0;

    bank(){
        studentInterest = 5;
        savingsInterest = 10;
        fixedInterest = 15;
        loanInterest = 10;
        initFund = 1000000;
        interFund = initFund;
        employeeList = new ArrayList<Employee>();
        accountList = new ArrayList<account>();
        loanList = new ArrayList<account>();
        input = new Scanner(System.in);
        System.out.println("Bank Created;");
        employeeInit();

    }

    public void employeeInit(){

        employeeList.add( new Director("Managing Director","MD") );
        employeeList.add( new Officer("Officer","O1") );
        employeeList.add( new Officer("Officer","O2") );
        employeeList.add( new Cashier("Cashier","C1") );
        employeeList.add( new Cashier("Cashier","C2") );
        employeeList.add( new Cashier("Cashier","C3") );
        employeeList.add( new Cashier("Cashier","C4") );
        employeeList.add( new Cashier("Cashier","C5") );

        for(int i = 0; i < employeeList.size(); i++){
            System.out.print(employeeList.get(i).getName() + ", ");
        }
        System.out.println("created");
    }

    public account accountQuery(String name){
        for(int i = 0; i < getAccountList().size(); i++){
            if(getAccountList().get(i).getName().equals(name))
                return getAccountList().get(i);
        }
        return null;
    }

    public Employee employeeQuery(String name){
        for(int i = 0; i < getEmployeeList().size(); i++){
            if(getEmployeeList().get(i).getName().equals(name))
                return getEmployeeList().get(i);
        }
        return null;
    }

    public double getStudentInterest() {
        return studentInterest;
    }

    public void setStudentInterest(double studentInterest) {
        this.studentInterest = studentInterest;
    }

    public double getSavingsInterest() {
        return savingsInterest;
    }

    public void setSavingsInterest(double savingsInterest) {
        this.savingsInterest = savingsInterest;
    }

    public double getFixedInterest() {
        return fixedInterest;
    }

    public void setFixedInterest(double fixedInterest) {
        this.fixedInterest = fixedInterest;
    }

    public void setInterFund(double interFund) {
        this.interFund = interFund;
    }

    public double getInterFund() {
        return interFund;
    }

    public List<account> getAccountList() {
        return accountList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<account> getLoanList() {
        return loanList;
    }

    public void takeInput(){
        String fInput, name;
        while(true){
            fInput = input.nextLine();
            String[] arrOfStr = fInput.split(" ");
            if(arrOfStr[0].equals("Create")){
                account Account;
                Employee employee;
                String atype;
                double deposit;
                name = arrOfStr[1];
                atype = arrOfStr[2];
                deposit = Double.parseDouble(arrOfStr[3]);
                Account = accountQuery(name);
                employee = employeeQuery(name);
                if(Account != null || employee != null){
                    System.out.println("Account already exists with this name");
                }
                else if((atype.equals("FixedDeposit") && deposit < 100000) || deposit < 0){
                    System.out.println("Account Creation Unsuccessful, You have to deposit minimum amount");
                }
                else{
                    if(atype.equals("Student")){
                        Account = new Student(name, atype, deposit);
                        accountList.add(Account);

                    }
                    else if(atype.equals("Savings")){
                        Account = new Savings(name, atype, deposit);
                        accountList.add(Account);

                    }
                    else{
                        Account = new Fixed(name, atype, deposit);
                        accountList.add(Account);
                    }

                    accountFunc(Account);
                }

            }
            else if(arrOfStr[0].equals("Open")){
                name = arrOfStr[1];
                Employee employee;
                account Account;
                boolean check = false;
                employee = employeeQuery(name);
                if(employee != null){
                    System.out.print(employee.getName() + " active");
                    if(loanList.size() > 0 && !(employee instanceof Cashier))
                        System.out.println(", There are loan approvals pending");
                    else{
                        System.out.println();
                    }
                    employeeFunc(employee);
                    check = true;
                }
                Account = accountQuery(name);
                if(Account != null && !check){
                    System.out.println("Welcome Back, " + Account.getName());
                    accountFunc(Account);
                    check = true;
                }
                if(!check){
                    System.out.println("No such Account with this name exists!");
                }



            }
            else if(arrOfStr[0].equals("INC")){
                incTime();
                System.out.println(getTime() + " year passed.");
            }

            else if(arrOfStr[0].equals("Close")){
                break;
            }

            else{
                System.out.println("cant recognize this command");
            }
        }
    }

    public void accountFunc(account tempAccount){

        while(true){
            String command;
            double amount;
            command = input.nextLine();
            String[] arrOfStr = command.split(" ");

            if(arrOfStr[0].equals("Deposit")){
                amount = Double.parseDouble(arrOfStr[1]);
                tempAccount.deposit(amount);

            }
            else if(arrOfStr[0].equals("Withdraw")){
                amount = Integer.parseInt(arrOfStr[1]);
                tempAccount.withdraw(amount);
            }
            else if(arrOfStr[0].equals("Query")){
                tempAccount.query();

            }
            else if(arrOfStr[0].equals("Request")){
                amount = Double.parseDouble(arrOfStr[1]);
                if(tempAccount.reqLoan(amount)){
                    loanList.add(tempAccount);
                }

            }
            else if(command.equals("Close")){
                System.out.println("Transaction closed for " + tempAccount.getName());
                break;

            }
            else{
                System.out.println("no such command");
            }
        }


    }

    public void employeeFunc(Employee tempEmployee){

        while (true){
            String command, name, atype;
            double amount;
            command = input.nextLine();
            String[] arrOfStr = command.split(" ");

            if(arrOfStr[0].equals("Lookup")){
                name = arrOfStr[1];
                account Account = accountQuery(name);
                if(Account != null){
                    tempEmployee.lookup(Account);
                }
                else{
                    System.out.println("No such Account with this name exists!");
                }


            }
            else if(arrOfStr[0].equals("Approve") && arrOfStr[1].equals("Loan")){
                //approve load has to be added as string
                double tloan = tempEmployee.appLoan(getLoanList());
                setInterFund(getInterFund() - tloan);


            }
            else if(arrOfStr[0].equals("Change")){
                atype = arrOfStr[1];
                amount = Double.parseDouble(arrOfStr[2]);

                if(atype.equals("Student")){
                    setStudentInterest(tempEmployee.changeInrate(getStudentInterest(), amount, atype));
                }
                else if(atype.equals("Savings")){
                    setSavingsInterest(tempEmployee.changeInrate(getSavingsInterest(), amount, atype));
                }
                else{
                    setFixedInterest(tempEmployee.changeInrate(getFixedInterest(), amount, atype));
                }


            }
            else if(arrOfStr[0].equals("See")){
                tempEmployee.fundCheck(getInterFund());

            }
            else if(command.equals("Close")){
                System.out.println("Operations for " + tempEmployee.getName() + " closed");
                break;

            }
            else{
                System.out.println("no such command");
            }
        }

    }

    static int getTime() {
        return year;
    }

    public void incTime(){
        year++;
        account.inYear();
        account Account;
        for(int i = 0; i < getAccountList().size(); i++){
            Account = getAccountList().get(i);
            if(Account instanceof Student){
                Account.adjust(getStudentInterest(), loanInterest);
            }
            else if(Account instanceof Savings){
                Account.adjust(getSavingsInterest(), loanInterest);
            }
            else{
                Account.adjust(getFixedInterest(), loanInterest);
            }
        }


    }


}
