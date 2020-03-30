package br.com.sandroni.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandroni.jpa.model.Account;

public class InserUpdate {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		Account account = new Account();
		
		account.setAgency(1023);
		account.setNumber(13413);
		account.setOwner("Bruno");
		account.setSum(9000.00);
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		account.setSum(33000.00);
		
		em.getTransaction().commit();

	}

}
