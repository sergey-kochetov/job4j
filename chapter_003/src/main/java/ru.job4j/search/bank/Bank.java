package ru.job4j.search.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> customers;

    public Bank() {
        this.customers = new HashMap<>();
    }

    public void addUser(User user) {
        //Objects.requireNonNull(user);
        List<Account> accounts = new ArrayList<>();
        this.customers.putIfAbsent(user, accounts);

    }

    public void deleteUser(User user) {
        Objects.requireNonNull(user);
        this.customers.remove(user);

    }

    public void addAccountToUser(String passport, Account account) {
       List<Account> list = this.getUserAccounts(passport);
        System.out.println(list.indexOf(account));
       if (-1 == list.indexOf(account)) {

           this.customers.get(this.getUserByPassport(passport)).add(account);
       }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> list = this.getUserAccounts(passport);
        if (-1 != list.indexOf(account)) {
            list.remove(account);
        }

    }

    public List<Account> getUserAccounts (String passport) {
        User user = getUserByPassport(passport);
        //Objects.requireNonNull(user);
        return this.customers.get(user);
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = this.getAccountByRequisite(srcPassport);
        Account destAccount = this.getAccountByRequisite(destPassport);
        Objects.requireNonNull(srcAccount);
        Objects.requireNonNull(destAccount);

        if ( srcAccount.getValue() >= amount) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            result = true;
        }
        return result;
    }

    private User getUserByPassport(String passport) {

        customers.forEach((a,b) ->
                System.out.println("user: " + a + ". list: " + b));


        for (User user : this.customers.keySet()) {

            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        throw new NullPointerException();
    }

    public Account getAccountByRequisite(String requisite) {
        Account result = null;
        for (Account acc : this.getUserAccounts(requisite)) {
            if (acc.getRequisites().equals(requisite)) {
                result = acc;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        User user1 = new User("name1", "passport1");
        Account account1 = new Account(1.0d, "req1");
        bank.addUser(user1);
        bank.addAccountToUser("passport1", account1);
       // final double result = bank.getAccountByRequisite("req1").getValue();
       // final double expected = 1.0d;

        //System.out.println(result);


    }
}
