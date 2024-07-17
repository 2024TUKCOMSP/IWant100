import { useState } from 'react';
import './App.css';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import LoginPage from './components/login/LoginPage';
import MainPage from './components/main/MainPage';
import CreateVotePage from './components/create/CreateVotePage';

function App() {
  return (
    <BrowserRouter>
      <div className="w-full h-screen grid grid-cols-[1fr_430px_1fr]">
        <div className='h-full'></div>
        <div className='shadow-xl h-full'>
          <Routes>
            <Route path='/login' element={<LoginPage />}></Route>
            <Route path='/' element={<MainPage />}></Route>
            <Route path='/create' element={<CreateVotePage />}></Route>
          </Routes>
        </div>
        <div className='h-full'></div>
      </div>
    </BrowserRouter>
  )
}

export default App