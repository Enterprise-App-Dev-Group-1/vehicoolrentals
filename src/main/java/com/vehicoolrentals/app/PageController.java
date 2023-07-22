import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The PageController class is a Spring MVC controller responsible for handling page-related requests.
 */
@Controller
public class PageController {

    /**
     * Handles the request to the root URL ("/") and returns the home page.
     *
     * @return the name of the view to render
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Handles the request to the "/search" URL and returns the rentals page.
     *
     * @return the name of the view to render
     */
    @GetMapping("/search")
    public String search() {
        return "rentals";
    }

    /**
     * Handles the request to the "/rentals" URL and returns the rentals page.
     *
     * @return the name of the view to render
     */
    @GetMapping("/rentals")
    public String rentals() {
        return "rentals";
    }

    /**
     * Handles the request to the "/profile" URL and returns the rentals page.
     *
     * @return the name of the view to render
     */
    @GetMapping("/profile")
    public String profile() {
        return "rentals";
    }

    /**
     * Handles the request to the "/profile" URL and returns the rentals page.
     *
     * @return the name of the view to render
     */
    @GetMapping("/login")
    public String login() {
        return "layout";
    }
}