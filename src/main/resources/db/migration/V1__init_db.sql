create table users
(
    user_id       serial
        primary key,
    username      text unique not null,
    password_hash text        not null
);
comment
on table users is 'Пользователи';


create table roles
(
    role_id   serial
        primary key,
    user_id   int  not null
        references users (user_id),
    role_name text not null
);
comment
on table roles is 'Роли пользователей';


create table notes
(
    note_id serial
        primary key,
    user_id int  not null
        references users (user_id),
    title   text,
    body    text not null
);
comment
on table notes is 'Заметки пользователей';
