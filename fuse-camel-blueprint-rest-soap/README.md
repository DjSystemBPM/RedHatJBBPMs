![Red Hat Products](https://upload.wikimedia.org/wikipedia/en/thumb/6/6c/RedHat.svg/1280px-RedHat.svg.png)

# RED HAT JBOSS FUSE	

Ejemplo de Red Hat JBoss Fuse para aprender el uso de los siguientes componentes:

* Componente Rest Server
* Componente Soap Client


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

En la consola del jboss fuse agregamos el Bundle a la fabrica con los siguientes comandos:

``` 
$ fabric:create 

$ fabric:container-create-child root legosoft

$ fabric:profile-create rest-legosoft-profile

$ fabric:container-add-profile legosoft rest-legosoft-profile

//AGREGAMOS LOS FEATURES Y BUNDLES NECESARIOS
$ fabric:profile-edit -f camel-gson rest-legosoft-profile 
$ fabric:profile-edit -f camel-jackson rest-legosoft-profile 
$ fabric:profile-edit -f camel-core rest-legosoft-profile 
$ fabric:profile-edit -f camel-jaxb rest-legosoft-profile 
$ fabric:profile-edit -f camel-cxf rest-legosoft-profile 
$ fabric:profile-edit -f camel-blueprint rest-legosoft-profile 

$ fabric:profile-edit -b mvn:com.legosoft.service/ejemploSoapFuse/1.0.2-SNAPSHOT rest-legosoft-profile
$ fabric:profile-edit -b mvn:com.fasterxml.jackson.core/jackson-annotations/2.7.3 rest-legosoft-profile

```

### 4.- VERIFICAMOS NUESTRA FABRICA

En la consola del jboss fuse observamos que los Bundles y Features este en la lista de nuestro perfil con el siguiente comando:

``` 
$  fabric:profile-display rest-legosoft-profile 

Container settings
----------------------------
Features : 
	camel-gson
	camel-jackson
	camel-core
	camel-jaxb
	camel-cxf
	camel-blueprint

Bundles : 
	mvn:com.multiva.service/Consulta-Productos-Contratados/1.0.0-SNAPSHOT
	mvn:com.legosoft.service/ejemploSoapFuse/1.0.2-SNAPSHOT
	mvn:com.fasterxml.jackson.core/jackson-annotations/2.7.3
	mvn:com.multiva.service/Consulta-Datos-Basicos-Cliente/1.0.0-SNAPSHOT
	mvn:com.multiva.service/Consulta-Servicios-Contratados/1.0.0-SNAPSHOT


Configuration details
----------------------------

```

### 5.- VERIFICACION DEL SERVICIO REST 

Para activar la ruta tenemos que hacer lo siguiente:

1.- Nos dirigimos a la ruta: http://localhost:8182/cxf

2.- Invocamos el servicio desde postman con la siguiente configuracion:
	METODO: POST
	URL: http://localhost:8182/cxf/request-rest/legosoft
	HEADERS: Content-Type = application/json
	BODY:
		{
		  "nombre":"",
		  "apellidop":"",
		  "apellidom":""
		}

### 6.- ELIMINACION DEL BUNDLE

Para eliminar el Bundle de nuestro OSGI ejecuta los siguientes comandos:

``` 
$ fabric:profile-edit --delete -b mvn:com.legosoft.service/ejemploSoapFuse/1.0.2-SNAPSHOT rest-legosoft-profile

``` 

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/RedHatProducts](https://github.com/DjSystemBPM/RedHatProducts). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*        
        
        
        
        
        
        
 

                
        
        
        
 
