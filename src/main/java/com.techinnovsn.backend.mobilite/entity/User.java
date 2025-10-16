
package com.techinnovsn.backend.mobilite.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.techinnovsn.backend.mobilite.entity.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO incrément
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true, nullable = false)
    private String telephone;

    @CreationTimestamp
    private LocalDateTime dateInscription;

    @Column(unique = true)
    private String numeroDePermis;

    private String dateExpirationDuPermis;

    @Enumerated(EnumType.STRING)
    private Role role;


    private String password;


}
