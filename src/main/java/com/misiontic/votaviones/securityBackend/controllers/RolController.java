package com.misiontic.votaviones.securityBackend.controllers;

import com.misiontic.votaviones.securityBackend.models.Permission;
import com.misiontic.votaviones.securityBackend.models.Rol;
import com.misiontic.votaviones.securityBackend.services.RolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolServices rolServices;

    @GetMapping("/all")
    public List<Rol> getAllRoles() {
        return this.rolServices.index();
    }

    @GetMapping("/{id}")
    public Optional<Rol> getRolById(@PathVariable("id") int id) {
        return this.rolServices.show(id);
    }

    @GetMapping("/validate/{idRol}")
    public ResponseEntity <Boolean> validatePermission(@PathVariable("idRol") int idRol, @RequestBody
        Permission permission) {
        return this.rolServices.validateGrant(idRol, permission);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol insertRol(@RequestBody Rol rol) {
        return this.rolServices.create(rol);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol updateRol(@PathVariable("id") int id, @RequestBody Rol rol) {
        return this.rolServices.update(id, rol);
    }

    @PutMapping("/update/{idRol}/add_permission/{idPermission}")
    public ResponseEntity <Rol> updateRolAddPermission(@PathVariable("idRol") int idRol, @PathVariable("idPermission")
        int idPermission){
        return  this.rolServices.updatedRolAddPermission(idRol, idPermission);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteRol(@PathVariable("id") int id) {
        return this.rolServices.delete(id);
    }
}