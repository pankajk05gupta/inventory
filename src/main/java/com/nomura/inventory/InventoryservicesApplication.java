package com.nomura.inventory;

import com.nomura.inventory.filter.InvCORSFilter;
import com.nomura.inventory.model.Item;
import com.nomura.inventory.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InventoryservicesApplication  implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(InventoryservicesApplication.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("itemRepositoryImp")
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryservicesApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		runJDBC();
	}

	void runJDBC() {

		log.info("Creating tables for testing...");

		jdbcTemplate.execute("DROP TABLE ITEMS IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE ITEMS(" +
				"id SERIAL, brand VARCHAR(255), size INTEGER,quantity INTEGER, price NUMERIC(15, 2) ,inStock BOOLEAN)");

		List<Item>  items = Arrays.asList(
				new Item("Brand1", 1,1,new BigDecimal("46.32"),true),
				new Item("Brand2", 2,3,new BigDecimal("37.32"),true)

		);

		log.info("[SAVE]");
		items.forEach(item -> {
			log.info("Saving...{}", item.getBrand());
			itemRepository.save(item);
		});



	}


	}
