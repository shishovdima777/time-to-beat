package com.timetobeat.timetobeat.services.serviceImpls;

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

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UsersRepository usersRepository;
    private final GamesRepository gamesRepository;
    private final UserDetailsImpl userDetails;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, GamesRepository gamesRepository, UserDetailsImpl userDetails, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.gamesRepository = gamesRepository;
        this.userDetails = userDetails;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUser(String username) {
        List<Game> gameList = gamesRepository.findByUsername(username);
        User user = usersRepository.getUserByUsername(username);
        user.setGames(gameList);
        return usersRepository.getUserByUsername(user.getUsername());
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
        User user = usersRepository.getUserByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserDetailsImpl(user);
    }
}
