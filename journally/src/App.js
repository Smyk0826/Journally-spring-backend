import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from 'react';
import Login from './COMPONENT/login';
import Profile from './COMPONENT/profile';
import Notebook from './COMPONENT/notebook';
import Home from './COMPONENT/home';
import SignIn from './COMPONENT/signin';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";
import { nameContext,idContext } from './context/context';



function App() {
  const [name, setName] = useState('');
  const [id, setId] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/hello')
      .then(res => res.json())
      .then(data => setName(data.name)
      .then(data => setId(data.id))
    );
  }, [])
  return (
    <nameContext.Provider value={{name, setName}}>
    <idContext.Provider value = {{id,setId}}>
    <Router>
    <div className="App">
      <Routes>
        <Route exact path="/" element={<Home/>}/>
        <Route exact path="/Login" element={<Login/>}/>
        <Route exact path="/signin" element={<SignIn/>}/>
        <Route exact path="/notebook" element={<Notebook/>}/>
        <Route exact path="/profile" element={<Profile/>}/>
        </Routes>
    </div>
    </Router>
    </idContext.Provider>
    </nameContext.Provider>
  );
}

export default App;
