package com.baldefullstackdev.Security_service.Models.Token;

import com.baldefullstackdev.Security_service.Models.User.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "token")
@Data
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "is_logged_out")
    private boolean loggedOut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
