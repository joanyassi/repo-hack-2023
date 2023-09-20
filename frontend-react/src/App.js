import './App.css';
import Home from './pages/Home'
import { RouterProvider} from 'react-router-dom';
import Router from './routes/routes'

function App() {
  return (
    <div className="App">
    <RouterProvider router={Router} />
      {/* <header className="App-header">
       <Home />
      </header> */}
    </div>
  );
}

export default App;
