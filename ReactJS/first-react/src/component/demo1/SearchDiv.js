import React from 'react'
import OptionDiv from './OptionDiv';

export default function SearchDiv(props) {
    const hiddenSearch = props.data;
    const onChangeSelect = (data) => {

    }
    const onSubmit = (e) => {
        e.preventDefault();
        let data = Object.fromEntries(new FormData(e.target));
        props.searchSubmit(data);
        document.getElementById("formSearch").reset();
    }

    const clearForm = () => {
        let choice = window.confirm("reset form???");
        if (choice) {
            document.getElementById("formSearch").reset();
        }
    }
    return (
        <div>
            <form onSubmit={onSubmit} id="formSearch">
                <div className={`tab-pane ${hiddenSearch}`} id="search-tab-pane" role="tabpanel" tabIndex="0">
                    <div className="search-field align-items-end">
                        <div className="me-3">
                            <label htmlFor="keyword-input" className="form-label">Keyword</label>
                            <input type="text" className="form-control" id="keyword-input" name="keyword" placeholder="Enter 3 character for search" />
                        </div>
                        <div className="me-3">
                            <label htmlFor="category-input" className="form-label">Category</label>
                            <OptionDiv onChange={onChangeSelect} />
                        </div>
                        <div style={{ marginTop: "5px" }}>
                            <button className="btn btn-primary" id="search-button" type='submit'>Search</button>
                            <button className="btn btn-outline-primary" id="clear-button" onClick={clearForm}>Clear</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    )
}
