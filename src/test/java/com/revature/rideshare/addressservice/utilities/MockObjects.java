package com.revature.rideshare.addressservice.utilities;

import com.revature.rideshare.addressservice.models.Address;

public class MockObjects {
    public static Address getAddress() {
        Address a = new Address();
        a.setId(1);
        a.setZip("27051");
        a.setState("VA");
        a.setCity("Reston");
        a.setStreet("123 Fake Street");
        return a;
    }

}
