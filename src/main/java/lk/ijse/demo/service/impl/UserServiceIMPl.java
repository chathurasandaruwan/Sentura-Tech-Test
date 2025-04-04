package lk.ijse.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.demo.dto.UserDTO;
import lk.ijse.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserServiceIMPl implements UserService {
    @Value("${api_key}")
    private String apiKey;
    private final OkHttpClient client;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean saveUser(UserDTO userDTO) {
        try {
            String jBody = objectMapper.writeValueAsString(userDTO);
            RequestBody body = RequestBody.create(jBody, MediaType.get("application/json"));
            Request request = new Request.Builder()
                    .url("https://8015b5dbc0724d38882ac90397c27649.weavy.io")
                    .post(body)
                    .addHeader("Authorization", "Bearer " + apiKey)
                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();

            return response.isSuccessful();


        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
