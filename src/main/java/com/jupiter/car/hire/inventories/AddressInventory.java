package com.jupiter.car.hire.inventories;

import com.jupiter.car.hire.beans.Address;

public interface AddressInventory {
    public Address getAddressById(long addressId);
    public long saveAddress(Address address);
    public void updateAddress(Address address);
}
