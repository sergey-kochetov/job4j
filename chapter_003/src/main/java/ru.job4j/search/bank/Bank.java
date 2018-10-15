package ru.job4j.search.bank;

import java.util.*;

/**
 * Bank.
 */
public class Bank {
    /**
     * customers map.
     */
    private Map<User, List<Account>> customers;

    /**
     * Constructor.
     */
    public Bank() {
        this.customers = new HashMap<>();
    }

    /**
     * Add user.
     * @param user - user
     */
    public void addUser(User user) {
        Objects.requireNonNull(user);
        this.customers.putIfAbsent(user, null);

    }

    /**
     * Delete user.
     * @param user - user
     */
    public void deleteUser(User user) {
        Objects.requireNonNull(user);
        this.customers.remove(user);

    }

    /**
     * Add account.
     * @param passport - passport
     * @param account - account
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry: this.customers.entrySet()) {
            User user = entry.getKey();
            List<Account> list = entry.getValue();
            if (user.getPassport().equals(passport)) {
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(account);
                    this.customers.putIfAbsent(user, list);
                    break;
                }
                list.add(account);
                this.customers.putIfAbsent(user, list);
                break;
            }
        }
    }
    /**
     * Delete account.
     * @param passport - passport
     * @param account - account
     */
    public void deleteAccountFromUser(String passport, Account account) {

        for (Map.Entry<User, List<Account>> entry: this.customers.entrySet()) {
            User user = entry.getKey();
            List<Account> list = entry.getValue();

            if (user.getPassport().equals(passport)) {
                list.remove(account);
                this.customers.putIfAbsent(user, list);
                break;
            }
        }
    }

    /**
     *  Get.
     * @param passport - passport
     * @return List accounts
     */
    public List<Account> getUserAccounts (String passport) {
         for (Map.Entry<User, List<Account>> entry: this.customers.entrySet()) {
            User user = entry.getKey();
            List<Account> list = entry.getValue();
            if (user.getPassport().equals(passport)) {
                return list;
            }
        }
        return new ArrayList<>();
        //throw new NullPointerException("passport not exist");
    }

    /**
     *  Transfer.
     * @param srcPassport - source passport
     * @param srcRequisite - source requisite
     * @param destPassport  - dest passport
     * @param dstRequisite - dest requisite
     * @param amount - money for transfer
     * @return - return true/false
     */
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = this.getAccountByRequisite(srcPassport, srcRequisite);
        Account destAccount = this.getAccountByRequisite(destPassport, dstRequisite);
        Objects.requireNonNull(srcAccount);
        Objects.requireNonNull(destAccount);

        if ( srcAccount.getValue() >= amount) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            result = true;
        }
        return result;
    }

    /**
     *  Return user by passport.
     * @param passport - passport
     * @return user
     */
    private User getUserByPassport(String passport) {
        for (User user : this.customers.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        throw new NullPointerException();
    }

    /**
     * Return user account by requisite.
     * @param passport - user passport
     * @param requisite - account requisite
     * @return account
     */
    public Account getAccountByRequisite(String passport, String requisite) {
        User user = getUserByPassport(passport);
        for (Account acc : this.customers.get(user)) {
            if (acc.getRequisites().equals(requisite)) {
                return acc;
            }
        }
        throw new NullPointerException("requisite not exist");
    }

    /**
     * Getter.
     * @return customers
     */
    public Map<User, List<Account>> getCustomers() {
        return customers;
    }
}
