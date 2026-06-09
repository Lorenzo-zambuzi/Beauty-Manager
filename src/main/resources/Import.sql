insert into Clientes( nome, email, telefone) values("Felipe","felipe@teste.com","955648873");
insert into Clientes( nome, email, telefone) values("Amaral","amaral@teste.com","945618977");
insert into Clientes( nome, email, telefone) values("Bariel","bariel@teste.com","945781233");
insert into Clientes( nome, email, telefone) values("Charopes","charopes@teste.com","911211313");

insert into Profissionais( nome, email, telefone, funcao, salario, senha) values("Dampartino","dampartino@teste.com","911211313", "cabeleireiro", "1500", "senha1");
insert into Profissionais( nome, email, telefone, funcao, salario, senha) values("Eniliesimo","eniliesimo@teste.com","922345467", "cabeleireiro", "1500", "senha1");
insert into Profissionais( nome, email, telefone, funcao, salario, senha) values("Foguernandez","foguernandez@teste.com","945731223", "cabeleireiro", "1500", "senha1");
insert into Profissionais( nome, email, telefone, funcao, salario, senha) values("Gabarantino","gabarantino@teste.com","999979999", "balconista", "1500", "senha1");
insert into Profissionais( nome, email, telefone, funcao, salario, senha) values("Horácilio","horácilio@teste.com","945688521", "balconista", "1500", "senha1");
insert into Profissionais( nome, email, telefone, funcao, salario, senha) values("Imberbue","imberbue@teste.com","913254687", "gerente", "1500", "senha1");

insert into Servicos( nome, preco) values("corte", "50");
insert into Servicos( nome, preco) values("escova", "120");
insert into Servicos( nome, preco) values("coloração", "90");
insert into Servicos( nome, preco) values("progressiva", "200");
insert into Servicos( nome, preco) values("luzes", "200");
insert into Servicos( nome, preco) values("hidratação", "30");


insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("1", "1", "1", "2026-06-01", "13:00");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("2", "6", "1", "2026-06-01", "13:30");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("3", "2", "1", "2026-06-01", "14:30");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("4", "5", "1", "2026-06-01", "15:30");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("1", "6", "1", "2026-06-01", "16:00");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("2", "1", "1", "2026-06-01", "16:30");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("1", "1", "1", "2026-06-09", "13:00");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("2", "6", "1", "2026-06-09", "13:30");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("3", "2", "1", "2026-06-09", "14:30");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("4", "5", "1", "2026-06-09", "15:30");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("1", "6", "1", "2026-06-09", "16:00");
insert into Agenda ( id_Cliente, id_Profissional, id_Servico, data, horario) values("2", "1", "1", "2026-06-09", "16:30");