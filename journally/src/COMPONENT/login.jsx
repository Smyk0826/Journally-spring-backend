import react, { useState, useContext } from "react";
import Title from "./Title";
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import { nameContext, idContext} from "../context/context";
import Popup from "./popup";

function Login_page(){
const navigate = useNavigate();
const [loginPass, setLoginPass] = useState('');
const [loginID,setLoginID] = useState('');
const value = useContext(nameContext);
const userId = useContext(idContext);
const [popupTrigger,setPopupTrigger] = useState(false);
const handleSubmit = async (e) => {
    e.preventDefault();
    try {
        //console.log(response);
        const response = await axios.get('http://localhost:8081/users?email='+loginID);
        console.log('response is : ',response);
        const userName = response.data.userName;
        console.log('username is : ',userName);
        if (userName != null) {
            value.setName(response.data.userName);
            userId.setId(response.data.userId);
            navigate('/profile'); // Redirect to the dashboard page
          } else {
            
            alert('Login failed!');
          }
    } catch (error) {
        setPopupTrigger(true);
        console.error('There was an error in Logging in -', error);
        //alert('An error occurred. Please try again.');
    }
};
return(
    <div>
    <div className="TitleBar">
        <div>
        <Title/>
        </div>
        <div className="buttonBox">
            {/* <LogOut/> */}
        </div>
    
    </div>
        <div>
            <form onSubmit={handleSubmit}>
            <div className="TextWriting">
            <div className="form-group">
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Email" value={loginID} onChange={(e)=>setLoginID(e.target.value)} />
            </div>
            <div className="form-group">
                <input type="password" class="TextArea form-control" id="exampleFormControlInput1" placeholder="Password" value={loginPass} onChange={(e)=>setLoginPass(e.target.value)}/>
            </div>
            <button type="submit" className="submit btn btn-dark">Log In</button>
          
            </div>
    
            </form>

        </div>
        <Popup trigger={popupTrigger} setTrigger={setPopupTrigger}>
               <h3>Invalid Login Id or Password</h3>
            </Popup>
     
    </div>
    );
}

export default Login_page;