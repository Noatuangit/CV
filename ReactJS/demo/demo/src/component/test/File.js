import React, { useEffect, useState } from 'react'
import './File.css'
import '../../fontawesome-free-6.3.0-web/css/all.css'

import Modal from './Modal';
import Participants from './Participants';
import ChatDiv from './ChatDiv';

export default function File() {
    let data = [{ name: "Le ngoc tuan" }, { name: "Le bao nhi" }, { name: "Le thai khang" }, { name: "Le nguyen thao uyen" }];

    const [chatMessage, setChat] = useState([
        { name: "Le ngoc tuan", message: "hello" },
        { name: "Le bao nhi", message: "chao moi nguoi" },
        { id: 123, name: 'You', message: "hello" },
        { name: "Le thai khang", message: "xin chao" }]);

    const [control, setControl] = useState({ camera: false, chat: false, participants: false, modal: false });

    const [time, setTime] = useState(new Date().toLocaleString() + "");

    const onClick = () => {
        setControl({ ...control, modal: false });
    }

    useEffect(() => {
        setInterval(() => setTime(new Date().toLocaleString() + ""), 1000)
        setTime(new Date().toLocaleString() + "");
    }, [time])

    const handleClick = (id) => {
        setChat([...chatMessage.filter(x => x.id !== id)]);
    }

    const handleChat = (data) => {
        setChat(data);
    }

    return (
        <div>
            <div className='main'>
                <div className='bai-test-item-left'>
                    <div className='bai-test-top-left ' style={{ textAlign: "center", justifyContent: "space-between" }}>
                        <div className='header'>
                            <div>
                                <h1>Room name</h1>
                                <p>{time}</p>
                            </div>
                            <div>
                                <i className="fa-solid fa-cog" onClick={() => setControl({ ...control, modal: true })} style={{ cursor: "pointer" }}></i>
                            </div>
                        </div>
                    </div>
                    <div className='bai-test-center-left' style={{ textAlign: "center" }}>
                        <h1>{control.camera ? "Camera is on" : "Camera is off"}</h1>
                    </div>
                    <div className='bai-test-bot-left'>
                        <button className='button-radius' style={control.camera ? { background: "blue" } : { background: "white" }} onClick={() => setControl({ ...control, camera: !control.camera })}>
                            <i className="fa-solid fa-camera" style={control.camera ? { color: "white" } : { color: "blue" }}></i>
                        </button>
                        <button className='button-radius' style={control.participants ? { background: "blue" } : { background: "white" }} onClick={() => setControl({ ...control, participants: !control.participants })}>
                            <i className="fa-solid fa-users" style={control.participants ? { color: "white" } : { color: "blue" }}></i>
                        </button>
                        <button className='button-radius' style={control.chat ? { background: "blue" } : { background: "white" }} onClick={() => setControl({ ...control, chat: !control.chat })} >
                            <i className="fa-solid fa-comment" style={control.chat ? { color: "white" } : { color: "blue" }}></i>
                        </button>
                    </div>
                </div>
                <div className='bai-test-item-right'>
                    {control.participants &&
                        <Participants data={data} />}
                    {control.chat && <ChatDiv participants={control.participants} data={chatMessage} handleChat={handleChat} onClick={handleClick} />
                    }
                </div>
            </div>
            {
                control.modal && <Modal onClick={onClick}></Modal>
            }

        </div>
    )
}
