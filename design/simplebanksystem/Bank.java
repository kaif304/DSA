package design.simplebanksystem;

class Bank {
    long[] accounts;
    public Bank(long[] balance) {
        this.accounts = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 > this.accounts.length || account2 > this.accounts.length) {
            return false;
        }
        if(money > this.accounts[account1-1]) {
            return false;
        }

        this.accounts[account1-1] -= money;
        this.accounts[account2-1] += money;

        return true;
    }

    public boolean deposit(int account, long money) {
        if(account > this.accounts.length) {
            return false;
        }

        this.accounts[account-1] += money;

        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account > this.accounts.length) {
            return false;
        }
        if(money > this.accounts[account-1]) {
            return false;
        }

        this.accounts[account-1] -= money;

        return true;
    }
}
