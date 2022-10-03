Feature: Search Province

  Rule: Search Province for POST request

      @Get_province
      Scenario Outline: Search Province
        Given User sends <Endpoint> request to search province
        Then User validates body response retrieved that contains <Town> and <CD>


        Examples:
          | Endpoint                                                            | Town | CD |
          | /ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio | VIGO | 54 |
