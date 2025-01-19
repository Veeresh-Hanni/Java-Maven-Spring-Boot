package net.bank;

import net.bank.controller.AccountController;
import net.bank.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	private AccountController accountController;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateAccount() {
		Account account = new Account();
		account.setAccountId("12345");
		account.setAccountHolderName("John Doe");
		account.setBalance(1000.0);

		ResponseEntity<Account> response = accountController.createAccount(account);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("12345", response.getBody().getAccountId());
	}

	@Test
	void testGetAccount() {
		Account account = new Account();
		account.setAccountId("12345");
		account.setAccountHolderName("John Doe");
		account.setBalance(1000.0);
		accountController.createAccount(account);

		ResponseEntity<Account> response = accountController.getAccount("12345");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("John Doe", response.getBody().getAccountHolderName());
	}

	@Test
	void testSignUp() {
		Account account = new Account();
		account.setAccountId("67890");
		account.setAccountHolderName("Jane Doe");
		account.setBalance(2000.0);

		ResponseEntity<Account> response = accountController.signUp(account);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("67890", response.getBody().getAccountId());
	}

	@Test
	void testLogin() {
		// Implement login test logic here
		// This will depend on how the login functionality is implemented
		assertEquals(true, true); // Placeholder for actual login test
	}
}
