@Passenger
Feature: API Passenger

  Como un usuario de la API de pasajeros
  Quiero actualizar y borrar pasajeros
  Para poder verificar los detalles los pasajeros

@CP3
Scenario: Actualizar un pasajero exitosamente
Given el actor establece el endpoint PATCH para actualizar un pasajero
When el envia  una solicitud HTTP PATCH con el "<name>"
Then el codigo de respuesta HTTP deberiaa ser 200


  @CP4
  Scenario: Eliminar un pasajero exitosamente
    Given el actor establece el endpoint DELETE para actualizar un pasajero
    When el envia  una solicitud HTTP DELETE con el "<id>"
    Then el codigo de respuesta HTTP deberiaa ser 200
