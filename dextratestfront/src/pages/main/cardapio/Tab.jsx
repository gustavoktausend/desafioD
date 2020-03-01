import React from 'react';
import { Row, Col, FormGroup, Card, CardBody } from 'reactstrap';
import  Item  from './item';

export default () => (
    <FormGroup>
        <Card style={{borderTop:0}}>
            <CardBody>
                <Row>
                    <Col style={{ display: 'flex' }}>
                        <h3>Cardapio</h3>
                    </Col>
                </Row>
                <Row>
                    <Item/>
                </Row>
            </CardBody>
        </Card>
    </FormGroup>
);