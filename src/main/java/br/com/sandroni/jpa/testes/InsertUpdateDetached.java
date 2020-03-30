package br.com.sandroni.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandroni.jpa.model.Account;

public class InsertUpdateDetached {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		Account account = new Account();
		
		account.setAgency(9873);
		account.setNumber(983873);
		account.setOwner("Maria");
		account.setSum(200.00);
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		em.close();
		
		account.setSum(33000.00);
		
		EntityManager em2 = emf.createEntityManager();
		
		em2.getTransaction().begin();
		
		em2.merge(account);
		
		em2.getTransaction().commit();
	}

}
