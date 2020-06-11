package com.camavilca.controllers.security;

import com.camavilca.dao.general.PersonaDAO;
import com.camavilca.dao.general.TipoPersonalDAO;
import com.camavilca.dao.security.RoleDAO;
import com.camavilca.dao.security.UsuarioDAO;
import com.camavilca.model.general.TipoPersonal;
import com.camavilca.model.security.Usuario;
import com.camavilca.model.security.request.SignUpForm;
import com.camavilca.zelper.constant.Constantine;
import com.camavilca.zelper.enums.EstadoEnum;
import com.camavilca.zelper.enums.TipoPersonalEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.albatross.zelpers.miscelanea.ObjectUtil;
import pe.albatross.zelpers.miscelanea.PhobosException;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImp implements UsuarioService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private TipoPersonalDAO tipoPersonalDAO;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }

    @Override
    public void save(SignUpForm user) {

        ObjectUtil.printAttr(user);

        if (user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new PhobosException(Constantine.FIELS_NO_COMPLET);
        }

        Usuario existEmail = usuarioDAO.findByUsername(user.getEmail());
        Usuario existUsername = usuarioDAO.findByUsername(user.getUsername());

        if (existEmail != null || existUsername != null) {
            throw new PhobosException(Constantine.EXIST_USER);
        }

        TipoPersonal tipoPersonal = tipoPersonalDAO.findByCodigo(TipoPersonalEnum.ASP);

        System.out.println("*******************************************");
        System.out.println("**************PERSONA NUEVA******************");
        System.out.println("*******************************************");

//        Persona newpersona = new Persona();
//        newpersona.setNombres(user.getName());
//        newpersona.setMaterno(user.getMaterno());
//        newpersona.setPaterno(user.getPaterno());
//        newpersona.setTipoPersonal(tipoPersonal);
//        newpersona.setEmail(user.getEmail());
//        personaDAO.save(newpersona);
//
//        System.out.println("*******************************************");
//        System.out.println("**************USUARIO******************");
//        ObjectUtil.printAttr(user);
//        System.out.println("*******************************************");

        Usuario newuser = new Usuario();
        newuser.setName(user.getName());
        newuser.setUsername(user.getUsername());
        newuser.setEstadoEnum(EstadoEnum.ACT);
        newuser.setEmail(user.getEmail());
        newuser.setPassword(bcryptEncoder.encode(user.getPassword()));
        ObjectUtil.printAttr(newuser);
        usuarioDAO.save(newuser);

    }

}
