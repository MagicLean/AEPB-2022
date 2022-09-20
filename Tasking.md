Tasking

Task1 停车-有车位

Given 小车，停车场有车位

When 申请停车

Then 获得车票，停车成功

should_get_ticket_when_parking_car_given_valid_car_and_remaining_parking_spaces_in_parking_lot



task2 停车-无车位

given 小车，停车场无车位

when 申请停车

then 提示没有剩余车位，停车失败

should_throw_exception_when_parking_car_given_valid_car_and_no_space_in_parking_lot





Task3 停车-没有车辆

Given 没有车辆

When 申请停车

Then 提示没有车辆，停车失败

should_throw_exception_when_parking_car_given_no_car





Task4 取车-有车票

Given 有车票，停车场有对应车辆

When 申请取车

Then 获得小车，取车成功

should_get_the_car_when_pick_up_car_given_valid_ticket_and_the_car_in_the_parking_lot



Task5 取车-无车票

given 无车票

When 申请取车

Then 提示没有车票，取车失败

should_throw_exception_when_pick_up_car_given_no_ticket



Task6 取车-无效车票

Given 有车票，但车票对应的车不在停车场

When 申请取车

Then 提示没有对应车辆，取车失败

should_throw_exception_when_pick_up_car_given_invalid_ticket_and_the_car_not_in_the_parking_lot
