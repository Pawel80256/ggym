--changeset pnowacki:10
create table muscle_part
(
    id          bigserial primary key,
    name        varchar unique not null,
    description varchar,
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

--changeset pnowacki:20
create table exercise_type
(
    id          bigserial primary key,
    name        varchar   not null,
    description varchar,
    created     timestamp not null default current_timestamp,
    modified    timestamp not null default current_timestamp
);

--changeset pnowacki:30
create table exercise
(
    id          bigserial primary key,
    name        varchar unique not null,
    description varchar,
    intensity   integer        NOT NULL CHECK (intensity >= 1 AND intensity <= 10),
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

--changeset pnowacki:40
create table exercises_types
(
    exercise_id      bigserial references exercise,
    exercise_type_id bigserial references exercise_type
);

--changeset pnowacki:50
create table exercises_muscle_parts
(
    exercise_id            bigint references exercise    not null,
    muscle_part_id         bigint references muscle_part not null,
    muscle_part_engagement integer                       not null check (muscle_part_engagement >= 1 AND muscle_part_engagement <= 10),
    primary key (exercise_id, muscle_part_id)
);

--changeset pnowacki:60
create table resistance_tool
(
    id          bigserial primary key,
    name        varchar unique not null,
    description varchar,
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

-- --changeset pnowacki:70
-- create table training_plan
-- (
--     id       bigserial primary key,
--     name     varchar                        not null,
--     owner    bigserial references ggym_user not null,
--     created  timestamp                      not null default current_timestamp,
--     modified timestamp                      not null default current_timestamp
-- );

--changeset pnowacki:80
create table training
(
    id               bigserial primary key,
--     training_plan_id bigserial references training_plan,
    user_id          bigint    not null references ggym_user,
    start_time       timestamp not null,
    end_time         timestamp,
    comment          varchar,
    created          timestamp not null default current_timestamp,
    modified         timestamp not null default current_timestamp
);

--changeset pnowacki:90
create table training_exercise
(
    id          bigserial primary key,
    exercise_id bigint references exercise not null,
    training_id bigint references training not null,
    sets        int                        not null,
    created     timestamp                  not null default current_timestamp,
    modified    timestamp                  not null default current_timestamp
);

-- --changeset pnowacki:100
-- create table exercise_set
-- (
--     id                   bigserial primary key,
--     exercise_instance_id bigint references exercise_instance not null,
--     resistance_tool_id   bigint references resistance_tool   not null,
--     weight               numeric,
--     repetitions          integer,
--     comment              varchar,
--     effort               integer                             NOT NULL CHECK (effort >= 1 AND effort <= 10),
--     created              timestamp                           not null default current_timestamp,
--     modified             timestamp                           not null default current_timestamp
-- );
