# 🧩 **Jerarquía de Vehículos y Polimorfismo en Java**

Este trabajo integrador tiene como objetivo aplicar de forma práctica los conceptos de **clases abstractas**, **herencia**, **interfaces**, **enumeraciones**, **polimorfismo** y **colecciones**, desarrollando un pequeño sistema orientado a vehículos.

A continuación se detalla el requerimiento completo, dividido en partes.

---

## 🚗 **Parte 1: Jerarquía de Vehículos**

### **1. Clase Base Abstracta: `Vehicle`**

Debés crear la clase abstracta `Vehicle` con las siguientes características:

* Atributos privados:

    * `brand` (String)
    * `model` (String)
    * `year` (int)
* Constructor que inicialice estos atributos.
* Métodos **getters** y **setters** para todos los atributos.
* Método `abstract` llamado `start()`.
* Método concreto `stop()` que imprima:
  **"El vehículo está detenido"**.
* Sobrescritura de `toString()` con el siguiente formato:
  **"Vehicle{brand='<brand>', model='<model>', year=<year>}"**.

---

### **2. Enumeración: `CarType`**

Crear un `enum` llamado **CarType** con los valores:

* `SEDAN`
* `TRUCK`
* `SPORTS`

---

### **3. Clase Concreta: `Car`**

Debés crear la clase `Car`, que **hereda** de `Vehicle`, con:

* Atributo privado `type` de tipo `CarType`.
* Constructor que inicialice `brand`, `model`, `year` (mediante `super`) y también `type`.
* Sobrescritura de `start()` para imprimir:
  **"El auto arrancó"**.
* Sobrescritura de `toString()` para agregar el tipo al final:
  **"Vehicle{brand='...', model='...', year=...} Tipo: <type>"**.

---

### **4. Interface: `Electric`**

Crear la interface `Electric` con un único método requerido:

* `chargeBattery()`

---

### **5. Clase Concreta: `ElectricCar`**

Crear la clase `ElectricCar`, que:

* **Hereda** de `Car`.
* **Implementa** la interface `Electric`.

Debe incluir:

* Atributo privado `batteryLevel` (int).
* Constructor que inicialice todos los atributos heredados y `batteryLevel`.
* Sobrescritura de `start()` para imprimir:
  **"El auto eléctrico está encendido..."**.
* Implementación de `chargeBattery()`:

    * Debe establecer `batteryLevel` a 100.
    * Imprimir: **"La batería está cargada al 100%"**.
* Sobrescritura de `toString()` con formato:
  **"ElectricCar{batteryLevel=<level>}Vehicle{brand='...', model='...', year=...} Tipo: <type>"**.

---

## 🖥️ **Parte 2: Demostración en `Main`**

En la clase `Main`, dentro del método `main`:

1. Crear una instancia de `Car` (ej.: *Fiat Duna*) y asignarla a una variable de tipo `Vehicle` llamada `myCar`.
2. Crear una instancia de `ElectricCar` (ej.: *Tesla Model 3*) y asignarla a una variable de tipo `Vehicle` llamada `myElectricCar`.
3. Demostrar **polimorfismo** llamando a `start()` en ambas instancias.
4. Llamar al método `chargeBattery()` sobre la instancia eléctrica (requiere **casting**).
5. Imprimir ambas instancias para verificar la salida de `toString()`.

---

## 🅱️ **Parte 3: Implementación de un Garaje**

### **7. Clase: `Garage`**

Crear la clase `Garage` con:

* Atributo privado `vehicles`: una colección (ej.: `List<Vehicle>`) ya inicializada.
* (Opcional) Atributo `capacity` y constructor.
* Método `addVehicle(Vehicle v)`: agrega un vehículo y devuelve boolean.
* Método `removeVehicle(Vehicle v)`: elimina un vehículo y devuelve boolean.
* Método `listVehicles()`: imprime todos los vehículos.
* Método `startAllVehicles()`: invoca `start()` sobre todos.
* Método `chargeAllElectricCars()`:

    * Detecta objetos `ElectricCar` usando `instanceof`.
    * Realiza casting y ejecuta `chargeBattery()`.

---

### **8. Extensión en `Main`**

* Crear instancia de `Garage`.
* Agregar `myCar` y `myElectricCar`.
* Ejecutar:

    * `garage.listVehicles()`
    * `garage.startAllVehicles()`
    * `garage.chargeAllElectricCars()`
    * `garage.listVehicles()` nuevamente para ver cambios en el `batteryLevel`.

---