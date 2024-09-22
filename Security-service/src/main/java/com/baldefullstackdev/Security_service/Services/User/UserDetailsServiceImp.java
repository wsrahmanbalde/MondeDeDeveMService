package com.baldefullstackdev.Security_service.Services.User;

import com.baldefullstackdev.Security_service.Models.User.User;
import com.baldefullstackdev.Security_service.Repositories.User.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    public User findByUsername(String email){return repository.findByEmail(email)
            .orElseThrow(()-> new UsernameNotFoundException("User not found"));}
}
