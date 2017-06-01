camel-eips: Demonstrates how to combine multiple EIPS in Camel
===================================
Author: Fuse Team  
Level: Beginner  
Technologies: Camel,Blueprint  
Summary: This quickstart demonstrates how to combine multiple EIPs in Camel in order to solve integration problems.
Target Product: Fuse  
Source: <https://github.com/jboss-fuse/quickstarts>

What is it?
-----------

This quickstart demonstrates how to combine multiple EIPs to solve integration problems.

In this example, an orders file containing several orders for zoos around the world is sent to us.

We first want to make sure we retain a copy of the original file. This is done using the Wiretap EIP.

After saving the original, we want to split the file up into the individual orders. This is done using the Splitter EIP.

Then we want to store the orders in separate directories by geographical region. This is done using a Recipient List EIP.

Finally, we want to filter out the orders that contain more than 100 animals and generate a message for the strategic account team. This is done using a Filter EIP.

In studying this example you will learn:


* Cómo usar el Wiretap EIP para copiar mensajes mientras pasan por una ruta
* Cómo usar el Splitter EIP para dividir mensajes grandes en pequeños
* Cómo utilizar el Recipient List EIP para determinar dinámicamente cómo pasa un mensaje a través de una ruta
* Cómo usar el Filter EIP para filtrar mensajes y ejecutar lógica para los que coinciden con el filtro
* Cómo definir y utilizar un bean para procesar un mensaje
* Cómo utilizar un punto final `direct:` para vincular varias rutas más pequeñas juntos




For more information see:

* http://www.enterpriseintegrationpatterns.com/RecipientList.html
* http://www.enterpriseintegrationpatterns.com/WireTap.html
* http://www.enterpriseintegrationpatterns.com/Filter.html
* http://www.enterpriseintegrationpatterns.com/Sequencer.html
* https://access.redhat.com/site/documentation/JBoss_Fuse/


System requirements
-------------------

Before building and running this example you need:

* Maven 3.1.1 or higher
* JDK 1.7 or 1.8
* JBoss Fuse 6


Build and Deploy the Quickstart
-------------------------------

1. Change your working directory to `camel-eips` directory.
*. Run `mvn clean install` to build the quickstart.
*. Start JBoss Fuse 6 by running bin/fuse (on Linux) or bin\fuse.bat (on Windows).
*. In the JBoss Fuse console, enter the following command:

        osgi:install -s mvn:org.jboss.quickstarts.fuse/beginner-camel-eips/6.3.0.redhat-187

*. Fuse should give you an id when the bundle is deployed
*. You can check that everything is ok by issuing  the command:

        osgi:list
   your bundle should be present at the end of the list


Use the bundle
--------------

To use the application be sure to have deployed the quickstart in Fuse as described above. Successful deployment will create and start a Camel route in Fuse.

1. As soon as the Camel route has been started, you will see a directory `work/eip/input` in your JBoss Fuse installation.
2. Copy the file you find in this example's `src/main/fabric8/data` directory to the newly created `work/eip/input`
directory.
3. Wait a few moments and you will find multiple files organized by geographical region under `work/eip/output':
** `2012_0003.xml` and `2012_0005.xml` in `work/eip/output/AMER`
** `2012_0020.xml` in `work/eip/output/APAC`
** `2012_0001.xml`, `2012_0002.xml` and `2012_0004.xml` in `work/eip/output/EMEA`
4. Use `log:display` on the ESB shell to check out the business logging.
        [main]    Processing orders.xml
        [wiretap]  Archiving orders.xml
        [splitter] Shipping order 2012_0001 to region EMEA
        [splitter] Shipping order 2012_0002 to region EMEA
        [filter]   Order 2012_0002 is an order for more than 100 animals
        ...

Undeploy the Bundle
-------------------

To stop and undeploy the bundle in Fuse:

1. Enter `osgi:list` command to retrieve your bundle id
2. To stop and uninstall the bundle enter

        osgi:uninstall <id>
        
        
        
        
![Red Hat Products](https://upload.wikimedia.org/wikipedia/en/thumb/6/6c/RedHat.svg/1280px-RedHat.svg.png)

# RED HAT JBOSS FUSE	

Ejemplo de Red Hat JBoss Fuse para aprender el uso de los siguientes componentes:

* Componente Wiretap: para copiar mensajes mientras pasan por una ruta
* Componente Splitter: para dividir mensajes grandes en pequeños
* Componente Recipient List: para determinar dinámicamente cómo pasa un mensaje a través de una ruta
* Componente Filter: para filtrar mensajes y ejecutar lógica para los que coinciden con el filtro
* Componente Direct: para vincular varias rutas más pequeñas juntos
* Cómo definir y utilizar un bean para procesar un mensaje


## PASOS PARA CONSTRUIR LA RUTA

Estas son las instrucciones para levantar el proyecto de manera correcta

### LIBRERIAS

* Maven 3.1.1 o superior
* JDK 1.7 o 1.8
* JBoss Fuse 6

### ARCHIVO DE DEPENDENCIAS MAVEN (pom.xml)

Observar las dependencias necesarias

###1.- CONSTRUYE Y DESPLIEGA EL PROYECTO

En la carpeta donde se encuentra el pom.xml ejecuta:

``` 
$ mvn clean install

``` 

###2.- INICIA EL RED HAT JBOSS FUSE

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

###3.- AGREGAS EL BUNDLE AL OSGI

En la consola del jboss fuse agregamos el Bundle a la lista de OSGI con el siguiente comando:

``` 
$  osgi:install -s mvn:org.jboss.fuse/fuse-camel-blueprint-files-xml/1.0.0-SNAPSHOT

```

###4.- VERIFICAMOS EL BUNDLE EN EL OSGI

En la consola del jboss fuse observamos que el Bundle este en la lista de OSGI con el siguiente comando:

``` 
$  osgi:osgi:list

```

###5.- USO DEL BUNDLE

Para activar la ruta tenemos que hacer lo siguiente:

1.- En la carpeta de instalacion de tu Fuse creamos la siguiente carpeta: `work/cbr/input`
2.- Copia los archivos de la carpeta: `src/main/fabric8/data` a la carpeta `work/cbr/input`
3.- Espera unos momentos y la ruta empezara a ordenar los archivos de la siguiente manera:
	* `order1.xml` en `work/cbr/output/others`
    * `order2.xml` y `order4.xml` en `work/cbr/output/uk`
    * `order3.xml` y `order5.xml` en `work/cbr/output/us`
4.-Para observar lo que pasa puedes abrir la consola web en logs o ejecutar el comando $ log:display
	


1. As soon as the Camel route has been started, you will see a directory  in your JBoss Fuse installation.
2. Copy the files you find in this quick start's  directory to the newly created `work/cbr/input`
directory.
3. Wait a few moments and you will find the same files organized by country under the `work/cbr/output` directory.
  
4. Use `log:display` to check out the business logging.
        Receiving order order1.xml
        Sending order order1.xml to another country
        Done processing order1.xml

###5.- ELIMINACION DEL BUNDLE

Para eliminar el Bundle de nuestro OSGI ejecuta los siguientes comandos:

``` 
$ osgi:list

$ osgi:osgi:uninstall <bundle id>

$ osgi:uninstall mvn:org.jboss.fuse/fuse-camel-blueprint-files-xml/1.0.0-SNAPSHOT

``` 


## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/RedHatProducts](https://github.com/DjSystemBPM/RedHatProducts). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*        
        
        
        
        
        
        
 

