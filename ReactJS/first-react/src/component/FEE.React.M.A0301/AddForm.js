import React from 'react'
import "./Form.css"
export default function AddForm() {
    return (
        <React.Fragment>
            <h1>Add content</h1>
            <hr />
            <div className="main-body">
                <h3>Content Form Element</h3>
                <form>
                    <div className="mb-3">
                        <label for="title-content" className="form-label">Title</label>
                        <input type="text" className="form-control" name="first-name" id="title-content"
                            described="firstNameHelp" />
                    </div>
                    <div className="mb-3">
                        <label for="bief" className="form-label">Brief</label>
                        <textarea id="brief" name="brief" className="field-text-area"></textarea>
                    </div>

                    <div className="mb-3">
                        <label for="description-view" className="form-label">Description</label>
                        <textarea id="description-view" name="description-view" className="field-text-area"></textarea>
                    </div>
                    <div className="mb-3">
                        <button type="reset" className="submit-button">Reset Button</button>

                        <button type="submit" className="submit-button">Submit Button</button>
                    </div>
                </form>
            </div>
        </React.Fragment>
    )
}
