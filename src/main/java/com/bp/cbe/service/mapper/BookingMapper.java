package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Booking;
import com.bp.cbe.domain.dto.BookingDto;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class, SeatMapper.class, BillboardMapper.class })
public interface BookingMapper {

	 Booking toBooking(BookingDto bookingDto);

	 BookingDto toBookingDto(Booking booking);
}
