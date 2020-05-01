package com.revature.rideshare.addressservice.services.impl;

import com.revature.rideshare.addressservice.models.Address;
import com.revature.rideshare.addressservice.models.AddressDTO;
import com.revature.rideshare.addressservice.repository.AddressRepository;
import com.revature.rideshare.addressservice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
	private AddressRepository repository;

	@Autowired
	public void setRepository(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Address> findAll() {
		return this.repository.findAll();
	}

	@Override
	public List<AddressDTO> findAllDTO() {
		List<Address> addresses = this.findAll();
		List<AddressDTO> dtos = new ArrayList<>();
		for (Address address : addresses) {
			dtos.add(new AddressDTO(address));
		}
		return dtos;
	}

	@Override
	public Address addAddress(Address address) {
		return this.repository.save(address);
	}

	@Override
	public Optional<Address> getAddressById(int id) {
		return this.repository.findById(id);
	}

	@Override
	public Address updateAddress(Address address) {
		return this.repository.save(address);
	}

	@Override
	public void deleteAddressById(int id) {
		this.repository.deleteById(id);
	}

}
