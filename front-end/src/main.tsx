import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import { ThemeProvider } from "@mui/material/styles";
import { CssBaseline } from "@mui/material";
import { theme } from "./theme/theme";

import Home from "./page/Home.tsx";
import Dashboard from "./page/Dashboard.tsx";
import Login from "./page/Login.tsx";
import Register from "./page/Register.tsx";
import MealList from "./page/MealList.tsx";
import MealItem from "./page/MealItem.tsx";
import Planning from "./page/Planning.tsx";
import GroceryList from "./page/GroceryList.tsx";
import FormLayout from "./layout/FormLayout.tsx";
import MainLayout from "./layout/MainLayout.tsx";
import MealAdd from "./page/MealAdd.tsx";
import IngredientList from "./page/IngredientList.tsx";
import IngredientItem from "./page/IngredientItem.tsx";
import IngredientAdd from "./page/IngredientAdd.tsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    element: <FormLayout />,
    children: [
      {
        path: "/login",
        element: <Login />,
      },
      {
        path: "/register",
        element: <Register />,
      },
      {
        path: "/meal/add",
        element: <MealAdd />,
      },
      {
        path: "/ingredient/add",
        element: <IngredientAdd />,
      },
    ],
  },
  {
    element: <MainLayout />,
    children: [
      {
        path: "/dashboard",
        element: <Dashboard />,
      },
      {
        path: "/meal",
        element: <MealList />,
      },
      {
        path: "/meal/:id",
        element: <MealItem />,
      },
      {
        path: "/ingredient",
        element: <IngredientList />,
      },
      {
        path: "/ingredient/:id",
        element: <IngredientItem />,
      },
      {
        path: "/planning",
        element: <Planning />,
      },
      {
        path: "/groceryList",
        element: <GroceryList />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <ThemeProvider theme={theme}>
    <CssBaseline />
    <RouterProvider router={router} />
  </ThemeProvider>,
);
