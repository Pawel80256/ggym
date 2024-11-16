--liquibase formatted sql

--changeset pnowacki:populate_muscle_parts
insert into muscle_part (name)
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

--changeset pnowacki:populate_resistance_tools
insert into resistance_tool (name)
values ('DUMBBELL'),
       ('BARBELL'),
       ('DOUBLE_DUMBBELLS'),
       ('RESISTANCE_BAND'),
       ('WEIGHT_BELT'),
       ('NONE');