package manage.xypx.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test")
	public void test(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("¹þ¹þ¹þ");
		resp.flushBuffer();
	}
}
