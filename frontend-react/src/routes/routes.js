import {
    createBrowserRouter,
} from "react-router-dom";

import Home from '../pages/Home'
import Login from '../pages/Login'
import Dashboard from '../pages/Dashboard'
import ClearTrades from '../pages/ClearTrades'
import Layout from "../components/header/header";

const Router = createBrowserRouter([
	{
		element: <Layout />,
		children: [
				{
		path: "/",
		element: <Login />,
	},
	{
		path: "/dashboard/:id",
		element: <Dashboard />,
	},
	{
		path: "/clearTrades/:id",
		element: <ClearTrades />,
	}
		]
	}
    
]);

export default Router