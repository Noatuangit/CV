import React from 'react'

export default function SelectOption(props) {

    const handleChange = (event) => {
        props.handleChange(event);
    }

    return (
        <div>
            <select className="form-select" aria-label="Default select example" value={props.value} name={props.name}
                onChange={handleChange}>
                {props.list.map(item => <option value={item} key={item}>{item}</option>)}
            </select>
        </div>
    )
}
