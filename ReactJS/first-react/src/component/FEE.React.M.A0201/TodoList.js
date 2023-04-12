import React, { Component } from 'react'
import { Button } from 'react-bootstrap'
import { Form, Table } from 'react-bootstrap';
export default class TodoList extends Component {
    constructor() {
        super();
        this.state = { arrayVar: [] };
        this.onSubmit = this.onSubmit.bind(this);

    }

    onSubmit(event) {
        event.preventDefault();
        const formData = {
            id: Date.now(),
            item: Object.fromEntries(new FormData(event.target)).item,
            status: "incomplete"
        };

        this.setState({
            arrayVar: [...this.state.arrayVar, formData]
        })

        document.getElementById("form").reset();
    }

    removeItem(current) {
        this.setState({
            arrayVar: this.state.arrayVar.filter(item => item.id != current.id)
        })
    }

    changeStatus(current) {
        this.setState({
            arrayVar: this.state.arrayVar.map(x => {
                if (x.id == current.id) {
                    x.status = "complete";
                }
                return x;
            })
        })
    }

    render() {
        return (
            <div style={{ textAlign: "center" }}>
                <div>
                    <h1>TODO</h1>
                    <Form id="form" onSubmit={this.onSubmit}>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Control placeholder='Input to do' name="item" required style={{ width: "60%", marginLeft: "20%" }} />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </div>
                <div >
                    <Table striped bordered hover size="sm" style={{ width: "60%", marginLeft: "20%" }}>
                        <tbody>
                            {this.state.arrayVar.map(x =>
                                <tr key={x.id} style={{ height: "50px" }}>
                                    <td colSpan="2" onClick={() => {
                                        this.changeStatus(x);
                                    }}>{x.item}</td>
                                    <td onClick={() => {
                                        this.changeStatus(x);
                                    }}>
                                        {x.status}
                                    </td>
                                    <td>
                                        {x.status == "incomplete" &&
                                            <Button variant="danger" onClick={() => {
                                                this.removeItem(x)
                                            }
                                            }
                                            > Delete
                                            </Button>
                                        }
                                    </td>
                                </tr>)}
                        </tbody>
                    </Table>
                </div>

            </div >
        )
    }
}
