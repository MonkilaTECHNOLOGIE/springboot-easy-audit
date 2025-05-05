
# 📊 Easy Audit

**Easy Audit** est une bibliothèque Java légère et extensible pour Spring Boot qui permet d’enregistrer automatiquement les événements d’audit (création, mise à jour, suppression) dans vos applications. Elle facilite la traçabilité des actions utilisateur en se basant sur les entités persistées.

---

## 📦 Table des matières

- [Installation](#-installation)
- [Configuration de base](#️-configuration-de-base)
- [Utilisation](#-utilisation)
- [Tests](#-tests)
- [Questions fréquentes](#-questions-fréquentes)
- [Licence](#-licence)
- [Auteur & Contact](#-auteur--contact)

---

## 🔧 Installation

### 1. Ajouter JitPack comme dépôt Maven

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

### 2. Ajouter la dépendance Easy Audit

```xml
<dependency>
  <groupId>com.github.MonkilaTECHNOLOGIE</groupId>
  <artifactId>easy-audit</artifactId>
  <version>1.0.0</version>
</dependency>
```

> 🔁 Remplacez `1.0.0` par la dernière version publiée sur [JitPack](https://jitpack.io/#MonkilaTECHNOLOGIE/easy-audit).

---

## ⚙️ Configuration de base

### 1. Activer l’audit dans `application.properties` :

```properties
easy.audit.enabled=true
```

### 2. Déclarer le Bean `AuditorAware`

```java
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.ofNullable(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );
    }
}
```

### 3. Étendre vos entités avec `AuditableEntity`

```java
@Entity
public class Product extends AuditableEntity {
    private String name;
    private double price;
}
```

---

## 📌 Utilisation
### 1. Activer la bibliothèque:

```java
@Configuration
@EnableEasyAudit
public class AuditConfig {
}
```
### 2. Annoter vos endpoints
```java
@Audit(action = "CREATE_USER", description = "Création d’un utilisateur")
@PostMapping("/users")
public ResponseEntity<User> create(@RequestBody User user) {
    return ResponseEntity.ok(userService.create(user));
}
```

### 3. Exemple complet
```java
@Audit(action = "CREATE_USER", description = "Création d’un utilisateur")
@PostMapping("/users")
public ResponseEntity<User> create(@RequestBody User user) {
    return ResponseEntity.ok(userService.create(user));
}
```

```java
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Audit(action = "CREATE_PRODUCT", description = "Création d’un produit")
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @Audit(action = "GET_PRODUCTS", description = "Liste des produits")
    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(productService.findAll());
    }
}
```


---

## 🧪 Tests

- Les tests unitaires peuvent être désactivés via `-DskipTests`
- Pensez à tester :
  - L'enregistrement d'entités
  - La modification des champs
  - La suppression
  - La vérification des logs générés

---

## ❓ Questions fréquentes

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <executions>
        <execution>
          <goals>
            <goal>repackage</goal>
          </goals>
        </execution>
      </executions>
      <configuration>
        <mainClass>com.monkilatech.Application</mainClass>
      </configuration>
    </plugin>
  </plugins>
</build>
```

---

## 📄 Licence

**MIT License**

---

## 👨‍💻 Auteur & Contact

**Développé par [MonkilaTECHNOLOGIE](https://github.com/MonkilaTECHNOLOGIE)**  
📧 Contact : [monkilatech@gmail.com](mailto:contact@monkila-tech.com)

---

⭐ **Merci d’étoiler le projet si vous le trouvez utile !**
