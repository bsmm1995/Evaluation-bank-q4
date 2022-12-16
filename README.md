## Indicaciones Generales

- Crear una rama con el nombre del participante: Ejemplo: Q42022-roman-macas-alex-patricio.
- Subir cambios a sus ramas una vez terminado el tiempo establecido.
    - Al finalizar el tiempo el repositorio no permitirá nuevos cambios.
- Implementar buenas prácticas de programación.

## Ejercicio: Reserva de butacas de cine

![](./assesmentQ4.png "Application manage model")
 
1. Mapeo(Completo proporciona chapter)

2. Repositorio(respositorio base de todas las entidades proporciona chapter)

   <p><strong>a. Generar el query necesario para obtener las reservas de películas cuyo genero sea terror y con un rango de fechas </strong></p>

   <p><strong>b. Generar el query necesario para obtener el numero de butacas disponibles y ocupadas por sala en la cartelera del día actual.</strong></p>

3. Servicios(estructura básica de los servicios y DTOS proporciona chapter)

    <p><strong>a. Implementar el método con transaccionalidad para inhabilitar la butaca y cancelar la reserva.</strong></p>

    <p><strong>b. Implementar el método con transaccionalidad para cancelar la cartelera y cancelar todas las reservas de la sala, adicional se debe habilitar las butacas e imprimir por consola la lista de clientes que fueron afectados.</strong></p>

    <p><strong>c. Si se trata de cancelar una cartelera cuando la función sea menor a la fecha actual se debe lanzar una excepción personalizada con el mensaje: 'No se puede cancelar funciones de la cartelera con fecha anterior a la actual'.</strong></p>

4. Controladores

    a. Implementar controlador para administrar butaca (proporcionado por Chapter)

    b. Implementar controlador para administrar la cartelera(proporcionado por Chapter)
        <p><strong>b1. Implementar endpoint para el servicio del punto 3 literal a.</strong></p>
        <p><strong>b2. Implementar endpoint para el servicio del punto 3 literal b.</strong></p>

    <p><strong>c. Implementar el manejo de excepciones con handlers.</strong></p>

	<p><strong>d. Implementar endpoint para obtener las reservas de películas cuyo genero sea terror y en un rango de fechas.</strong></p>

    <p><strong>e. Implementar endpoint para obtener el numero de butacas disponibles y ocupadas por sala en la cartelera del día actual.</strong></p>

5. Pruebas unitarias

	<p><strong>a. Implementar la prueba unitaria para el servicio del punto 3 literal a </strong></p>

6. Prueba de integración

	<p><strong>a. Implementar la prueba de integración para el query del punto 2 literal a </strong></p>

	<p><strong>b. Implementar la prueba de integración para el query del punto 2 literal b </strong></p>

	<p><strong>c. Implementar la prueba de integración para el endpoint del punto 4 literal b2</strong></p>