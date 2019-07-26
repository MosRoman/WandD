package com.gmail.morovo1988.projectShop.repositories;

import com.gmail.morovo1988.projectShop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(String name);
}
