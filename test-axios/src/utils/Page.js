import React, { useState, useMemo } from 'react'

export default function Page(props) {
    const [page, setPage] = useState([]);

    useMemo(() => {
        setPage(new Array(props.totalPages).fill(0));
    }, [props]);

    return (
        <div>
            <nav aria-label="Page navigation example">
                <ul className="pagination">
                    {props.number > 0 && <ul className="pagination"><li className="page-item">
                        <button className="page-link" onClick={() => props.handleClick(0)}>
                            <i className="fa-solid fa-angles-left"></i>
                        </button>
                    </li>
                        <li className="page-item">
                            <button className="page-link" onClick={() => props.handleClick(props.number - 1)}>
                                <i className="fa-solid fa-angle-left"></i>
                            </button>
                        </li></ul>}
                    {page.map((item, index) =>
                        <li className="page-item" key={index + item}>
                            <button className={index === props.number ? "btn btn-primary" : "btn btn-light"}
                                onClick={() => props.handleClick(index)}>{index + 1}</button>
                        </li>
                    )}
                    {props.number < props.totalPages - 1 && <ul className="pagination">
                        <li className="page-item">
                            <button className="page-link" onClick={() => props.handleClick(props.number + 1)}>
                                <i className="fa-solid fa-angle-right"></i>
                            </button>
                        </li>
                        <li className="page-item">
                            <button className="page-link" onClick={() => props.handleClick(props.totalPages - 1)}>
                                <i className="fa-solid fa-angles-right"></i>
                            </button>
                        </li>
                    </ul>}
                </ul>
            </nav>
        </div>
    )
}
