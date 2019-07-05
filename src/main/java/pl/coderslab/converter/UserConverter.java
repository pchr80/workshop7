package pl.coderslab.converter;


import org.hibernate.engine.config.spi.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import java.awt.print.Book;

public class UserConverter implements Converter<String, User> {

    @Autowired
    UserRepository userRepository;

    public User convert(String source) {
        return userRepository.findFirstById(Long.valueOf(source));
    }

}
