//package com.camavilca.model.security.request;
//
//import java.util.Collection;
//import java.util.Objects;
//import java.util.Set;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class UserPrinciple implements UserDetails {
//
//    private static final long serialVersionUID = 1L;
//
//    private Long id;
//    private String name;
//    private String username;
//    private String email;
//    private String password;
//    private Set<String> role;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrinciple(Long id, String name,
//            String username, String email, String password,
//            Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.name = name;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Set<String> getRole() {
//        return role;
//    }
//
//    public void setRole(Set<String> role) {
//        this.role = role;
//    }
//
////    public static UserPrinciple build(Usuario user) {
////        List<GrantedAuthority> authorities = user.getRoles().stream().map(role
////                -> new SimpleGrantedAuthority(role.getName().name())
////        ).collect(Collectors.toList());
////
////        return new UserPrinciple(
////                user.getId(),
////                user.getName(),
////                user.getUsername(),
////                user.getEmail(),
////                user.getPassword(),
////                authorities
////        );
////    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        UserPrinciple user = (UserPrinciple) o;
//        return Objects.equals(id, user.id);
//    }
//
//}
