/*
 * Copyright 2017-Present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 package cook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableOAuth2Client
public class Application {

    @Autowired
    private Menu menu;

    @RequestMapping("/restaurant")
    public String restaurant() {
      return String.format("Today's special is: %s<br/>And recipe is: %s", menu.getSpecial(), menu.getPlainRecipeText());
    }

    @RequestMapping("/restaurant/secret-menu")
    public String secretMenu() {
      return menu.getSecretMenu();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
