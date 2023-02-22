package com.bp.cbe.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "BILLBOARD")
@Data
@EqualsAndHashCode(callSuper = false)
public class BillboardEntity extends BaseEntity {
    @Column(nullable = false)
    private LocalDate date;
    @Column(name = "START_TIME", nullable = false)
    private LocalTime startTime;
    @Column(name = "END_TIME", nullable = false)
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name = "ID_MOVIE", nullable = false, foreignKey = @ForeignKey(name = "FK_MOVIE_BILLBOARD"))
    private MovieEntity movie;
    @ManyToOne
    @JoinColumn(name = "ID_ROOM", nullable = false, foreignKey = @ForeignKey(name = "FK_ROOM_BILLBOARD"))
    private RoomEntity room;
}
