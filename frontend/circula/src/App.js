import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AutoForm from './components/AutoForm';
import ValidationForm from './components/ValidationForm';
import Home from './components/Home';
import Navbar from './components/Navbar';

function App() {
  return (
    <Router>
      <Navbar />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<AutoForm />} />
          <Route path="/validate" element={<ValidationForm />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
