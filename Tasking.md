Tasking

## v1
Task1 停车-有车位

Given 小车，停车场有车位

When 申请停车

Then 获得车票，停车成功

should_get_ticket_and_park_successfully_when_apply_for_parking_given_valid_car_and_remaining_parking_spaces_in_parking_lot



task2 停车-无车位

given 小车，停车场无车位

when 申请停车

then 拒绝停车，停车失败

should_refuse_to_park_when_apply_for_parking_given_valid_car_and_no_space_in_parking_lot





Task3 停车-不符合停车场规则的车辆（暂停）

Given 不符合停车场规则的车辆

When 申请停车

Then 拒绝停车，停车失败

should_refuse_to_park_when_apply_for_parking_given_invalid_car





Task4 取车-有车票

Given 有车票，停车场有对应车辆

When 申请取车

Then 获得小车，取车成功，车票失效

should_get_the_car_and_ticket_become_invalid_when_apply_for_picking_up_given_valid_ticket_and_the_car_in_the_parking_lot



Task5 取车-无车票

given 无车票

When 申请取车

Then 拒绝取车，取车失败

should_refuse_to_pick_up_when_apply_for_picking_up_given_no_ticket



Task6 取车-无效车票（伪造车票、过期车票）

Given 有无效车票

When 申请取车

Then 提示车票错误，取车失败

should_refuse_to_pick_up_when_apply_for_picking_up_given_invalid_ticket

## v2
作为一个初入职场的停车小弟
顺序停放多个停车场
可以取出

Tasking1 - 小弟顺序停车
given 小车，停车场1有位置
when 小弟去停车
then 车辆停入停车场1，获得车票

Tasking2 - 小弟顺序停车
given  小车，停车场1停满，停车场2有位置
when 小弟去停车
then 车辆停入停车场2，获得车票


Tasking3 - 小弟顺序停车
given  小车，停车场1停满，停车场2停满
when 小弟去停车
then 提示没有剩余车位，停车失败

Tasking4 - 小弟取车
Given  有车票，停车场1有对应车辆
When 小弟去取车
Then 获得小车

Tasking5 - 小弟取车
Given  有车票，停车场1没有对应车辆，停车场2也没有对应车辆
When 小弟去取车
Then 提示没有车辆，取车失败
