-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25-Fev-2022 às 01:56
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `quiosque`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `data_nascimento` date NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telcel` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `prod_interesse` varchar(50) NOT NULL,
  `genero` varchar(15) NOT NULL,
  `data_cadastro` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`id`, `nome`, `data_nascimento`, `endereco`, `telcel`, `email`, `prod_interesse`, `genero`, `data_cadastro`) VALUES
(8, 'Leandro', '1985-06-04', 'Rua ciro monteiro 174 ', '15151568', 'heh%@gmail', 'suco', 'masculino', '2022-02-24 20:42:20'),
(9, 'tiaguin', '2020-07-08', 'Cotia Rua ciro monteiro 174 ', '15151568', 'ha@m', 'w', 'feminino', '2022-02-24 20:42:20'),
(10, 'LeandroDDD', '2022-02-25', 'Cotia Rua ciro monteiro 174 ', '15151568', 'l34ndr0penha@gmail.com', 'whisky', 'masculino', '2022-02-25 20:53:58');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
