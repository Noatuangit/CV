import React from 'react'

export default function NoResult(props) {
    return (
        <tr>
            <td colSpan={props.column} style={{ textAlign: "center" }}>
                No record suitable with condition
            </td>
        </tr>
    )
}
