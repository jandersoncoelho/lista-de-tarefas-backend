/**
 * Pacote que contém a interface de repositório para a entidade Tarefa.
 * 
 * Este pacote é responsável por fornecer a camada de acesso a dados para as
 * operações relacionadas às tarefas. Utiliza a interface TarefaRepository para
 * definir os métodos de persistência e recuperação de dados das tarefas no
 * banco de dados.
 */
/**
 * Esta interface define o repositório para a entidade Tarefa.
 * <p>
 * O repositório fornece métodos para acessar e manipular dados de tarefas
 * persistidos em um banco de dados. Ele estende a interface JpaRepository,
 * que oferece funcionalidades padrão para operações CRUD (Create, Read, Update, Delete)
 * e paginação.
 * </p>
 *
 * @param Tarefa A classe da entidade Tarefa que este repositório gerencia.
 * @param Long O tipo de dado do ID da entidade Tarefa.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see com.jandersoncoelho.lista_tarefas.model.Tarefa
 */
package com.jandersoncoelho.lista_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jandersoncoelho.lista_tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}