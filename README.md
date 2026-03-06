##############################################################################
*********Calculadora Básica - Android*********
##############################################################################
Descripción

Esta aplicación es una calculadora básica, permite realizar operaciones aritméticas simples entre dos números y mantiene un historial de operaciones realizadas.

La aplicación está construida utilizando Kotlin, Jetpack Compose para la interfaz de usuario y sigue el patrón de arquitectura MVVM (Model–View–ViewModel) para la gestión del estado y la separación de responsabilidades.

##############################################################################
*********Características*********
##############################################################################

Ingreso de dos números como entrada.

Selección de operación matemática:

Suma

Resta

Multiplicación

Soporte para:

Números enteros

Números negativos

Números decimales

Validación de entrada:

Solo se permite un punto decimal por número

Se evitan entradas inválidas

Cálculo del resultado de la operación seleccionada.

Historial de operaciones realizadas.

Eliminación de operaciones individuales del historial.

Opción para limpiar completamente el historial.

Navegación entre pantallas utilizando Navigation Compose.


##############################################################################
*********Flujo de la aplicación*********
##############################################################################
*********Pantalla de Calculadora*********

Permite al usuario:

Ingresar dos números.

Seleccionar una operación matemática.

Calcular el resultado.

Navegar al historial de operaciones.

El botón de cálculo solo se habilita cuando las entradas son válidas.


*********Pantalla de Historial*********

Muestra la lista de operaciones realizadas con el siguiente formato:

12.5 + 3.2 = 15.7

El usuario puede:

Eliminar una operación específica.

Limpiar todo el historial.

Regresar a la pantalla de la calculadora.


##############################################################################
*********Tecnologías utilizadas*********
##############################################################################

Kotlin

Jetpack Compose

Navigation Compose

ViewModel

StateFlow
