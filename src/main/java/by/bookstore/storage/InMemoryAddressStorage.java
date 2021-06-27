package by.bookstore.storage;

import by.bookstore.entity.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryAddressStorage implements AddressStorage {

    private List<Address> addresses = new ArrayList<>();
    private static long incId;


    private Address incId(Address address){
        address.setId(incId++);
        return address;
    }

    public Address save(Address address){
        Address address1 = incId(address);
        addresses.add(address1);
        return address1;
    }

    @Override
    public Address getById(long id) {
        for (Address address : addresses) {
            if (address.getId() == id) {
                return address;
            }
        }
        return null;
    }

    @Override
    public List<Address> getAll() {
        return new ArrayList<>(addresses);
    }
}
