-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12/06/2026 às 04:46
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bmdb`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `agenda`
--

CREATE TABLE `agenda` (
  `data` date DEFAULT NULL,
  `horario` time DEFAULT NULL,
  `id_agendamento` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_profissional` int(11) NOT NULL,
  `id_servico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `agenda`
--

INSERT INTO `agenda` (`data`, `horario`, `id_agendamento`, `id_cliente`, `id_profissional`, `id_servico`) VALUES
('2026-06-01', '13:00:00', 1, 1, 1, 1),
('2026-06-01', '13:30:00', 2, 2, 3, 2),
('2026-06-01', '14:30:00', 3, 3, 2, 3),
('2026-06-01', '15:30:00', 4, 4, 3, 4),
('2026-06-01', '16:00:00', 5, 1, 2, 5),
('2026-06-01', '16:30:00', 6, 2, 1, 5),
('2026-06-09', '13:00:00', 7, 1, 1, 4),
('2026-06-09', '13:30:00', 8, 2, 3, 3),
('2026-06-11', '14:30:00', 9, 3, 2, 2),
('2026-06-11', '15:30:00', 10, 4, 1, 1),
('2026-06-11', '16:00:00', 11, 1, 3, 6),
('2026-06-11', '16:30:00', 12, 2, 1, 6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `email`, `nome`, `telefone`) VALUES
(1, 'felipe@teste.com', 'Felipe', '955648873'),
(2, 'amaral@teste.com', 'Amaral', '945618977'),
(3, 'bariel@teste.com', 'Bariel', '945781233'),
(4, 'charopes@teste.com', 'Charopes', '911211313');

-- --------------------------------------------------------

--
-- Estrutura para tabela `profissionais`
--

CREATE TABLE `profissionais` (
  `id_profissional` int(11) NOT NULL,
  `salario` double NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `funcao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `profissionais`
--

INSERT INTO `profissionais` (`id_profissional`, `salario`, `email`, `funcao`, `nome`, `senha`, `telefone`) VALUES
(1, 1500, 'dampartino@teste.com', 'cabeleireiro', 'Dampartino', 'senha1', '911211313'),
(2, 1500, 'eniliesimo@teste.com', 'cabeleireiro', 'Eniliesimo', 'senha1', '922345467'),
(3, 1500, 'foguernandez@teste.com', 'cabeleireiro', 'Foguernandez', 'senha1', '945731223'),
(4, 1500, 'gabarantino@teste.com', 'balconista', 'Gabarantino', 'senha1', '999979999'),
(5, 1500, 'horácilio@teste.com', 'gerente', 'Horácilio', 'senha1', '945688521');

-- --------------------------------------------------------

--
-- Estrutura para tabela `servicos`
--

CREATE TABLE `servicos` (
  `id_servico` int(11) NOT NULL,
  `preco` double NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `servicos`
--

INSERT INTO `servicos` (`id_servico`, `preco`, `nome`) VALUES
(1, 50, 'corte'),
(2, 120, 'escova'),
(3, 90, 'coloração'),
(4, 200, 'progressiva'),
(5, 200, 'luzes'),
(6, 30, 'hidratação');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`id_agendamento`);

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices de tabela `profissionais`
--
ALTER TABLE `profissionais`
  ADD PRIMARY KEY (`id_profissional`);

--
-- Índices de tabela `servicos`
--
ALTER TABLE `servicos`
  ADD PRIMARY KEY (`id_servico`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agenda`
--
ALTER TABLE `agenda`
  MODIFY `id_agendamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `profissionais`
--
ALTER TABLE `profissionais`
  MODIFY `id_profissional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `servicos`
--
ALTER TABLE `servicos`
  MODIFY `id_servico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
