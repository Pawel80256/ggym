--changeset pnowacki:populate_roles
insert into role (id, name)
values (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

--changeset pnowacki:populate_permisions
insert into permission (id, name)
values (1, 'MANAGE_TRAINING'),
       (2, 'MANAGE_TRAINING_PLAN');

--changeset pnowacki:assign_permissions
insert into roles_permissions (role_id, permission_id)
values (1, 1),
       (2, 1),
       (1, 2),
       (2, 2);

