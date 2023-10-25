package fatec.Spring2023.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.Spring2023.entity.Temperatura;
import fatec.Spring2023.repository.TemperaturaRepository;

@Service
public class TemperaturaService {
 
    @Autowired
    private TemperaturaRepository temperaturaRepo;

    public List <Temperatura> buscarPorDataHoraouMedida(LocalDateTime dataHora, Float medida) {
       return temperaturaRepo.findByDataHoraGreaterThanAndMedidaGreaterThan(dataHora, medida);
        
     }
    public Temperatura novoTemperatura(Temperatura temperatura) {
        
        return temperaturaRepo.save(temperatura);
    }
    public List<Temperatura> buscarTodos() {
    return temperaturaRepo.findAll();
    }
}
