package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Booking;
import com.bp.cbe.service.dto.BookingDto;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class, SeatMapper.class, BillboardMapper.class })
public interface BookingMapper {

	public Booking toBooking(BookingDto bookingDto);

	public BookingDto toBookingDto(Booking booking);

}
