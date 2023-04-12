import React, { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import "./Form.css"

export default function EditForm() {
    let { email } = useParams();
    return (
        <React.Fragment>
            <h1>Edit Profile</h1>
            <hr />
            <div className="main-body">
                <h3>Profile Form Element</h3>
                <form>
                    <div className="mb-3">
                        <label for="first-name" className="form-label">First name</label>
                        <input type="text" className="form-control" name="first-name" id="first-name"
                            described="firstNameHelp" />
                    </div>
                    <div className="mb-3">
                        <label for="last-name" className="form-label">Last name</label>
                        <input type="text" className="form-control" id="last-name" name="last-name"
                            described="lastNameHelp" />
                    </div>
                    <div className="mb-3">
                        <label for="phone" className="form-label">Phone</label>
                        <input type="text" className="form-control" id="phone" name="phone" described="phoneHelp" />
                    </div>
                    <div className="mb-3">
                        <label for="email-id" className="form-label">Email</label>
                        <input type="text" className="form-control" id="email-id" name="email" disabled value={email}
                            described="emailHelp" />
                    </div>
                    <div className="mb-3">
                        <label for="description" className="form-label">Description</label>
                        <textarea id="description" name="description" className="field-text-area"></textarea>
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
