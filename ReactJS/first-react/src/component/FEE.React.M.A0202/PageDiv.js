import React, { Component } from 'react'
import customerData from './users.json';

export default class PageDiv extends Component {
    constructor() {
        super();
    }

    handleClick(e) {
        this.props.onClickPage(e);
    }

    render() {
        const classDiv = { width: "40px", backgroundColor: "white", borderRadius: "20px", color: "black", height: "40px", border: "1px solid black", padding: "7px 5px 15px 15px" };
        let page = 0;
        let pageDisplay = 0;
        let data = customerData;
        return (
            <ul style={{ display: 'flex', listStyle: 'none', cursor: 'pointer' }}>
                {
                    data.map((item, index) => {
                        if (index === page) {
                            let pageCurrent = page;
                            pageDisplay += 1;
                            page += 5;
                            return <li style={classDiv} onClick={() => this.handleClick(pageCurrent)} key={Date.now() + page}>
                                {pageDisplay}
                            </li>
                        }
                    })}
            </ul>
        )
    }
}
