import React, { useMemo, useState } from 'react'
import "../layout.css"
import { serRest } from '../../utils/UrlPack';
import axios from 'axios';
import Page from '../../utils/Page';

import DeleteButton from '../../Button/DeleteButton';
import { Link } from 'react-router-dom';
import SearchForm from '../../Search/SearchForm';
import NoResult from '../../Layout/NoResult';
export default function Service() {
  const [state, setState] = useState({ data: { content: [] } });
  const [render, setRender] = useState(false);
  const [condition, setCondition] = useState("");

  const rerender = () => setRender(!render)
  useMemo(() => {
    axios.get(`${serRest}?c=${condition}`).then(resp => setState(resp));
  }, [render, condition])

  function handleClick(page) {
    axios.get(`${serRest}?p=${page}&c=${condition}`).then(res => {
      setState(res);
    })
  }
  const onSubmit = (data) => {
    setCondition(data)
  }
  return (
    <div>
      <div className="main">
        <div className="wrap-item">
          <Link as={Link} to="create"> <button className='btn btn-success'><i className="fa-solid fa-plus"> </i> Create</button> </Link>
        </div>
        <div className="wrap-item-center">
          <SearchForm
            onSubmit={onSubmit}
          />
          <table className="table table-striped">
            <thead>
              <tr>
                <td>#</td>
                <td>Customer name</td>
                <td>id service</td>
                <td>Date begin</td>
                <td>Time begin</td>
                <td>Amount</td>
                <td></td>
              </tr>
            </thead>
            <tbody>
              {state.data.content.length > 0 && state.data.content.map((item, index) => <tr key={Date.now() + index}>
                <td>{index + 1}</td>
                <td>{item.customerName}</td>
                <td>{item.serviceId}</td>
                <td>{item.date_use}</td>
                <td>{item.time_begin}</td>
                <td>{item.amount}</td>
                <td>
                  <DeleteButton url={serRest}
                    item={item}
                    rerender={rerender} />
                </td>
              </tr>)}
              {
                state.data.content.length == 0 &&
                <NoResult column={7} />
              }
            </tbody>
          </table>
          <Page
            totalPages={state.data.totalPages}
            number={state.data.number}
            handleClick={handleClick}
          />
        </div>
      </div>
    </div>
  )
}
