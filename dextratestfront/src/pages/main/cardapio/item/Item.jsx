import React,{ useState } from 'react';
import { Row, Col, FormGroup, Card, CardBody, CardFooter } from 'reactstrap';

export default({data}) => {

    return(
        <Col md={3}>
              <Card>
                  <CardBody style={{minHeight: 160 }}>
                      {data.nomeLanche}
                      <br/>
                      <Col>
                          {data.ingredientes.map(ingrediente => {
                              let color;
                              switch (ingrediente) {
                                  case "OVO" : color = '#e19753';
                                      break;
                                  case "BACON" : color = '#f55a5a';
                                      break;
                                  case "HAMBURGUER_CARNE" : color = '#af2e00';
                                      break;
                                  case "QUEIJO" : color = '#b8ad40';
                                      break;
                                  case "ALFACE" : color = '#238a00';
                                      break;
                                  default : color = '#000000';
                              }
                              return <li> <b style={{color:color}}>{ingrediente}</b></li>
                            })
                          }
                      </Col>
                  </CardBody>
                  <CardFooter>
                      Valor : {new Intl.NumberFormat('pt-BR', {style:'currency', currency: 'BRL' }).format(data.valorLanche)  }
                  </CardFooter>
              </Card>
        </Col>
    )
}
