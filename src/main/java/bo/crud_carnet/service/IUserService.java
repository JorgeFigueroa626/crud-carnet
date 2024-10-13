package bo.crud_carnet.service;

import bo.crud_carnet.domain.User;
import bo.crud_carnet.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {

    public User createUser(User user) throws UserNotFoundException;

    public User getByUserId(Long id) throws UserNotFoundException;

    public User getByUserName(String name) throws UserNotFoundException;

    public User updateUser(User user) throws UserNotFoundException;

    public List<User> findAllUsers() throws UserNotFoundException;

    public void deleteByUserId(Long id)throws UserNotFoundException;

}
