import {
    createBrowserRouter,
} from "react-router-dom";

import Home from '../pages/Home'
import Login from '../pages/Login'
import Dashboard from '../pages/Dashboard'
import HelloWord from '../pages/HelloWord'
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
		path: "/hello-world",
		element: <HelloWord />,
	}
		]
	}
    
]);

export default Router