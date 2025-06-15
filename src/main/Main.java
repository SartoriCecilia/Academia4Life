package main;

import dao.AlunoDAO;
import dao.TreinoDAO;
import entidades.Aluno;
import entidades.Treino;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();
        TreinoDAO treinoDAO = new TreinoDAO();

        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuAluno(scanner, alunoDAO);
                    break;
                case 2:
                    menuTreino(scanner, treinoDAO);
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar o sistema 4Life. Ate a proxima!");
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.\n");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenuPrincipal() {
        System.out.println("\n======================================");
        System.out.println("          ACADEMIA 4LIFE               ");
        System.out.println("======================================");
        System.out.println("1 - Gerenciar Alunos");
        System.out.println("2 - Gerenciar Treinos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    public static void menuAluno(Scanner scanner, AlunoDAO alunoDAO) {
        int opcao;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.println("\n=========== MENU ALUNO ============");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Editar Aluno");
            System.out.println("4 - Excluir Aluno");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data de nascimento (dd/MM/aaaa): ");
                    String dataNascStr = scanner.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataNascStr, formatter);
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    Aluno novoAluno = new Aluno();
                    novoAluno.setNome(nome);
                    novoAluno.setDataNascimento(dataNascimento);
                    novoAluno.setEmail(email);
                    novoAluno.setCpf(cpf);
                    novoAluno.setTelefone(telefone);

                    alunoDAO.cadastrarAluno(novoAluno);
                    break;

                case 2:
                    List<Aluno> alunos = alunoDAO.listarAlunos();
                    System.out.println("\n--- LISTA DE ALUNOS ---");
                    for (Aluno a : alunos) {
                        System.out.println("ID: " + a.getId() +
                            " | Nome: " + a.getNome() +
                            " | Data Nascimento: " + a.getDataNascimento() +
                            " | Email: " + a.getEmail() +
                            " | CPF: " + a.getCpf() +
                            " | Telefone: " + a.getTelefone());
                    }
                    break;

                case 3:
                    System.out.print("ID do aluno a editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova data de nascimento (dd/MM/aaaa): ");
                    String novaDataNascStr = scanner.nextLine();
                    LocalDate novaDataNasc = LocalDate.parse(novaDataNascStr, formatter);
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    String novoCpf = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    Aluno alunoEditado = new Aluno();
                    alunoEditado.setNome(novoNome);
                    alunoEditado.setDataNascimento(novaDataNasc);
                    alunoEditado.setEmail(novoEmail);
                    alunoEditado.setCpf(novoCpf);
                    alunoEditado.setTelefone(novoTelefone);

                    alunoDAO.editarAluno(idEditar, alunoEditado);
                    break;

                case 4:
                    System.out.print("ID do aluno a excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();
                    alunoDAO.excluirAluno(idExcluir);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpção invalida. Tente novamente.\n");
            }
        } while (opcao != 0);
    }


    public static void menuTreino(Scanner scanner, TreinoDAO treinoDAO) {
        int opcao;

        do {
            System.out.println("\n=========== MENU TREINO ============");
            System.out.println("1 - Cadastrar Treino");
            System.out.println("2 - Listar Treinos por Aluno");
            System.out.println("3 - Editar Treino");
            System.out.println("4 - Excluir Treino");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do aluno: ");
                    int alunoId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do exercicio: ");
                    String nomeExercicio = scanner.nextLine();
                    System.out.print("Numero de series: ");
                    int series = scanner.nextInt();
                    System.out.print("Numero de repeticoes: ");
                    int repeticoes = scanner.nextInt();
                    scanner.nextLine();
                    Treino novoTreino = new Treino(alunoId, nomeExercicio, series, repeticoes);
                    treinoDAO.cadastrarTreino(novoTreino);
                    break;
                case 2:
                    System.out.print("ID do aluno para listar treinos: ");
                    int idAluno = scanner.nextInt();
                    scanner.nextLine();
                    List<Treino> treinos = treinoDAO.listarTreinosPorAluno(idAluno);
                    System.out.println("\n--- TREINOS DO ALUNO ---");
                    for (Treino t : treinos) {
                        System.out.println("ID: " + t.getId() + " | Exercicio: " + t.getNomeExercicio() +
                                " | Series: " + t.getSeries() + " | Repeticoes: " + t.getRepeticoes());
                    }
                    break;
                case 3:
                    System.out.print("ID do treino a editar: ");
                    int idTreino = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome do exercicio: ");
                    String novoExercicio = scanner.nextLine();
                    System.out.print("Nova quantidade de series: ");
                    int novasSeries = scanner.nextInt();
                    System.out.print("Nova quantidade de repeticoes: ");
                    int novasReps = scanner.nextInt();
                    scanner.nextLine();
                    Treino treinoEditado = new Treino();
                    treinoEditado.setNomeExercicio(novoExercicio);
                    treinoEditado.setSeries(novasSeries);
                    treinoEditado.setRepeticoes(novasReps);
                    treinoDAO.editarTreino(idTreino, treinoEditado);
                    break;
                case 4:
                    System.out.print("ID do treino a excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();
                    treinoDAO.excluirTreino(idExcluir);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.\n");
            }
        } while (opcao != 0);
    }
}