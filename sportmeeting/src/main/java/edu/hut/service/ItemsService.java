package edu.hut.service;

import edu.hut.domain.*;

import java.util.List;

public interface ItemsService {

    public List<ItemsType> findItemsType();

    public List<Items> findItems();

    int saveItems(List<MatchItems> matchItems);

    int registerItems(List<Register> registers);

    List<MatchItems_info> findItemsList();

    List<Items> findMatchItems();

    List<ItemsType> findMatchItemsType();
}
