package dao;

import entidades.Treino;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexao.ConexaoBD;

public class TreinoDAO {

    public void cadastrarTreino(Treino treino) {
        String sql = "INSERT INTO treinos (id_aluno, nomeExercicio, series, repeticoes) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, treino.getIdAluno());
            stmt.setString(2, treino.getNomeExercicio());
            stmt.setInt(3, treino.getSeries());
            stmt.setInt(4, treino.getRepeticoes());

            stmt.executeUpdate();
            System.out.println("✅ Treino cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar treino: " + e.getMessage());
        }
    }

    public List<Treino> listarTreinosPorAluno(int idAluno) {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM treinos WHERE id_aluno = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Treino t = new Treino();
                t.setId(rs.getInt("id"));
                t.setIdAluno(rs.getInt("id_aluno"));
                t.setNomeExercicio(rs.getString("nomeExercicio"));
                t.setSeries(rs.getInt("series"));
                t.setRepeticoes(rs.getInt("repeticoes"));
                lista.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar treinos: " + e.getMessage());
        }

        return lista;
    }

    public void editarTreino(int id, Treino treinoAtualizado) {
        String sql = "UPDATE treinos SET nomeExercicio = ?, series = ?, repeticoes = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, treinoAtualizado.getNomeExercicio());
            stmt.setInt(2, treinoAtualizado.getSeries());
            stmt.setInt(3, treinoAtualizado.getRepeticoes());
            stmt.setInt(4, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("✅ Treino atualizado com sucesso!");
            } else {
                System.out.println("⚠️ Treino não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao editar treino: " + e.getMessage());
        }
    }

    public void excluirTreino(int idTreino) {
        String sql = "DELETE FROM treinos WHERE id = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTreino);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("✅ Treino excluido com sucesso!");
            } else {
                System.out.println("⚠️ Treino nao encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir treino: " + e.getMessage());
        }
    }

	public List<Treino> listarTreinosPorAluno1(int idAluno) {
		return null;
	}

}