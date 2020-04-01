package br.com.sandroni.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandroni.jpa.model.Account;
import br.com.sandroni.jpa.model.Client;

public class CreateAccountClient {

	public static void main(String[] args) {

		
		
		Account account = new Account();
		account.setAgency(134134);
		account.setNumber(141);
		account.setOwner("Joaquim José 2");
		account.setSum(1234341.00);
		
		
		Client client = new Client();
		client.setName("Joaquim José ");
		client.setAddress("Rua dos Cavaleiros, 333");
		client.setProfissional("System Enginier");
		client.setAccount(account);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(account);
		em.persist(client);
		
		em.getTransaction().commit();
	}

}
