package br.com.sandroni.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sandroni.jpa.enums.MovimentType;
import br.com.sandroni.jpa.model.Account;
import br.com.sandroni.jpa.model.Movement;

public class MovementInsert {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager em = emf.createEntityManager();
		
		Account account = new Account();
		account.setAgency(90123);
		account.setNumber(1342234);
		account.setOwner("Donatello");
		account.setSum(1000000.00);
		
		Movement mov = new Movement();
		
		mov.setAccount(account);
		mov.setDate(LocalDateTime.now());
		mov.setDescription("Buy a Land Rover");
		mov.setBalance(new BigDecimal(900000.00));
		mov.setMovimentType(MovimentType.EXIT);
		
		em.getTransaction().begin();
		
		em.persist(account);
		em.persist(mov);
		
		em.getTransaction().commit();
		
	}

}
