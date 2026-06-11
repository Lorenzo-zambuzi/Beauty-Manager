package br.com.beautyManager.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.service.ProfissionalService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginWebController {

	@Autowired
	private ProfissionalService ps;
	
	@GetMapping
	public String telaDeLogin() {
		return "Login";
	}
	
	@GetMapping("/login")
	public String loginVerificacao(HttpSession session, @RequestParam(name = "email") String email, @RequestParam(name = "senha") String senha) {
		
		if(ps.buscarPorEmail(email) != null) {
			Profissional profissional = ps.buscarPorEmail(email);
			if(senha.equals(profissional.getSenha()) && senha != null) {
				session.setAttribute("user", profissional);
				// model.addAttribute("usuario", profissional);
				return "redirect:/index";
			}
		}
		
		return "Login";
	}
}
