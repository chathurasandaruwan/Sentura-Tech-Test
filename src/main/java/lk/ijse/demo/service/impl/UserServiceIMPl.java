package lk.ijse.demo.service.impl;

import lk.ijse.demo.dto.UserDTO;
import lk.ijse.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceIMPl implements UserService {
    @Value("${api_key}")
    private String apiKey;
    private final OkHttpClient client;

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return false;
    }
}
