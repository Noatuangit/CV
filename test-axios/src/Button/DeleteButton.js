import axios from 'axios'
import React from 'react'

export default function DeleteButton(props) {

    const deleteItem = () => {
        if (props.id) {
            axios.put(`${props.url}/${props.id}`)
                .then(resp => props.rerender())
            return;
        }
        axios.put(`${props.url}/delete`, props.item, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => props.rerender())
    }

    return (
        <React.Fragment>
            <button className='btn btn-danger' style={{ width: "40px" }} data-bs-toggle="modal" data-bs-target={`#modal-${props.id}`} >
                <i className="fa-solid fa-eraser"></i>
            </button>
            <div className="modal fade" id={`modal-${props.id}`} tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-sm">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            Delete this item ?
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" className="btn btn-danger" data-bs-dismiss="modal" onClick={deleteItem}> Delete</button>
                        </div>
                    </div>
                </div>
            </div>
        </React.Fragment>
    )
}
