package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Customer;
import com.bp.cbe.service.dto.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	public Customer toBooking(CustomerDto customerDto);

	public CustomerDto toBookingDto(Customer customer);

}
