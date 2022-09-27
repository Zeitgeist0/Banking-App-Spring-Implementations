package com.bankingappfinal.resource;

import com.bankingappfinal.dao.RoleJpaRepository;
import com.bankingappfinal.dao.UserJpaRepository;
import com.bankingappfinal.domain.SysRole;
import com.bankingappfinal.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
public class UsersAndRolesGenerator {
@Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  private UserJpaRepository userJpaRepository;
@Autowired
private   RoleJpaRepository roleJpaRepository;
  @PostConstruct
  public void init() {
    SysRole userRole = new SysRole();
    SysRole adminRole = new SysRole();
    userRole.setName("USER");
    adminRole.setName("ADMIN");
 roleJpaRepository.saveAll(List.of(userRole, adminRole));

 SysUser regularUser = new SysUser();
 SysUser adminUser = new SysUser();

 regularUser.setName("u");
 regularUser.setEnabled(true);
 regularUser.setPassword(passwordEncoder.encode("u"));
 regularUser.setSysRoles(Set.of(userRole));

   adminUser.setName("a");
   adminUser.setEnabled(true);
   adminUser.setPassword(passwordEncoder.encode("a"));
   adminUser.setSysRoles(Set.of(userRole , adminRole));
userJpaRepository.saveAll(List.of(regularUser,adminUser));
  }
}
