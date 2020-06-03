package edu.hut.service.impl;

import edu.hut.dao.ItemsDao;
import edu.hut.domain.*;
import edu.hut.service.ItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("ItemsService")
public class ItemsServiceImpl implements ItemsService {

    @Resource(name = "ItemsDao")
    private ItemsDao itemsDao;

    @Override
    public List<ItemsType> findItemsType() {
        return itemsDao.findItemsType();
    }

    @Override
    public List<Items> findItems() {
        return itemsDao.findItems();
    }

    @Override
    public int saveItems(List<MatchItems> matchItems) {
        return itemsDao.saveItems(matchItems);
    }

    @Override
    public int registerItems(List<Register> registers) {

        for(Register register:registers){
            register.setMatch_index(1);
        }
        return itemsDao.registerItems(registers);
    }

    @Override
    public List<MatchItems_info> findItemsList() {
        List<MatchItems_info> itemsList = itemsDao.findItemsList();
        return itemsList;
    }

    @Override
    public List<Items> findMatchItems() {
        return itemsDao.findMatchItems();
    }

    @Override
    public List<ItemsType> findMatchItemsType() {
        return itemsDao.findMatchItemsType();
    }
}
