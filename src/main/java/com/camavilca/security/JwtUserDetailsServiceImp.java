package com.camavilca.security;

import com.camavilca.dao.security.UsuarioDAO;
import com.camavilca.model.security.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuarioDB = usuarioDAO.findByUsername(username);

        return new User(usuarioDB.getUsername(), usuarioDB.getPassword(),
                new ArrayList<>());
    }

    

}
