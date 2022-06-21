import logo from './logo.svg';
import './App.css';
import AddInventory from './components/AddInventory'
import Items from './components/Items';

function App() {
  return (
    <div>
      <div className="App">
       <AddInventory/>
       <br></br>
       <br></br>
       <Items/>
      </div>
    </div>


  );
}

export default App;
