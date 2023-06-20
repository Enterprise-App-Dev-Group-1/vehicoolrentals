import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/search")
    public String search() {
        return "rentals";
    }

    @GetMapping("/rentals")
    public String rentals() {
        return "rentals";
    }

    @GetMapping("/profile")
    public String profile() {
        return "rentals";
    }
}