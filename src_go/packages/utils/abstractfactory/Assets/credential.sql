drop table if exists credentials

create table credentials (
  id serial primary key,
  passwd text not null,
  username text not null
);



