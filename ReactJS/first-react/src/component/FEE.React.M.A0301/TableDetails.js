import React from 'react'
import "./Form.css"
export default function TableDetails() {
    return (
        <React.Fragment>
            <h1>View content</h1>
            <hr />
            <div className="main-body">
                <h3>View content list</h3>
                <div className="table-container">
                    <div className="mb3">
                        <table>
                            <tr>
                                <th id="first-column">
                                    #
                                </th>
                                <th id="title-column">
                                    Title
                                </th>
                                <th id="brief-column">
                                    Brief
                                </th>
                                <th id="date-column">
                                    Create Date
                                </th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Lorem ipsum dolor sit amet consectetur adipisicing elit. </td>
                                <td>Eveniet ea sint eaque qui deleniti dolorem nemo dignissimos dicta, unde consequatur
                                    incidunt accusamus eum, distinctio fugiat quia culpa tempora? Perferendis, suscipit!
                                </td>
                                <td>30/08/2022 12:04</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Lorem ipsum dolor sit amet consectetur adipisicing elit. </td>
                                <td>Eveniet ea sint eaque qui deleniti dolorem nemo dignissimos dicta, unde consequatur
                                    incidunt accusamus eum, distinctio fugiat quia culpa tempora? Perferendis, suscipit!
                                </td>
                                <td>30/08/2022 12:04</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Lorem ipsum dolor sit amet consectetur adipisicing elit. </td>
                                <td>Eveniet ea sint eaque qui deleniti dolorem nemo dignissimos dicta, unde consequatur
                                    incidunt accusamus eum, distinctio fugiat quia culpa tempora? Perferendis, suscipit!
                                </td>
                                <td>30/08/2022 12:04</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>

        </React.Fragment>
    )
}
