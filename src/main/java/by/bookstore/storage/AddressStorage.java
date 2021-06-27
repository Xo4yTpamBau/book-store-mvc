package by.bookstore.storage;

import by.bookstore.entity.Address;

import java.util.List;

public interface AddressStorage {

     Address save (Address address);

     Address getById(long id);

     List<Address> getAll();
}
