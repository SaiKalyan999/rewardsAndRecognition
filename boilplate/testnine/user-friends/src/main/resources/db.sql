create table public.users
( id bigint not null primary key,
 name varchar not null,
 email varchar not null unique,
 phone_number bigint,
 address varchar(10485760) );

alter table users add constraint valid_email CHECK (
email ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}
[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' );


create table friends(
id bigint not null primary key,
user_id bigint not null,
friend_id bigint not null,
constraint user_id_fk foreign key(user_id) references users(id),
constraint friend_id_fk foreign key(friend_id) references users(id));