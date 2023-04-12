import React from 'react';
import './App.css';
import FooterNavbar from './component/layout/FooterNavbar';
import HeaderNavbar from './component/layout/HeaderNavbar';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import TodoList from './component/FEE.React.M.A0201/TodoList';
import Test from './component/FEE.React.M.A0103/Test';
import Table from './component/FEE.React.M.A0202/Table';
import FormController from './component/FEE.React.M.A0301/FormController';
import Register from './component/FEE.React.M.A0301/Register';
import LoginForm from './component/FEE.React.M.A0301/LoginForm';
import AddForm from './component/FEE.React.M.A0301/AddForm';
import TableDetails from './component/FEE.React.M.A0301/TableDetails';
import EditForm from './component/FEE.React.M.A0301/EditForm';
import FormBasicCrud from './component/FEE.React.M.A0302/FormBasicCrud';
import Demo from './component/demo1/demo1';

function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderNavbar />
        <Routes>
          <Route path="/todo" element={<TodoList />}></Route>
          <Route path="/productList" element={<Test />}></Route>
          <Route path="/table" element={<Table />}></Route>
          <Route path="/login" element={<LoginForm />}></Route>
          <Route path="/register" element={<Register />}></Route>
          <Route path="/crud" element={<FormBasicCrud />}></Route>
          <Route path="/demo" element={<Demo />}></Route>
          <Route path="/formController" element={<FormController />}>
            <Route path="formAdd" element={<AddForm />}></Route>
            <Route path="formEdit/:email" element={<EditForm />}></Route>
            <Route path="tableController" element={<TableDetails />}></Route>
          </Route>
        </Routes>
        <FooterNavbar />
      </BrowserRouter>
    </div>
  );
}

export default App;
