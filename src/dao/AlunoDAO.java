package dao;

import conexao.ConexaoBD;
import entidades.Aluno;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void cadastrarAluno(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, data_nascimento, email, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setDate(2, Date.valueOf(aluno.getDataNascimento())); // LocalDate -> java.sql.Date
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getTelefone());
            stmt.executeUpdate();
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                Date dataSql = rs.getDate("data_nascimento");
                if (dataSql != null) {
                    a.setDataNascimento(dataSql.toLocalDate()); // java.sql.Date -> LocalDate
                }
                a.setEmail(rs.getString("email"));
                a.setCpf(rs.getString("cpf"));
                a.setTelefone(rs.getString("telefone"));
                alunos.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        return alunos;
    }

    public void editarAluno(int idEditar, Aluno alunoEditado) {
        String sql = "UPDATE alunos SET nome = ?, data_nascimento = ?, email = ?, cpf = ?, telefone = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alunoEditado.getNome());
            stmt.setDate(2, Date.valueOf(alunoEditado.getDataNascimento()));
            stmt.setString(3, alunoEditado.getEmail());
            stmt.setString(4, alunoEditado.getCpf());
            stmt.setString(5, alunoEditado.getTelefone());
            stmt.setInt(6, idEditar);
            stmt.executeUpdate();
            System.out.println("Aluno atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao editar aluno: " + e.getMessage());
        }
    }

    public void excluirAluno(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Aluno excluido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir aluno: " + e.getMessage());
        }
    }
}