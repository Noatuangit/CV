import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import FooterProject from './Layout/FooterProject';
import HeaderProject from './Layout/HeaderProject';
import CustomerList from './Customer/CustomerList';
import ComputerList from './Computer/ComputerList';
import CreateCustomer from './Customer/CreateCustomer';
import CustomerMain from './Customer/CustomerMain';
import CreateComputer from './Computer/CreateComputer';
import ComputerMain from './Computer/ComputerMain';
import ServiceMain from './Service/ServiceMain';
import CreateService from './Service/CreateService';
import ServiceList from './Service/ServiceList';
import React from 'react';
import Total from './Booking/Total';
import Computer from './Booking/Computer/Computer';
import EditDetails from './Booking/Computer/EditDetails';
import ComputerDetailMains from './Booking/Computer/ComputerDetailMains';
import Service from './Booking/Service/Service';
import ServiceDetails from './Booking/Service/ServiceDetails';
import FormServiceDetails from './Booking/Service/FormServiceDetails';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <HeaderProject />
        <Routes>
          <Route path='/customer' element={<CustomerMain />} >
            <Route path='createCustomer' element={<CreateCustomer />} />
            <Route path='list' element={<CustomerList />} />
            <Route path=':id' element={<CreateCustomer />} />
          </Route>
          <Route path='/computer' element={<ComputerMain />}  >
            <Route path='createComputer' element={<CreateComputer />} />
            <Route path='list' element={<ComputerList />} />
            <Route path=':id' element={<CreateComputer />} />
          </Route>
          <Route path='/service' element={<ServiceMain />}  >
            <Route path='createService' element={<CreateService />} />
            <Route path='list' element={<ServiceList />} />
            <Route path=':id' element={<CreateService />} />
          </Route>
          <Route path='/bookingComputer' element={<ComputerDetailMains />}  >
            <Route path='' element={<Computer />} />
            <Route path='edit' element={<EditDetails />} />
          </Route>
          <Route path='/bookingService' element={<ServiceDetails />}>
            <Route path='' element={<Service />} />
            <Route path='create' element={<FormServiceDetails />} />
            <Route path='edit' element={<FormServiceDetails />} />
          </Route>
          <Route path='/manager' element={<Total />} />
        </Routes>
        <FooterProject />
      </BrowserRouter>
    </div>
  );
}

export default App;
