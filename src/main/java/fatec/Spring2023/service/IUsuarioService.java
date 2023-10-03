package  fatec.Spring2023.service;
import java.util.List;
import  fatec.Spring2023.entity.Usuario;

public interface IUsuarioService {
 
    public Usuario buscarPorId(Long id);
    public Usuario novoUsuario(Usuario usuario);
    public List<Usuario> buscarTodos();
}