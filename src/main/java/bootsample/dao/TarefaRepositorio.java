package bootsample.dao;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.Tarefa;

public interface TarefaRepositorio extends CrudRepository<Tarefa, Integer>{

}
