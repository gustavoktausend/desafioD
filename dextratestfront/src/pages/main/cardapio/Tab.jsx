import React, {useState, useLayoutEffect} from 'react';
import { Row, Col, FormGroup, Card, CardBody } from 'reactstrap';
import  Item  from './item';
import { lancheApi } from '../../../api';

export default () => {
    const [items, setItems] = useState([]);

    useLayoutEffect(() => {
        const fetchData = async() => {
            if (!Object.keys(items).length) {
                try {
                    const {data} = await lancheApi.get();
                    setItems(data);
                } catch (e) {
                    console.error(e);
                }
            }
        };
        fetchData();
    }, [items]);

    return (
        <FormGroup>
            <Card style={{borderTop: 0}}>
                <CardBody>
                    <Row>
                        <Col style={{display: 'flex'}}>
                            <h3>Cardapio</h3>
                        </Col>
                    </Row>
                    <Row>
                        {items.map(item => <Item key={item.nomeLanche} data={item} /> )}
                    </Row>
                </CardBody>
            </Card>
        </FormGroup>
    );
};