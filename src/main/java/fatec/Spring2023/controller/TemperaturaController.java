package fatec.Spring2023.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.Spring2023.entity.Temperatura;
import fatec.Spring2023.service.TemperaturaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/temperatura")
public class TemperaturaController {
        @Autowired
        private TemperaturaService service;

        @GetMapping
        public List<Temperatura> buscarTodos() {
            return service.buscarTodos();
        }

        @GetMapping(value = "/{datahora}/{medida}")
        public List <Temperatura> buscarPorDataHoraouMedida(@PathVariable("datahora") LocalDateTime datahora, @PathVariable("medida") Float medida ) {
            return service.buscarPorDataHoraouMedida(datahora, medida);
        }
        @PostMapping
        public Temperatura novoTemperatura(@RequestBody Temperatura empregado) {
            return service.novoTemperatura(empregado);
        }
 
}