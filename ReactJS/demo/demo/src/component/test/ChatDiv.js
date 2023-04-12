import React, { useEffect, useState } from 'react'
import "../../fontawesome-free-6.3.0-web/css/all.css"
export default function ChatDiv(props) {
    const [oldMessage, setOldMessage] = useState([]);

    useEffect(() => {
        setOldMessage([...props.data]);
    }, [props])

    const onSubmit = (e) => {
        e.preventDefault();
        let getMessage = { id: Date.now(), message: Object.fromEntries(new FormData(e.target)).message };
        if (getMessage.message.trim() === '') {
            window.alert("input something to send!");
            return;
        }
        document.getElementById("message").value = "";
        props.handleChat([...oldMessage, getMessage]);
    }

    function onClick(id) {
        props.onClick(id);
    }
    return (
        <div className='right'>
            <div className={props.participants ? "bai-test-center-right" : "bai-test-top-right"} style={props.participants ? {} : { maxHeight: "500px" }}>
                <h1>Chat</h1>
                <table className='table'>
                    <tbody>
                        {
                            oldMessage.map(item => {
                                if (item.id === undefined) {
                                    return <tr key={item.name + item.message}>
                                        <td>{item.name}:{item.message}</td>
                                        <td></td>
                                    </tr>
                                }
                                return <tr key={item.id + item.message}>
                                    <td></td>
                                    <td>
                                        <button className='button-radius' onClick={() => onClick(item.id)}>X</button>
                                        {item.message}: you
                                    </td>
                                </tr>
                            })
                        }
                    </tbody>
                </table>

            </div>
            <div className={props.participants ? "bai-test-bot-right" : "bai-test-bot-right-fix"} >
                <form onSubmit={onSubmit} id="form">
                    <input type="text" name="message" id="message" />
                    <button type='submit' >
                        <i className="fa-solid fa-paper-plane"></i>
                    </button>
                </form>
            </div>
        </div>
    )
}
