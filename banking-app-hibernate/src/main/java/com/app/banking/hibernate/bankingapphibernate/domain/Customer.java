package com.app.banking.hibernate.bankingapphibernate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends AbstractEntity {

  @Column(name = "name")
 private String name;
  @Column(name = "email")
 private String email;
  @Column(name = "age")
 private Integer age;
  @ManyToMany(fetch = FetchType.EAGER)
  private List<Employer> employers;
  @OneToMany(mappedBy = "customer")
  private Set<Account> accounts = new LinkedHashSet<>();


  @Override
  public String toString() {
    return "Customer{" +
      "id=" + this.getId() +
      ", name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", age=" + age +
      ", employers=" + employers +
      ", accounts=" + accounts +
      '}';
  }
}
