
# PasswordStrengthCheckerService

## Descripción
El siguiente trabajo es una propuesta de implementación de un servicio web para la medición de la vulnerabilidad de una
contraseña a los ataques empleados por los piratas informáticos, como el uso de contraseñas comunes, datos personales del
usuario, ataques de diccionario y ataques de fuerza bruta.

Esta aplicación derivada de la revisión de las opciones disponibles en la web, pretende, mediante la conectividad de los
servicios web, proporcionar una opción accesible por cualquier plataforma, con el fin de cubrir dos de las principales
limitaciones encontradas en los medidores de fortaleza de contraseña revisados: no proporcionar una buena retroalimentación
para el usuario, y que sus diccionarios utilizados para el análisis de fortaleza son limitados para el idioma español, estando
enfocados básicamente en el idioma inglés.

## Utilización

El proyecto fue desarrollado en el lenguaje Java con la ayuda de Spring boot, es posible encontrar dentro de su
carpeta frontend una forma en html para realizar consultas al servicio web. Fue creado como un proyecto Java en el IDE
Eclipse pero puede ser utilizado en cualquier IDE de su preferencia.

## Licencia
El proyecto ha sido liberado utilizando la licencia GNU (https://www.gnu.org/licenses/gpl.txt).

El análisis de diccionario utiliza un concentrado de palabras comunes (dictionary.txt) construida a partir de la depuración de la colección de palabras ofrecidas por la compañía de seguridad Openwall y es utilizada en varios de sus productos, como el popular programa para vulnerar contraseñas John the Ripper, se incluye se respectiva licencia en el paquete
src.pwd.resources.dictionaries

Adicionalmente se incluye el archivo spanish_dictionary.txt, este archivo contiene un concentrado de palabras en español, el cual es parte del trabajo de investigación del Dr. Sergio Ellerbracke (@SerEllerbracke).
