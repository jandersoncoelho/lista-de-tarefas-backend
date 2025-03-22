package com.jandersoncoelho.lista_tarefas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que a classe é uma entidade
@Data // Gera os métodos getters, setters, equals, hashCode e toString 
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@Builder // Padrão de projeto
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;
    
    private boolean concluida;
}
