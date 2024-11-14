--changeset pnowacki:1
insert into role (id, name)
values (1,'ROLE_ADMIN'),
       (2,'ROLE_CLIENT');

--changeset pnowacki:2
insert into permission (id, name)
values (1,'CREATE_TRAINING'),
(2,'DELETE_TRAINING');

--changeset pnowacki:3
insert into roles_permissions (role_id, permission_id)
values (1,1),
       (1,2),
       (2,1);
