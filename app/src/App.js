import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

function App() {
  const [recipes, setRecipes] = useState([]);
  const getRecipes = async () => {
    try{
      const response = await axios.get("http://localhost:8080/getRecipes");
      console.log(response.data);
      setRecipes(response.data);
    }
    catch(err){
      console.log(err);
    }
  }
  useEffect(()=>{
    getRecipes();
  },[])
  return(
    <div className='App'>
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <div>
        {recipes.map(recipe =>
            <div key={recipe.id}>
              {recipe.title}
            </div>
          )}
        </div>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  )
 
}

export default App;

