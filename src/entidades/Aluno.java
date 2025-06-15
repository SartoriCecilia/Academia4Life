package entidades;

import java.time.LocalDate;

public class Aluno {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String cpf;
    private String telefone;

    public Aluno() {}

    public Aluno(String nome, LocalDate dataNascimento, String email, String cpf, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Aluno(int id, String nome, LocalDate dataNascimento, String email, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() { 
        return id; 
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public LocalDate getDataNascimento() { 
        return dataNascimento; 
    }

    public void setDataNascimento(LocalDate dataNascimento) { 
        this.dataNascimento = dataNascimento; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getCpf() { 
        return cpf; 
    }

    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    }

    public String getTelefone() { 
        return telefone; 
    }

    public void setTelefone(String telefone) { 
        this.telefone = telefone; 
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Data de Nascimento: " + dataNascimento +
               " | Email: " + email +
               " | CPF: " + cpf +
               " | Telefone: " + telefone;
    }
}