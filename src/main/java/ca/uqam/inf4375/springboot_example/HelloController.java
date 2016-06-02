/*
 * Copyright 2016 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.uqam.inf4375.springboot_example;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class HelloController {

    /**
     * Runs `this.class` as a Spring application.
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
    }

    @RequestMapping("/hello")
    String sayHello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String sayPost() {
        return "POST received!";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    Map<String, Object> showPostData(@RequestBody Map<String, Object> postData) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "POST received!");
        response.put("post_data", postData);
        return response;
    }

    @RequestMapping(value = "/item/{itemId}")
    String showItemId(@PathVariable("itemId") String itemId) {
        return itemId;
    }
}
