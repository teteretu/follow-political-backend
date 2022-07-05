package com.softete.followpolitical.rest.api.Service;

import com.softete.followpolitical.rest.api.Model.UserModel;
import com.softete.followpolitical.rest.api.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void saveCorrect() {
        UserModel userModel = buildUser();
        UserModel userReturned = buildUser();
        userReturned.setId(Integer.parseInt("1"));

        when(userRepository.save(userModel)).thenReturn(userReturned);

        assertEquals(userReturned, userService.saveUser(userModel));

        verify(userRepository, times(1)).save(userModel);
    }

    private UserModel buildUser() {
        UserModel userModel = new UserModel();
        userModel.setEmail("Shalala@email.com");
        userModel.setName("Shalala");
        userModel.setPassword("ShalalaPass");

        return userModel;
    }
}