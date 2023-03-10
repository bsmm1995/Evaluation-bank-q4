package com.bp.cbe.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "ROOM")
@Data
@EqualsAndHashCode(callSuper = false)
public class RoomEntity extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private Short number;
}
