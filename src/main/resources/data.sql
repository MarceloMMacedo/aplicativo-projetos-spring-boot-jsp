-- Inserindo dados na tabela pessoa
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João1', '2024-01-01', '123.456.789-01', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João2', '2024-01-02', '123.456.789-02', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João3', '2024-01-03', '123.456.789-03', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João4', '2024-01-04', '123.456.789-04', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João5', '2024-01-05', '123.456.789-05', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João6', '2024-01-06', '123.456.789-06', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João7', '2024-01-07', '123.456.789-07', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João8', '2024-01-08', '123.456.789-08', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João9', '2024-01-09', '123.456.789-09', true, false);
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES ('João10', '2024-01-10', '123.456.789-10', true, false);

-- Inserindo dados na tabela projeto
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 1', '2024-01-01', '2024-12-31', 'Este é o Projeto 1', 'EM_ANALISE', 1000.0, 'BAIXO_RISCO', 1);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 2', '2024-01-02', '2024-12-31', 'Este é o Projeto 2', 'ANALISE_REALIZADA', 2000.0, 'MEDIO_RISCO', 2);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 3', '2024-01-03', '2024-12-31', 'Este é o Projeto 3', 'ANALISE_APROVADA', 3000.0, 'ALTO_RISCO', 3);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 4', '2024-01-04', '2024-12-31', 'Este é o Projeto 4', 'INICIADO', 4000.0, 'BAIXO_RISCO', 4);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 5', '2024-01-05', '2024-12-31', 'Este é o Projeto 5', 'PLANEJADO', 5000.0, 'MEDIO_RISCO', 5);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 6', '2024-01-06', '2024-12-31', 'Este é o Projeto 6', 'EM_ANDAMENTO', 6000.0, 'ALTO_RISCO', 6);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 7', '2024-01-07', '2024-12-31', 'Este é o Projeto 7', 'ENCERRADO', 7000.0, 'BAIXO_RISCO', 7);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 8', '2024-01-08', '2024-12-31', 'Este é o Projeto 8', 'CANCELADO', 8000.0, 'MEDIO_RISCO', 8);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 9', '2024-01-09', '2024-12-31', 'Este é o Projeto 9', 'EM_ANALISE', 9000.0, 'ALTO_RISCO', 9);
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, descricao, status, orcamento, risco, idgerente) VALUES ('Projeto 10', '2024-01-10', '2024-12-31', 'Este é o Projeto 10', 'ANALISE_REALIZADA', 10000.0, 'BAIXO_RISCO', 10);

-- Inserindo dados na tabela membros
INSERT INTO membros (idprojeto, idpessoa) VALUES (1, 1);
INSERT INTO membros (idprojeto, idpessoa) VALUES (2, 2);
INSERT INTO membros (idprojeto, idpessoa) VALUES (3, 3);
INSERT INTO membros (idprojeto, idpessoa) VALUES (4, 4);
INSERT INTO membros (idprojeto, idpessoa) VALUES (5, 5);
INSERT INTO membros (idprojeto, idpessoa) VALUES (6, 6);
INSERT INTO membros (idprojeto, idpessoa) VALUES (7, 7);
INSERT INTO membros (idprojeto, idpessoa) VALUES (8, 8);
INSERT INTO membros (idprojeto, idpessoa) VALUES (9, 9);
INSERT INTO membros (idprojeto, idpessoa) VALUES (10, 10);

INSERT INTO membros (idprojeto, idpessoa) VALUES (1, 2);
INSERT INTO membros (idprojeto, idpessoa) VALUES (2, 3);
INSERT INTO membros (idprojeto, idpessoa) VALUES (3, 4);
INSERT INTO membros (idprojeto, idpessoa) VALUES (4, 5);
INSERT INTO membros (idprojeto, idpessoa) VALUES (5, 6);
INSERT INTO membros (idprojeto, idpessoa) VALUES (6, 7);
INSERT INTO membros (idprojeto, idpessoa) VALUES (7, 8);
INSERT INTO membros (idprojeto, idpessoa) VALUES (8, 9);
INSERT INTO membros (idprojeto, idpessoa) VALUES (9, 10);
INSERT INTO membros (idprojeto, idpessoa) VALUES (10, 1);

