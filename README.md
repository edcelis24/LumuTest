# Automatización de pruebas - WordCounter 

_WordCounter.net es una herramienta en línea que permite contar palabras, caracteres y otros elementos en textos. Es útil para escritores, estudiantes y profesionales que necesitan ajustar la longitud de sus documentos. Además, ofrece análisis de densidad de palabras clave y sugerencias de estilo, ideal para mejorar la calidad y el SEO de los textos._

### Pre-requisitos 📋

_Herramientas que necesitas para instalar el proyecto de pruebas de manera local_

```
Java 11 
Gradle 8.2
Editor de texto preferiblemente (IntelliJ IDEA)
```
## Comenzando 🚀

_El actual repositorio contiene un proyecto de pruebas automatizadas utilizando SerenityBDD con el marco de trabajo ScreenPlay_

- LumuTest.


### Estructuración

```
/
├── LumuTest
│   ├── gradle
│   ├── src
│   │   ├── main
│   │   └── test   
│   ├── build.gradle
│   ├── gradlew
│   ├── gradlew.bat
│   ├── serenity.properties
│   ├── settings.gradle
│   ├── .gitignore
│   └── README.md
└──
```


### Instalación 🔧

1. Clonar el repositorio.

```
git clone https://github.com/edcelis24/LumuTest.git
```

2. Abrir el proyecto de pruebas.

```
cd LumuTest
```

4. Crear rama para trabajar dentro del proyecto de pruebas.

```
git checkout -b "feature/Descripción"
```

## Ejecutando las pruebas ⚙️
### Ejecución en IntelliJ IDEA

1. Abrir el proyecto de pruebas en el editor de texto IntelliJ IDEA
2. Esperar a que se construya el proyecto y se descarguen las dependencias.
3. Clic en el botón Run, ubicado en la parte superior derecha.

### Ejecución en Consola y/o Terminal

1. Abrir el proyecto de pruebas en la consola.
```
cd LumuTest
```
2. Ejecutar el comando para iniciar las pruebas.
```
gradle clean build test aggregate --info
```
### Verificación de las pruebas
_Como resultado de la ejecución, desde la consola tanto del equipo o del editor de texto nos retornará un mensaje como el siguiente, en el caso en que las pruebas se hayan ejecutado correctamente_
```
        __    _____ _____ ____ _____   ____   _    ____  ____  _____ ____  
  _     \ \  |_   _| ____/ ___|_   _| |  _ \ / \  / ___|/ ___|| ____|  _ \ 
 (_)_____| |   | | |  _| \___ \ | |   | |_) / _ \ \___ \\___ \|  _| | | | |
  _|_____| |   | | | |___ ___) || |   |  __/ ___ \ ___) |___) | |___| |_| |
 (_)     | |   |_| |_____|____/ |_|   |_| /_/   \_\____/|____/|_____|____/ 
        /_/    
                                                                    
----------------------------------------------------------------------------
BUILD SUCCESSFUL in 12s
```
_Para el caso en que las pruebas no se hayan ejecutado correctamente por errores de codificación de las mismas o bugs encontrados._
️
```
        __  _____ _____ ____ _____   _____ ____  ____   ___  ____  
 _      / / |_   _| ____/ ___|_   _| | ____|  _ \|  _ \ / _ \|  _ \ 
(_)____| |    | | |  _| \___ \ | |   |  _| | |_) | |_) | | | | |_) |
 |_____| |    | | | |___ ___) || |   | |___|  _ <|  _ <| |_| |  _ < 
(_)    | |    |_| |_____|____/ |_|   |_____|_| \_\_| \_\\___/|_| \_\
        \_\                                                         

----------------------------------------------------------------------------
BUILD FAILED in 11s
```
