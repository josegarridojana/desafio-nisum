/*
 * @(#)UsuarioController.java
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
package com.nisum.ms.controllers;

import com.nisum.ms.entities.Usuario;
import com.nisum.ms.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UsuarioController.
 *
 * @author Jose.
 * @version 1.0.0
 */
@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    /** usuarioService. */
    @Autowired
    UsuarioService usuarioService;

    @ApiOperation(value = "Listar todos los usuarios", produces = "application/json")
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return this.usuarioService.getAllUsuarios();
    }

    @ApiOperation(value = "Listar todos los usuarios por nombre", produces = "application/json")
    @GetMapping("/por-nombre")
    public List<Usuario> getAllUsuariosByName(@RequestParam(required = false) final String nombre) {
        return this.usuarioService.getAllUsuariosByName(nombre);
    }

    @ApiOperation(value = "Listar por idientificador", produces = "application/json")
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable("id") final long id) {
        return this.usuarioService.getUsuarioById(id);
    }

    @ApiOperation(value = "Guardar", produces = "application/json")
    @PostMapping
    public Usuario createUsuario(@RequestBody final Usuario usuario) {
        return this.usuarioService.createUsuario(usuario);
    }

    @ApiOperation(value = "Actualizar", produces = "application/json")
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable("id") final long id,
        @RequestBody final Usuario usuario) {
        return this.usuarioService.updateUsuario(id, usuario);
    }

    @ApiOperation(value = "Eliminar", produces = "application/json")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id") final long id) {
        return this.usuarioService.deleteUsuario(id);
    }

    @ApiOperation(value = "eliminar todos", produces = "application/json")
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllUsuarios() {
        return this.usuarioService.deleteAllUsuarios();
    }

    @ApiOperation(value = "Listar por usuarios activos", produces = "application/json")
    @GetMapping("/activos")
    public List<Usuario> findByIsActive() {
        return this.usuarioService.findByIsActive();
    }

}
