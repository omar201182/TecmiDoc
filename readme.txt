# Sistema de Administración de Citas Médicas

Este proyecto es un sistema de administración de citas médicas que permite dar de alta doctores y pacientes, crear citas, y controlar el acceso mediante administradores.

## Instalación y Configuración

### Requisitos

- Java JDK 8 o superior
- Maven

### Pasos para la Instalación

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/omar201182/TecmiDoc.git
    cd Docs
    ```

2. **Cambiar al branch `develop`**:
    ```sh
    git checkout develop
    ```

3. **Compilar el proyecto como un FAT JAR**:
    ```sh
    mvn clean compile assembly:single
    ```

### Configuración

El proyecto incluye un archivo `.gitignore` para excluir archivos de la carpeta `db`, donde se almacenarán los datos de doctores, pacientes y citas. Asegúrese de que esta carpeta exista en el directorio raíz del proyecto antes de ejecutar el programa.

## Uso del Programa

### Ejecución del Programa

Para ejecutar el programa, utilice el siguiente comando desde el directorio del proyecto:


java -jar Doctors_jar/Doctors.jar

