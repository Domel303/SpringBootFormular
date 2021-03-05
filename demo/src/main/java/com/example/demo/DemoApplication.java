package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Controller
	public class GreetingController {

		private final WebTraffic webTraffic;
		private final CounterService counterService;

		public GreetingController(WebTraffic webTraffic, CounterService counterService){
			this.webTraffic = webTraffic;
			this.counterService = counterService;
		}



		@GetMapping("/formular")
		public String greetingForm(Model model) {
			model.addAttribute("formular", new GreetingImpl());
			return "formular";
		}

		@PostMapping("/formular")
		public String greetingSubmit(@ModelAttribute GreetingImpl greeting, Model model) {
			counterService.add();
			webTraffic.add();
			model.addAttribute("formular", greeting);
			model.addAttribute("counter", counterService.getCounter());
			model.addAttribute("webTraffic", webTraffic.getTraffic());
			return "result";
		}

		/*

		private final CounterServiceImpl counterServiceImpl;

		public GreetingController(CounterServiceImpl counterServiceImpl) {
			this.counterServiceImpl = counterServiceImpl;
		}

		@RequestMapping(value = "/greeting")
		public String requestGreeting(@RequestParam(name="name", required = false,defaultValue = "World") String name, Model model){
			counterServiceImpl.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("counter", counterServiceImpl.getCounter());

			return "greeting";
		}

		@GetMapping(value = "/greeting2")
		public String requestGreeting2(@RequestParam(name="name", required = false,defaultValue = "World") String name, Model model){
			counterServiceImpl.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("counter", counterServiceImpl.getCounter());
			return "greeting";
		}
*/

	}





}
