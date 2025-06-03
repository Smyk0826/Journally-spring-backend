// ProtectedRoute.js
import { Navigate } from 'react-router-dom';
import {idContext} from './context/context';
import {useContext} from 'react';
import LoginPage from './COMPONENT/login';

function ProtectedRoute({ children }) {
  const userId = useContext(idContext);

 return userId.id !== -1 ? children : <Navigate to="/login" replace />;

}

export default ProtectedRoute;
