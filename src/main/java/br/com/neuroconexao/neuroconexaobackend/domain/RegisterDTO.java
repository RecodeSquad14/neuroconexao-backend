package br.com.neuroconexao.neuroconexaobackend.domain;

public record RegisterDTO(String login, String password, UserRole role) {
}