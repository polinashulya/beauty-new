/* insert data for ROLES */
insert into user_roles (id, name)
VALUES (1, 'ROLE_CLIENT') ON CONFLICT DO NOTHING;

insert into user_roles (id, name)
VALUES (2, 'ROLE_EMPLOYEE') ON CONFLICT DO NOTHING;

insert into user_roles (id, name)
VALUES (3, 'ROLE_ADMIN') ON CONFLICT DO NOTHING;
