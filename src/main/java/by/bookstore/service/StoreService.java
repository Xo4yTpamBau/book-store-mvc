package by.bookstore.service;

import by.bookstore.entity.Store;
import by.bookstore.storage.InMemoryStoreStorage;
import by.bookstore.storage.StoreStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreService {

    @Autowired
    private InMemoryStoreStorage inMemoryStoreStorage;

    public Store save(Store store){
        return inMemoryStoreStorage.save(store);
    }
}
