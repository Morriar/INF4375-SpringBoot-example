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

import org.springframework.data.annotation.Id;

/**
 * Item representation that can be stored in an Repository.
 */
public class Item {

    /**
     * Primary key used by the Repository.
     */
    @Id
    private String id;

    private String title;
    private Double price;

    public Item() {
    }

    /**
     * The constructor does not accept id, we let the repository generate it.
     *
     * @param title
     * @param price
     */
    public Item(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Item[id=%s, title=%s, price=%f]",
                id, title, price);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
