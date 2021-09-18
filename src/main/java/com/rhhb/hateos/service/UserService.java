package com.rhhb.hateos.service;

import com.rhhb.hateos.dto.UserDTO;
import com.rhhb.hateos.entity.User;
import com.rhhb.hateos.util.DTOMapper;
import com.rhhb.hateos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO insertUser(UserDTO userDto) {
        var user = DTOMapper.map(userDto, User.class);
        user = this.userRepository.save(user);
        return DTOMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> findAll() {
        return this.userRepository.findAll().stream()
                .map(user -> DTOMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO findUserById(Long id) {
        return this.userRepository.findById(id).map(user -> DTOMapper.map(user, UserDTO.class))
                .orElse(new UserDTO());
    }

    public void updateUser(UserDTO userDto, Long id) {
        var user = DTOMapper.map(userDto, User.class);
        user.setId(id);
        this.userRepository.save(user);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    public void deleteUser(Long id) {
        var userDTO = this.findUserById(id);
        var user = DTOMapper.map(userDTO, User.class);
        this.userRepository.delete(user);
    }
}
