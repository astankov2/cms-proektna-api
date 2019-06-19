package mk.ukim.finki.wp.cmsproektnaapi.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(value = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping(value = "/")
public class MainResource {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void main() {
    }

    @GetMapping(value = "/error/")
    @ResponseBody
    public String error() {
        return "Access denied";
    }
}
