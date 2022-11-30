package com.misiontic.votaviones.securityBackend.repositories;

import com.misiontic.votaviones.securityBackend.models.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository <Permission, Integer> {
}
