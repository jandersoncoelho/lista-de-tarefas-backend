/**
 * Esta classe é o controlador para lidar com solicitações relacionadas às entidades "Tarefa".
 * Faz parte da aplicação "lista_tarefas".
 * 
 * O controlador é responsável por gerenciar as operações CRUD e outras funcionalidades relacionadas às tarefas.
 * 
 * Pacote: com.jandersoncoelho.lista_tarefas.controller
 * 
 * Nota: Certifique-se de que a grafia correta de "controller" seja usada no nome do pacote.
 */
package com.jandersoncoelho.lista_tarefas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jandersoncoelho.lista_tarefas.model.Tarefa;
import com.jandersoncoelho.lista_tarefas.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository tarefaRepository;

    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // 📌 Criar uma nova tarefa (CREATE)
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // 📌 Listar todas as tarefas (READ)
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // 📌 Buscar uma tarefa pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefa(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 📌 Atualizar uma tarefa (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setDescricao(tarefaAtualizada.getDescricao());
                    tarefa.setConcluida(tarefaAtualizada.isConcluida());
                    tarefaRepository.save(tarefa);
                    return ResponseEntity.ok(tarefa);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 📌 Deletar uma tarefa (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
