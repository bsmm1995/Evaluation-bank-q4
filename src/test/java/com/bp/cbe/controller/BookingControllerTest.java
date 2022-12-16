package com.bp.cbe.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
class BookingControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByGenreAndDates() {
    }
}