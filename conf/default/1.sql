# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table userlogin (
  id                            integer not null,
  name                          varchar(255),
  email                         VARCHAR(255),

  constraint pk_userlogin primary key (id)
);
create sequence userlogin_seq;


# --- !Downs

drop table if exists userlogin;
drop sequence if exists userlogin_seq;

