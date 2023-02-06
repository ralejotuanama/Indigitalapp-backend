# Indigitalapp-backend

INDIGITAL - PROYECTO - BACKEND

BACKEND INDIGITAL Consideraciones: Para la realización de este reto he utilizado tecnología java específicamente la version 8. También spring boot, spring security (jwt), spring data. Como base de datos he utilizado postgres. Hemos también utilizado maven, github. PASO 1: Para desplegar el aplicativo creamos la base de datos en postgress con el nombre bdretail y automáticamente con el jpa se crearán las tablas mapeadas en nuestros modelos del aplicativo.

Adicional a ello creamos 2 tablas que necesitaremos para el tema de los tokens de jwt. create table oauth_access_token ( token_id VARCHAR(256), token bytea, authentication_id VARCHAR(256), user_name VARCHAR(256), client_id VARCHAR(256), authentication bytea, refresh_token VARCHAR(256) ); create table oauth_refresh_token ( token_id VARCHAR(256), token bytea, authentication bytea );

PASO 2: Para realizar la prueba de autenticamos necesitamos registra un usuario , para ello realizamos un test con junit ingresando un usuario y contraseña para ello he utilizado la clase encrypt.

PASO 3: Para pruebas en el postman he tenido que utilizar como tipo de autenticación Basic Auth y hay que poner credenciales de username y password que están el properties . Y luego de ello en el postman ingreso el usuario y contraseña que del usuario que registre en la base de datos.

Para la prueba utilizamos la siguiente url en el postman. http://localhost:8080/oauth/token y al ser exitoso el usuario y contraseña nos retornara un token y código correcto de respuesta 200.

PASO 4: Para el endpoint de registro de clientes,actualizacion, eliminacion de clientes , utilizamos la siguiente url http://localhost:8080/clientes para la respectiva pruebas debemos utilizar en el postman la palabra bearer seguida el token de seguridad. Se adjunta el respectivo postman para probar dichas funcionalidades.

Vemos el código exitoso de 201 es decir creado correctamente. Si modificamos el token de acceso o ponemos un token incorrecto nos mostrara un error que nos devolverar error de token

PASO 5: Para hacer busquedas por email y dni utilizamos el respectivo endpoint : localhost:8080/clientes/buscar , se adjunta la coleccion de postman para la respectiva prueba.

PASO 6: Para el tema de los indicadores se utiliza la siguientes url: localhost:8080/consultasindicador/tazaNatalidad, localhost:8080/consultasindicador/MayorCantidadNacimiento, localhost:8080/consultasindicador/MenorCantidadNacimiento , se adjunta la coleccion son los respectivos ejemplos.

