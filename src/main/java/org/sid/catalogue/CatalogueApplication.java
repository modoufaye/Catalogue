package org.sid.catalogue;

import org.sid.catalogue.dao.ProduitRepository;
import org.sid.catalogue.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CatalogueApplication {

	public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(CatalogueApplication.class, args);
            ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
            
            produitRepository.save(new Produit("Ordinateur HP", 90000, 40));
            produitRepository.save(new Produit("Ordinateur ACCER", 75000, 30));
            produitRepository.save(new Produit("Imprimante HP ", 100000, 15));
            produitRepository.save(new Produit("Imprimante EPson", 95000, 28));
            produitRepository.save(new Produit("Souris HP", 20000, 30));
             produitRepository.save(new Produit("Souris Epson", 9000, 30));
            
            produitRepository.save(new Produit("Ordinateur Samsung", 50000, 10));
            produitRepository.save(new Produit("Souris ACCER", 30000, 54));
            produitRepository.save(new Produit("Imprimante ITEL ", 10000, 15));
            produitRepository.save(new Produit("Imprimante EPson", 95000, 28));
            produitRepository.save(new Produit("Clavier HP", 20000, 30));
            produitRepository.save(new Produit("Clavier Epson", 20000, 17));
            
            produitRepository.save(new Produit("Ordi HP", 50000, 10));
            produitRepository.save(new Produit("Souris ACCER", 30000, 54));
            produitRepository.save(new Produit("Modem HP ", 10000, 15));
            produitRepository.save(new Produit("Imprimante EPson", 95000, 28));
            produitRepository.save(new Produit("Clavier HP", 15000, 5));
            produitRepository.save(new Produit("Clavier Epson 420", 15000, 5));
            
            
            produitRepository.save(new Produit("Ordi HP", 90000, 40));
            produitRepository.save(new Produit("Ordi ACCER", 75000, 30));
            produitRepository.save(new Produit("Imp HP ", 100000, 15));
            produitRepository.save(new Produit("RAM HP", 95000, 28));
            produitRepository.save(new Produit("Souris HP", 20000, 30));
             produitRepository.save(new Produit("Souris EPson 342", 15000, 28));
            
            produitRepository.save(new Produit("Ordi Samsung", 50000, 10));
            produitRepository.save(new Produit("Projecteur hp", 30000, 54));
            produitRepository.save(new Produit("Imp ITEL ", 10000, 15));
            produitRepository.save(new Produit("Ram HP", 95000, 28));
            produitRepository.save(new Produit("Disque HP", 20000, 30));
             produitRepository.save(new Produit("Ordi Epson", 20000, 30));
            produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
                    
	}

}
