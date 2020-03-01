import React from 'react';
import { NavItem, NavLink } from 'reactstrap';
import classnames from 'classnames';
import './tabSelector.css';

export default ({ activeTab, tabIndex, onClick, children }) => (
    <NavItem>
        <NavLink className={classnames({ active: activeTab === tabIndex })}
                 onClick={() => onClick(tabIndex)} style={{ cursor: "pointer" }}>
            { children }
        </NavLink>
    </NavItem>
)