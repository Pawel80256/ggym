--liquibase formatted sql

--changeset pnowacki:1
create table cv_muscle_part
(
    id    bigserial primary key,
    value varchar(20) not null
);

--changeset pnowacki:2
create table cv_resistance_tool
(
    id    bigserial primary key,
    value varchar(20) not null
)

