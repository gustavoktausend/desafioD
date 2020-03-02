import React, {useState, useLayoutEffect} from 'react';
import { Row, Col, FormGroup, Card, CardBody, Button } from 'reactstrap';
import { lancheApi } from '../../../api';


export default () => {
    const [items, setItems] = useState([]);
    const [reqItems, setReqItems] = useState([]);

    useLayoutEffect(() => {
        const fetchData = async() => {
            if (!Object.keys(items).length) {
                try {
                    const {data} = await lancheApi.getAllIngredientes();
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
                            <h3>Montagem</h3>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            {items.map(item => {return <><br/> <Button color='secondary'> {item} </Button> <br/></> } )}
                        </Col>
                        <Col>

                        </Col>
                    </Row>


                </CardBody>
            </Card>
        </FormGroup>
    );
};