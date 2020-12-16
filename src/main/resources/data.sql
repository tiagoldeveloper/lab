USE LAB;

INSERT INTO MEN_SEQ(NEXT_VAL)VALUES(16);

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(1, 'registro.nao.encontrado.titulo','Registro não encontrado.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(2, 'registro.nao.encontrado.msg','Registro não encontrado para o código {0}. Verifique o código e tente novamente.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(3, 'registro.nao.pode.ser.excluido','Registro em uso, não pode ser excluido para código {0}.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(4, 'registro.em.uso.titulo','Registro em uso.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(5, 'campos.invalidos.msg','Um ou mais campos estão inválidos. Realize o preenchimento correto e tente novamente.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(6, 'campos.invalidos.titulo','Um ou mais campos estão inválidos.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(7, 'mensagem.nao.encontrada','Mensagem não encontrada', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(8, 'stacktrace.nao.econtrado','Stacktrace não encontrado.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(9, 'erro.nao.tratado.titulo','Erro não tratado.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(10, 'erro.nao.tratado.msg','Erro não tratado, verifique com responsavel.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(11, 'metodo.nao.suportado.titulo','Metodo não suportado.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(12, 'metodo.nao.suportado.msg','Verifique se o tipo de metodo é o correto ou se está faltando parametro e tente novamente.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(13, 'campos.valores.invalidos.titulo','Dados invalidos.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(14, 'campos.valores.invalidos.msg','Um ou mais campos estão com valores inválidos. Verifique os valores e tente novamente.', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(15, 'campo.formato.invalido.titulo','Um ou mais campos está com formato invalido', 1, '2020-11-27', 0, '0');

INSERT INTO TB_MENSAGEM(MEN_ID, MEN_CHAVE, MEN_VALOR, ATIVO, DATA_ULT_ALTERACAO, VERSAO, USUARIO_ULT_ALTERACAO)
VALUES(16, 'campo.formato.invalido.msg','Verifique o formato e valore(s) do(s) campo(s) e tente novamente.', 1, '2020-11-27', 0, '0');

INSERT INTO PER_SEQ(NEXT_VAL)VALUES(19);

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('1', '/v1/grupo/salvar', 'Salvar grupo', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('2', '/v1/grupo/atualizar', 'Atualizar grupo', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('3', '/v1/grupo/buscar', 'Buscar um grupo', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('4', '/v1/grupo/listar', 'Listar todos  grupos', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('5', '/v1/grupo/remover', 'Excluir um grupo', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('6', '/v1/permissao/listar', 'Lista todas permissões', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('7', '/v1/permissao/salvar', 'Salva permissão', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('8', '/v1/permissao/atualizar', 'Atualiza permissão', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('9', '/v1/permissao/buscar', 'Busca uma permissão', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('10', '/v1/permissao/remover', 'Remove permissão', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('11', '/v1/usuario/listar', 'Lista todos usuários', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('12', '/v1/usuario/buscar', 'Busca um usuário pelo id', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('13', '/v1/usuario/salvar', 'Salva  usuário', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('14', '/v1/usuario/atualizar', 'Atualiza um usuário', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('15', '/v1/usuario/permissao', 'Lista todas permissões por usuário', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('16', '/v1/grupo/permissao/listar', 'Lista todas permissões por grupo', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('17', '/v1/grupo/associar/desassocia/lote', 'Associa e Desassocia  permissões de grupo', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('18', '/v1/usuario/grupo/listar', 'Lista grupos por usuário', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_PERMISSAO(PER_ID,PER_URL,PER_NOME,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('19', '/v1/usuario/grupo/associar/desassociar', 'Associa e Desassocia grupos de usuário', '1', '2020-12-10', '0', '0');

INSERT INTO GRU_SEQ(NEXT_VAL)VALUES(2);

INSERT INTO  TB_GRUPO(GRU_ID,GRU_NOME,GRU_DESCRICAO,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('1', 'ADMIN', 'Administrador do sistema, ou seja o mesmo tem acesso total ao sistema', '1', '2020-12-10', '0', '0');

INSERT INTO  TB_GRUPO(GRU_ID,GRU_NOME,GRU_DESCRICAO,ATIVO,DATA_ULT_ALTERACAO,VERSAO,USUARIO_ULT_ALTERACAO)
VALUES ('2', 'USUARIO_MANUTENCAO', 'Cadastrar, Atualizar, Remover, Visualizar Informaçao, Visualizar Permissões', '1', '2020-12-10', '0', '0');

INSERT INTO USU_SEQ(NEXT_VAL)VALUES(2);
INSERT INTO  TB_USUARIO(USU_ID,USU_NOME,USU_LOGIN,USU_SENHA,ATIVO,DATA_ULT_ALTERACAO,VERSAO, USUARIO_ULT_ALTERACAO)
VALUES ('1', 'Administrador de sistema', 'admin', '$2a$10$fDbJZlsjSrFAwBGpbtP.quUyeFsF2u6Z3ji7BIj4ItRRj5K5Ls1UO', '1', '2020-12-10', '0', '0');
-- admin123

INSERT INTO  TB_USUARIO(USU_ID,USU_NOME,USU_LOGIN,USU_SENHA,ATIVO,DATA_ULT_ALTERACAO,VERSAO, USUARIO_ULT_ALTERACAO)
VALUES ('2', 'Usuário do sistema', 'usuariox', '$2a$10$oZR2aHh9G6v33SqJ1eIrke2dfhZBqWWnhvIf41d4KHiVDv9MjHXXW', '1', '2020-12-10', '0', '0');
-- usuariox123

INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,1);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,2);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,3);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,4);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,5);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,6);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,7);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,8);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,9);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,10);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,11);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,12);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,13);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,14);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,15);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,16);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,17);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(1,18);

INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(2,12);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(2,13);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(2,14);
INSERT INTO TB_GRUPO_PERMISSAO(GRUPO_ID, PERMISSAO_ID) VALUES(2,15);

INSERT INTO TB_USUARIO_GRUPO(USUARIO_ID, GRUPO_ID) VALUES(1, 1);
INSERT INTO TB_USUARIO_GRUPO(USUARIO_ID, GRUPO_ID) VALUES(2, 2);
