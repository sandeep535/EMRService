package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "invalidated_tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidatedTokenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 512)
    private String token;

    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiry;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "logout_time")
    private Date logoutTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Date getExpiry() { return expiry; }
    public void setExpiry(Date expiry) { this.expiry = expiry; }

    public Date getLogoutTime() { return logoutTime; }
    public void setLogoutTime(Date logoutTime) { this.logoutTime = logoutTime; }
}
