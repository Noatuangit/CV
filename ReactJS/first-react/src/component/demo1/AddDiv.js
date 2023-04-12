import React, { useState } from 'react'
import OptionDiv from './OptionDiv';
import validationCustom from './CustomValidation';


export default function AddDiv(props) {
    const hiddenAdd = props.data;
    const [state, setState] = useState();
    const [stateValid, setStateValid] = useState([]);

    const onChangeSelect = (option) => {
        setState({ ...state, category: option });
    }

    function handleChange(e) {
        setState({ ...state, [e.target.name]: e.target.value });
    }

    const resetForm = () => {
        let choice = window.confirm("reset form???");
        if (choice) {
            document.getElementById("form-add").reset();
        }
    }

    const onSubmit = (e) => {
        e.preventDefault();
        setState({ ...state, id: Date.now() });
        let valid = validationCustom(Object.fromEntries(new FormData(e.target)));
        if (valid[1]) {
            props.onSubmit(state);
            document.getElementById("form-add").reset();
            setStateValid({})
            return;
        }
        setStateValid(valid[0]);
    }

    const warning = { color: "red" };

    return (
        <div>
            <form onSubmit={onSubmit} id="form-add">
                <div className={`tab-pane ${hiddenAdd}`} id="form-tab-pane" role="tabpanel" tabIndex="0">
                    <div className="form-field align-items-end">
                        <div className="me-3">
                            <label htmlFor="title-input" className="form-label">Title</label>
                            {(stateValid.requiredTitle !== undefined) && <span style={warning}> không được để trống.</span>}
                            <input
                                type="text"
                                className="form-control"
                                id="title-input"
                                defaultValue=""
                                name="title"
                                onChange={(e) => { handleChange(e) }}
                            />

                        </div>
                        <div className="me-3">
                            <label htmlFor="category-input" className="form-label">Category</label>
                            {(stateValid.requiredCategory !== undefined) && <span style={warning}> không được để trống.</span>}
                            <OptionDiv onChange={onChangeSelect} />
                        </div>
                        <div className="me-3">
                            <label htmlFor="author-input" className="form-label">Author</label>
                            {(stateValid.requiredAuthor !== undefined) && <span style={warning}> không được để trống.</span>}
                            {(stateValid.patternAuthor !== undefined) && <span style={warning}> không được có số.</span>}
                            <input
                                type="text"
                                defaultValue=""
                                className="form-control"
                                onChange={(e) => { handleChange(e) }}
                                id="author-input"
                                name="author" />
                        </div>
                        <div className="me-3">
                            <label htmlFor="release-year-input" className="form-label">Release year</label>
                            {(stateValid.requiredYear !== undefined) && <span style={warning}> không được để trống.</span>}
                            {(stateValid.patternYear !== undefined) && <span style={warning}> không được có chữ.</span>}
                            {(stateValid.maxYear !== undefined) && <span style={warning}> không quá năm hiện tại.</span>}
                            <input
                                type="text"
                                className="form-control"
                                defaultValue=""
                                onChange={(e) => { handleChange(e) }}
                                id="release-year-input"
                                name="year" />
                        </div>
                        <div className="mt-3">
                            <button className="btn btn-primary" id="submit-button" type='submit'>Submit</button>
                            <button className="btn btn-outline-primary" id="cancel-button" type='button' onClick={resetForm}>Cancel</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    )
}
