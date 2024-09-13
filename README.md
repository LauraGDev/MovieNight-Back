# MovieNight 🎬🍿💜

## Índice
- [Proyecto 📝](#proyecto)
- [Capturas 🎬🍿💜](#capturas)
- [Diagramas 📊](#diagramas)
    - [User Journey](#user-journey)
    - [Diagrama de flujo](#diagrama-de-flujo)
    - [Diagrama de datos](#diagrama-de-datos)
- [Tecnologías 💻](#tecnologías)
- [Instalación 🛠️](#instalación)
    - [Requerimientos](#requerimientos)
    - [Configuración del Backend](#configuración-del-backend)
    - [Configuración del Frontend](#configuración-del-frontend)
- [Uso 🎬](#uso)
- [Contribución 🤝](#contribución)


## Proyecto
Desarrollo de una aplicación de entretenimiento en la que cada usuario puede crear diferentes perfiles para los miembros de su familia y, en cada perfil, guardar las películas y series que cada uno quiere ver. Estas listas se llaman Watchlists. Además, para aquellos momentos en los que los usuarios no saben qué ver, disponen de una sección donde pueden seleccionar sus perfiles, y la aplicación elige aleatoriamente una recomendación de entre todas las Watchlists seleccionadas.

La aplicación permite a los usuarios iniciar sesión, y es a través de esta autenticación que tienen acceso a la creación de perfiles y Watchlists.

## Capturas
![MovieNight Demo](https://github.com/user-attachments/assets/2498e441-ebca-4a8d-aff4-8efe3e0c35e0)

## Diagramas

### User Journey
[Ver User Journey](https://www.figma.com/board/buVjsRuDOaGSes8WQZTz8q/Userflow?node-id=0-1&node-type=CANVAS&t=yiLqRsjrYGBHnWDj-0)

### Diagrama de flujo
[Ver diagrama de flujo](https://www.figma.com/board/NpRra1k4BiQM8sa8Bk0dxE/Workflow-MovieNight?node-id=0-1&node-type=canvas&t=ObfcgA7bbP8enl2w-0)

### Diagrama de datos
[Ver diagrama de datos](https://www.figma.com/board/NpRra1k4BiQM8sa8Bk0dxE/Workflow-MovieNight?node-id=0-1&node-type=canvas&t=ObfcgA7bbP8enl2w-0) 

## Tecnologías

**Front**
- [React.js](https://react.dev/)
- [JavaScript](https://www.w3schools.com/js/js_intro.asp)
- [TailwindCSS](https://tailwindcss.com/)

**Back**
- [Java](https://www.java.com)
- [PgAdmin](https://www.pgadmin.org/)+ [SQL](https://www.w3schools.com/sql/default.asp)
- [SpringBoot](https://spring.io/projects/spring-boot)


## Instalación

### Requerimientos

- [Node.js](https://nodejs.org/en)
- [VSC](https://www.w3schools.com/java/java_intro.asp) con [extensión Java Pack VSC](vscjava.vscode-java-pack), [IntelliJ](https://www.jetbrains.com/es-es/idea/)  or tu IDE de preferencia
- Base de datos SQL


### Configuración del Backend

1. Clona el repositorio del backend:
    ```bash
    git clone https://github.com/LauraGDev/MovieNight-Back
    ```

2. Crea una base de datos llamada `movienight` en PostgreSQL.

3. Modifica el archivo `application.properties` en el repositorio del backend:
    - Añade tus credenciales de PostreSQL y la ruta a tu BBDD.

5. Crea un archivo `.env` en la raíz del repositorio del backend y añade la clave secreta para JWT:
    ```plaintext
    JWT_TOKEN=tu_clave_secreta_aqui
    ```

6. Instala las dependencias y ejecuta el backend

7. Vuelve a modificar el archivo `application.properties` en el repositorio del backend:
    - Comenta la línea `spring.jpa.hibernate.ddl-auto=create`.
    - Descomenta la línea `spring.jpa.hibernate.ddl-auto=update`.
      Si dejas `create` sin comentar, las tablas se crearán de nuevo cada vez que ejecutes el backend. Si quieres mantener los datos existentes, asegúrate de seguir los pasos anteriores.



### Configuración del Frontend

1. Clona el repositorio del frontend:
    ```bash
    git clone https://github.com/LauraGDev/MovieNight-Front
    ```

2. Crea un archivo `.env` en la raíz del repositorio del frontend y añade el token de tu cuenta de The Movie Database:
    ```plaintext
    VITE_TMDB_TOKEN=tu_token_aqui
    ```

3. Instala las dependencias del frontend:
    ```bash
    npm install
    ```

4. Ejecuta el frontend:
    ```bash
    npm run dev
    ```

5. Abre el enlace que aparece con tu puerto local.

## Uso
El programa debe iniciarse primero en el back.

Para compilar:

```
Da al play para compilar automáticamente.

```

Una vez iniciado el back, en el front:

```
npm run dev
```

Abre el enlace que aparece con tu puerto local.


## Contribución

1. Haz un fork del repositorio.
2. Crea una nueva rama: `git checkout -b feature/name`.
3. Haz tus cambios.
4. Haz push de tu rama: `git push origin feature/name`.
5. Crea un pull request.


