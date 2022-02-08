public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        account1.depositCheckingMoney(500.00);
        account1.depositSavingsMoney(100.00);
        System.out.print(account1.getCheckingBalance() + "\n");
        System.out.print(account1.getSavingsBalance() + "\n");

        account1.withdrawCheckingMoney(250.00);
        account1.withdrawSavingsMoney(50.00);
        System.out.print(account1.getCheckingBalance() + "\n");
        System.out.print(account1.getSavingsBalance() + "\n");

        account1.withdrawCheckingMoney(251.00); // returns previous values and does not submit changes
        account1.withdrawSavingsMoney(51.00);// returns previous values and does not submit changes
        System.out.print(account1.getCheckingBalance() + "\n");
        System.out.print(account1.getSavingsBalance() + "\n");

        System.out.print(account1.getTotalMoney() + "\n"); // 300.00
        System.out.print(account1.getTotalNumberOfAccounts() + "\n"); // 3 accounts
    }
}