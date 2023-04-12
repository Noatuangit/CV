import React, { useEffect, useState } from 'react'

export default function PageView(props) {
    const [pageState, setPage] = useState([]);
    useEffect(() => {
        setPage(props.list)
    }, [props])
    const classDiv = { width: "40px", backgroundColor: "white", borderRadius: "5px", color: "black", height: "40px", border: "1px solid black", padding: "7px 5px 15px 15px" };
    let page = 0;
    let pageDisplay = 0;
    return (
        <div>
            <ul style={{ display: 'inline-block' }}>
                <ul style={{ display: 'flex', listStyle: 'none', cursor: 'pointer' }}>
                    {
                        pageState.map((item, index) => {
                            if (index === page) {
                                let pageCurrent = page;
                                pageDisplay += 1;
                                page += 2;
                                return <li style={classDiv} onClick={() => props.handleClick(pageCurrent)} key={Date.now() + page}>
                                    {pageDisplay}
                                </li>
                            }
                        })}
                </ul>
            </ul>
        </div>
    )
}
