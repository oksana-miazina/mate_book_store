<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/6295/6295417.png" width="100" />
</p>
<p align="center">
    <h1 align="center">MATE BOOK STORE</h1>
</p>

<p align="center">
	<img src="https://img.shields.io/github/license/oksana-miazina/mate_book_store?style=flat&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/oksana-miazina/mate_book_store?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/oksana-miazina/mate_book_store?style=flat&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/oksana-miazina/mate_book_store?style=flat&color=0080ff" alt="repo-language-count">
<p>
<p align="center">
		<em>Developed with the software and tools below.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/YAML-CB171E.svg?style=flat&logo=YAML&logoColor=white" alt="YAML">
	<img src="https://img.shields.io/badge/GitHub%20Actions-2088FF.svg?style=flat&logo=GitHub-Actions&logoColor=white" alt="GitHub%20Actions">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">
	<img src="https://img.shields.io/badge/Spring-000000.svg?style=flat&logo=Spring&logoColor=white" alt="Spring">
</p>
<hr>

##  Quick Links

> - [ Overview](#-overview)
> - [ Features](#-features)
> - [ Repository Structure](#-repository-structure)
> - [ Modules](#-modules)
> - [ Getting Started](#-getting-started)
    >   - [ Installation](#-installation)
>   - [ Running mate_book_store](#-running-mate_book_store)
>   - [ Tests](#-tests)
> - [ Project Roadmap](#-project-roadmap)
> - [ Contributing](#-contributing)
> - [ License](#-license)
> - [ Acknowledgments](#-acknowledgments)

---

##  Overview

Mate Book Store is a Java-based book store management system designed to simplify inventory, sales, and customer data management. It offers features such as inventory tracking, sales monitoring, customer data handling, and sales report generation. Built with standard coding practices, it ensures reliability and maintainability for efficient bookstore operations. Users can easily set up, build, and run the application to streamline their bookstore management tasks.

---

##  Features

- **Inventory Management**: Easily add, update, and remove books from the inventory.
- **Customer Data Handling**: Maintain comprehensive records of customer information and purchase history.
- **User Authorization**: Secure login system with role-based access control for administrators, managers, and staff.
- **User-Friendly Interface**: Intuitive and easy-to-navigate user interface for efficient bookstore management.
- **Scalability**: Designed to handle bookstores of all sizes, from small shops to large chains.

---

##  Repository Structure

```sh
└── mate_book_store/
    ├── .github
    │   └── workflows
    │       └── ci.yml
    ├── checkstyle.xml
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── mate
        │   │       └── academy
        │   └── resources
        │       ├── application.properties
        │       ├── data
        │       │   ├── books-categories.csv
        │       │   ├── books.csv
        │       │   └── categories.csv
        │       ├── db
        │       │   └── changelog
        │       ├── messages.properties
        │       └── messages_uk.properties
        └── test
            ├── java
            │   └── mate
            │       └── academy
            └── resources
                └── application.properties
```

---

##  Modules

<details closed><summary>.</summary>

| File                                                                             | Summary          |
| ---                                                                              |------------------|
| [pom.xml](https://github.com/oksana-miazina/mate_book_store/blob/master/pom.xml) | some description |

</details>

<details closed><summary>.github.workflows</summary>

| File                                                                                             | Summary                                              |
| ---                                                                                              | ---                                                  |
| [ci.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/.github/workflows/ci.yml) | some description |

</details>

<details closed><summary>src.main.resources.db.changelog</summary>

| File                                                                                                                                               | Summary                                                                              |
| ---                                                                                                                                                | ---                                                                                  |
| [db.changelog-master.yaml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/db.changelog-master.yaml) | some description |

</details>

<details closed><summary>src.main.resources.db.changelog.changes</summary>

| File                                                                                                                                                                               | Summary                                                                                                  |
| ---                                                                                                                                                                                | ---                                                                                                      |
| [11-create-books-categories-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/11-create-books-categories-table.yml) | some description |
| [10-loaddata-categories.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/10-loaddata-categories.yml)                     | some description           |
| [13-create-shopping-carts-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/13-create-shopping-carts-table.yml)     | some description   |
| [04-create-users-roles-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/04-create-users-roles-table.yml)           | some description      |
| [01-create-books-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/01-create-books-table.yml)                       | some description            |
| [07-insert-roles-to-users.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/07-insert-roles-to-users.yml)                 | some description         |
| [06-insert-roles.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/06-insert-roles.yml)                                   | some description                  |
| [14-create-cart-items-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/14-create-cart-items-table.yml)             | some description       |
| [02-create-users-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/02-create-users-table.yml)                       | some description            |
| [16-create-orders-items-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/16-create-orders-items-table.yml)         | some description     |
| [15-create-orders-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/15-create-orders-table.yml)                     | some description           |
| [12-loaddata-books-categories.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/12-loaddata-books-categories.yml)         | some description     |
| [03-create-roles-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/03-create-roles-table.yml)                       | some description            |
| [05-insert-users.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/05-insert-users.yml)                                   | some description                  |
| [08-loaddata-books.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/08-loaddata-books.yml)                               | some description               |
| [09-create-categories-table.yml](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/resources/db/changelog/changes/09-create-categories-table.yml)             | some description       |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore</summary>

| File                                                                                                                                                      | Summary                                                                                    |
| ---                                                                                                                                                       | ---                                                                                        |
| [BookStoreApplication.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/BookStoreApplication.java) | some description |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.response</summary>

| File                                                                                                                                                     | Summary                                                                                        |
| ---                                                                                                                                                      | ---                                                                                            |
| [ResponseHandler.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/response/ResponseHandler.java) | some description |
| [GeneralResponse.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/response/GeneralResponse.java) | some description |
| [ErrorResponse.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/response/ErrorResponse.java)     | some description   |
| [SuccessResponse.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/response/SuccessResponse.java) | some description |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.validator</summary>

| File                                                                                                                                                              | Summary                                                                                             |
| ---                                                                                                                                                               | ---                                                                                                 |
| [FieldMatch.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/validator/FieldMatch.java)                   | some description          |
| [FieldMatchValidator.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/validator/FieldMatchValidator.java) | some description |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.repository</summary>

| File                                                                                                                                                                     | Summary                                                                                                 |
| ---                                                                                                                                                                      | ---                                                                                                     |
| [RoleRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/RoleRepository.java)                 | some description         |
| [OrderItemRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/OrderItemRepository.java)       | some description    |
| [CartItemRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/CartItemRepository.java)         | some description     |
| [BookRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/BookRepository.java)                 | some description `src/main/java/mate/academy/bookstore/repository/BookRepository.java`         |
| [UserRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/UserRepository.java)                 | some description `src/main/java/mate/academy/bookstore/repository/UserRepository.java`         |
| [CategoryRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/CategoryRepository.java)         | some description `src/main/java/mate/academy/bookstore/repository/CategoryRepository.java`     |
| [ShoppingCartRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/ShoppingCartRepository.java) | some description `src/main/java/mate/academy/bookstore/repository/ShoppingCartRepository.java` |
| [OrderRepository.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/repository/OrderRepository.java)               | some description `src/main/java/mate/academy/bookstore/repository/OrderRepository.java`        |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.controller</summary>

| File                                                                                                                                                                         | Summary                                                                                                   |
| ---                                                                                                                                                                          | ---                                                                                                       |
| [BookController.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/controller/BookController.java)                     | some description `src/main/java/mate/academy/bookstore/controller/BookController.java`           |
| [AuthenticationController.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/controller/AuthenticationController.java) | some description `src/main/java/mate/academy/bookstore/controller/AuthenticationController.java` |
| [ShoppingCartController.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/controller/ShoppingCartController.java)     | some description `src/main/java/mate/academy/bookstore/controller/ShoppingCartController.java`   |
| [OrderController.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/controller/OrderController.java)                   | some description `src/main/java/mate/academy/bookstore/controller/OrderController.java`          |
| [CategoryController.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/controller/CategoryController.java)             | some description `src/main/java/mate/academy/bookstore/controller/CategoryController.java`       |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.dto</summary>

| File                                                                                                                                                                      | Summary                                                                                              |
| ---                                                                                                                                                                       | ---                                                                                                  |
| [UserLoginResponseDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/UserLoginResponseDto.java)             | some description `src/main/java/mate/academy/bookstore/dto/UserLoginResponseDto.java`       |
| [UserRegistrationRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/UserRegistrationRequestDto.java) | some description `src/main/java/mate/academy/bookstore/dto/UserRegistrationRequestDto.java` |
| [ShoppingCartRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/ShoppingCartRequestDto.java)         | some description `src/main/java/mate/academy/bookstore/dto/ShoppingCartRequestDto.java`     |
| [CategoryDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/CategoryDto.java)                               | some description `src/main/java/mate/academy/bookstore/dto/CategoryDto.java`                |
| [ShoppingCartDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/ShoppingCartDto.java)                       | some description `src/main/java/mate/academy/bookstore/dto/ShoppingCartDto.java`            |
| [OrderUpdateRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/OrderUpdateRequestDto.java)           | some description `src/main/java/mate/academy/bookstore/dto/OrderUpdateRequestDto.java`      |
| [OrderItemDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/OrderItemDto.java)                             | some description `src/main/java/mate/academy/bookstore/dto/OrderItemDto.java`               |
| [UserLoginRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/UserLoginRequestDto.java)               | some description `src/main/java/mate/academy/bookstore/dto/UserLoginRequestDto.java`        |
| [CartItemResponseDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/CartItemResponseDto.java)               | some description `src/main/java/mate/academy/bookstore/dto/CartItemResponseDto.java`        |
| [OrderCreateRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/OrderCreateRequestDto.java)           | some description `src/main/java/mate/academy/bookstore/dto/OrderCreateRequestDto.java`      |
| [CartItemRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/CartItemRequestDto.java)                 | some description `src/main/java/mate/academy/bookstore/dto/CartItemRequestDto.java`         |
| [CategoryRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/CategoryRequestDto.java)                 | some description `src/main/java/mate/academy/bookstore/dto/CategoryRequestDto.java`         |
| [BookDtoWithoutCategoryIds.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/BookDtoWithoutCategoryIds.java)   | some description `src/main/java/mate/academy/bookstore/dto/BookDtoWithoutCategoryIds.java`  |
| [BookRequestDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/BookRequestDto.java)                         | some description `src/main/java/mate/academy/bookstore/dto/BookRequestDto.java`             |
| [UserResponseDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/UserResponseDto.java)                       | some description `src/main/java/mate/academy/bookstore/dto/UserResponseDto.java`            |
| [BookDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/BookDto.java)                                       | some description `src/main/java/mate/academy/bookstore/dto/BookDto.java`                    |
| [OrderDto.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/dto/OrderDto.java)                                     | some description `src/main/java/mate/academy/bookstore/dto/OrderDto.java`                   |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.model</summary>

| File                                                                                                                                            | Summary                                                                                  |
| ---                                                                                                                                             | ---                                                                                      |
| [Category.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/Category.java)         | some description `src/main/java/mate/academy/bookstore/model/Category.java`     |
| [OrderItem.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/OrderItem.java)       | some description `src/main/java/mate/academy/bookstore/model/OrderItem.java`    |
| [ShoppingCart.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/ShoppingCart.java) | some description `src/main/java/mate/academy/bookstore/model/ShoppingCart.java` |
| [CartItem.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/CartItem.java)         | some description `src/main/java/mate/academy/bookstore/model/CartItem.java`     |
| [Order.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/Order.java)               | some description `src/main/java/mate/academy/bookstore/model/Order.java`        |
| [CartItemKey.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/CartItemKey.java)   | some description `src/main/java/mate/academy/bookstore/model/CartItemKey.java`  |
| [Role.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/Role.java)                 | some description `src/main/java/mate/academy/bookstore/model/Role.java`         |
| [Book.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/Book.java)                 | some description `src/main/java/mate/academy/bookstore/model/Book.java`         |
| [User.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/model/User.java)                 | some description `src/main/java/mate/academy/bookstore/model/User.java`         |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.config</summary>

| File                                                                                                                                                 | Summary                                                                                     |
| ---                                                                                                                                                  | ---                                                                                         |
| [MapperConfig.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/config/MapperConfig.java)     | some description `src/main/java/mate/academy/bookstore/config/MapperConfig.java`   |
| [SecurityConfig.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/config/SecurityConfig.java) | some description `src/main/java/mate/academy/bookstore/config/SecurityConfig.java` |
| [I18nConfig.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/config/I18nConfig.java)         | some description `src/main/java/mate/academy/bookstore/config/I18nConfig.java`     |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.service</summary>

| File                                                                                                                                                            | Summary                                                                                           |
| ---                                                                                                                                                             | ---                                                                                               |
| [OrderService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/OrderService.java)               | some description `src/main/java/mate/academy/bookstore/service/OrderService.java`        |
| [CategoryService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/CategoryService.java)         | some description `src/main/java/mate/academy/bookstore/service/CategoryService.java`     |
| [ShoppingCartService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/ShoppingCartService.java) | some description `src/main/java/mate/academy/bookstore/service/ShoppingCartService.java` |
| [LocaleService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/LocaleService.java)             | some description `src/main/java/mate/academy/bookstore/service/LocaleService.java`       |
| [UserService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/UserService.java)                 | some description `src/main/java/mate/academy/bookstore/service/UserService.java`         |
| [BookService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/BookService.java)                 | some description `src/main/java/mate/academy/bookstore/service/BookService.java`         |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.service.impl</summary>

| File                                                                                                                                                                               | Summary                                                                                                       |
| ---                                                                                                                                                                                | ---                                                                                                           |
| [SecurityUserDetailsService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/impl/SecurityUserDetailsService.java) | some description `src/main/java/mate/academy/bookstore/service/impl/SecurityUserDetailsService.java` |
| [CategoryServiceImpl.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/impl/CategoryServiceImpl.java)               | some description `src/main/java/mate/academy/bookstore/service/impl/CategoryServiceImpl.java`        |
| [BookServiceImpl.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/impl/BookServiceImpl.java)                       | some description `src/main/java/mate/academy/bookstore/service/impl/BookServiceImpl.java`            |
| [ShoppingCartServiceImpl.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/impl/ShoppingCartServiceImpl.java)       | some description `src/main/java/mate/academy/bookstore/service/impl/ShoppingCartServiceImpl.java`    |
| [LocaleServiceImpl.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/impl/LocaleServiceImpl.java)                   | some description `src/main/java/mate/academy/bookstore/service/impl/LocaleServiceImpl.java`          |
| [UserServiceImpl.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/impl/UserServiceImpl.java)                       | some description `src/main/java/mate/academy/bookstore/service/impl/UserServiceImpl.java`            |
| [OrderServiceImpl.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/service/impl/OrderServiceImpl.java)                     | some description `src/main/java/mate/academy/bookstore/service/impl/OrderServiceImpl.java`           |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.mapper</summary>

| File                                                                                                                                                         | Summary                                                                                         |
| ---                                                                                                                                                          | ---                                                                                             |
| [UserMapper.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/mapper/UserMapper.java)                 | some description `src/main/java/mate/academy/bookstore/mapper/UserMapper.java`         |
| [OrderMapper.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/mapper/OrderMapper.java)               | some description `src/main/java/mate/academy/bookstore/mapper/OrderMapper.java`        |
| [ShoppingCartMapper.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/mapper/ShoppingCartMapper.java) | some description `src/main/java/mate/academy/bookstore/mapper/ShoppingCartMapper.java` |
| [BookMapper.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/mapper/BookMapper.java)                 | some description `src/main/java/mate/academy/bookstore/mapper/BookMapper.java`         |
| [OrderItemMapper.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/mapper/OrderItemMapper.java)       | some description `src/main/java/mate/academy/bookstore/mapper/OrderItemMapper.java`    |
| [CartItemMapper.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/mapper/CartItemMapper.java)         | some description `src/main/java/mate/academy/bookstore/mapper/CartItemMapper.java`     |
| [CategoryMapper.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/mapper/CategoryMapper.java)         | some description `src/main/java/mate/academy/bookstore/mapper/CategoryMapper.java`     |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.security</summary>

| File                                                                                                                                                                         | Summary                                                                                                  |
| ---                                                                                                                                                                          | ---                                                                                                      |
| [AuthenticationServiceImpl.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/security/AuthenticationServiceImpl.java) | some description `src/main/java/mate/academy/bookstore/security/AuthenticationServiceImpl.java` |
| [JwtAuthenticationFilter.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/security/JwtAuthenticationFilter.java)     | some description `src/main/java/mate/academy/bookstore/security/JwtAuthenticationFilter.java`   |
| [JwtUtil.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/security/JwtUtil.java)                                     | some description `src/main/java/mate/academy/bookstore/security/JwtUtil.java`                   |
| [AuthenticationService.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/security/AuthenticationService.java)         | some description `src/main/java/mate/academy/bookstore/security/AuthenticationService.java`     |

</details>

<details closed><summary>src.main.java.mate.academy.bookstore.exception</summary>

| File                                                                                                                                                                                | Summary                                                                                                      |
| ---                                                                                                                                                                                 | ---                                                                                                          |
| [EntityNotFoundException.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/exception/EntityNotFoundException.java)           | some description `src/main/java/mate/academy/bookstore/exception/EntityNotFoundException.java`      |
| [EntityAlreadyExistsException.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/exception/EntityAlreadyExistsException.java) | some description `src/main/java/mate/academy/bookstore/exception/EntityAlreadyExistsException.java` |
| [CustomGlobalExceptionHandler.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/exception/CustomGlobalExceptionHandler.java) | some description `src/main/java/mate/academy/bookstore/exception/CustomGlobalExceptionHandler.java` |
| [RegistrationException.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/main/java/mate/academy/bookstore/exception/RegistrationException.java)               | some description `src/main/java/mate/academy/bookstore/exception/RegistrationException.java`        |

</details>

<details closed><summary>src.test.java.mate.academy.bookstore</summary>

| File                                                                                                                                                                | Summary                                                                                         |
| ---                                                                                                                                                                 | ---                                                                                             |
| [BookStoreApplicationTests.java](https://github.com/oksana-miazina/mate_book_store/blob/master/src/test/java/mate/academy/bookstore/BookStoreApplicationTests.java) | some description `src/test/java/mate/academy/bookstore/BookStoreApplicationTests.java` |

</details>

---

##  Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

* **Java**: `version 17`

###  Installation

1. Clone the mate_book_store repository:

```sh
git clone https://github.com/oksana-miazina/mate_book_store
```

2. Change to the project directory:

```sh
cd mate_book_store
```

3. Install the dependencies:

```sh
mvn clean install
```

###  Running mate_book_store

Use the following command to run mate_book_store:

```sh
java -jar target/myapp.jar
```

###  Tests

To execute tests, run:

```sh
mvn test
```

---

##  Project Roadmap

- [X] `► INSERT-TASK-1`
- [ ] `► INSERT-TASK-2`
- [ ] `► ...`

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Submit Pull Requests](https://github.com/oksana-miazina/mate_book_store/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/oksana-miazina/mate_book_store/discussions)**: Share your insights, provide feedback, or ask questions.
- **[Report Issues](https://github.com/oksana-miazina/mate_book_store/issues)**: Submit bugs found or log feature requests for Mate_book_store.

<details closed>
    <summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.
   ```sh
   git clone https://github.com/oksana-miazina/mate_book_store
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to GitHub**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.

Once your PR is reviewed and approved, it will be merged into the main branch.

</details>

---

##  License

This project is protected under the [The Unlicense](https://choosealicense.com/licenses/unlicense/) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

[**Return**](#-quick-links)

---
