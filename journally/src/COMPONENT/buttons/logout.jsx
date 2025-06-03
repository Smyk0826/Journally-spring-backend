import react from "react";
import { idContext } from "../../context/context";
import { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
function LogOut(){
    
    const navigate = useNavigate();
    const userId = useContext(idContext);

    function handleLogOut(){
        userId.setId(-1);
        navigate('/login');
    }
    return <button className="login btn btn-warning" onClick={handleLogOut}>Log Out</button>
}
export default LogOut;