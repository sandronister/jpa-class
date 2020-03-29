package br.com.sandroni.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class CreateTable {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}
}
