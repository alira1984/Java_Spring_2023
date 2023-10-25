package fatec.Spring2023.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.Spring2023.entity.Temperatura;


public interface TemperaturaRepository extends JpaRepository<Temperatura, Long>{

    public List<Temperatura> findByDataHoraGreaterThanAndMedidaGreaterThan(LocalDateTime dataHora, Float medida);
 
}