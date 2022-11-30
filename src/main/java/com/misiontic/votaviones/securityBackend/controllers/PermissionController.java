package com.misiontic.votaviones.securityBackend.controllers;


import com.misiontic.votaviones.securityBackend.models.Permission;
import com.misiontic.votaviones.securityBackend.services.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionServices permissionServices;

    @GetMapping("/all")
    public List <Permission> getAllPermissions() {
        return this.permissionServices.index();
    }

    @GetMapping("/{id}")
    public Optional <Permission> getPermissionById(@PathVariable("id") int id) {
        return this.permissionServices.show(id);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Permission insertPermission(@RequestBody Permission permission) {
        return this.permissionServices.create(permission);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Permission updatePermission(@PathVariable("id") int id, @RequestBody Permission permission) {
        return this.permissionServices.update(id, permission);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deletePermission(@PathVariable("id") int id) {
        return this.permissionServices.delete(id);
    }
}