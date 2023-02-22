package com.bp.cbe.domain.entity;

import com.bp.cbe.domain.enums.MovieGenreEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Movie extends BaseEntity {
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 30, nullable = false)
    private MovieGenreEnum genre;
    @Column(name = "ALLOWED_AGE", nullable = false)
    private Short allowedAge;
    @Column(name = "LENGTH_MINUTES", nullable = false)
    private Short lengthMinutes;
}
