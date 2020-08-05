package com.study.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.study.demo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationDAOService implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationDAOService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUser()
                .stream()
                .filter(applicationUser -> applicationUser.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUser() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "annasmith",
                        passwordEncoder.encode("password"),
                        STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "linda",
                        passwordEncoder.encode("password"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "tom",
                        passwordEncoder.encode("password"),
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );
        return  applicationUsers;
    }
}
