package com.bp.cbe.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Booking extends BaseEntity {
    @Column(nullable = false)
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "ID_CUSTUMER", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_BOOKING"))
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "ID_SEAT", nullable = false, foreignKey = @ForeignKey(name = "FK_SEAT_BOOKING"))
    private Seat seat;
    @ManyToOne
    @JoinColumn(name = "ID_BILLBOARD", nullable = false, foreignKey = @ForeignKey(name = "FK_BILLBOARD_BOOKING"))
    private Billboard billboard;
}
