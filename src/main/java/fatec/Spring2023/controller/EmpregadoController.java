package fatec.Spring2023.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.Spring2023.entity.Empregado;
import fatec.Spring2023.service.EmpregadoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/empregado")
public class EmpregadoController {
        @Autowired
        private EmpregadoService service;

        @GetMapping
        public List<Empregado> buscarTodos() {
            return service.buscarTodos();
        }

        @GetMapping(value = "/{ctps}/{email}")
        public List <Empregado> buscarPorCtpsouEmail(@PathVariable("ctps") Long ctps, @PathVariable("email") String email ) {
            return service.buscarPorCtpsouEmail(ctps, email);
        }
        @PostMapping
        public Empregado novoEmpregado(@RequestBody Empregado empregado) {
            return service.novoEmpregado(empregado);
        }
 
}
