import React, { useEffect, useState } from 'react'
import "../../fontawesome-free-6.3.0-web/css/all.css"

export default function RoleTable(props) {
    const [tableData, setTableData] = useState([]);
    const converterDisplay = (data) => {
        let arrays = data.map(item => {
            if (item.role == "Manager") {
                return { ...item, create: true, edit: true, view: true };
            }
            if (item.role == "Support") {
                return { ...item, create: false, edit: true, view: true };
            }
            return { ...item, create: false, edit: false, view: true };
        })
        return arrays;
    }
    useEffect(() => {
        setTableData(converterDisplay(props.data));
    }, [props])
    return (
        <div>
            <table className='table'>
                <thead>
                    <tr>
                        <td>
                            #
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Roles
                        </td>
                        <td>
                            Creator
                        </td>
                        <td>
                            Editor
                        </td>
                        <td>
                            Viewer
                        </td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    {
                        tableData.map((item, index) =>
                            <tr key={item.user + item.role + index}>
                                <td>{index + 1}</td>
                                <td>{item.user}</td>
                                <td>{item.role}</td>
                                <td>{item.create && <span><i class="fa-solid fa-check"></i></span>}</td>
                                <td>{item.edit && <span><i class="fa-solid fa-check"></i></span>}</td>
                                <td>{item.view && <span><i class="fa-solid fa-check"></i></span>}</td>
                                <td>
                                    <button>edit</button>
                                    <button>delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
