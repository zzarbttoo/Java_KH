import logo from './logo.svg';
import './App.css';
import {Route} from 'react-router-dom';
import Home from './pages/Home';
import About from './pages/About';

//exact 는 uri 가 완전히 일치해야만 하는 것
function App() {
  return (
    <div className = "App">
      <Route exact path = "/" component = {Home} />
      <Route path = "/about/:name" component = {About} />
    </div>
  );
}

export default App;
