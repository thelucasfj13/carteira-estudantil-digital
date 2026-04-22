package com.carteira.config;

import com.carteira.model.Usuario;
import com.carteira.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (!usuarioRepository.existsByEmail("admin@carteira.edu.br")) {
            Usuario admin = new Usuario();
            admin.setEmail("admin@carteira.edu.br");
            admin.setSenha(passwordEncoder.encode("admin123"));
            admin.setNome("Administrador");
            admin.setRole(Usuario.Role.ADMIN);
            usuarioRepository.save(admin);
            System.out.println("Usuário admin criado: admin@carteira.edu.br / admin123");
        }
    }
}