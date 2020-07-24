package br.com.abd.api.login;

import br.com.abd.api.usuario.resource.UsuarioResource;
import br.com.abd.api.usuario.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"Login"}, value = "API REST Login")
@RequestMapping(value = "/api/login")
@CrossOrigin(origins = "*")
public class LoginRestController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation(value = "Efetua login.")
    public ResponseEntity<?> login(@RequestBody UsuarioResource resource) {

        return new ResponseEntity<>(new UsuarioResource(usuarioService.login(resource.getEmail(), resource.getSenha())), HttpStatus.ACCEPTED);
    }

}