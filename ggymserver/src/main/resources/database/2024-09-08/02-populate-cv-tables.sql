--liquibase formatted sql

--changeset pnowacki:1
insert into cv_muscle_part (value)
values ('CHEST'),
       ('BICEPS');

--changeset pnowacki:2
insert into cv_resistance_tool (value)
values ('DUMBBELL'),
       ('BARBELL');