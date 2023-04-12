import React, { useState } from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import OrderManager from './component/Order/OrderManager';
import './layout.css'
import Customer from './component/customer/Customer';
import File from './component/test/File';


function App() {
  return (
    <div>
      <div>
        <a href='/order'>
          <button className='btn btn-success'>Order</button>
        </a>
        <a href='/customer'>
          <button className='btn btn-info'>Customer</button>
        </a>
        <a href='/test'>
          <button className='btn btn-secondary'>Test</button>
        </a>
      </div>
      <BrowserRouter>
        <Routes>
          <Route path='/order' element={<OrderManager />}></Route>
          <Route path='/customer' element={<Customer />}></Route>
          <Route path='/test' element={<File />}></Route>
        </Routes>
      </BrowserRouter>

    </div>
  );
}

export default App;
