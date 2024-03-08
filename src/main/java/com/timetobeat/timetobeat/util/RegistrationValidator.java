package com.timetobeat.timetobeat.util;

import com.timetobeat.timetobeat.dto.requests.RegistrationDataDTO;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class RegistrationValidator implements Validator {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public RegistrationValidator(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDataDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationDataDTO registrationDataDTO = (RegistrationDataDTO) target;
        User user = modelMapper.map(registrationDataDTO, User.class);
        Optional<User> userEntity = usersRepository.findByEmail(user.getEmail());

        if(userEntity.isPresent()) {
            errors.rejectValue("email", "", "User with this email already exists");
        }
        userEntity = usersRepository.findUserByUsername(user.getUsername());

        if(userEntity.isPresent()) {
            errors.rejectValue("username", "", "User with this username already exists");
        }

        if(!registrationDataDTO.getPassword().equals(registrationDataDTO.getConfirmationPassword())) {
            errors.rejectValue("confirmationPassword", "", "Confirm password field does not match");
        }


    }
}
