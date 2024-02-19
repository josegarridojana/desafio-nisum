/*
 * @(#)UsuarioServiceImplTest.java
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
package com.nisum.ms.services;

import com.nisum.ms.entities.Usuario;
import com.nisum.ms.exceptions.SimpleException;
import com.nisum.ms.fixture.UsuarioFixture;
import com.nisum.ms.properties.ExpresRegexProperties;
import com.nisum.ms.repositories.UsuarioRepository;
import com.nisum.ms.services.impl.UsuarioServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * UsuarioServiceImplTest.
 *
 * @author Jose.
 * @version 1.0.0
 */
public class UsuarioServiceImplTest {

    /** usuarioRepository. */
    @Mock
    private UsuarioRepository usuarioRepository;
    /** expresRegexProperties. */
    @Mock
    private ExpresRegexProperties expresRegexProperties;
    /** usuarioService. */
    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    // -------------------------------------------------------------------
    // -- Setup ----------------------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Setup.
     *
     * @throws Exception Exception
     */
    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    // -------------------------------------------------------------------
    // -- Test -----------------------------------------------------------
    // -------------------------------------------------------------------

    /**
     * Test.
     */
    @Test
    void testGetAllUsuarios() {
        final List<Usuario> rs = UsuarioFixture.getUsuarios();
        Mockito.when(this.expresRegexProperties.getEmail()).thenReturn(
            "^[\\w-\\\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Mockito.when(this.expresRegexProperties.getPassword()).thenReturn(
            "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Mockito.when(this.usuarioRepository.findAll())
            .thenReturn(rs);
        Assertions.assertNotNull(this.usuarioService.getAllUsuarios());
    }

    /**
     * Test.
     */
    @Test
    void testCreateUsuario() {
        final Usuario rs = UsuarioFixture.getUsuario();
        final Usuario rq = UsuarioFixture.getUsuarioRequest();
        final Optional<Usuario> findUserEmail = UsuarioFixture.getUsuarioOptional();
        Mockito.when(this.expresRegexProperties.getEmail()).thenReturn(
            "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Mockito.when(this.expresRegexProperties.getPassword()).thenReturn(
            "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Mockito.when(this.usuarioRepository.findByEmail("sasa@sas.cl"))
            .thenReturn(findUserEmail);
        Mockito.when(this.usuarioRepository.save(ArgumentMatchers.any(Usuario.class)))
            .thenReturn(rs);
        Assertions.assertNotNull(this.usuarioService.createUsuario(rq));
    }

    /**
     * Test.
     */
    @Test
    void testCreateUsuarioException() {
        final Usuario rq = UsuarioFixture.getUsuarioRequest();
        Mockito.when(this.usuarioRepository.save(ArgumentMatchers.any(Usuario.class)))
            .thenThrow(SimpleException.class);
        Assertions.assertThrows(SimpleException.class,
            () -> this.usuarioService.createUsuario(rq));
    }

    /**
     * Test.
     */
    @Test
    void testCreateUsuarioEmailException() {
        final Usuario rs = UsuarioFixture.getUsuario();
        final Usuario rq = UsuarioFixture.getUsuarioRequest();
        final Optional<Usuario> findUserEmail = UsuarioFixture.getUsuarioOptional();
        Mockito.when(this.expresRegexProperties.getEmail()).thenReturn(
            "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Mockito.when(this.expresRegexProperties.getPassword()).thenReturn(
            "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Mockito.when(this.usuarioRepository.findByEmail(ArgumentMatchers.anyString()))
            .thenReturn(findUserEmail);
        Mockito.when(this.usuarioRepository.save(ArgumentMatchers.any(Usuario.class)))
            .thenReturn(rs);
        Assertions.assertThrows(SimpleException.class,
            () -> this.usuarioService.createUsuario(rq));
    }

}
