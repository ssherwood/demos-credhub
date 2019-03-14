package io.undertree.demos.cfcredhub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CredhubController {

    @Value("${my-secrets.secret-list}")
    private String[] secrets;

    @GetMapping("/secrets")
    public String[] getSecrets() {
        return secrets;
    }

    @GetMapping("/secrets/{index}")
    public String getSecretByIndex(@PathVariable int index) {
        return secrets[index];
    }
}
