package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.User;

import java.util.Collection;

public interface UserRepository<T extends User> {
    /*
    * Basic CRUD operations
    * */

    T create(T data);
    T get(Long id);
    T update(T data);
    Collection<T> list(int page, int pageSize);
    Boolean delete(Long id);
}
