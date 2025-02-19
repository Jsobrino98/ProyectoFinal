package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.DTO.UsuarioDTO;
import AD.SistemaTorneosCompeticions.Models.Usuario;
import AD.SistemaTorneosCompeticions.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    // Método para listar todos los USUARIOS
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> new UsuarioDTO(
                usuario.getNombreUsuario(),
                usuario.getNombreCompleto(),
                usuario.getEmail()
        )).collect(Collectors.toList());
    }


    public Usuario obtener(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }


    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario findByUsernameOrEmail(String usernameOrEmail) {
        Optional<Usuario> usuario = usuarioRepository.findByNombreUsuarioOrEmail(usernameOrEmail, usernameOrEmail);
        return usuario.orElse(null); // Devuelve null si no se encuentra
    }

    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByNombreUsuario(username);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario guardar(Usuario usuario) {
        // Encriptar la contraseña antes de guardar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

}
