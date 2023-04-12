import React from 'react'

export default function SearchForm(props) {
    const style = { marginLeft: "10px", marginRight: "10px" };

    const onSubmit = (e) => {
        e.preventDefault();
        let formData = Object.fromEntries(new FormData(e.target)).condition;
        props.onSubmit(formData.trim());
    }

    const reset = () => {
        document.getElementById("condition").value = "";
        props.onSubmit("");
    }

    return (
        <div>
            <form onSubmit={onSubmit} id="form">
                <div className="input-group">
                    <input type="search" className="form-control rounded" name='condition' id="condition" placeholder="Search" style={style} aria-label="Search" />
                    <button type="submit" className="btn btn-outline-primary" style={style}>search</button>
                    <button type="button"
                        className="btn btn-outline-info"
                        style={style}
                        onClick={reset}
                    >Reset</button>
                </div>
            </form>
        </div>
    )
}
