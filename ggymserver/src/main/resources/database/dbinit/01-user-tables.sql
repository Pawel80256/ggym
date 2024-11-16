--liquibase formatted sql

--changeset pnowacki:create_user
create table ggym_user
(
    id       bigserial primary key,
    name     varchar        not null,
    email    varchar unique not null,
    password varchar        not null,
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

--changeset pnowacki:create_role
create table role
(
    id   bigserial primary key,
    name varchar unique not null,
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

--changeset pnowacki:create_permission
create table permission
(
    id   bigserial primary key,
    name varchar unique not null,
    created     timestamp      not null default current_timestamp,
    modified    timestamp      not null default current_timestamp
);

--changeset pnowacki:role_permissions
create table roles_permissions
(
    role_id       bigint references role,
    permission_id bigint references permission
);

--changeset pnowacki:user_roles
create table users_roles
(
    user_id bigint references ggym_user,
    role_id bigint references role
);
