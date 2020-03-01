import React from 'react';
import { Navbar, NavbarBrand } from 'reactstrap';
import './header.css';

export default () => (
    <Navbar style={{ backgroundColor: '#242323'}} dark expand="md" fixed>
        <NavbarBrand tag="span" style={{cursor: 'pointer'}}>
            Teste Dextra
        </NavbarBrand>
    </Navbar>
);