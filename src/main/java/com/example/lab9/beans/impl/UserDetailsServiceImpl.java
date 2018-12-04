package com.example.lab9.beans.impl;

import com.example.lab9.model.ApplicationUser;
import com.example.lab9.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> applicationUser = applicationUserRepository.findById(username);
        if (!applicationUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.get().getUsername(), applicationUser.get().getPassword(), emptyList());
    }
}