package fatec.Spring2023.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.Spring2023.entity.Empregado;
import fatec.Spring2023.repository.EmpregadoRepository;

@Service
public class EmpregadoService {
 
    @Autowired
    private EmpregadoRepository empregadoRepo;

    public List <Empregado> buscarPorCtpsouEmail(Long ctps, String email) {
       return empregadoRepo.findByCtpsOrEmail(ctps, email);
        
    }
    public Empregado novoEmpregado(Empregado empregado) {
        
        return empregadoRepo.save(empregado);
    }
    public List<Empregado> buscarTodos() {
    return empregadoRepo.findAll();
    }
}