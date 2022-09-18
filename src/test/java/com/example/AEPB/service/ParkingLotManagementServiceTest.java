package com.example.AEPB.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ParkingLotManagementServiceTest {

    @InjectMocks
    private ParkingLotManagementService parkingLotManagementService;

    @Test
    void should_get_ticket_and_park_successfully_when_apply_for_parking_given_valid_car_and_remaining_parking_spaces_in_parking_lot() {
        // given


        // when


        // then

    }

    @Test
    void should_refuse_to_park_when_apply_for_parking_given_valid_car_and_no_space_in_parking_lot() {
        // given


        // when


        // then
    }

    @Test
    void should_refuse_to_park_when_apply_for_parking_given_invalid_car() {
        // given


        // when


        // then
    }

    @Test
    void should_get_the_car_and_ticket_become_invalid_when_apply_for_picking_up_given_valid_ticket_and_the_car_in_the_parking_lot() {
        // given


        // when


        // then
    }

    @Test
    void should_refuse_to_pick_up_when_apply_for_picking_up_given_no_ticket() {
        // given


        // when


        // then
    }

    @Test
    void should_refuse_to_pick_up_when_apply_for_picking_up_given_invalid_ticket() {
        // given


        // when


        // then
    }
}
