package com.user.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * @author Thangamudy Gurusamy
 * Date : 15/04/24
 * Package : com.user.model
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Users")
public class UserDetails {

    @Id
    private UUID userId;
    private String loginId;
    private String password;
    private String securityRole;
    private String firstName;
    private String lastName;
    private String emailAddress;
}
