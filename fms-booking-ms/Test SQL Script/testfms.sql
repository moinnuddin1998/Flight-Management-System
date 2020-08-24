INSERT INTO `fms_sql`.`flight`
(`flight_number`,
`carrier_name`,
`flight_model`,
`seat_capacity`)
VALUES
(123,
"indigo",
"BigJet",
60);

INSERT INTO `fms_sql`.`flight`
(`flight_number`,
`carrier_name`,
`flight_model`,
`seat_capacity`)
VALUES
(124,
"Air India",
"BigJet",
60);

INSERT INTO `fms_sql`.`airport`
(`airport_code`,
`airport_location`,
`airport_name`)
VALUES
("DLI",
"Delhi",
"IGI");

INSERT INTO `fms_sql`.`airport`
(`airport_code`,
`airport_location`,
`airport_name`)
VALUES
("MUM",
"Mumbai",
"MIA");
INSERT INTO `fms_sql`.`schedule`
(`schedule_id`,
`arrival_date_time`,
`departure_date_time`,
`destination_airport_airport_code`,
`source_airport_airport_code`)
VALUES
(1234,
"2020-05-07 05:45",
"2020-05-07 06:50",
"DLI",
"MUM");

INSERT INTO `fms_sql`.`schedule_flight`
(`schedule_flight_id`,
`available_seats`,
`schedule_flight_state`,
`ticket_cost`,
`flight_flight_number`,
`schedule_schedule_id`)
VALUES
(123456,
60,
true,
5000.00,
123,
1234);


