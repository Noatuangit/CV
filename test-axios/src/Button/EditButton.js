import React from 'react'
import CreateCustomer from '../Customer/CreateCustomer'
import { Link } from 'react-router-dom'

export default function EditButton(props) {
    const handleClick = () => <CreateCustomer id={props.id} url={props.url} />

    return (
        <div>
            <Link as={Link} className="dropdown-item" to={`/${props.url}/${props.id}`} style={{ textDecoration: 'none' }}>
                <button className='btn btn-warning' style={{ width: "40px" }} onClick={handleClick}>
                    <i className="fa-solid fa-user-pen">
                    </i>
                </button>
            </Link>
        </div>
    )
}
