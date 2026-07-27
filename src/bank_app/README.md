### **Simulador de Cuenta Bancaria**

Desarrollo de una aplicación de consola en Java que simula el funcionamiento básico de una cuenta bancaria.
Mini aplicación desarrollada en **Java** para practicar los fundamentos de la Programación Orientada a Objetos (POO), organización por capas y buenas prácticas de desarrollo.

## 📋 Descripción

La aplicación simula un sistema bancario básico desde la consola, permitiendo realizar operaciones sobre una cuenta de usuario mediante un menú interactivo.

El proyecto está organizado siguiendo una estructura sencilla de capas (`model`, `service` y `ui`) para separar las responsabilidades del código.

## 🚀 Funcionalidades

- Crear un usuario bancario.
- Consultar información de la cuenta.
- Realizar depósitos.
- Realizar retiros.
- Validar operaciones antes de ejecutarlas.
- Menú interactivo por consola.

## 🏗️ Arquitectura

### model
Contiene las clases que representan las entidades del sistema.

### service
Contiene la lógica de negocio y las operaciones bancarias.

- **TransactionService** define las operaciones disponibles.
- **TransactionServiceImpl** implementa la lógica del sistema.

### ui
Punto de entrada de la aplicación.
- **BankMenu** administra la interacción con el usuario mediante el menú de consola.
- **Main** ejecuta el programa con valores predefinidos

## 🛠️ Tecnologías

- Java
- IntelliJ IDEA
- Programación Orientada a Objetos (POO)

## 📚 Conceptos practicados

- Encapsulamiento
- Interfaces
- Implementación de interfaces
- Separación de responsabilidades
- Organización por paquetes
- Validaciones
- Menús por consola
---