package com.timetobeat.timetobeat.services.serviceImpls;

import com.timetobeat.timetobeat.exceptions.UserNotExistsException;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import com.timetobeat.timetobeat.repositories.UsersRepository;
import com.timetobeat.timetobeat.security.UserDetailsImpl;
import com.timetobeat.timetobeat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UsersRepository usersRepository;
    private final GamesRepository gamesRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, GamesRepository gamesRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.gamesRepository = gamesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUser(String username) {
        Optional<User> user = usersRepository.getUserByUsername(username);

        if(user.isPresent()) {
            List<Game> gameList = gamesRepository.findByUsername(username);
            user.get().setGames(gameList);
        } else {
            throw new NoSuchElementException();
        }

        return user.get();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.getUserByUsername(username);

        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserDetailsImpl(user.get());
    }
}
