package br.com.abd.api.usuario.controller;

import br.com.abd.api.usuario.resource.UsuarioResource;
import br.com.abd.api.usuario.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"Usuarios"}, value = "API REST Usuarios")
@RequestMapping(value = "/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation(value = "Registra um usuário.")
    public ResponseEntity<?> save(@RequestBody UsuarioResource resource) {

        // Ignore the id
        if (resource.getId() != null) {
            resource.setId(null);
        }

        return new ResponseEntity<>(new UsuarioResource(this.usuarioService.saveOrUpdate(resource.toEntity())), HttpStatus.CREATED);
    }
}
