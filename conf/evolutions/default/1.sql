# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table espaconave (
  id                        bigint auto_increment not null,
  modelo                    varchar(255),
  pais                      varchar(255),
  constraint pk_espaconave primary key (id))
;

create table missao (
  id                        bigint auto_increment not null,
  planeta_id                bigint,
  espaconave_id             bigint,
  lancamento                datetime(6),
  tripulada                 tinyint(1) default 0,
  orcamento                 float,
  constraint pk_missao primary key (id))
;

create table planeta (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  sistema                   varchar(255),
  habitavel                 tinyint(1) default 0,
  constraint pk_planeta primary key (id))
;

alter table missao add constraint fk_missao_planeta_1 foreign key (planeta_id) references planeta (id) on delete restrict on update restrict;
create index ix_missao_planeta_1 on missao (planeta_id);
alter table missao add constraint fk_missao_espaconave_2 foreign key (espaconave_id) references espaconave (id) on delete restrict on update restrict;
create index ix_missao_espaconave_2 on missao (espaconave_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table espaconave;

drop table missao;

drop table planeta;

SET FOREIGN_KEY_CHECKS=1;

