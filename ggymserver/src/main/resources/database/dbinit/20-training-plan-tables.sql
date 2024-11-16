--liquibase formatted sql

--changeset pnowacki:create_training_plan_week
create table planned_training_week
(
    id               bigserial primary key,
    training_plan_id bigint references training_plan not null,
    sequence            integer                         not null,
    created          timestamp                       not null default current_timestamp,
    modified         timestamp                       not null default current_timestamp
);

--changeset pnowacki:create_training_day
create table planned_training_day
(
    id                       bigserial primary key,
    name                     varchar,
    day_of_the_week          integer                                 not null check ( day_of_the_week >= 1 and day_of_the_week <= 7 ),
    planned_training_week_id bigint references planned_training_week not null,
    notes                    varchar,
    created                  timestamp                               not null default current_timestamp,
    modified                 timestamp                               not null default current_timestamp
);

--changeset pnowacki:create_planned_training
create table planned_training
(
    id                      bigserial primary key,
    name                    varchar,
    description             varchar,
    planned_training_day_id bigint references planned_training_day not null,
    sequence                   integer,
    created                 timestamp                              not null default current_timestamp,
    modified                timestamp                              not null default current_timestamp
);

--changeset pnowacki:create_planned_exercise
create table planned_exercise
(
    id                  bigserial primary key,
    exercise_id         bigint references exercise         not null,
    planned_training_id bigint references planned_training not null,
    sets_count          integer, --for 1st ver. supports only the same number of reps in each set
    reps_count          integer,
    duration            integer, --in seconds
    sequence               integer,
    created             timestamp                          not null default current_timestamp,
    modified            timestamp                          not null default current_timestamp
);