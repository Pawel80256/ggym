--changeset pnowacki:create_muscle_part
create table muscle_part
(
    id          bigserial primary key,
    name        varchar unique not null,
    description varchar,
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

--changeset pnowacki:create_exercise_type
create table exercise_type
(
    id          bigserial primary key,
    name        varchar   not null,
    description varchar,
    created     timestamp not null default current_timestamp,
    modified    timestamp not null default current_timestamp
);

--changeset pnowacki:create_exercise
create table exercise
(
    id               bigserial primary key,
    name             varchar unique                  not null,
    description      varchar,
    intensity        integer                         NOT NULL CHECK (intensity >= 1 AND intensity <= 10),
    created          timestamp                       not null default current_timestamp,
    modified         timestamp                       not null default current_timestamp
);

--changeset pnowacki:create_exercises_types
create table exercises_types
(
    exercise_id bigserial references exercise,
    exercise_type_id bigserial references exercise_type
);

--changeset pnowacki:create_exercises_muscle_parts
create table exercises_muscle_parts
(
    exercise_id            bigint references exercise    not null,
    muscle_part_id         bigint references muscle_part not null,
    muscle_part_engagement integer                       NOT NULL CHECK (muscle_part_engagement >= 1 AND muscle_part_engagement <= 10),
    primary key (exercise_id, muscle_part_id)
);

--changeset pnowacki:create_resistance_tool
create table resistance_tool
(
    id          bigserial primary key,
    name        varchar unique not null,
    description varchar,
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

--changeset pnowacki:create_training_plan
create table training_plan
(
    id       bigserial primary key,
    name     varchar                        not null,
    owner    bigserial references ggym_user not null,
    created  timestamp                      not null default current_timestamp,
    modified timestamp                      not null default current_timestamp
);

--changeset pnowacki:create_training
create table training
(
    id               bigserial primary key,
    training_plan_id bigserial references training_plan,
    user_id          bigint    not null references ggym_user,
    start_time       timestamp not null,
    end_time         timestamp,
    comment          varchar,
    created          timestamp not null default current_timestamp,
    modified         timestamp not null default current_timestamp
);

--changeset pnowacki:create_exercise_instance
create table exercise_instance
(
    id          bigserial primary key,
    exercise_id bigint references exercise not null,
    training_id bigint references training not null,
    created     timestamp                  not null default current_timestamp,
    modified    timestamp                  not null default current_timestamp
);

--changeset pnowacki:create_exercise_set
create table exercise_set
(
    id                   bigserial primary key,
    exercise_instance_id bigint references exercise_instance not null,
    resistance_tool_id   bigint references resistance_tool   not null,
    weight               numeric,
    repetitions          integer,
    comment              varchar,
    effort               integer                             NOT NULL CHECK (effort >= 1 AND effort <= 10),
    created              timestamp                           not null default current_timestamp,
    modified             timestamp                           not null default current_timestamp
);
