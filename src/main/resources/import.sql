insert into categoria (id, nome, descricao) values (1, 'Sub-13', 'Crianças até 13 anos');
insert into categoria (id, nome, descricao) values (2, 'Profissional', 'Jogadores do time principal');
insert into jogador(id, cpf, nome, salario, telefone, categoria_id) values (1, '12345678900', 'Neymar',100000, 5511999838600, 2);
insert into jogador(id, cpf, nome, salario, telefone, categoria_id) values (2, '00987654321', 'Messi Son', 0, 2288991100, 1);
insert into partida(id, adversario, campeonato, data_jogo, gols_feitos, gols_sofridos, local, categoria_id) values (1, 'Peru', 'Copa America', '2019-06-22', 6, 0, 'São Paulo', 1);
insert into partida(id, adversario, campeonato, data_jogo, gols_feitos, gols_sofridos, local, categoria_id) values (2, 'Catar', 'Copa America Sub-13', '2019-06-23', 2, 0, 'Porto Alegre', 2);

