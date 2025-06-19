--liquibase formatted sql

--changeset pnowacki:create_user
create table ggym_user
(
    id       bigserial primary key,
    name     varchar        not null,
    email    varchar unique not null,
    password varchar        not null,
    created  timestamp      not null default current_timestamp,
    modified timestamp      not null default current_timestamp
);