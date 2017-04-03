package bootsample.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Tarefa;
import bootsample.service.TarefaService;

@Controller
public class MainController {
	
	@Autowired
	private TarefaService tarefaService;

	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODO_HOME");
		return "index";
	}
	
	@GetMapping("/todas")
	public String todasTarefas(HttpServletRequest request){
		request.setAttribute("tarefas", tarefaService.findAll());
		request.setAttribute("mode", "MODO_TAREFAS");
		return "index";
	}
	
	@GetMapping("/nova")
	public String nova(HttpServletRequest request){
		request.setAttribute("mode", "MODO_NOVO");
		return "index";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Tarefa tarefa, BindingResult bindingResult, HttpServletRequest request){
		tarefa.setDataCriacao(new Date());
		tarefaService.save(tarefa);
		request.setAttribute("tarefas", tarefaService.findAll());
		request.setAttribute("mode", "MODO_TAREFAS");
		return "index";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("tarefa", tarefaService.findTarefa(id));
		request.setAttribute("mode", "MODO_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id, HttpServletRequest request){
		tarefaService.delete(id);
		request.setAttribute("tarefas", tarefaService.findAll());
		request.setAttribute("mode", "MODO_TAREFAS");
		return "index";
	}
}
