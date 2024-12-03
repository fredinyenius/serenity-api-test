@Airlines
Feature: API Aerilineas


  Como un usuario de la API de aerolíneas
  Quiero obtener la lista de todas las aerolíneas
  Para poder verificar los detalles de las aerolíneas disponibles

  @CP1

  Scenario: Obtener todas las aerolíneas
    Given el actor establece el endpoint para obtener las aerolineas
    When el actor envia una solicitud
    Then el codigo de respuesta deberia ser 200


  @CP02
  Scenario Outline:Crear una aerolinea exitosamente
    Given el actor establece el endpoint POST para crear una aerolinea
    When el envia una solicitud HTTP POST con el "<_id>" "<name>" "<country>" "<logo>" "<slogan>" "<head_quaters>" "<website>" "<established>"
    Then el codigo de respuesta HTTP deberia ser 200
    Examples:

      |  | _id | name           | country | logo     | slogan                   | head_quaters | website     | established |
      |  | 1   | Ramon Castilla | Lima    | lima.png | Miraflores ciudad amable | Miraflores   | flowers.com | 1857        |
      |  | 3   | Alfredo Parodi | Lima    | lima.png | Centro financiero        | San Isidro   | isidro.pe   | 1931        |

