import React from 'react';
import { Container, Row, Col } from 'reactstrap';
import { Header } from './components';
import { MainPage } from './pages';
import logo from './logo.svg';
import './App.css';

export default () => {
    return (
        <>
            <Header/>
            <br/>
            <Container fluid style={{ height:(window.innerHeight * 0.9) }}>
                <Row>
                    <Col md={{size: 10, offset: 1}} sm>
                        <MainPage/>
                    </Col>
                </Row>
            </Container>
        </>
    )
};