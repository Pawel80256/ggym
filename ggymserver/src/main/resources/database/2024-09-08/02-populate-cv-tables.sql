--liquibase formatted sql

--changeset pnowacki:1
insert into cv_muscle_part (value)
values ('CALF'),
       ('QUAD'),
       ('HAMSTRING'),
       ('GLUTES'),
       ('ABS'),
       ('BACK_EXTENSORS'),
       ('LATS'),
       ('CHEST'),
       ('FRONT_DELT'),
       ('SIDE_DELT'),
       ('REAR_DELT'),
       ('BICEPS'),
       ('TRICEPS'),
       ('FOREARM');

--changeset pnowacki:2
insert into cv_resistance_tool (value)
values ('DUMBBELL'),
       ('BARBELL'),
       ('DOUBLE_BARBELLS'),
       ('RESISTANCE_BAND'),
       ('WEIGHT_BELT'),
       ('NONE');