package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.Customer;
import com.bp.cbe.domain.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toBooking(CustomerDto customerDto);

    CustomerDto toBookingDto(Customer customer);
}
