package com.facundotorrez.pruebatecnca.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.facundotorrez.pruebatecnca.interfaceServices.IUsuarioService;
import com.facundotorrez.pruebatecnca.models.Inspector;
import com.facundotorrez.pruebatecnca.models.Usuario;
import com.facundotorrez.pruebatecnca.repositories.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService , UserDetailsService{
    @Autowired
	private UsuarioRepository usuarioRepository;
    
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Usuario saveOrUpdate(Usuario usuario) {
		// TODO Auto-generated method stub
		int idUsuario = usuario.getIdUsuario();
		Optional<Usuario> usuariobd = usuarioRepository.findById(idUsuario);
		System.out.println(usuario);
		if( usuariobd.isEmpty() ) {
			usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
			return usuarioRepository.save(usuario);
		}
		else {
			return usuariobd.get();
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByUsernameAndFetchUserRolesEagerly(username);		
		return buildUser(user, buildGrantedAuthorities(user.getPerfil().getUsuarios()));
	}
	
	private User buildUser(Usuario user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getNombreUsuario(), user.getContraseña(), user.isEnable(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<Usuario> usuarios) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(Usuario usuario: usuarios) {
			grantedAuthorities.add(new SimpleGrantedAuthority(usuario.getPerfil().getPerfil()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}
