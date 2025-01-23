-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23/01/2025 às 20:29
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `breeder`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `coelhos`
--

CREATE TABLE `coelhos` (
  `ID_coelho` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `raca` varchar(50) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `cor` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `coelhos`
--

INSERT INTO `coelhos` (`ID_coelho`, `nome`, `raca`, `data_nasc`, `sexo`, `peso`, `cor`) VALUES
(1, 'Dorothy', 'Holandês', '2021-03-14', 'F', 1.22, 'Preto e branco'),
(2, 'Mascavo', 'Mini Lop', '2020-06-23', 'M', 2.4, 'Marrom'),
(3, 'Billy', 'Netherland Dwarf', '2022-10-04', 'M', 1.13, 'Preto'),
(4, 'Algodão', 'Coelho Leão', '2019-04-10', 'M', 2.1, 'Branco'),
(5, 'Cacau', 'Coelho Polonês', '2020-02-08', 'F', 1.17, 'Marrom');

-- --------------------------------------------------------

--
-- Estrutura para tabela `crias`
--

CREATE TABLE `crias` (
  `ID_cria` int(11) NOT NULL,
  `ID_pai` int(11) DEFAULT NULL,
  `ID_mae` int(11) DEFAULT NULL,
  `data_cria` date DEFAULT NULL,
  `sexo_cria` char(1) DEFAULT NULL,
  `peso_nasc` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `crias`
--

INSERT INTO `crias` (`ID_cria`, `ID_pai`, `ID_mae`, `data_cria`, `sexo_cria`, `peso_nasc`) VALUES
(1, 2, 5, '2024-01-20', 'M', 0.055),
(2, 2, 5, '2024-01-20', 'M', 0.057),
(3, 2, 5, '2024-01-20', 'F', 0.058),
(4, 2, 5, '2024-01-20', 'M', 0.059),
(5, 4, 1, '2023-10-26', 'F', 0.055),
(6, 4, 1, '2023-10-26', 'F', 0.056),
(7, 4, 1, '2023-10-26', 'M', 0.056);

-- --------------------------------------------------------

--
-- Estrutura para tabela `proprietarios`
--

CREATE TABLE `proprietarios` (
  `ID_prop` int(11) NOT NULL,
  `nome_prop` varchar(100) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `fone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `proprietarios`
--

INSERT INTO `proprietarios` (`ID_prop`, `nome_prop`, `endereco`, `fone`) VALUES
(1, 'Eliana Silva', 'Rua 30', '9823456678'),
(2, 'Rodrigo Santos', 'Rua 21', '994681012'),
(3, 'Miriam Maia', 'Rua São José', '98691215'),
(4, 'Celso Portiolli', 'Rua 11', '11092001'),
(5, 'Bárbara Ribeiro', 'Rua 46', '985101520');

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `ID_venda` int(11) NOT NULL,
  `ID_coelho` int(11) DEFAULT NULL,
  `ID_comprador` int(11) DEFAULT NULL,
  `data_venda` date DEFAULT NULL,
  `preco` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `vendas`
--

INSERT INTO `vendas` (`ID_venda`, `ID_coelho`, `ID_comprador`, `data_venda`, `preco`) VALUES
(1, 3, 4, '2023-08-09', 150),
(2, 1, 1, '2024-12-05', 100),
(3, 2, 4, '2024-11-19', 80.5);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `coelhos`
--
ALTER TABLE `coelhos`
  ADD PRIMARY KEY (`ID_coelho`);

--
-- Índices de tabela `crias`
--
ALTER TABLE `crias`
  ADD PRIMARY KEY (`ID_cria`),
  ADD KEY `ID_Pai` (`ID_pai`),
  ADD KEY `ID_Mae` (`ID_mae`);

--
-- Índices de tabela `proprietarios`
--
ALTER TABLE `proprietarios`
  ADD PRIMARY KEY (`ID_prop`);

--
-- Índices de tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`ID_venda`),
  ADD KEY `ID_coelho` (`ID_coelho`),
  ADD KEY `ID_comprador` (`ID_comprador`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `coelhos`
--
ALTER TABLE `coelhos`
  MODIFY `ID_coelho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `crias`
--
ALTER TABLE `crias`
  MODIFY `ID_cria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `proprietarios`
--
ALTER TABLE `proprietarios`
  MODIFY `ID_prop` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `ID_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `crias`
--
ALTER TABLE `crias`
  ADD CONSTRAINT `crias_ibfk_1` FOREIGN KEY (`ID_pai`) REFERENCES `coelhos` (`ID_coelho`),
  ADD CONSTRAINT `crias_ibfk_2` FOREIGN KEY (`ID_mae`) REFERENCES `coelhos` (`ID_coelho`);

--
-- Restrições para tabelas `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`ID_Coelho`) REFERENCES `coelhos` (`ID_coelho`),
  ADD CONSTRAINT `vendas_ibfk_2` FOREIGN KEY (`ID_Comprador`) REFERENCES `proprietarios` (`ID_prop`),
  ADD CONSTRAINT `vendas_ibfk_3` FOREIGN KEY (`ID_coelho`) REFERENCES `coelhos` (`ID_coelho`) ON DELETE CASCADE,
  ADD CONSTRAINT `vendas_ibfk_4` FOREIGN KEY (`ID_comprador`) REFERENCES `proprietarios` (`ID_prop`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
