public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts;
    private static double totalMoney;
    
    public BankAccount() {
        this.numberOfAccounts ++;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public double depositCheckingMoney(double amount) {
        this.checkingBalance += amount;
        this.totalMoney += amount;
        return this.checkingBalance;
    }

    public double depositSavingsMoney(double amount) {
        this.savingsBalance += amount;
        this.totalMoney += amount;
        return this.savingsBalance;
    }

    public double withdrawCheckingMoney(double amount) {
        if (this.checkingBalance - amount >= 0) {
            this.checkingBalance -= amount;
            this.totalMoney -= amount;
            return this.checkingBalance;
        }
        else {
            return this.checkingBalance;
        }
    }

    public double withdrawSavingsMoney(double amount) {
        if (this.savingsBalance - amount >= 0) {
            this.savingsBalance -= amount;
            this.totalMoney -= amount;
            return this.savingsBalance;
        }
        else {
            return this.savingsBalance;
        }
    }

    public double getTotalMoney() {
        return this.totalMoney;
    }

    public int getTotalNumberOfAccounts() {
        return this.numberOfAccounts;
    }
}