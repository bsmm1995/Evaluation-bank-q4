package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.entity.BookingEntity;
import com.bp.cbe.domain.dto.BookingDto;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class, SeatMapper.class, BillboardMapper.class })
public interface BookingMapper {

	 BookingEntity toBooking(BookingDto bookingDto);

	 BookingDto toBookingDto(BookingEntity booking);
}
