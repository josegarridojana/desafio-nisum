/*
 * @(#)UsuarioFixture.java
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
package com.nisum.ms.fixture;

import com.nisum.ms.entities.Phone;
import com.nisum.ms.entities.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * UsuarioFixture.
 *
 * @author Jose.
 * @version 1.0.0
 */
public class UsuarioFixture {

    /**
     * Genera un Objeto de usuarios para probar service.
     *
     * @return {@link Usuario}
     */
    public static Usuario getUsuario() {
        final Usuario usuario = new Usuario();
        usuario.setName("Juan Rodriguez");
        usuario.setEmail("juan@rodriguez2.org");
        usuario.setPassword("hunter288");
        usuario.setActive(true);
        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(new Date());
        usuario.setToken(UUID.randomUUID());
        final List<Phone> phones = UsuarioFixture.getPhones();
        usuario.setPhones(phones);
        return usuario;
    }

    /**
     * Genera un Objeto Optional de usuarios para probar service.
     *
     * @return {@link Usuario}
     */
    public static Optional<Usuario> getUsuarioOptional() {
        final Usuario usuario = new Usuario();
        usuario.setName("Juan Rodriguez");
        usuario.setEmail("juan@rodriguez2.org");
        usuario.setPassword("hunter288");
        usuario.setActive(true);
        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(new Date());
        usuario.setToken(UUID.randomUUID());
        final List<Phone> phones = UsuarioFixture.getPhones();
        usuario.setPhones(phones);
        return Optional.of(usuario);
    }

    /**
     * Genera un Objeto de usuarios para probar service de solicitud.
     *
     * @return {@link Usuario}
     */
    public static Usuario getUsuarioRequest() {
        final Usuario usuario = new Usuario();
        usuario.setName("Juan Rodriguez");
        usuario.setEmail("juan@rodriguez2.org");
        usuario.setPassword("hunter288");
        final List<Phone> phones = UsuarioFixture.getPhones();
        usuario.setPhones(phones);
        return usuario;
    }


    /**
     * Genera una lista de usuarios para probar service.
     *
     * @return {@link Usuario}
     */
    public static List<Usuario> getUsuarios() {
        final List<Usuario> usuarios = new ArrayList<>();
        final Usuario usuario = new Usuario();
        usuario.setName("Juan Rodriguez");
        usuario.setEmail("juan@rodriguez2.org");
        usuario.setPassword("hunter288");
        usuario.setActive(true);
        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(new Date());
        usuario.setToken(UUID.randomUUID());
        final List<Phone> phones = UsuarioFixture.getPhones();
        usuario.setPhones(phones);
        usuarios.add(usuario);
        return usuarios;
    }

    /**
     * Genera una lista de telefonos para probar service.
     *
     * @return {@link Phone}
     */
    public static List<Phone> getPhones() {
        final List<Phone> phones = new ArrayList<>();
        final Phone phone = new Phone();
        phone.setCityCode("1");
        phone.setContryCode("1");
        phone.setContryCode("12");
        phone.setNumber("1212");
        phones.add(phone);
        return phones;
    }

}
