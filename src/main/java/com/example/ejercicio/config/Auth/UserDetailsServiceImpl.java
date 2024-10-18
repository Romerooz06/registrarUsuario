package com.example.ejercicio.config.Auth;

import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var usuario = getById(username);

    if (usuario == null) {
      throw new UsernameNotFoundException(username);
    }
    return User
            .withUsername(username)
            .password(usuario.password())
            .roles(usuario.roles().toArray(new String[0]))
            .build();
  }

  public record Usuario(String username, String password, Set<String> roles) {};

  public static Usuario getById(String username) {
    var password = "$2a$12$8A.qLidNP/XgT5woObc7Pup80odxi7mKmT.8Mp61Z1KxtwLExdggG";
    Usuario admin = new Usuario(
            "admin",
            password,
            Set.of("ADMIN")
    );
    var usuarios = List.of(admin);

    return usuarios
            .stream()
            .filter(e -> e.username().equals(username))
            .findFirst()
            .orElse(null);
  }
}
