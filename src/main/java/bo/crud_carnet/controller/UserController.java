package bo.crud_carnet.controller;

import bo.crud_carnet.domain.User;
import bo.crud_carnet.exception.UserNotFoundException;
import bo.crud_carnet.service.IUserService;
import bo.crud_carnet.shared.JsonResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public JsonResult createUser(@Valid @RequestBody User user){
        userService.createUser(user);
        return new JsonResult(true, null, "Usuario creado exitosamente.");
    }

    @GetMapping("/{userId}")
    public User getByUserId(@PathVariable Long userId) throws UserNotFoundException {
        return userService.getByUserId(userId);
    }

    @GetMapping("/search/{name}")
    public User getByUserId(@PathVariable String name) throws UserNotFoundException {
        return userService.getByUserName(name);
    }

    @GetMapping
    public List<User> findAllUser(){
        return userService.findAllUsers();
    }

    @PutMapping
    public JsonResult updateUser(@Valid @RequestBody User user) throws UserNotFoundException{
        User response = userService.updateUser(user);
        return new JsonResult(true, response, "Usuario actualizado exitosamente.");
    }

    @DeleteMapping("/{userId}")
    public JsonResult deleteByUserId(@PathVariable Long userId) throws UserNotFoundException{
        userService.deleteByUserId(userId);
        return new JsonResult(true, null, "Usuario eliminado correctamente.");
    }
}
