import React, { useEffect } from 'react'

export default function Page(props) {
    const classDiv = { width: "40px", backgroundColor: "white", borderRadius: "20px", color: "black", height: "40px", border: "1px solid black", padding: "7px 5px 15px 15px" };
    let page = 0;
    let pageDisplay = 0;
    const handleClick = (e) => {
        this.props.onClickPage(e);
    }
    return (
        <ul style={{ display: 'flex', listStyle: 'none', cursor: 'pointer' }}>
            {
                props.data.map((item, index) => {
                    if (index === page) {
                        let pageCurrent = page;
                        pageDisplay += 1;
                        page += 5;
                        return <li style={classDiv} onClick={handleClick(pageCurrent)} key={Date.now() + page}>
                            {pageDisplay}
                        </li>
                    }
                })}
        </ul>
    )
}
