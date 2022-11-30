import './App.css';
import {useState} from 'react';

//function App() {
  const App = props => {
    const [color, setColor] = useState('black');

    return (
      <div>
        <h1 style={{color : color}}>리액트 프로젝트 데모</h1>
        <hr/>
        <button onClick={()=>setColor('red')}>Red</button>
        <button onClick={()=>setColor('blue')}>BLUE</button>
        <button onClick={()=>setColor('green')}>GREEN</button>
        <button onClick={()=>setColor('')}>BLACK</button>
      </div>
    );
  }

  export default App;