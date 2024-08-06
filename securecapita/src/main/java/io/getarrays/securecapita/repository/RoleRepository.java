package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.Role;

import java.util.Collection;

public interface RoleRepository<T extends Role> {
    /*
     * Basic CRUD operations
     * */
    T create(T data);
    T get(Long id);
    T update(T data);
    Collection<T> list(int page, int pageSize);
    Boolean delete(Long id);

    void addRoleToUser(Long userId, String roleName);
    Role getRoleByUserId(Long userId);
    Role getRoleByEmail(String email); //email must be unique
    void updateUserRole(Long userId, String roleName);

}
