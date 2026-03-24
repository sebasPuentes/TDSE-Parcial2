# TDSE-Parcial2
Parcial 2
## Arquitectura Propuesta

Se tiene un proxy que redirige las peticiones hacia dos servidores que contienen el math service funcionado (Pell Sequence)

![alt text](docs/blobid0.png)

## Implementacion

- Math Service: Este Repositorio es el encargado de realizar el calculo matemático de la secuencia de pell. Se realiza un controlador y servicio para este caso.

Controlador:
![alt text](docs/mathService.png)

Servicio:
![alt text](docs/mathService2.png)


- Proxy: Encargado de redireccionar peticiones.

Controlador:
![alt text](docs/ProxyController.png)

Se hace uso HttpURLConnection para llamar al servicio correspondiente. En este caso mathService.

## Formulario
Dentro de resources en la carpeta static crearemos un index.html para el formulario junto con la llamada asincrona dado por el profesor.

![alt text](docs/indexhtml.png)

## Despliegue AWS

1. Crear la Respectivas instancias en aws. En este caso 2 para math service y 1 para el proxy.

![alt text](docs/instanciasEC2.png)

2. Instalar Java usando el siguiente comando "sudo yum install java-17-amazon-corretto-devel".

3. Ejecutar en cada repositorio el comando "mvn clean install" para que genere el .jar correspondiente. Haciendo uso del protocolo sftp subiremos este a las respectivas instancias. 

4. Haciendo uso del comando java -jar nombreJAt.jar correremos el proyecto.

Ejemplo en Math Service 1:

![alt text](image.png)

5. Abrir los puertos en cada instancia.

## Evidencia Funcionamiento

![alt text](docs/evidencia.png)

## Autor

- Juan Sebastian Puentes Julio
