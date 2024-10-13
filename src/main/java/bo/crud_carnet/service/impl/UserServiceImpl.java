package bo.crud_carnet.service.impl;

import bo.crud_carnet.domain.User;
import bo.crud_carnet.exception.UserNotFoundException;
import bo.crud_carnet.repository.IUserRepository;
import bo.crud_carnet.service.IUserService;
import bo.crud_carnet.shared.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User createUser(User user) throws UserNotFoundException {
        return userRepository.save(user);

    }

    @Override
    public User getByUserId(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User getByUserName(String name) throws UserNotFoundException {
        return userRepository.findByName(name);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers()throws UserNotFoundException {
        return userRepository.findAll();
    }

    @Override
    public void deleteByUserId(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.deleteById(user.getId());
    }
}
