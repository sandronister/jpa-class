package br.com.sandroni.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandroni.jpa.model.Account;

public class RemoveAccount {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		Account account = em.find(Account.class, 7L);
		
		em.getTransaction().begin();
		em.remove(account);
		
		em.getTransaction().commit();
	}

}
