package br.com.sandroni.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandroni.jpa.model.Account;

public class UpdateAccount {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
				
		Account account = em.find(Account.class, 1L);
		
		em.getTransaction().begin();
		account.setSum(10000.00);
		em.getTransaction().commit();
	}

}
