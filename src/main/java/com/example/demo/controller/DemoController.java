/**
 * 
 */
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruptam
 *
 */
@RestController
public class DemoController {

	@GetMapping(value="/hi")
	public String sendResponse() {
		return "Hello-World: Testing Poll SCM";
	}
}
