# Suplementos POS

Sistema de punto de venta e inventario para una tienda de suplementos alimenticios. Desarrollado como proyecto académico utilizando Java, Spring Boot, MySQL y JDBC puro, sin ORM.

## Tecnologías

- **Java 21**
- **Spring Boot**
- **Maven**
- **MySQL 8.4**
- **JDBC API (`JdbcTemplate`)**
- HTML, CSS y JavaScript

## Características

- Gestión de categorías.
- Gestión de productos.
- Control de inventario y existencias.
- Registro de ventas.
- Detalle de ventas.
- Actualización automática del inventario al realizar ventas.
- Consultas y reportes mediante SQL.

> Las funcionalidades se irán implementando progresivamente durante el desarrollo del proyecto.

## Requisitos

Antes de comenzar, asegúrate de tener instalado:

- Java JDK 21.
- Maven (o utilizar el Maven Wrapper del proyecto, si está disponible).
- MySQL 8.4.
- Git.

**Opcional:** Nix con soporte para flakes, para utilizar el entorno de desarrollo proporcionado.

## Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/DarThunder/Supplement-Store
cd suplementos-pos
```

### 2. Crear la base de datos

Inicia MySQL y crea la base de datos:

```sql
CREATE DATABASE proyecto_db;
```

Las tablas se inicializan mediante el archivo `schema.sql` al iniciar la aplicación, si la configuración de inicialización SQL está habilitada.

### 3. Configurar las credenciales

Configura las variables de entorno necesarias para conectarte a MySQL.

Linux/macOS:

```bash
export DB_USER="tu_usuario"
export DB_PASSWORD="tu_contraseña"
```

Windows PowerShell:

```powershell
$env:DB_USER="tu_usuario"
$env:DB_PASSWORD="tu_contraseña"
```

Revisa `src/main/resources/application.properties` para confirmar el usuario, host, puerto y nombre de la base de datos.

### 4. Ejecutar el proyecto

Con Maven:

```bash
mvn spring-boot:run
```

Si quiere usar Maven Wrapper:

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación estará disponible en:

http://localhost:8070

## Entorno de desarrollo con Nix (opcional)

Si tienes Nix instalado y habilitado para utilizar flakes:

```bash
nix develop
```

Esto proporciona las herramientas necesarias para desarrollar el proyecto, incluyendo Java 21, Maven y herramientas de MySQL.

## Estructura del proyecto

```text
src/
├── main/
│   ├── java/com/proyecto/sistema/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── service/
│   │   └── SistemaApplication.java
│   │
│   └── resources/
│       ├── application.properties
│       ├── schema.sql
│       └── static/
│           ├── css/
│           ├── js/
│           └── index.html
│
└── test/
```

## Arquitectura

El backend utiliza una arquitectura por capas:

1. **Controller:** recibe las solicitudes HTTP y expone los endpoints REST.
2. **Service:** contiene la lógica de negocio.
3. **Repository:** ejecuta consultas SQL mediante `JdbcTemplate`.
4. **Model:** representa las entidades y objetos del sistema.

### Importante

Este proyecto utiliza JDBC puro para el acceso a datos.

No se utilizan Hibernate, JPA ni ningún otro ORM. Las consultas y operaciones sobre la base de datos se implementan mediante SQL.

## Flujo de trabajo

1. Actualiza tu rama local antes de comenzar a trabajar:

   ```bash
   git pull
   ```

2. Crea una rama para tu funcionalidad:

   ```bash
   git switch -c feature/nombre-funcionalidad
   ```

3. Realiza tus cambios y pruébalos.

4. Guarda tus cambios:

   ```bash
   git add .
   git commit -m "feat: descripción del cambio"
   ```

5. Sube tu rama:

   ```bash
   git push -u origin feature/nombre-funcionalidad
   ```

6. Abre un Pull Request para revisar e integrar los cambios.

## Convenciones

Se recomienda utilizar:

- Nombres de clases en `PascalCase`.
- Variables y métodos en `camelCase`.
- Consultas SQL escritas explícitamente en los repositorios.
- Mensajes de commit descriptivos.
- Una rama por funcionalidad o corrección.
- No subir contraseñas, credenciales ni archivos locales de configuración.

## Licencia

Este proyecto está distribuido bajo la licencia **GNU Affero General Public License v3.0 (AGPL-3.0)**.

Consulta el archivo `LICENSE` para conocer los términos y condiciones.
