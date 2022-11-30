package com.misiontic.votaviones.securityBackend.repositories;

import com.misiontic.votaviones.securityBackend.models.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository <Rol, Integer> {
}
