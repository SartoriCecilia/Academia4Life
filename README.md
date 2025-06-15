**Sistema de Cadastro de Alunos e Treinos - Academia 4Life**
Este projeto é uma aplicação Java com persistência em MySQL, desenvolvida para gerenciar o cadastro de alunos e seus respectivos treinos em uma academia. A interface é baseada em linha de comando (CLI).

📚 Descrição Geral
O sistema Academia 4Life permite que a administração da academia:

✅ Cadastre, liste, edite e exclua alunos;

✅ Cadastre, liste, edite e exclua treinos vinculados aos alunos;

✅ Navegue por menus intuitivos na linha de comando.

⚙ Tecnologias Utilizadas
- Java SE 8+

- JDBC

- MySQL

- IDE Java (Eclipse, IntelliJ, NetBeans etc.)

- Terminal (CLI)

🚀 Como Executar
•Clone o repositório:

git clone https://github.com/seuusuario/academia-4life.git

•Abra o projeto em sua IDE Java de preferência.

•Configure o banco de dados MySQL:
Execute o script SQL abaixo para criar o banco e as tabelas:

CREATE DATABASE IF NOT EXISTS academia4life;
USE academia4life;

CREATE TABLE IF NOT EXISTS alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
	data_nascimento DATE NOT NULL,
    email VARCHAR(100) NOT NULL,
	cpf VARCHAR(14),
    telefone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS treinos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomeExercicio VARCHAR(100) NOT NULL,
    repeticoes INT NOT NULL,
    series INT NOT NULL,
    id_aluno INT NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES alunos(id) ON DELETE CASCADE
);

•Configure a conexão com o banco de dados no arquivo ConexaoBD.java:

private static final String URL = "jdbc:mysql://localhost:3306/academia4life";
private static final String USUARIO = "root";
private static final String SENHA = "sua_senha";
Execute a classe Main.java para iniciar o sistema.

📦 Estrutura do Projeto

🔹 Main.java
Interface principal (CLI), com os menus:

Menu de Aluno: cadastrar, listar, editar, excluir

Menu de Treino: cadastrar, listar por aluno, editar, excluir

🔹 Aluno.java
Entidade com os atributos:

id, nome, dataNascimento, email, cpf, telefone

🔹 Treino.java
Entidade com os atributos:

id, idAluno, nomeExercicio, series, repeticoes

🔹 AlunoDAO.java
Responsável pelas operações SQL da tabela alunos.

🔹 TreinoDAO.java
Responsável pelas operações SQL da tabela treinos.

🔹 ConexaoBD.java
Faz a conexão com o banco de dados MySQL utilizando JDBC.


💻 Exemplo de Execução (CLI)
======================================
          ACADEMIA 4LIFE              
======================================
1 - Gerenciar Alunos
2 - Gerenciar Treinos
0 - Sair
Escolha uma opcao: 1

=========== MENU DE ALUNO ============
1 - Cadastrar Aluno
2 - Listar Alunos
3 - Editar Aluno
4 - Excluir Aluno

👩‍💻 Autores
Desenvolvido por Cecília Sartori e Indria Quito.

📄 Licença
Este projeto está licenciado sob os termos da MIT License.

