package fatec.Spring2023.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.Spring2023.entity.Empregado;


public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{

    public List<Empregado> findByCtpsOrEmail(Long ctps, String email);
 
}