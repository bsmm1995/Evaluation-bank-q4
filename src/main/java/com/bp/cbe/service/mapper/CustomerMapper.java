package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.entity.CustomerEntity;
import com.bp.cbe.domain.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toBooking(CustomerDto customerDto);

    CustomerDto toBookingDto(CustomerEntity customer);
}
