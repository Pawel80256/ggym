--liquibase formatted sql
--todo: add unique constraints
--changeset pnowacki:1
create table muscle_part
(
    id    bigserial primary key,
    value varchar not null
);

--changeset pnowacki:2
create table exercise
(
    id        bigserial primary key,
    type      varchar not null,
    intensity integer NOT NULL CHECK (intensity >= 1 AND intensity <= 10)
);

--changeset pnowacki:3
create table exercises_muscle_parts
(
    exercise_id            bigint references exercise    not null,
    muscle_part_id         bigint references muscle_part not null,
    muscle_part_engagement integer                       NOT NULL CHECK (muscle_part_engagement >= 1 AND muscle_part_engagement <= 10)
);

--changeset pnowacki:4
create table resistance_tool
(
    id    bigserial primary key,
    value varchar not null
);

--changeset pnowacki:5
create table load
(
    id                 bigserial primary key,
    resistance_tool_id bigint references resistance_tool not null,
    weight             numeric,
    comment            varchar
);

--changeset pnowacki:6
create table training
(
    id         bigserial primary key,
    start_time timestamp not null,
    end_time   timestamp not null,
    comment    varchar
    -- user_id
);

--changeset pnowacki:7
create table exercise_instance
(
    id          bigserial primary key,
    exercise_id bigint references exercise not null ,
    training_id bigint references training not null
);

--changeset pnowacki:8
create table exercise_set
(
    id                   bigserial primary key,
    repetitions          integer                             not null,
    exercise_instance_id bigint references exercise_instance not null,
    load_id              bigint references load,
    effort               integer                             NOT NULL CHECK (effort >= 1 AND effort <= 10)
);
