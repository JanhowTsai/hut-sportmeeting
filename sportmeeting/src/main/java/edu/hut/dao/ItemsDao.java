package edu.hut.dao;

import edu.hut.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ItemsDao")
public interface ItemsDao {

    List<ItemsType> findItemsType();

    List<Items> findItems();

    int saveItems(List<MatchItems> matchItems);

    int registerItems(List<Register> registers);

    List<MatchItems_info> findItemsList();

    List<Items> findMatchItems();

    List<ItemsType> findMatchItemsType();
}
