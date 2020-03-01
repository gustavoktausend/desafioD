import React, { useState } from 'react';
import { Form, TabContent, TabPane, Nav } from 'reactstrap';
import { TabSelector } from "../../components";
import CardapioTab from './cardapio';

export default () => {
    const [activeTab, setActiveTab] = useState('1');
    const toggle = tab => activeTab !== tab && setActiveTab(tab);


    return (
        <>
            <Form>
                <Nav className="ml-auto" tabs>
                    <TabSelector onClick={toggle} tabIndex="1" activeTab={activeTab}>Cardapio</TabSelector>
                </Nav>
                <TabContent activeTab={activeTab}>
                    <TabPane tabId="1">
                        <CardapioTab/>
                    </TabPane>
                </TabContent>
            </Form>
        </>
    );
};