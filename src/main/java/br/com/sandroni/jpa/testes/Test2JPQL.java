package br.com.sandroni.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.sandroni.jpa.model.Category;
import br.com.sandroni.jpa.model.Movement;

public class Test2JPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		Category category = new Category();
		category.setId(1L);
				
		String psql = "select m from Movement m  join m.categories c where c = :pCategories order by m.balance desc";
		TypedQuery<Movement> query = em.createQuery(psql,Movement.class);
		query.setParameter("pCategories", category);
		
		//query.setParameter("pAccount", account);
		List<Movement> resultList = query.getResultList();
		
		for (Movement movement : resultList) {
			System.out.println("Descrição: "+ movement.getDescription());
			System.out.println("Valor: "+movement.getBalance());
			System.out.println("Tipo: "+ movement.getMovimentType());
		}
	}

}
