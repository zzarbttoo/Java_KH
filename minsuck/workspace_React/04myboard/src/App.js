import logo from './logo.svg';
import './App.css';
import {Route} from 'react-router-dom';
import List from './pages/List';
import Insert from './pages/Insert';
import Detail from './pages/Detail';
import Update from './pages/Update';


function App() {
  
  return (
    <div className="App">
      <Route exact path = "/" component={List}/>
      <Route path = "/insert" component = {Insert}/>
      <Route path = "/detail/:seq" component={Detail}/>
      <Route path = '/update/:seq' component={Update}/>
    </div>
  );
}

export default App;