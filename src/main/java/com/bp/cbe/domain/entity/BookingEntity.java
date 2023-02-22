package com.bp.cbe.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "BOOKING")
@Data
@EqualsAndHashCode(callSuper = false)
public class BookingEntity extends BaseEntity {
    @Column(nullable = false)
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "ID_CUSTUMER", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_BOOKING"))
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name = "ID_SEAT", nullable = false, foreignKey = @ForeignKey(name = "FK_SEAT_BOOKING"))
    private SeatEntity seat;
    @ManyToOne
    @JoinColumn(name = "ID_BILLBOARD", nullable = false, foreignKey = @ForeignKey(name = "FK_BILLBOARD_BOOKING"))
    private BillboardEntity billboard;
}
