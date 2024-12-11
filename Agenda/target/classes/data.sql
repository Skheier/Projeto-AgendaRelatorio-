INSERT INTO endereco (cep, estado, uf, cidade, logradouro, numero, complemento) VALUES
    ('12624099', 'Santa Catarina', 'SC', 'Joinville', 'Rua dos Peixes', 371, 'Ao Lado do Sanatório'),
    ('76005962', 'Tocantins', 'TO', 'Palmas', 'Avenida Tancredo Dumas 3th', 1190, 'Frente ao beco das Lamúrias'),
    ('12488932', 'Santa Catarina', 'SC', 'Blumenal', 'Rua Taruaré', 18, ''),
    ('99272122', 'Salvietics', 'ST', 'Blansasa', 'Taruaré Scovos', 384, ''),
    ('69919781', 'Acre', 'AC', 'Rio Branco', 'Avenida Central ll', 1271, ''),
    ('29193420', 'Espirito Santo', 'ES', 'Aracruz', 'Rua José Carlos Albuquerque Barbosa', 882, ''),
    ('59146573', 'Rio Grande do Norte', 'RN', 'Parnamirim', 'Rua do Cristal', 35, 'Em frente ao super mercado'),
    ('35181612', 'Minas Gerais', 'MG', 'Timóteo', 'Rua Raul Seixas', 1247, ''),
    ('26195370', 'Rio de Janeiro', 'RJ', 'Bellford Roxo', 'Rua Aldebaram', 88, '');

INSERT INTO servico (nome, valor) VALUES
    ('Consulta de rotina', 100.00),
    ('Borrachaeia', 90.750),
    ('Maquiagem', 180.00),
    ('Lavagem de carro', 25.93);


INSERT INTO cliente (nome, telefone, email, endereco_id) VALUES
    ('Walter Mercado', '112445332', 'fimDaWagner@blogspot.com', 1),
    ('Eduardo Tavares', '17249933', 'ubeba@hotmail.com', 2);

INSERT INTO funcionario (nome, telefone, email, endereco_id, salario) VALUES
    ('Robson Delgado Neto', '112445332', 'mamarais@blogspot.com', 3, 1883.2),
    ('Dr. Brezhnev','127749921', 'BrezhninNKVD@gmail.su', 4, 19200.5    );


INSERT INTO agenda (descricao, servico_id, data, status, funcionario_id, cliente_id) VALUES
  ('Agendamento Show', 1, DATE '1947-03-28', false, 1, 1),
  ('Agendamento test 1', 2, DATE '1989-12-08', false, 2, 2),
  ('Maquiassaria', 3, DATE '2024-12-08', false, 1, 2);



INSERT INTO tipo_acesso (descricao) VALUES
  ('Funcionário'),--id = 1 Uso comum do "manipulador", agente padrão da agenda
  ('Dev');        --id = 2 Uso do Desenvolvedor

INSERT INTO usuario (usuario, senha, dt_cadastro, tipo_acesso_id) VALUES
  ('Stalin', 'Komradeleninmybeloved', DATE '1947-03-28', 1),
  ('FDRosevelt', 'Dearmrstalin', DATE '1947-03-28', 1),
  ('marlon', 'rodiriguez123', DATE '2022-12-31', 2),
  ('OthavioBR', 'VectraCD1977', DATE '2002-07-31', 2);

--TIMESTAMP '2022-12-31 23.59.59'
--DATE '2022-12-31' inserção direta no h2
