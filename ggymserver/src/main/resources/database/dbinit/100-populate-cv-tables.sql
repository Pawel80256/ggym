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

--changeset pnowacki:populate_exercise_types
insert into exercise_type (id, name, description)
values (1, 'MULTI_JOINT', 'MULTI_JOINT');

--changeset pnowacki:populate_exercises
insert into exercise (id, name, description, exercise_type_id, intensity)
values (1,'BENCH_PRESS', 'Bench press',1,7);

