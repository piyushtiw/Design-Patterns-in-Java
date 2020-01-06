import java.io.*;
import java.util.*;

abstract class Customer {
    public abstract void update(int rate);
}

class BankLoan {
    private List<Customer> customerList = new ArrayList<Customer>();
    private int base_rate;

    public void setInterestRate(int rate) {
        this.base_rate = rate;
        updateCustomers();
    }

    public void updateCustomers(){
        for (Customer eachCustomer : customerList) {
            eachCustomer.update(base_rate);
        }
    }

    public void addToList(Customer addCustomer){
        customerList.add(addCustomer);
    }

    public int getInterestRate() {
        return base_rate;
    }
}


class Student extends Customer{
    public static int count = 0;
    private int index;
    public Student(){
        this.index = ++count;
    }

    public void  update (int rate) {
        double marginal_rate = 2.5;
        System.out.println( "Student " + this.index + " Interest Rate: " + (rate + marginal_rate) );
    }
}


class SeniorCitizen extends Customer{
    public void update  (int rate) {
        double marginal_rate = 1.0;
        System.out.println( "Senior Citizen Interest Rate: " + (rate + marginal_rate) );
    }
}

class BNYCucumber {
    public static void main(String[] args) {
        BankLoan loanedcustomers = new BankLoan();
        SeniorCitizen CustomerA = new SeniorCitizen();
        Student CustomerB = new Student();
        Student CustomerC = new Student();

        loanedcustomers.addToList(CustomerA);
        loanedcustomers.addToList(CustomerB);
        loanedcustomers.addToList(CustomerC);

        loanedcustomers.setInterestRate(4);
    }
}

