create table todo (
    id serial primary key,
    title varchar not null,
    is_completed boolean not null default false
);