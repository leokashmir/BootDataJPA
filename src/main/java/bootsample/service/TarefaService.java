package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bootsample.dao.TarefaRepositorio;
import bootsample.model.Tarefa;

@Service
@Transactional
public class TarefaService {

	private final TarefaRepositorio trepositorio;

	public TarefaService(TarefaRepositorio tarefarepositorio) {
		this.trepositorio = tarefarepositorio;
	}
	
	public List<Tarefa> findAll(){
		List<Tarefa> tarefas = new ArrayList<>();
		for(Tarefa tarefa : trepositorio.findAll()){
			tarefas.add(tarefa);
		}
		return tarefas;
	}
	
	public Tarefa findTarefa(int id){
		return trepositorio.findOne(id);
	}
	
	public void save(Tarefa tarefa){
		trepositorio.save(tarefa);
	}
	
	public void delete(int id){
		trepositorio.delete(id);
	}
}
