import React from 'react'

export default function Radio(props) {
    const handleChange = (event) => {
        props.handleChange(event);
    }

    return (
        <div>
            {props.list.map(item =>
                <div key={item + props.name} className="column">
                    <ul style={{ listStyle: "none", display: "inline" }} >
                        <label>{item}</label>
                        <li style={{ listStyle: "none", display: "inline" }}>
                            <input type="radio"
                                checked={props.value === item}
                                onChange={handleChange}
                                name={props.name}
                                value={props.unit ?? item}
                            />
                        </li>
                    </ul>

                </div>)}
        </div>
    );
}
