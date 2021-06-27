package by.bookstore.storage;

import by.bookstore.entity.Store;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryStoreStorage implements StoreStorage{

    private List<Store> stores = new ArrayList<>();
    private long incId;

    private Store incId(Store store){
        store.setId(incId++);
        return store;
    }

    @Override
    public Store save(Store store) {
        Store store1 = incId(store);
        stores.add(store1);
        return store1;
    }
}
