package by.bookstore.service;

import by.bookstore.entity.Address;
import by.bookstore.storage.AddressStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressService {

    @Autowired
    private AddressStorage addressStorage;

    public Address save (Address address){
       return addressStorage.save(address);
    }

    public Address getById(long id){
        return addressStorage.getById(id);
    }

    public List<Address> getAll(){
        return addressStorage.getAll();
    }
}
