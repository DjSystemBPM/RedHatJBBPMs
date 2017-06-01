![Red Hat Products](https://upload.wikimedia.org/wikipedia/en/thumb/6/6c/RedHat.svg/1280px-RedHat.svg.png)

# RED HAT JBOSS FUSE	

Ejemplo de Red Hat JBoss Fuse para aprender el uso de los siguientes componentes:

* Componente onException: para manejar excepciones en rutas.
* Cómo definir un controlador de errores por defecto para su contexto Camel
* Cómo definir rutinas de manejo de errores específicas de excepciones


## PASOS PARA CONSTRUIR LA RUTA

Estas son las instrucciones para levantar el proyecto de manera correcta

### LIBRERIAS

* Maven 3.1.1 o superior
* JDK 1.7 o 1.8
* JBoss Fuse 6

### ARCHIVO DE DEPENDENCIAS MAVEN (pom.xml)

Observar las dependencias necesarias

### 1.- CONSTRUYE Y DESPLIEGA EL PROYECTO

En la carpeta donde se encuentra el pom.xml ejecuta:

``` 
$ mvn clean install

``` 

### 2.- INICIA EL RED HAT JBOSS FUSE

En la carpeta de instalacion del JBoss Fuse ejecuta los siguientes comandos:

``` 
$ ./bin/start

$ ./bin/status

$ ./bin/client

Ejemplo:

[acuevas@localhost bin]$ ./client
client: JAVA_HOME not set; results may vary
Logging in as admin
1150 [sshd-SshClient[6e78fcf5]-nio2-thread-3] WARN org.apache.sshd.client.keyverifier.AcceptAllServerKeyVerifier - Server at [/0.0.0.0:8101, DSA, 51:23:3d:28:10:87:b1:d4:34:ac:f9:28:35:56:b9:84] presented unverified {} key: {}
      _ ____                  ______
     | |  _ \                |  ____|             
     | | |_) | ___  ___ ___  | |__ _   _ ___  ___
 _   | |  _ < / _ \/ __/ __| |  __| | | / __|/ _ \
| |__| | |_) | (_) \__ \__ \ | |  | |_| \__ \  __/
 \____/|____/ \___/|___/___/ |_|   \__,_|___/\___|

  JBoss Fuse (6.3.0.redhat-187)
  http://www.redhat.com/products/jbossenterprisemiddleware/fuse/

Hit '<tab>' for a list of available commands
and '[cmd] --help' for help on a specific command.

Open a browser to http://localhost:8181 to access the management console

Create a new Fabric via 'fabric:create'
or join an existing Fabric via 'fabric:join [someUrls]'

Hit '<ctrl-d>' or 'osgi:shutdown' to shutdown JBoss Fuse.

JBossFuse:admin@root>

```

### 3.- AGREGAS EL BUNDLE AL OSGI

En la consola del jboss fuse agregamos el Bundle a la lista de OSGI con el siguiente comando:

``` 
$ osgi:install -s mvn:org.jboss.quickstarts.fuse/fuse-camel-blueprint-onexception-errorhandler/1.0.0-SNAPSHOT

```

### 4.- VERIFICAMOS EL BUNDLE EN EL OSGI

En la consola del jboss fuse observamos que el Bundle este en la lista de OSGI con el siguiente comando:

``` 
$  osgi:list

```

### 5.- USO DEL BUNDLE

Para activar la ruta tenemos que hacer lo siguiente:

1.- En la carpeta de instalacion de tu Fuse creamos la siguiente carpeta: `work/cbr/input`
2.- Copia los archivos de la carpeta: `src/main/fabric8/data` a la carpeta `work/cbr/input`
3.- Espera unos momentos y la ruta empezara a ordenar los archivos.
4.- Para observar lo que pasa puedes abrir la consola web en logs o ejecutar el comando $ log:display
	

### 6.- ELIMINACION DEL BUNDLE

Para eliminar el Bundle de nuestro OSGI ejecuta los siguientes comandos:

``` 
$ osgi:list

$ osgi:osgi:uninstall <bundle id>

$ osgi:uninstall mvn:org.jboss.quickstarts.fuse/fuse-camel-blueprint-onexception-errorhandler/1.0.0-SNAPSHOT

``` 

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/RedHatProducts](https://github.com/DjSystemBPM/RedHatProducts). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*   