package br.com.neuroconexao.neuroconexaobackend.exception;

public class ProfissionalNotFoundException extends RuntimeException {
    public ProfissionalNotFoundException(Long id) {
        super("Profissional não encontrado com o ID: " + id);
    }
}
