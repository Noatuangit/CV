import React, { useEffect, useState } from 'react'

export default function Participants(props) {
    const [customer, setCustomer] = useState([]);

    const onSubmit = (e) => {
        e.preventDefault();
        let formData = Object.fromEntries(new FormData(e.target)).search.toLocaleLowerCase();
        if (formData === "") {
            setCustomer(props.data);
        } else {
            setCustomer([...customer.filter(x => x.name.toLocaleLowerCase().includes(formData))]);
        }
        document.getElementById("form").reset();
    }

    useEffect(() => {
        setCustomer(props.data);
    }, [props])

    return (
        <div className='bai-test-top-right'>
            <h1>Participants</h1>
            <form onSubmit={onSubmit} id="form">
                <div className="input-group">
                    <input type="search" className="form-control rounded" placeholder="username" aria-label="Search" style={{ height: "50px" }}
                        name="search" described="search-addon" />
                    <button type="submit" className="btn btn-outline-primary" style={{ height: "50px" }}>
                        <i className="fa-solid fa-search" />
                    </button>
                </div>
            </form>

            <ul>
                {customer.map(item => <li key={item.name}>
                    {item.name}</li>)}
            </ul>
        </div>
    )
}
