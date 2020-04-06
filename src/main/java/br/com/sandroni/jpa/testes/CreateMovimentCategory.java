package br.com.sandroni.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandroni.jpa.enums.MovimentType;
import br.com.sandroni.jpa.model.Account;
import br.com.sandroni.jpa.model.Category;
import br.com.sandroni.jpa.model.Movement;

public class CreateMovimentCategory {

	public static void main(String[] args) {
		Account account = new Account();
		account.setId(1L);

		
		Category category = new Category("Viagem");
		Category category2 = new Category("Negócios");
		
		Movement movement = new Movement();
		movement.setAccount(account);
		movement.setBalance(new BigDecimal(250.00));
		movement.setMovimentType(MovimentType.EXIT);
		movement.setDate(LocalDateTime.now());
		movement.setDescription("Viagem ao RJ");
		movement.setCategories(Arrays.asList(category,category2));
		
		Movement movement2 = new Movement();
		movement2.setAccount(account);
		movement2.setBalance(new BigDecimal(300.00));
		movement2.setMovimentType(MovimentType.EXIT);
		movement2.setDate(LocalDateTime.now());
		movement2.setDescription("Viagem ao RJ");
		movement2.setCategories(Arrays.asList(category,category2));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(category);
		em.persist(category2);
		
		em.persist(movement2);
		em.persist(movement);
		
		em.getTransaction().commit();
	}

}
