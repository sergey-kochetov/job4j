package ru.job4j.search.bank;

import org.junit.Test;
import ru.job4j.search.Person;
import ru.job4j.search.PhoneDictionary;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    /**
     * Test.
     */
    @Test
    public void whenAddUserThenBankAddUserToAccounts(){
        Bank bank = new Bank();
        User user1 = new User("name1", "passport1");
        bank.addUser(user1);
        final int expected = 0;
        assertThat(bank.getUserAccounts("passport1").size(), is(expected));
    }
    /**
     * Test.
     */
    @Test(expected = NullPointerException.class)
    public void whenAddNullUserThenMapBankThrowsException(){
        Bank bank = new Bank();
        User user = null;
        bank.addUser(user);
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteUserThenMapBankDeleteUserFromAccounts(){
        Bank bank = new Bank();
        User user1 = new User("name1", "passport1");
        User user2 = new User("name2", "passport2");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user1);
        final int expected = 0;
        assertThat(bank.getUserAccounts("passport1").size(), is(expected));
    }

    /**
     * Test.
     */
    @Test
    public void whenAddAccountToUserThenMapBankAddAccountValueIsZero(){
        Bank bank = new Bank();
        User user1 = new User("name1", "passport1");
        Account account1 = new Account(1.0d, "req1");
        bank.addUser(user1);
        bank.addAccountToUser("passport1", account1);
        final double result = bank.getAccountByRequisite("req1").getValue();
        final double expected = 1.0d;
        assertThat(result, is(expected));
    }
    /**
     * Test.
     */
    @Test
    public void whenAddTwoAccToUserAndOneAccDelThenMapBankUserAccountValueIsOne(){
        Bank bank = new Bank();
        User user1 = new User("name1", "passport1");
        Account account1 = new Account(1.0d, "req1");
        Account account2 = new Account(2.0d, "req2");
        bank.addUser(user1);
        bank.addAccountToUser("name1", account1);
        bank.addAccountToUser("name1", account2);
        bank.deleteAccountFromUser("name1", account1);
        final int result = bank.getUserAccounts("passport1").size();
        final int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Test.
     *
     */
    @Test
    public void whenIncorrectTransferMoneyThenIsNotOk(){
        Bank mapBank = new Bank();
        User user1 = new User("name1", "passport1");
        Account account1 = new Account(3.0d, "req1");
        mapBank.addUser(user1);
        mapBank.addAccountToUser("passport1", account1);

        User user2 = new User("name2", "passport2");
        Account account2 = new Account(2.0d, "req2");
        mapBank.addUser(user2);
        mapBank.addAccountToUser("name2", account2);

        final boolean result = mapBank.transferMoney(
                "passport1", "req1", "passport2", "req2", 4.0d);

        final boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * Test.
     */
    @Test
    public void whenCorrectTransferMoneyThenIsOk(){
        Bank mapBank = new Bank();
        User user1 = new User("name1", "passport1");
        Account account1 = new Account(3.0d, "req1");
        mapBank.addUser(user1);
        mapBank.addAccountToUser("passport1", account1);

        User user2 = new User("name2", "passport2");
        Account account2 = new Account(2.0d, "req2");
        mapBank.addUser(user2);
        mapBank.addAccountToUser("name2", account2);

        final boolean result = mapBank.transferMoney(
                "passport1", "req1", "passport2", "req2", 1.0d);

        final boolean expected = true;
        assertThat(result, is(expected));
    }
}
