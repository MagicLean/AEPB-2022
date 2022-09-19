package com.example.AEPB.service;

import com.example.AEPB.entity.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        String ticketId = UUID.randomUUID().toString();
        String carId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, carId, true);
        ParkingLotManagementService.parkingLot.setRemainingSpaceCount(99);
        ParkingLotManagementService.carIdToTicketMap.put(carId, ticket);

        // when
        Ticket resultTicket = parkingLotManagementService.pickUpCar(ticket);

        // then
        assertFalse(resultTicket.getEnabled());
        assertEquals(100, ParkingLotManagementService.parkingLot.getRemainingSpaceCount());
    }

    @Test
    void should_refuse_to_pick_up_when_apply_for_picking_up_given_no_ticket() {
        // given
        Ticket ticket = null;

        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLotManagementService.pickUpCar(ticket));

        // then
        assertEquals("没有车票", result.getMessage());
    }

    @Test
    void should_refuse_to_pick_up_when_apply_for_picking_up_given_invalid_ticket() {
        // given
        String ticketId = UUID.randomUUID().toString();
        String carId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, null, true);
        ParkingLotManagementService.parkingLot.setRemainingSpaceCount(99);
        ParkingLotManagementService.carIdToTicketMap.put(carId, ticket);

        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLotManagementService.pickUpCar(ticket));

        // then
       assertEquals("车票无效——伪造车票", result.getMessage());
    }

    @Test
    void should_refuse_to_pick_up_when_apply_for_picking_up_given_expired_ticket() {
        // given
        String ticketId = UUID.randomUUID().toString();
        String carId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, carId, false);
        ParkingLotManagementService.parkingLot.setRemainingSpaceCount(99);
        ParkingLotManagementService.carIdToTicketMap.put(carId, ticket);

        // when
        RuntimeException result = assertThrows(RuntimeException.class, () -> parkingLotManagementService.pickUpCar(ticket));

        // then
       assertEquals("车票无效——过期车票", result.getMessage());
    }
}
