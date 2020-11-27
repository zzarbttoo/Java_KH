import logo from './logo.svg';
import './App.css';

function App() {

  var hello = "Hello JSX";

  //if 문과 for 문을 사용할 수 없다
  //if 는 삼항연산자로 대체한다

  var array = [];

  for (var i = 0; i< 3; i++){

    array.push((<tr><td>{i}</td></tr>));

  }


  return (
    <div className="App">
      <h1>{hello}</h1>
      { false ? <h1>I'm true</h1> : <h1>I'm false</h1>}
      {/*주석을 이렇게 써야한다 */}
      <table border = "1">
      {array}
      </table>
    </div>
  );
}

export default App;
