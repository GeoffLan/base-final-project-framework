package ac.jiu.bobby.project.security;

import ac.jiu.bobby.project.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Mengambil role dari user dan mengubahnya menjadi SimpleGrantedAuthority
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // Mengambil password yang sudah terenkripsi
    }

    @Override
    public String getUsername() {
        return user.getFirstName(); // Atau username dari user
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Kita tidak menangani masa expired account
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Kita anggap user tidak terkunci
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Kita anggap kredensial user tidak kadaluarsa
    }

    @Override
    public boolean isEnabled() {
        return !user.isDeleted(); // Jika user dihapus, berarti tidak aktif
    }

    public User getUser() {
        return user; // Memberikan akses ke objek User
    }
}
