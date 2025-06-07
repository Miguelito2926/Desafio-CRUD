package com.ednaldo.crud_clientes.dto;

import com.ednaldo.crud_clientes.entities.Client;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "Nome precisa ter de 3 a 80 caracteres.")
    @NotBlank(message = "Nome: não pode ser vazio.")
    private String name;

    @CPF(message = "CPF: inválido.")
    @NotBlank(message = "CPF: campo obrigatório.")
    private String cpf;

    @DecimalMin(value = "0.0", inclusive = true, message = "Renda: não pode ser negativa.")
    @NotNull(message = "Renda: campo obrigatório.")
    private Double income;

    @PastOrPresent(message = "Data de nascimento: não pode ser data futura.")
    @NotNull(message = "Data de nascimento: campo obrigatório.")
    private LocalDate birthDate;

    @NotNull(message = "Filhos: campo obrigatório.")
    @Min(value = 0, message = "Filhos: não pode ser menor que zero.")
    private Integer children;

    public ClientDTO() {}

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
