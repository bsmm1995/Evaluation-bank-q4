package com.bp.cbe.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Seat extends BaseEntity {
    @Column(nullable = false)
    private Short number;
    @Column(name = "ROW_NUMBER", nullable = false)
    private Short rowNumber;
    @ManyToOne
    @JoinColumn(name = "ID_ROOM", nullable = false, foreignKey = @ForeignKey(name = "FK_ROOM_SEAT"))
    private Room room;
}
