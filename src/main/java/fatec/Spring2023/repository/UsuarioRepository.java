package fatec.Spring2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fatec.Spring2023.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
 
}