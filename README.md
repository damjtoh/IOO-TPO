# TPO IOO 2C 2017

## Consignas

## Sistema de venta y subasta de productos y servicios

Se solicita al equipo de diseñadores que diseñe e implemente un sistema que permita la venta y subasta de productos y servicios.

* El sistema debe permitir la administración de usuarios (alta, baja y modificación). De los mismos se debe guardar la siguiente información: nombre, domicilio, mail, nombre de usuario, contraseña y su reputación
* La reputación de un  usuario se obtiene de las calificaciones positivas, negativas y neutras que recibe por  cada transacción realizada.
* Las calificaciones de un usuario deben guardar la siguiente información: usuario que califico, transacción realizada, calificación (escala de 1 a 10), observaciones, fecha de la calificación.
* Las contraseñas de acceso vencen cada 180 días y deben ser actualizadas por el usuario. 
* Las contraseñas tienen las siguientes restricciones:
* Longitud mínima 8 caracteres, máxima 20
* Debe tener al menos un carácter numérico y al menos un carácter mayúscula.
* El sistema debe permitir administrar los productos y servicios que se venderán a través de la aplicación. En general todos deben tener: nombre que identifica al producto o servicio, descripción, fecha de publicación, fecha hasta vigencia publicación, precio, formas de pago (efectivo, tarjeta de crédito, transferencia bancaria), imágenes.
* En el caso de los servicios además se incorpora: contratación por abono o contratación por única vez, certificados que acreditan profesiones.
* En el caso de los productos se agrega: garantía extendida, garantía por X cantidad de años o meses especificando la cantidad.
* En el caso de las subastas se pueden dar dos casos: que el usuario quiera subastar productos o servicios que ya estaban publicados o que subaste productos no existentes en el sistema. En ambos casos la subasta tiene la misma información mencionada anteriormente y adiciona los siguientes datos: precio mínimo, días de vigencia de la subasta, precio inicial de la subasta.
* El sistema debe permitir que los usuarios realicen transacciones de venta de productos y servicios y debe registrar la información en el mismo.
* Cuando comienza una subasta, el sistema debe registrar los usuarios interesados en la misma junto con sus ofertas. Cada vez que se realiza una nueva oferta, el sistema debe notificar a todos los interesados para que puedan contra ofertar.
* Cuando una subasta llega a su fin, el usuario que realizo la mejor oferta es el ganador y se debe crear la transacción de venta.
* Al día siguiente de confirmada una transacción, el sistema debe habilitar el usuario comprador la funcionalidad de calificar al vendedor. Se registra la misma y se notifica al vendedor.
* Por cada transacción realizada el vendedor debe pagar una comisión sobre el precio de venta. Mensualmente debe recibir un resumen con todas las operaciones realizadas, la comisión discriminada y el total a pagar.

Se pide:
* Documentar el diseño del sistema e implementar en base a las siguientes fases:
  * Primera Fase: Diseño e implementación del sistema sin interfases graficas. ENTREGA 29/09
  * Segunda Fase: Incorporar las interfases graficas. ENTREGA 10/11

### Features
- [ ] Login
  - [ ] Cambiar input de password text -> password
  - [ ] Checkear la password tiene más de 180 días
- [ ] Panel de administración
  - [ ] Falta el botón de generar reporte de comisiones
- [ ] Alta de usuario
  - [ ] Validar el formato de la password
- [ ] Modificación de usuario
- [ ] Home usuario
- [ ] Listado de publicaciones
- [ ] Ver publicación
  - [ ] Funcionalidad de comprar
  - [ ] Funcionalidad de ofertar subasta
  - [ ] Funcionalidad de cambiar desde ventaDirecta -> Subasta.
- [ ] Calificar
- [ ] Mi reputación
- [ ] Mis transacciones
- [ ] Crear publicación
  - [ ] Mensaje de exito y que se cierre la ventana
  - [ ] ComboBox con el tipo de publicación, para que se muestren/oculten campos de garantias/certificados
- [ ] Crear subasta
- [x] Crear un diagrama de clases consistente.


