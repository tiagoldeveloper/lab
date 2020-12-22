
use lab;

insert into men_seq(next_val)values(16);

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(1, 'registro.nao.encontrado.titulo','registro não encontrado.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(2, 'registro.nao.encontrado.msg','registro não encontrado para o código {0}. verifique o código e tente novamente.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(3, 'registro.nao.pode.ser.excluido','registro em uso, não pode ser excluido para código {0}.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(4, 'registro.em.uso.titulo','registro em uso.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(5, 'campos.invalidos.msg','um ou mais campos estão inválidos. realize o preenchimento correto e tente novamente.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(6, 'campos.invalidos.titulo','um ou mais campos estão inválidos.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(7, 'mensagem.nao.encontrada','mensagem não encontrada', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(8, 'stacktrace.nao.econtrado','stacktrace não encontrado.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(9, 'erro.nao.tratado.titulo','erro não tratado.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(10, 'erro.nao.tratado.msg','erro não tratado, verifique com responsavel.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(11, 'metodo.nao.suportado.titulo','metodo não suportado.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(12, 'metodo.nao.suportado.msg','verifique se o tipo de metodo é o correto ou se está faltando parametro e tente novamente.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(13, 'campos.valores.invalidos.titulo','dados invalidos.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(14, 'campos.valores.invalidos.msg','um ou mais campos estão com valores inválidos. verifique os valores e tente novamente.', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(15, 'campo.formato.invalido.titulo','um ou mais campos está com formato invalido', 1, '2020-11-27', 0, '0');

insert into tb_mensagem(men_id, men_chave, men_valor, ativo, data_ult_alteracao, versao, usuario_ult_alteracao)
values(16, 'campo.formato.invalido.msg','verifique o formato e valore(s) do(s) campo(s) e tente novamente.', 1, '2020-11-27', 0, '0');

insert into per_seq(next_val)values(19);

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('1', '/v1/grupo/salvar', 'salvar grupo', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('2', '/v1/grupo/atualizar', 'atualizar grupo', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('3', '/v1/grupo/buscar', 'buscar um grupo', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('4', '/v1/grupo/listar', 'listar todos  grupos', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('5', '/v1/grupo/remover', 'excluir um grupo', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('6', '/v1/permissao/listar', 'lista todas permissões', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('7', '/v1/permissao/salvar', 'salva permissão', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('8', '/v1/permissao/atualizar', 'atualiza permissão', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('9', '/v1/permissao/buscar', 'busca uma permissão', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('10', '/v1/permissao/remover', 'remove permissão', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('11', '/v1/usuario/listar', 'lista todos usuários', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('12', '/v1/usuario/buscar', 'busca um usuário pelo id', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('13', '/v1/usuario/salvar', 'salva  usuário', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('14', '/v1/usuario/atualizar', 'atualiza um usuário', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('15', '/v1/usuario/permissao', 'lista todas permissões por usuário', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('16', '/v1/grupo/permissao/listar', 'lista todas permissões por grupo', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('17', '/v1/grupo/associar/desassocia/lote', 'associa e desassocia  permissões de grupo', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('18', '/v1/usuario/grupo/listar', 'lista grupos por usuário', '1', '2020-12-10', '0', '0');

insert into  tb_permissao(per_id,per_url,per_nome,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('19', '/v1/usuario/grupo/associar/desassociar', 'associa e desassocia grupos de usuário', '1', '2020-12-10', '0', '0');

insert into gru_seq(next_val)values(2);

insert into  tb_grupo(gru_id,gru_nome,gru_descricao,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('1', 'ADMIN', 'administrador do sistema, ou seja o mesmo tem acesso total ao sistema', '1', '2020-12-10', '0', '0');

insert into  tb_grupo(gru_id,gru_nome,gru_descricao,ativo,data_ult_alteracao,versao,usuario_ult_alteracao)
values ('2', 'USUARIO', 'cadastrar, atualizar, remover, visualizar informaçao, visualizar permissões', '1', '2020-12-10', '0', '0');

insert into usu_seq(next_val)values(2);
insert into  tb_usuario(usu_id,usu_nome,usu_login,usu_senha,ativo,data_ult_alteracao,versao, usuario_ult_alteracao)
values ('1', 'administrador de sistema', 'admin', '$2a$10$8WChvGUIpcd9HP/xhCNX2O.4jn9jucY9xE8cG53tRiP3mavyaxtui', '1', '2020-12-10', '0', '0');
-- admin123

insert into  tb_usuario(usu_id,usu_nome,usu_login,usu_senha,ativo,data_ult_alteracao,versao, usuario_ult_alteracao)
values ('2', 'usuário do sistema', 'usuariox', '$2a$10$fh62H0EK3tbYAbY79yZ2R.F8V7q4XBr20I7VYJLPlS8nlWRDlvuhK', '1', '2020-12-10', '0', '0');
-- usuariox123

insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,1);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,2);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,3);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,4);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,5);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,6);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,7);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,8);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,9);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,10);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,11);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,12);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,13);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,14);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,15);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,16);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,17);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(1,18);

insert into tb_grupo_permissao(grupo_id, permissao_id) values(2,12);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(2,13);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(2,14);
insert into tb_grupo_permissao(grupo_id, permissao_id) values(2,15);

insert into tb_usuario_grupo(usuario_id, grupo_id) values(1, 1);
insert into tb_usuario_grupo(usuario_id, grupo_id) values(2, 2);
