package com.cg.repositories;

import com.cg.dto.role.RoleResult;
import com.cg.repositories.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    @Query("SELECT new com.cg.dto.order.OrderCreate (" +
//            "o.id, " +
//            "o.grandTotal, " +
//            "o.userId, " +
//            "o.createdBy, " +
//            "o.address, " +
//            "o.orderStatus, " +
//            "o.createdAt " +
//            ")" +
//            "FROM Order AS o " +
//            "WHERE o.createdBy = ?1"
//    )
    Optional<Role> findRoleCodeUserById(Long id);

}
