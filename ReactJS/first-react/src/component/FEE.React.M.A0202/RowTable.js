import React, { Component } from 'react'

export default class RowTable extends Component {
    constructor(props) {
        super(props);
    }

    converterDate(stringDate) {
        let [year, month, day] = (stringDate + "").split("-")
        return `${day}/${month}/${year}`;
    }
    converterPhone(stringPhone) {
        return (stringPhone + "").replace("(", "").replace(")", "").replace(" ", "");
    }

    render() {
        return (
            <tbody>
                {this.props.list.map((currentItem, index) =>
                    <tr key={index + 1}>
                        <td>{index + 1}</td>
                        <td>{currentItem.first_name}</td>
                        <td>{currentItem.last_name}</td>
                        <td>{this.converterDate(currentItem.birthday)}</td>
                        <td>{currentItem.email}</td>
                        <td>{currentItem.gender}</td>
                        <td>{currentItem.salary}</td>
                        <td>{this.converterPhone(currentItem.phone)}</td>
                    </tr>)
                }
            </tbody>
        )
    }
}
