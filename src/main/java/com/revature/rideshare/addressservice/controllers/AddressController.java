package com.revature.rideshare.addressservice.controllers;

import com.revature.rideshare.addressservice.models.Address;
import com.revature.rideshare.addressservice.models.AddressDTO;
import com.revature.rideshare.addressservice.services.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin
@Api(tags = {"Address"})
public class AddressController {
	private AddressService addressService;

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@ApiOperation(value = "Return all addresses", tags = {"Address"})
	@GetMapping
	public ResponseEntity<List<AddressDTO>> getAddresses() {
		List<AddressDTO> dtos = addressService.findAllDTO();
		if (dtos.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(dtos);
	}

	@ApiOperation(value = "Add a new address", tags = {"Address"})
	@PostMapping
	public ResponseEntity<AddressDTO> addAddress(@Valid @RequestBody AddressDTO addressDTO) {
		Optional<Address> foundAddress = addressService.getAddressById(addressDTO.getId());
		if (foundAddress.isPresent()) return ResponseEntity.status(HttpStatus.CONFLICT).build();
		Address address = addressService.addAddress(new Address(addressDTO));
		if (address == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(new AddressDTO(address));
	}
}
