create schema api_projetos_academicos;

use api_projetos_academicos;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `matricula` varchar(12) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `fk_endereco_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `matricula`, `nome`, `cpf`, `curso`, `fk_endereco_id`) VALUES
(2, '125658', 'Aluno 2', '586.568.598-70', 'Eng. da Computação', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `numero` varchar(8) DEFAULT NULL,
  `cep` varchar(14) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `rua`, `numero`, `cep`, `cidade`, `estado`, `pais`) VALUES
(2, 'Rua 2', '80', '58.415-200', 'Campina Grande', 'PB', 'BR');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_endereco` (`fk_endereco_id`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_endereco` FOREIGN KEY (`fk_endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;
