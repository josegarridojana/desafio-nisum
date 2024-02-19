/*
 * @(#)UsuarioServiceImpl.java
 *
 * Copyright (c) (Chile). All rights reserved.
 *
 * All rights to this product are owned by and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.nisum.ms.services.impl;

import com.nisum.ms.constants.DesafioConstants;
import com.nisum.ms.entities.Phone;
import com.nisum.ms.entities.Usuario;
import com.nisum.ms.exceptions.SimpleException;
import com.nisum.ms.properties.ExpresRegexProperties;
import com.nisum.ms.repositories.UsuarioRepository;
import com.nisum.ms.services.UsuarioService;
import com.nisum.ms.utils.DesafioUtils;
import com.nisum.ms.utils.JWTUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * UsuarioServiceImpl.
 *
 * @author Jose.
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    /** usuarioRepository. */
    private final UsuarioRepository usuarioRepository;
    /** expresRegexProperties. */
    private final ExpresRegexProperties expresRegexProperties;

    @Override
    public List<Usuario> getAllUsuarios() {
        try {
            System.out.println("JWTUtils:" + JWTUtils.createJWT(DesafioConstants.SUBJECT));
            return this.usuarioRepository.findAll();
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de usuarios", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public List<Usuario> getAllUsuariosByName(final String name) {
        try {
            final List<Usuario> usuarios = new ArrayList<>();
            this.usuarioRepository.findByNameContaining(name).forEach(usuarios::add);
            return usuarios;
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de usuarios por nombre", HttpStatus.BAD_REQUEST
                .value(), ex);
        }
    }

    @Override
    public Usuario getUsuarioById(final long id) {
        try {
            final Optional<Usuario> pruebaData = this.usuarioRepository.findById(id);
            if (!pruebaData.isPresent()) {
                throw new SimpleException("Usuario no encontrado", HttpStatus.BAD_REQUEST.value());
            }
            return pruebaData.get();
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de usuarios por id", HttpStatus.BAD_REQUEST.value(),
                ex);
        }

    }

    @Override
    public Usuario createUsuario(final Usuario usuario) {
        try {
            this.validateEmailAndPassword(usuario);
            final Optional<Usuario> findUserEmail = this.usuarioRepository.findByEmail(usuario.getEmail());
            if (findUserEmail.isPresent()) {
                throw new SimpleException("El correo ya registrado", HttpStatus.BAD_REQUEST.value());
            }
            final Usuario saveUsuario = new Usuario();
            saveUsuario.setName(usuario.getName());
            saveUsuario.setEmail(usuario.getEmail());
            saveUsuario.setPassword(usuario.getPassword());
            saveUsuario.setActive(true);
            saveUsuario.setCreated(new Date());
            saveUsuario.setModified(new Date());
            saveUsuario.setLastLogin(new Date());
            saveUsuario.setToken(UUID.randomUUID());
            // Por si se utiliza JWT
            // saveUsuario.setToken(JWTUtils.createJWT(usuario.getName()));
            final List<Phone> phones = usuario.getPhones();
            saveUsuario.setPhones(phones);
            return this.usuarioRepository
                .save(saveUsuario);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear usuarios", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public Usuario updateUsuario(final long id, final Usuario usuario) {
        try {
            final Optional<Usuario> usuarioData = this.usuarioRepository.findById(id);
            if (!usuarioData.isPresent()) {
                throw new SimpleException("Usuario no actualizado", HttpStatus.BAD_REQUEST.value());
            }
            final Usuario saveUsuario = usuarioData.get();
            saveUsuario.setName(usuario.getName());
            saveUsuario.setEmail(usuario.getEmail());
            saveUsuario.setPassword(usuario.getPassword());
            saveUsuario.setActive(usuario.isActive());
            saveUsuario.setModified(new Date());
            final List<Phone> phones = usuario.getPhones();
            saveUsuario.setPhones(phones);
            return this.usuarioRepository.save(saveUsuario);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear usuarios", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteUsuario(final long id) {
        try {
            this.usuarioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear usuarios", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllUsuarios() {
        try {
            this.usuarioRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear usuarios", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public List<Usuario> findByIsActive() {
        try {
            return this.usuarioRepository.findByIsActive(true);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear usuarios", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    private void validateEmailAndPassword(final Usuario usuario) {
        if (!DesafioUtils.validateEmail(usuario.getEmail(), this.expresRegexProperties.getEmail()) && !DesafioUtils
            .validatePassword(usuario
                .getPassword(), this.expresRegexProperties.getPassword())) {
            throw new SimpleException("El correo o la password no son validas", HttpStatus.BAD_REQUEST.value());
        }
    }

}
