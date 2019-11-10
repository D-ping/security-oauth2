package com.daiyuchuan.security.distributed.uaa.model;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class UserDo implements UserDetails,Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private Byte gender;
    @Column(name = "gmtCreate")
    @CreationTimestamp
    private Date gmtCreate;
    @Column(name = "gmtModified")
    @UpdateTimestamp
    private Date gmtModified;
    @Column(name = "isDelete")
    private Byte isDelete;


    @PreUpdate
    protected void onUpdate() {
        gmtModified = new Date();
    }

    // 以下是 security 需要的实现
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

    // 账户是否过期,过期无法验证
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    // 指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    // 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    // 是否被禁用,禁用的用户不能身份验证
    @Override
    public boolean isEnabled() {
        return false;
    }


}
