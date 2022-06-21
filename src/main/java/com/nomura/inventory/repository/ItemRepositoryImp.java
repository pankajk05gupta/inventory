package com.nomura.inventory.repository;

import com.nomura.inventory.model.Item;
import com.nomura.inventory.services.InvServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImp implements  ItemRepository{

    private static final Logger log = LoggerFactory.getLogger(ItemRepositoryImp.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from Items", Integer.class);
    }

    @Override
    public int save(Item item) {
        return jdbcTemplate.update(
                "insert into ITEMS (brand,size,quantity,price,inStock) values(?,?,?,?,?)",
                item.getBrand(),item.getSize(),item.getQuantity(),item.getPrice(),item.isInStock());
    }


   @Override
    public List<Item> getAllItem() {
        return jdbcTemplate.query(
                "select * from Items order by id desc",
                (rs, rowNum) ->
                        new Item(
                                rs.getLong("id"),
                                rs.getString("brand"),
                                rs.getInt("size"),
                                rs.getInt("quantity"),
                                rs.getBigDecimal("price"),
                                rs.getBoolean("inStock")
                        )
        );
    }



}
