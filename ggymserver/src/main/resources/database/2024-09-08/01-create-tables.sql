--liquibase formatted sql

--changeset pnowacki:10
create table ggym_user
(
    id    bigserial primary key,
    name  varchar        not null,
    email varchar unique not null
);

--changeset pnowacki:11
create table role
(
    id   bigserial primary key,
    name varchar unique not null
);

--changeset pnowacki:12
create table users_roles
(
    user_id bigint references ggym_user,
    role_id bigint references role
);

--changeset pnowacki:20
create table muscle_part
(
    id   bigserial primary key,
    name varchar unique not null
);

--changeset pnowacki:30
create table exercise
(
    id        bigserial primary key,
    type      varchar        not null,
    name      varchar unique not null,
    intensity integer        NOT NULL CHECK (intensity >= 1 AND intensity <= 10)
);

--changeset pnowacki:40
create table exercises_muscle_parts
(
    exercise_id            bigint references exercise    not null,
    muscle_part_id         bigint references muscle_part not null,
    muscle_part_engagement integer                       NOT NULL CHECK (muscle_part_engagement >= 1 AND muscle_part_engagement <= 10)
);

--changeset pnowacki:50
create table resistance_tool
(
    id   bigserial primary key,
    name varchar unique not null
);

--changeset pnowacki:60
create table training
(
    id         bigserial primary key,
    user_id    bigint    not null references ggym_user,
    start_time timestamp not null,
    end_time   timestamp,
    comment    varchar,
    created    timestamp not null default current_timestamp
);

--changeset pnowacki:70
create table exercise_instance
(
    id          bigserial primary key,
    exercise_id bigint references exercise not null,
    training_id bigint references training not null
);

--changeset pnowacki:80
create table exercise_set
(
    id                   bigserial primary key,
    exercise_instance_id bigint references exercise_instance not null,
    resistance_tool_id   bigint references resistance_tool   not null,
    weight               numeric,
    repetitions          integer                             not null,
    comment              varchar,
    effort               integer                             NOT NULL CHECK (effort >= 1 AND effort <= 10)
);

