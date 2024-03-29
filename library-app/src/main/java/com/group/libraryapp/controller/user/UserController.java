package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    // private final List<User> users = new ArrayList<>();
    // private final JdbcTemplate jdbcTemplate;
    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {
        // this.jdbcTemplate = jdbcTemplate;
        // this.userServiceV1 = new UserServiceV1(jdbcTemplate);
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUserDB(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsersDB() {
        return userService.getUsers();
    }

//    @GetMapping("/user")
//    public List<UserResponse> getUsersDB() {
//        String sql = "SELECT * FROM user";
//        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//
//                return new UserResponse(id, name, age);
//            }
//        });
//    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);

    }

//    @PutMapping("/user")
//    public void updateUser(@RequestBody UserUpdateRequest request) {
//
//        String readSql = "SELECT * FROM user WHERE id = ?";
//        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
//
//        if(isUserNotExist) {
//            throw new IllegalArgumentException();
//        }
//
//        String sql = "UPDATE user SET name = ? WHERE id = ?";
//        jdbcTemplate.update(sql, request.getName(), request.getId());
//    }

//    @PutMapping("/user")
//    public void updateUser(@RequestBody UserUpdateRequest request) {
//        String sql = "UPDATE user SET name = ? WHERE id = ?";
//        jdbcTemplate.update(sql, request.getName(), request.getId());
//    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam(value="name") String name) {
        userService.deleteUser(name);
    }

//    @DeleteMapping("/user")
//    public void deleteUser(@RequestParam(value="name") String name) {
//
//        String readSql = "SELECT * FROM user WHERE name = ?";
//        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
//
//        if(isUserNotExist) {
//            throw new IllegalArgumentException();
//        }
//
//        String sql = "DELETE FROM user WHERE name = ?";
//        jdbcTemplate.update(sql, name);
//    }




//    @PostMapping("/user")
//    public void saveUserList(@RequestBody UserCreateRequest request) {
//        users.add(new User(request.getName(), request.getAge()));
//    }
//
//    @GetMapping("/fruit")
//    public Fruit fruit() {
//        return new Fruit("바나나", 3000);
//    }
//
//    @GetMapping("/user")
//    public List<UserResponse> getUsersList() {
//        List<UserResponse> responses = new ArrayList<>();
//
//        for (int i = 0; i < users.size(); i++) {
//            // responses.add(new UserResponse(i + 1, users.get(i).getName(), users.get(i).getAge()));
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//
//        return responses;
//    }
}
