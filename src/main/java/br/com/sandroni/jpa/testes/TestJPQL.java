package br.com.sandroni.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.sandroni.jpa.model.Account;
import br.com.sandroni.jpa.model.Movement;

public class TestJPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		Account account = new Account();
		account.setId(1L);
				
		String psql = "select m from Movement m where m.account=:pAccount order by m.balance descs";
		TypedQuery<Movement> query = em.createQuery(psql,Movement.class);
		query.setParameter("pAccount", account);
		
		//query.setParameter("pAccount", account);
		List<Movement> resultList = query.getResultList();
		
		for (Movement movement : resultList) {
			System.out.println("Descrição: "+ movement.getDescription());
			System.out.println("Valor: "+movement.getBalance());
			System.out.println("Tipo: "+ movement.getMovimentType());
		}
;	}

}
