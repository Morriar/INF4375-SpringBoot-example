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
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;

/**
 * ItemController provides a CRUD interface to MongoDB.
 *
 * Route: `/items`
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    /**
     * Repository used to retrieve and store albums.
     */
    @Autowired
    private ItemRepository repository;

    /**
     * Get all the items.
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Item> getItems() {
        return repository.findAll();
    }

    /**
     * Create a new item.
     */
    @RequestMapping(method = RequestMethod.POST)
    Map<String, Object> createItem(@RequestBody Map<String, Object> albumMap) {
        // FIXME input should be verified and sanitized!
        Item item = new Item(
                albumMap.get("title").toString(),
                Double.parseDouble(albumMap.get("price").toString()));

        repository.save(item);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Item created successfully");
        response.put("item", item);
        return response;
    }
}
