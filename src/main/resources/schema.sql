-- Scripts para mysql, caso queira rodar em oracle/sqlserver deve verificar na documentação dos mesmos.


drop database if exists lab;

create database lab character set latin1 collate latin1_general_cs;

use lab;

create table gru_seq(next_val bigint(20) default null);
create table per_seq (next_val bigint(20) default null);
create table usu_seq (next_val bigint(20) default null);
create table men_seq (next_val bigint(20) default null);

create table tb_permissao (
  per_id bigint(20) not null primary key,
  per_url varchar(100),
  per_nome varchar(100),
  ativo int(11) default null,
  data_ult_alteracao date default null,
  versao int(11) default null,
  usuario_ult_alteracao varchar(70) null
);

create table tb_grupo (
  gru_id bigint(20) not null primary key,
  gru_descricao varchar(100),
  gru_nome varchar(100),
  ativo int(11) default null,
  data_ult_alteracao date default null,
  versao int(11) default null,
  usuario_ult_alteracao varchar(70) null
);

create table tb_usuario (
  usu_id bigint(20) not null primary key,
  usu_nome varchar(70),
  usu_login varchar(70),
  usu_senha varchar(200),
  ativo int(11) default null,
  data_ult_alteracao date default null,
  versao int(11) default null,
  usuario_ult_alteracao varchar(70) null
);

create table tb_mensagem (
  men_id bigint(20) not null primary key,
  men_chave varchar(100),
  men_valor varchar(255),
  ativo int(11) default null,
  data_ult_alteracao date default null,
  versao int(11) default null,
  usuario_ult_alteracao varchar(70) null
);

create table tb_usuario_grupo (
  usuario_id bigint(20) not null,
  grupo_id bigint(20) not null,
  primary key (usuario_id, grupo_id),
  key index_grupo (grupo_id),
  constraint fk_usuario foreign key (usuario_id) references tb_usuario (usu_id) on delete no action on update no action,
  constraint fk_grupo foreign key (grupo_id) references tb_grupo (gru_id) on delete no action on update no action
);

create table tb_grupo_permissao (
  grupo_id bigint(20) not null,
  permissao_id bigint(20) not null,
  primary key (grupo_id,permissao_id),
  key index_permissao_id (permissao_id),
  constraint fk_grupo_per foreign key (grupo_id) references tb_grupo (gru_id) on delete no action on update no action,
  constraint fk_permissao foreign key (permissao_id) references tb_permissao (per_id) on delete no action on update no action
);


