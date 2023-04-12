import React, { Component } from 'react'
import customerData from './users.json';
import RowTable from './RowTable';
import PageDiv from './PageDiv';
import { Form, Button } from 'react-bootstrap';

export default class Table extends Component {
    flag = true;
    constructor() {
        super();
        this.state = { data: customerData.slice(0, 5) };
    }

    pageDiv(index) {
        this.setState({ data: customerData.slice(index * 5, index * 5 + 5) });
    }

    onClickPage = (page) => {
        this.setState({ data: customerData.slice(page, page + 5) })
    }

    onSubmit = (e) => {
        e.preventDefault();
        const name_filter = Object.fromEntries(new FormData(e.target)).name;
        this.flag = false;
        this.setState({
            data: customerData.filter(x => {
                for (let keys of Object.keys(x)) {
                    if ((x[keys] + "").includes(name_filter))
                        return true;
                }
                return false;
            })
        });
        document.getElementById("searchForm").reset();

    }

    onChangeSort(event) {
        let fieldSearch = event.target.value;
        let sort = customerData.sort((x, y) => {
            if (x[fieldSearch] > y[fieldSearch]) {
                return 1;
            }
            return -1
        }).slice(0, 5);
        this.setState({ data: sort });
    }

    resetPage() {
        this.flag = true;
        this.setState({ data: customerData.slice(0, 5) })
    }

    render() {
        return (
            <div>
                <h1>Simple Table By TuanLN6</h1>
                <div style={{ display: "flex", justifyContent: "space-between" }}>
                    <select className="form-select"
                        value='DEFAULT'
                        aria-label="Default select example"
                        id="select_sort"
                        name="select_sort"
                        style={{ width: "500px" }}
                        onChange={(e) => this.onChangeSort(e)}>
                        <option value="DEFAULT" disabled>Select field to sort</option>
                        <option value="first_name">First Name</option>
                        <option value="last_name">Last Name</option>
                        <option value="birthday">Birthday</option>
                        <option value="email">Email</option>
                        <option value="gender">Gender</option>
                        <option value="salary">Salary</option>
                        <option value="phone">Phone</option>
                    </select>
                    <button className='btn btn-info' onClick={() => this.resetPage()}>Reset</button>
                    <Form className="d-flex" onSubmit={this.onSubmit} id="searchForm">
                        <Form.Control
                            type="search"
                            placeholder="Search by name"
                            className="me-2"
                            name="name"
                            aria-label="Search"
                        />
                        <Button variant="success" type='submit' >Search</Button>
                    </Form>
                </div>
                <table className="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Birthday</th>
                            <th scope="col">Email</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Salary</th>
                            <th scope="col">Phone</th>
                        </tr>
                    </thead>

                    <RowTable list={this.state.data} />

                </table>

                {this.flag && <PageDiv onClickPage={this.onClickPage} />}
            </div>
        )
    }
}

