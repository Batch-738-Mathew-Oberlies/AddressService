package com.revature.rideshare.addressservice.services;

import com.revature.rideshare.addressservice.models.Address;
import com.revature.rideshare.addressservice.models.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
	List<Address> findAll();

	List<AddressDTO> findAllDTO();

	Address addAddress(Address address);

	Optional<Address> getAddressById(int id);

	Address updateAddress(Address address);

	void deleteAddressById(int id);
}
