import React from 'react'

export default function OptionDiv(props) {
    const category = ["truyện kí", "trinh thám", "tiểu thuyết"];
    const handleChange = (e) => {
        props.onChange(e.target.value);
    }
    return (
        <React.Fragment>
            <select onChange={handleChange} defaultValue='' name='category' className="form-select" id="category-input">
                <option value='' disabled>Choice </option>
                {category.map(item =>
                    <option key={Date.now() + Math.random(100)} value={item} className="form-select"> {item} </option>)
                }
            </select>
        </React.Fragment>
    )
}
